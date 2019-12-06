package com.calc.ui.elements.actions;

import com.calc.parser.util;
import com.calc.parser.util2;
import java.awt.event.ActionEvent;
import java.util.Collections;

public class action_arrLeft extends actionCommon {

    public void actionPerformed(ActionEvent e) {

        System.out.println("================ arrLeft =================");

        if (histor.getHistory().size() != 0) {

            String last_element = histor.getHistory().get(histor.getHistory().size() - 1);

            histor.getHistory().remove(last_element);
             
            String str = result.getText();
            String[] parsedTwoArgText = util2.parseArguments(str);

            String last_char = str.substring(result.getText().length() - 1, result.getText().length());

            int count = util.findChar(parsedTwoArgText[0], '.');

            System.out.println("count before: " + count + "  " + getAction_point().points.size());

            if (last_char.equals(".")) {

                int point_size = getAction_point().points.size();

                // 2 and more  (points)
                if (count > 0) {
                    getAction_point().points.removeAll(Collections.singleton("one_point_point"));
                    getAction_point().points.removeAll(Collections.singleton("two_point"));
                    getAction_point().points.removeAll(Collections.singleton("no_point"));
                    System.out.println("arr left 3:");
                    //  1 (point)    
                } else {
                    getAction_point().points.removeAll(Collections.singleton("one_point"));
                    System.out.println("arr left 2:");
                }

            }

            for (int i = 0; i < getAction_point().points.size(); i++) {
                String element = getAction_point().points.get(i);
                System.out.println(element);
            }

//            System.out.println(last_char);
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
