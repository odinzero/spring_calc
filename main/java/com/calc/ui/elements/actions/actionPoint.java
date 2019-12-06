package com.calc.ui.elements.actions;

import com.calc.parser.util;
import com.calc.parser.util2;
import java.awt.event.ActionEvent;

public class actionPoint extends actionCommon {

//    public actionResult action_result;
//
//    public void setAction_result(actionResult action_result) {
//        this.action_result = action_result;
//    }
//
//    public actionResult getAction_result() {
//        return action_result;
//    }
    public void actionPerformed(ActionEvent e) {
        // rule for key '.'
        String[] parsedTwoArgText = util2.parseArguments(result.getText());

        if (points.size() == 0) {
            if (parsedTwoArgText[1].equals("one_point")) {
                points.add("one_point");
                histor.getHistory().add(getPressKey());
                System.out.println("point3_3:  one_point");
            }
        } // two variants:
        else if (points.size() == 1) {
            // 1.2+.5
            if (parsedTwoArgText[1].equals("one_point_point")) {
                points.add("one_point_point");
                histor.getHistory().add(getPressKey());
                System.out.println("point3_3:  one_point_point");
            }
            // 1.2+5.5
            if (parsedTwoArgText[1].equals("two_point")) {
                points.add("two_point");
                histor.getHistory().add(getPressKey());
                System.out.println("point3_3:  two_point");
            }
        } else {
            points.add("no_point");
        }

        System.out.println("================ " + parsedTwoArgText[1] + " " + points.size() + "  "
                + histor.getHistory().size() + " =================");

        boolean last_isNumber = false;
        if (histor.getHistory().size() != 0) {
            if (histor.getHistory().size() >= 2) {
                last_isNumber = util.isNumeric(histor.getHistory().get(histor.getHistory().size() - 2));

                System.out.println("point2: " + last_isNumber + "  "
                        + histor.getHistory().get(histor.getHistory().size() - 2) + "  " + histor.getHistory().size());
            } else {
                histor.setFirstTime(util.isNumeric(histor.getHistory().get(histor.getHistory().size() - 1)));

                if (last_isNumber != histor.isFirstTime()) {
                    last_isNumber = histor.isFirstTime();
                }

                System.out.println("point1: " + last_isNumber + "  "
                        + histor.getHistory().get(histor.getHistory().size() - 1) + "  " + histor.getHistory().size());
            }
        }

        if (points.size() != 0 ) {
            // prev element in textfield is number
            if (last_isNumber) {

                if (points.get(0).equals("one_point") && points.size() == 1) {

                    boolean b = parsedTwoArgText[0].contains(".");

                    // protection from wrong second point like this 3.2222(.) 
                    if (b) {
                        result.setText(parsedTwoArgText[0]); //
                        System.out.println("point3_1:" + parsedTwoArgText[0]);
                    } else {
                        result.setText(parsedTwoArgText[0] + this.getPressKey()); //
                        System.out.println("point3_1_:");
                    }
                } else if (points.get(1).equals("one_point_point") && points.size() == 2) {
                    result.setText(parsedTwoArgText[0] + "0" + this.getPressKey());
                    System.out.println("point3_82:");
                } else if (points.get(1).equals("two_point") && points.size() >= 2) {

                    int count = util.findChar(parsedTwoArgText[0], '.');

                    if (count < 2) {
                        result.setText(parsedTwoArgText[0] + this.getPressKey()); //
                        System.out.println("point3_2:");
                        // protection from trird point like this 3.2222 + 5.333333(.)   
                    } else {
                        result.setText(parsedTwoArgText[0]); //
                        System.out.println("point3_2_:");
                    }
                } // 
                else if (points.get(1).equals("one_point_point") && points.size() >= 2) {

                    int count = util.findChar(parsedTwoArgText[0], '.');

                    if (count < 2) {

                        // protection from additional zero 20.4557+0(0).236747 
                        if (parsedTwoArgText[1].equals("one_point_point")) {
                            result.setText(parsedTwoArgText[0] + "0" + this.getPressKey());
                            // protection from additional zero 20.4557+0(0).236747
                        } else if (parsedTwoArgText[1].equals("two_point")) {
                            result.setText(parsedTwoArgText[0] + this.getPressKey());
                        }
                        System.out.println("point30_01:");
                        // protection from trird point like this 3.2222 + 5.333333(.)   
                    } else {
                        result.setText(parsedTwoArgText[0]); //
                        System.out.println("point30_2:");
                    }

                    // result.setText(parsedTwoArgText[0] + "0" + this.getPressKey());
                    //System.out.println("point30_20:" + getActResult().countPressedResult + " " + points.size());
                } //
                else {
                    System.out.println("point30_20_500 :");
                }
            } // prev element in textfield is not number
            else {
                //
                if (histor.getHistory().size() >= 2) {

                    if (points.get(0).equals("one_point") && points.size() == 1) {
                        result.setText(parsedTwoArgText[0]);
                        System.out.println("point410");
                    } else if (points.get(1).equals("one_point_point") && points.size() == 2) {
                        result.setText(parsedTwoArgText[0] + "0" + this.getPressKey());
                        System.out.println("point41_55");
                    } else if (points.get(1).equals("two_point") && points.size() >= 2) {
                        //result.setText(parsedTwoArgText[0] + this.getPressKey());
                        protectFromThirdPoint(parsedTwoArgText[0]);
                        System.out.println("point41");
                    } else {

                        int count = util.findChar(parsedTwoArgText[0], '.');

                        // protection from like this 2.2345 + 2.2(.)
                        if (count < 2) {
                            result.setText(parsedTwoArgText[0] + this.getPressKey());
                            System.out.println("point41_1");
                        } // protection from like this 2.2345 + 2.2(.)
                        else {
                            result.setText(parsedTwoArgText[0]);
                            System.out.println("point41_777");
                        }

                    }

                } else {
                    result.setText(parsedTwoArgText[0] + this.getPressKey());
                    System.out.println("point6");
                }

            }
        // '%' key is pressed  ; points size = 0;
        // case when like this -> 23.466
        } else {
          // boolean b0 = parsedTwoArgText[0].contains(".");
           
          int count = util.findChar(parsedTwoArgText[0], '.');
           if(count < 2) {
               if(parsedTwoArgText[1].equals("one_point_point")) {
                 result.setText(parsedTwoArgText[0] + "0" + this.getPressKey());
                 System.out.println("p00_10: " );
               }
               else if(parsedTwoArgText[1].equals("two_point")) {
                 result.setText(parsedTwoArgText[0] + this.getPressKey());  
                 System.out.println("p00_11: " );
               }
           } 
           else {
               result.setText(parsedTwoArgText[0] ); // + this.getPressKey()
               System.out.println("p00_12: " );
           }
           
            System.out.println("p00: " );
        }
    }

    public void protectFromThirdPoint(String parsedTwoArgText) {

        int count = util.findChar(parsedTwoArgText, '.');

        // protection from like this 2.2345 + 2.2(.)
        if (count < 2) {
            result.setText(parsedTwoArgText + this.getPressKey());
            System.out.println("point41_1m");
        } // protection from like this 2.2345 + 2.2(.)
        else {
            result.setText(parsedTwoArgText);
            System.out.println("point41_777m");
        }
    }
}
