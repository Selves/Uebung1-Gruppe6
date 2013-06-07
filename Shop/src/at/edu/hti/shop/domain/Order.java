
package at.edu.hti.shop.domain;

import java.util.ArrayList;
import java.util.List;

import at.edu.hti.shop.domain.rules.FittingWight;
import at.edu.hti.shop.domain.rules.IShipmentSplitter;
import at.edu.hti.shop.domain.rules.MatchinProducts;
import at.edu.hti.shop.domain.rules.MatchingShippingDates;

public class Order {

  private ArrayList<OrderLine> myLines = new ArrayList<>();
  private List<Shipment> shipments = new ArrayList<>();
  private IPriceStrategy pricing;
  private MatchingShippingDates matchDate = new MatchingShippingDates();
  private MatchinProducts matchProducts = new MatchinProducts();
  private FittingWight weightCheck = new FittingWight(10);
  private IShipmentSplitter splitter = null;

  public Order(IPriceStrategy pricing) {
    setPricing(pricing);
    splitter = matchDate.And(matchProducts.And(weightCheck));
    //matchProducts.And(weightCheck);
  }

  public Order() {
    setPricing(null);
  }

  public boolean add(OrderLine e) {

    if (e == null)
      return false;

    return myLines.add(e);
  }

  public double calcPrize() {
    return this.pricing.calcPrice(myLines);
  }

  public void changeAmount(String productName, int amount) {
    if (amount == 0) {
      OrderLine toRemove = null;
      for (OrderLine line : this.myLines) {
        if (line.getProduct().getName().equalsIgnoreCase(productName)) {
          toRemove = line;
        }
      }
      if (toRemove != null) {
        this.myLines.remove(toRemove);
      }
      return;
    } else {
      for (OrderLine line : this.myLines) {
        if (line.getProduct().getName().equalsIgnoreCase(productName)) {
          line.setAmount(amount);
        }
      }
    }
  }

  public int getLineAmount() {
    return myLines.size();
  }

  public void setPricing(IPriceStrategy pricing) {
    if (pricing != null) {
      this.pricing = pricing;
    } else {
      this.pricing = new SimplePricingWithMinimumCosts();
    }
  }

  @Override
  public String toString() {
    return super.toString() + " \n =>" + calcPrize() + " \n " + this.myLines;

  }

  public void createShipments() {
    ArrayList<ArrayList<OrderLine>> shipmentList = new ArrayList<ArrayList<OrderLine>>();
    for (OrderLine singleLine : this.myLines) {
      boolean inserted = false;
      System.out.println(singleLine);
      for (ArrayList<OrderLine> list : shipmentList) {
        if (splitter.IsSatisfiedBy(list, singleLine)) {
          System.out.println("Add line: " + singleLine);
          list.add(singleLine);
          inserted = true;
          break;
        }
      }
      if (inserted == false) {
        System.out.println("create new list: " + singleLine);
        ArrayList<OrderLine> newList = new ArrayList<OrderLine>();
        newList.add(singleLine);
        shipmentList.add(newList);
      }
    }
    for (ArrayList<OrderLine> shipment : shipmentList) {
      double price = this.pricing.calcPrice(shipment);
      Shipment newShipment = new Shipment(shipment);
      newShipment.setPrice(price);

      System.out.println("ADD shipping: " + newShipment);
      this.shipments.add(newShipment);
    }
  }

  public String printShipments() {
    String returnVal = "";
    for (Shipment ship : this.shipments) {
      returnVal = returnVal + ship.toString();
    }
    return returnVal;
  }
}
