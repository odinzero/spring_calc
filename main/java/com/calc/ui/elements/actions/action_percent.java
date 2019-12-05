package com.calc.ui.elements.actions;

import com.calc.parser.util;
import com.calc.parser.util2;
import java.awt.event.ActionEvent;

public class action_percent extends actionCommon {
    
    public actionPoint action_point;

    public void setAction_point(actionPoint action_point) {
        this.action_point = action_point;
    }

    public actionPoint getAction_point() {
        return action_point;
    }

    public void actionPerformed(ActionEvent e) {

        System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%: " + result.getText());

        countPressedPercent++;

        String[] parsedTwoArgText = util2.parseArguments(result.getText());

        if (countPressedPercent == 1) {

            if (parsedTwoArgText.length > 2) {

                percentHistoryOperations.add(result.getText());

                Number first_argument = Double.parseDouble(parsedTwoArgText[2]);
                // String operand = parsedTwoArgText[3];
                Number second_argument = Double.parseDouble(parsedTwoArgText[4]);

                // 500 - 20% = 500 - (500 * 20/100) = 
                String percent = util.formulaFindPercent(first_argument, second_argument);

                result.setText(percent);
                System.out.println("perc 100: ");
            } else {
                
                action_point.points.clear();
                histor.getHistory().clear();
                
                result.setText("0");
                System.out.println("perc 111: ");
            }

        } // countPressedPercent > 1
        else {
            if (!result.getText().equals("0")) {

//                if (parsedTwoArgText[2] != null && parsedTwoArgText[3] != null && parsedTwoArgText[4] != null) {
                String percent_history_operations = percentHistoryOperations.get(0);

                String[] parsedTwoArg = util2.parseArguments(percent_history_operations);

                Number first_argument = util.parseNumber(parsedTwoArg[2]);
                // String operand = parsedTwoArgText[3];
                Number second_argument = util.parseNumber(result.getText());

                // 500 - first_argument
                // 20  - second_argument
                // 500 * 20% = 500 * (500 * 20/100) = 500 * 100 
                String percent = util.formulaFindPercent(first_argument, second_argument);

                result.setText(percent);

                System.out.println("perc 1: " + percent_history_operations + " | " + first_argument);
//                } else {
//                    result.setText("0");
//                }
            } // textField text = 0
            else {
                if (histor.getHistory().size() == 0) {
                    result.setText("0");
                    System.out.println("perc 2: ");
                } else {
                    String percent_history_operations = percentHistoryOperations.get(0);

                    String[] parsedTwoArg = util2.parseArguments(percent_history_operations);

                    Number first_argument = util.parseNumber(parsedTwoArg[2]);
                    // String operand = parsedTwoArgText[3];
                    Number second_argument = util.parseNumber(result.getText());

                    // 500 - first_argument
                    // 20  - second_argument
                    // 500 * 20% = 500 * (500 * 20/100) = 500 * 100 
                    String percent = util.formulaFindPercent(first_argument, second_argument);

                    result.setText(percent);

                    System.out.println("perc 1: " + percent_history_operations + " | " + first_argument);

                    System.out.println("perc 5: ");
                }

            }

        }

    }
}
