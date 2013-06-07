
package at.edu.hti.shop.domain.cathegory;

import java.util.ArrayList;
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

public abstract class AbstraceCathegory implements ICathegory {

  protected List<String> notSuitable = new ArrayList<>();

  @Override
  public abstract String getName();

  @Override
  public boolean isCathegorySuitAble(String name) {
    for (String notSuitAbleChathegory : this.notSuitable) {
      if (notSuitAbleChathegory.equalsIgnoreCase(name)) {
        return false;
      }
    }
    return true;
  }
}

//---------------------------- Revision History ----------------------------
//$Log$
//