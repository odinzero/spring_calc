
package com.calc.ui.elements.actions;

import com.calc.parser.util;
import java.awt.event.ActionEvent;

public class action_oneDivideX extends actionCommon {
   
    public void actionPerformed(ActionEvent e) {
        
        Number n = util.parseNumber(result.getText());
        
        result.setText("" + util.formulaOneDivideX(n)); 
    }
    
    
}
