package com.calc.ui.elements.actions;

import com.calc.base.IActionListener;
import com.calc.parser.util;
import static com.calc.parser.util.parseOperation;
import com.calc.parser.util2;
import java.awt.event.ActionEvent;

public class actionResult extends actionCommon {

    // when key '=' is not pressed
    public boolean pressed = false;

    public void setPressed(boolean pressed) {
        this.pressed = pressed;
    }

    public boolean isPressed() {
        return pressed;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (getAction_ce_c().isTurnOnCalc()) {

            countPressedResult++;

            calcHistoryOperations.add(result.getText());

            //  System.out.println("co00: " + result.getText());
            String r = null;
            if (countPressedResult == 1) {

                String[] parsedTwoArgText = util2.parseArguments(result.getText());
                resHistoryOperations.add(result.getText());

                // when two arguments like 50.56+12
                if (parsedTwoArgText.length > 2) {

                    System.out.println("co0: " + result.getText());

                    r = parseOperation(result.getText(), "$4");

                    result.setText(r.toString());
                // when textfiled like this 56.23, 56.23+ and etc    
                } else {
                    result.setText(result.getText());
                }
            } // countPressedResult > 1
            else {

                if (!result.getText().equals("0")) {

                    if (histor.getHistory().size() >= 3) {

                        String res_history_operations = resHistoryOperations.get(0);

                        System.out.println("co1: " + res_history_operations);

                        String[] parsedTwoArgText = util2.parseArguments(res_history_operations);

                        if (parsedTwoArgText.length > 2) {
                            String operand = parsedTwoArgText[3];
                            String last_argument = parsedTwoArgText[4];

                            //  System.out.println("co2: " + operand + " " + last_argument);
                            String res = result.getText() + operand + last_argument;

                            r = parseOperation(res, "$4");
                            result.setText(r.toString());
                        } else {

                            result.setText(result.getText());
                        }

//                        System.out.println("=  01: " + result.getText() + "  " + operand + "  " + last_argument );
                    } else {
                        r = parseOperation(result.getText(), "$4");
                        result.setText(r.toString());
                        System.out.println("=  02: ");
                    }
                    // result text = 0    
                } else {
                    if (histor.getHistory().size() == 0) {
                        result.setText("0");
                        System.out.println("=  03: ");
                    } else {
                        String res_history_operations = resHistoryOperations.get(0);

//                        System.out.println("co1: " + res_history_operations);
                        String[] parsedTwoArgText = util2.parseArguments(res_history_operations);

                        String operand = parsedTwoArgText[3];
                        String last_argument = parsedTwoArgText[4];

//                        System.out.println("co2: " + operand + " " + last_argument);
                        String res = result.getText() + operand + last_argument;

                        r = parseOperation(res, "$4");
                        result.setText(r.toString());
                    }

                }
            }

            setPressed(true);

        }
    }

}
