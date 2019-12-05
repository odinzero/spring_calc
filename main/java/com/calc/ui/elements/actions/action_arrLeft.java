package com.calc.ui.elements.actions;

import com.calc.parser.util;
import java.awt.event.ActionEvent;

public class action_arrLeft extends actionCommon {

    public void actionPerformed(ActionEvent e) {

        System.out.println("================ arrLeft =================");

        if (histor.getHistory().size() != 0) {

            String last_element = histor.getHistory().get(histor.getHistory().size() - 1);

            histor.getHistory().remove(last_element);

            String str = result.getText();

            str = str.substring(0, str.length() - 1);

            result.setText(str);

        } else {
            
            result.setText("0"); 
        }

//          for (int i = 0; i < histor.getHistory().size(); i++) {
//              String element = histor.getHistory().get(i);
//              System.out.println(element);
//          }
        System.out.println("================ arrLeft end =================");
    }
}
