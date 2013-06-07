
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

public abstract class AbstractShipmentSplitter implements IShipmentSplitter {

  public abstract boolean IsSatisfiedBy(List<OrderLine> orderLines, OrderLine orderToCompare);

  @Override
  public IShipmentSplitter And(IShipmentSplitter other) {
    System.out.println("add and spec: " + other);
    return new AndShipmentSpiltter(this, other);
  }

  @Override
  public IShipmentSplitter Or(IShipmentSplitter other) {
    System.out.println("add Or spec: " + other);
    return new OrShipmentSplitter(this, other);
  }

  @Override
  public IShipmentSplitter Not() {
    System.out.println("add Not spec: ");
    return new NotShipmentSplitter(this);
  }

}

//---------------------------- Revision History ----------------------------
//$Log$
//