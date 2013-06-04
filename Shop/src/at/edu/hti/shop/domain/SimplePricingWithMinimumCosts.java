
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

public class SimplePricingWithMinimumCosts implements IPriceStrategy {

  @Override
  public double calcPrice(List<OrderLine> lines) {
    double sum = 0;

    for (OrderLine line : lines) {
      sum += line.calcPrize();
    }

    if (sum > 10) {
      return sum;
    } else {
      sum = sum + 5;
    }
    return sum;
  }
}

//---------------------------- Revision History ----------------------------
//$Log$
//