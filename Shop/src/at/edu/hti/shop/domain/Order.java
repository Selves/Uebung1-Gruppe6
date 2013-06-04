
package at.edu.hti.shop.domain;

import java.util.ArrayList;

public class Order {

  private ArrayList<OrderLine> myLines = new ArrayList<>();

  private IPriceStrategy pricing;

  public Order(IPriceStrategy pricing) {
    setPricing(pricing);
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

    return super.toString() + " \n =>" + calcPrize();
  }
}
