
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

public class FittingWight extends AbstractShipmentSplitter {

  private int maxWight;

  public FittingWight(int maxWight) {
    this.maxWight = maxWight;
    ;
  }

  @Override
  public boolean IsSatisfiedBy(List<OrderLine> orderLines, OrderLine orderToCompare) {
    if (orderLines == null) {
      return false;
    }
    int sumWeight = 0;
    for (OrderLine singleLine : orderLines) {
      sumWeight += singleLine.calcWight();
    }
    sumWeight += orderToCompare.calcWight();
    System.out.println("Sum weight: " + sumWeight);
    if (sumWeight < maxWight) {
      return true;
    } else {
      return false;
    }
  }
}

//---------------------------- Revision History ----------------------------
//$Log$
//