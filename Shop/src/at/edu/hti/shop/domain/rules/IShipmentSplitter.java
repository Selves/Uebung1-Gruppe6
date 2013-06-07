
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

public interface IShipmentSplitter {
  public boolean IsSatisfiedBy(List<OrderLine> orderLines, OrderLine orderToCompare);

  public IShipmentSplitter And(IShipmentSplitter other);

  public IShipmentSplitter Or(IShipmentSplitter other);

  public IShipmentSplitter Not();

}

//---------------------------- Revision History ----------------------------
//$Log$
//