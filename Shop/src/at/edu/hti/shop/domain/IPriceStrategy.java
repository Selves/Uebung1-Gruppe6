
package at.edu.hti.shop.domain;

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

public interface IPriceStrategy {

  public double calcPrice(List<OrderLine> lines);
}

//---------------------------- Revision History ----------------------------
//$Log$
//