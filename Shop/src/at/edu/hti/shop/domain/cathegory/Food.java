
package at.edu.hti.shop.domain.cathegory;

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

public class Food extends AbstraceCathegory {

  public Food() {
    notSuitable.add("CHEMICAL");
    notSuitable.add("TOOL");
  }

  @Override
  public String getName() {
    return "FOOD";
  }

}

//---------------------------- Revision History ----------------------------
//$Log$
//