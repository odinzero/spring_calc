package com.calc.ui.elements.actions;

import com.calc.base.IActionListener;
import com.calc.parser.History;
import com.calc.parser.util;
import com.calc.parser.util2;
import java.awt.event.ActionEvent;

public class actionCommon extends IActionListener {

    actionResult actResult;
    action_CE_C action_ce_c;
    action_percent act_percent;
    actionPoint action_point;

    public void setActResult(actionResult actResult) {
        this.actResult = actResult;
    }

    public actionResult getActResult() {
        return actResult;
    }

    public void setAction_ce_c(action_CE_C action_ce_c) {
        this.action_ce_c = action_ce_c;
    }

    public action_CE_C getAction_ce_c() {
        return action_ce_c;
    }

    public void setAct_percent(action_percent act_percent) {
        this.act_percent = act_percent;
    }

    public action_percent getAct_percent() {
        return act_percent;
    }

    public void setAction_point(actionPoint action_point) {
        this.action_point = action_point;
    }

    public actionPoint getAction_point() {
        return action_point;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (getAction_ce_c().isTurnOnCalc()) {

            getActResult().countPressedResult = 0;
            getActResult().resHistoryOperations.clear();

            getAct_percent().countPressedPercent = 0;
            getAct_percent().percentHistoryOperations.clear();

            System.out.println("common:" + getActResult().countPressedPercent);

            int historySize = histor.getHistory().size();

            if (!getPressKey().equals("=") && !getPressKey().equals(".")) {

                histor.getHistory().add(getPressKey());
            }

            // System.out.println("::: " + histor.getHistory().size()); 
            boolean last_isNumber = false;
            if (histor.getHistory().size() != 0) {
                if (histor.getHistory().size() >= 2) {
                    last_isNumber = util.isNumeric(histor.getHistory().get(histor.getHistory().size() - 2));

                    System.out.println("if last_isNumber:" + last_isNumber + "  "
                            + histor.getHistory().get(histor.getHistory().size() - 2) + "  " + histor.getHistory().size());
                } else {
                    histor.setFirstTime(util.isNumeric(histor.getHistory().get(histor.getHistory().size() - 1)));

                    if (last_isNumber != histor.isFirstTime()) {
                        last_isNumber = histor.isFirstTime();
                    }

                    System.out.println("else last_isNumber:" + last_isNumber + "  "
                            + histor.getHistory().get(histor.getHistory().size() - 1) + "  " + histor.getHistory().size());
                }
            }

            // key '=' is pressed 
            if (actResult.isPressed()) {
                // clear History
                //histor.getHistory().clear();

                System.out.println("0:" + histor.getHistory().size());

                if (!getPressKey().equals("-") && !getPressKey().equals("+")
                        && !getPressKey().equals("*") && !getPressKey().equals("/")) {
                    //
                    if (!result.getText().equals("0")) {
                        // set text in textField  
                        result.setText(result.getText() + getPressKey());
                        System.out.println("1: " + getPressKey());
                    } else {
                        if (result.getText().equals("0")) {
                            result.setText(getPressKey()); // "0"
                            System.out.println("16: " + getPressKey());
                        } else {
                            result.setText(getPressKey());
                            System.out.println("15: " + getPressKey());
                        }
                    }
                } else {
                    result.setText(result.getText() + getPressKey());
                    System.out.println("2: " + getPressKey());
                }

                // key '=' need set to false
                actResult.setPressed(false);

                // System.out.println("pressed1: " + actResult.isPressed());
            } // key '=' is not pressed
            else {
                // previous click is number
                if (last_isNumber) {
                    //
                    if (!result.getText().equals("0")) {
                        result.setText(result.getText() + getPressKey());
                        System.out.println("5: " + getPressKey());
                    } else {

                        // String zeroORothernumber = histor.getHistory().get(0);
                        if (getPressKey().equals("0")) {
                            result.setText(getPressKey()); //+
                            System.out.println("11: " + getPressKey());
                        } else {
                            //
                            if (!result.getText().equals("0")) {
                                result.setText(result.getText() + getPressKey());
                                System.out.println("30: " + getPressKey());
                            } else {
                                if (!histor.getHistory().get(0).equals("0")) {
                                    result.setText(getPressKey());
                                    System.out.println("31: " + getPressKey());
                                } else {
                                    result.setText(result.getText() + getPressKey());
                                    System.out.println("32: " + getPressKey());
                                }
                            }
                        }
                    }
                } // previous click is not number
                else {
                    // and current click numbers 1,2,3,4,5,6 ...
                    if (!getPressKey().equals("+") && !getPressKey().equals("-")
                            && !getPressKey().equals("*") && !getPressKey().equals("/")) {

                        if (result.getText().equals("0")) {
                            result.setText(getPressKey());
                            // histor.getHistory().clear();
                            System.out.println("7: " + getPressKey());
                        } else {
                            result.setText(result.getText() + getPressKey());
                            System.out.println("12: " + getPressKey());
                        }
                        //and current click not number     
                    } else {

                        if (historySize > 0) {
                            boolean first_isNumber = util.isNumeric(histor.getHistory().get(0));

                            if (first_isNumber) {

                                System.out.println("8 start: ======================");
//                                for (int i = 0; i < histor.getHistory().size(); i++) {
//                                    String element = histor.getHistory().get(i);
//                                    System.out.println(element);
//                                }

                                String[] parsedTwoArgText = util2.parseArguments(result.getText());

                                String num = parsedTwoArgText[0].substring(result.getText().length() - 1, result.getText().length());

                                boolean b = util.isNumeric(num);

                                if (b) {
                                    result.setText(result.getText().substring(0, result.getText().length()) + this.pressKey);
                                    System.out.println("8_1 num: " + num + " " + b);
                                } else {

                                    // replace operands between each other +,-,/,*
                                    histor.getHistory().remove(histor.getHistory().size() - 2);
                                    histor.getHistory().remove(histor.getHistory().size() - 1);
                                    histor.getHistory().add(getPressKey());

                                    String sub = result.getText().substring(0, result.getText().length() - 1);// - 1

                                    result.setText(sub + getPressKey());
                                    
                                    System.out.println("8_2 num: " + num + " " + b);
                                }
                                
                                System.out.println("8 end: ====================== " + getAction_point().points.size());
                            } else {
                                //
                                if (result.getText().equals("0")) {
                                    result.setText(result.getText());
                                    System.out.println("9: " + getPressKey());
                                } else {
                                    // replace operands between each other 
                                    histor.getHistory().remove(histor.getHistory().size() - 2);
                                    histor.getHistory().remove(histor.getHistory().size() - 1);
                                    histor.getHistory().add(getPressKey());

                                    String sub = result.getText().substring(0, result.getText().length() - 1); //-1

                                    result.setText(sub + getPressKey());
                                    System.out.println("29: " + getPressKey());
                                }
                            }
                            // historySize == 0    
                        } else {
                            if (result.getText().equals("0")) {
                                result.setText("0");
                                System.out.println("10: " + getPressKey());
                            }
                        }

                    }

                }
//                }

            }

        }

    }

}
