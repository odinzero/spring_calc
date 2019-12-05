package com.calc.ui.elements.actions;

import com.calc.parser.util;
import com.calc.parser.util2;
import java.awt.event.ActionEvent;

public class action_percent extends actionCommon {

    public void actionPerformed(ActionEvent e) {

        String[] parsedTwoArgText = util2.parseArguments(result.getText());
        
        Number first_argument = Double.parseDouble(parsedTwoArgText[2]);
       // String operand = parsedTwoArgText[3];
        Number second_argument = Double.parseDouble(parsedTwoArgText[4]);
        
        // 500 * 20% = 500 * (500 * 20/100) = 50000 
        // 500 / 20% = 500 / (500 * 20/100) = 
        // 500 + 20% = 500 + (500 * 20/100) = 
        // 500 - 20% = 500 - (500 * 20/100) = 
        String percent = util.formulaFindPercent(first_argument, second_argument);
        
       // System.out.println("%%%: " + p);
        
        result.setText(percent);
    }
}
