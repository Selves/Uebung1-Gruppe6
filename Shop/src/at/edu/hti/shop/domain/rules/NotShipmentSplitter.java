
package at.edu.hti.shop.domain.rules;

import java.util.List;

import at.edu.hti.shop.domain.OrderLine;

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

public class NotShipmentSplitter extends AbstractShipmentSplitter {

  private IShipmentSplitter one;

  public NotShipmentSplitter(IShipmentSplitter one) {
    this.one = one;
  }

  @Override
  public boolean IsSatisfiedBy(List<OrderLine> orderLines, OrderLine orderToCompare) {
    return !one.IsSatisfiedBy(orderLines, orderToCompare);
  }
}

//---------------------------- Revision History ----------------------------
//$Log$
//