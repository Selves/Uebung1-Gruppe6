
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

public class Chemical extends AbstraceCathegory {

  public Chemical() {
    notSuitable.add("FOOD");
  }

  @Override
  public String getName() {
    return "CHEMICAL";
  }
}

//---------------------------- Revision History ----------------------------
//$Log$
//