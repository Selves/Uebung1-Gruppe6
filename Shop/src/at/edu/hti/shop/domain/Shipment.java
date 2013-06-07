
package at.edu.hti.shop.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Copyright 2013 SSI Schaefer PEEM GmbH. All Rights reserved. <br />
 * <br />
 * $Id$ <br />
 * <br />
 * This is the class header. The first sentence (ending with "."+SPACE) is important, because it is used summary in the package overview pages.<br />
 * <br />
 * 
 * @author ehe
 * @version $Revision$
 */

public class Shipment {
  private List<OrderLine> shipmentList = new ArrayList<>();
  private Date Shippindate = new Date();
  private double price;

  public Shipment(List<OrderLine> lines) {
    this.shipmentList = lines;
  }

  public List<OrderLine> getShipmentList() {
    return shipmentList;
  }

  public Date getShippindate() {
    return Shippindate;
  }

  public double getPrice() {
    return price;
  }

  public void setPrice(double price) {
    this.price = price;
  }

  @Override
  public String toString() {

    return "Shipment[PRICE[" + price + "] LINES[" + this.shipmentList + "]]";
  }

}

//---------------------------- Revision History ----------------------------
//$Log$
//