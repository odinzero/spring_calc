package com.calc.launcher;

import com.calc.exceptions.mathException;
import com.calc.parser.util;
import static com.calc.parser.util.getSqrt;
import static com.calc.parser.util.removeEndZeroFromInteger;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class main {

    public static void main(String[] args) {

         Launcher launcher = new Launcher();
         launcher.launch();

        
//         String add = " 5.55 - 4.56867 ";
//         System.out.println("Math: " + parseNumberFromString("4.56867465767687877786686868868")); //formulaFindPercent("400", "35")
//------------------------------------------------------------------------------         
//        String add = " 45.6 + "; // -3.56 / 0.1 
        String add = "9.8+."; // -0.5.
        
//        String regex = "(\\s*)([-]*\\d*\\.*\\d*\\.*)(\\s*)([+-\\/\\*])(\\s*)([-]*\\d*\\.*\\d*\\.*)(\\s*)";
//        
//        String s = add.replaceAll(regex, "$4");
//        
//        System.out.println("res :" + s);
        
//        parseArguments(add);
//        
//        System.out.println("res :" + parseArguments(add));

//        Number n1 = parseNumber2(add, "$2$3$4");
//        Number n2 = parseNumber2(add, "$9$10$11");

//        System.out.println("res :" + n1 + "  " + n2);
//
//        String n = parseOperation(add, "$4");
//
//        System.out.println("res :" + n);

//         Number n = util.parseNumber("9.0");
//
//         System.out.println("res sqrt :" + n  + "  " +  getSqrt(n));  
//         
//         System.out.println("1/x :" + formulaOneDivideX(-5) );
//------------------------------------------------------------------------------         
        //System.out.println("res:" + n);
//        countNumberAfterDot(n.toString());
        //String fs =  n.toString().replaceFirst("\\.0*$|(\\.\\d*?)0+$", "$1");
//        System.out.println("res:" + negateNumber(-5)); //String.format( "%.3f", n ) res:0.9820000000000002
        // String replacement = "$1$2$3$4$5$6$7";
//        String replacement = "$4";
//        
//        //                 1     2    3      4     5     6     7
//        String regex = "(\\s*)(\\d*)(\\s*)([+-])(\\s*)(\\d*)(\\s*)";
//        
//        String str0 = add.replaceAll(regex, replacement);
//        Number num_s1 =  parseNumber(add, "$2");
//        String operation =  parseOperation(add, "$4");
//        Number num_s2 =  parseNumber(add, "$6");
//        if(operation.equals("+")) {
//            int num1 =  Integer.parseInt(num_s1); 
//            int num2 =  Integer.parseInt(num_s2); 
//            int sum = num1 + num2;
//            System.out.println(sum);
//        }
    }

    public static Number parseNumber2(String input, String find, int type) {

        String regex1 = "(\\s*)([-]*\\d*)(\\.*)(\\d*)(\\.*)(\\s*)([+-\\/\\*]*)";
         //                 1              2            3       4        5            6               7
        String regex2 = "(\\s*)([-]*\\d*\\.*\\d*\\.*)(\\s*)([+-\\/\\*])(\\s*)([-]*\\d*\\.*\\d*\\.*)(\\s*)";

        String numberStr = "";
        switch(type) {
            default:break;
            case 1: numberStr = input.replaceAll(regex1, find); break;
            case 2: numberStr = input.replaceAll(regex2, find); System.out.println("ins ! :" + find);  break;
        }
        
        //String numberStr = input.matches(regex);

        System.out.println("numberStr b :" + numberStr);

        // 'numvberStr' canno be equal ""
        if (!numberStr.equals("")) {
            
            if(numberStr.equals(".")) 
              numberStr = "0"+numberStr;  
          // remove zero after dot  
            numberStr = numberStr.replaceAll("([-]*\\d*)(\\.*)(\\d*)(\\.*)([+-\\/\\*])([0]*$)", "$1$2$3");

            System.out.println("numberStr a :" + numberStr);
            int dot = numberStr.indexOf('.');

            // System.out.println("dot:" + dot);
            double numDouble = 0;
            int numInt = 0;
            // number like this 13,25,37,489,5,6,7,8,9
            // Integer
            if (dot == -1) {
                
                System.out.println("numberStr int :" + numberStr);
                numInt = Integer.parseInt(numberStr);

                System.out.println("numInt:" + numInt);
//            System.out.println("dot:" + dot);
                return numInt;
            }// number, like this 5.46467
            // Double 
            else {
                char someChar = '.';
                int count = 0;

                for (int i = 0; i < numberStr.length(); i++) {
                    if (numberStr.charAt(i) == someChar) {
                        count++;
                    }
                }
                numDouble = Double.parseDouble(numberStr); 

                System.out.println("numDouble:" + numDouble);

//            System.out.println("dot:" + dot);
                return numDouble;
            }
        } // protection from state when number is equal 'null'
        else {
            return null;
        }

    }
    
    public static String parseArguments(String input) {
        
        //                 1         2                 3        
        String regex1 = "(\\s*)([-]*\\d*\\.*\\d*\\.*)(\\s*)";
        //                 1         2                 3        4 
        String regex2 = "(\\s*)([-]*\\d*\\.*\\d*\\.*)(\\s*)([+-\\/\\*])";
        //                 1         2                 3        4        5             6             7
        String regex3 = "(\\s*)([-]*\\d*\\.*\\d*\\.*)(\\s*)([+-\\/\\*])(\\s*)([-]*\\d*\\.*\\d*\\.*)(\\s*)";
        
        String operand = null;
        Number num1 = null;
        Number num2 = null;
        if(input.matches(regex1) ) {
            
            num1 = parseNumber2(input, "$2$3$4", 1);
                    
            System.out.println("bool1: " + input.matches(regex1) + "  " + num1);
            
            return num1.toString();
        } else if (input.matches(regex2)) {
            
            num1 = parseNumber2(input, "$2$3$4", 1);
            
            operand = input.replaceAll(regex2, "$4");
            System.out.println("bool2: " + input.matches(regex2) + "  " + num1);
            
            return num1.toString() + operand;
        } else if (input.matches(regex3)) {
            
            
            System.out.println("bool3: ");
            
            num1 = parseNumber2(input, "$2", 2); 
            num2 = parseNumber2(input, "$6", 2);
            operand = input.replaceAll(regex3, "$4");
            
            System.out.println("bool3: " + input.matches(regex3) + "  " + num1  + "  " + operand );
            
            return num1.toString() + operand + num2.toString();
        } else {
             return "";
        }

    }
    
    //===========================================================================================================

    public static String parseOperation(String input, String find) {
        //                 1         2            3        4        5         6             7
        String regex = "(\\s*)([-]*\\d*\\.*\\d*)(\\s*)([+-\\/\\*])(\\s*)([-]*\\d*\\.*\\d*)(\\s*)";

        String s = input.replaceAll(regex, find);

        // System.out.println("s:" + s);
        Number num1 = parseNumber(input, "$2");
        Number num2 = parseNumber(input, "$6");

        // num1 and num2 should exist !
        if (num1 != null && num2 != null) {

            System.out.println("num1:" + num1 + "num2:" + num2);
            Number result = null;

            if (s.equals("+")) {
                result = addNumbers(num1, num2);

                String res = calculation(result, num1, num2);

                return res.toString();

            } else if (s.equals("-")) {
                result = subNumbers(num1, num2);

                String res = calculation(result, num1, num2);

                return res.toString();

            } else if (s.equals("/")) {
                boolean findZero = num2.toString().matches("^[-]*[0]*\\.*[0]*$");

                if (!findZero) {
                    result = divideNumbers(num1, num2);
                } else {
                    return "Cannot divide by zero";
                }

                return result.toString();

            } else if (s.equals("*")) {
                result = multiplyNumbers(num1, num2);

                String res = result.toString().replaceAll("(^[0]*)(\\.*[0]*$)", "$1");

                return res.toString();
            } else {

                return s;
            }
            // protection from states in textfiled 'result' like as '3.4 + ' or ' - 1.5'
        } else if (num1 != null && num2 == null) {

            System.out.println("num1:" + num1);

            return num1.toString();
        } else if (num1 == null && num2 != null) {

            System.out.println("num2:" + num2);

            return num2.toString();
        } else {

            System.out.println("---:");
            return "";
        }

        // return result.toString();
    }

    public static String calculation(Number result, Number num1, Number num2) {

        int lenAfterDot1 = countNumberAfterDot(num1.toString());
        int lenAfterDot2 = countNumberAfterDot(num2.toString());

        int max = Math.max(lenAfterDot1, lenAfterDot2);

//        System.out.println("max minus:" + max);
//
//        System.out.println("sss:" + result);
        // Double
        if (max != 0) {
            String fs = String.format("%." + max + "f", result);
            return fs.toString();
            // Integer   
        } else {
            return result.toString();
        }
    }

    public static Number parseNumber(String input, String find) {
        //                 1        2             3       4           5         6             7
        String regex = "(\\s*)([-]*\\d*\\.*\\d*)(\\s*)([+-\\/\\*])(\\s*)([-]*\\d*\\.*\\d*)(\\s*)";

        String numberStr = input.replaceAll(regex, find);

        //   System.out.println("numberStr b :" + numberStr);
        // 'numvberStr' canno be equal ""
        if (!numberStr.equals("")) {
            // remove zero after dot  
            numberStr = numberStr.replaceAll("(\\d*)(\\.*)([0]*$)", "$1");

            //System.out.println("numberStr a :" + numberStr);
            int dot = numberStr.indexOf('.');

            // System.out.println("dot:" + dot);
            double numDouble = 0;
            int numInt = 0;
            // number, like this 5.46467
            // Double
            if (dot == -1) {
                numInt = Integer.parseInt(numberStr);

//            System.out.println("numDouble:" + numDouble);
//            System.out.println("dot:" + dot);
                return numInt;
            } // number like this 13,25,37,489,5,6,7,8,9
            // Integer
            else {
                numDouble = Double.parseDouble(numberStr);

//            System.out.println("numInt:" + numInt);
//            System.out.println("dot:" + dot);
                return numDouble;
            }
        } // protection from state when number is equal 'null'
        else {
            return null;
        }

    }

    public static int countNumberAfterDot(String number) {

        int dot = number.indexOf('.');

        int lenAfterDot = 0;
        // Integer
        if (dot == -1) {
            lenAfterDot = 0;
        }
        // Double
        if (dot == 1) {
            lenAfterDot = number.length() - dot - 1;
        }

//        System.out.println("countNumberAfterDot number.length():" + number.length());
//        System.out.println("countNumberAfterDot lenAfterDot:" + dot);
//        System.out.println("countNumberAfterDot lenAfterDot:" + lenAfterDot);
        return lenAfterDot;
    }

    public static Number addNumbers(Number a, Number b) {
        if (a instanceof Double || b instanceof Double) {
            return a.doubleValue() + b.doubleValue();
        } else if (a instanceof Float || b instanceof Float) {
            return a.floatValue() + b.floatValue();
        } else if (a instanceof Long || b instanceof Long) {
            return a.longValue() + b.longValue();
        } else {
            return a.intValue() + b.intValue();
        }
    }

    public static Number subNumbers(Number a, Number b) {
        if (a instanceof Double || b instanceof Double) {
            System.out.println("D");
            return a.doubleValue() - b.doubleValue();
        } else if (a instanceof Float || b instanceof Float) {
            System.out.println("F");
            return a.floatValue() - b.floatValue();
        } else if (a instanceof Long || b instanceof Long) {
            System.out.println("L");
            return a.longValue() - b.longValue();
        } else {
            return a.intValue() - b.intValue();
        }
    }

    public static Number divideNumbers(Number a, Number b) {
        if (a instanceof Double || b instanceof Double) {
            System.out.println("D");
            return a.doubleValue() / b.doubleValue();
        } else if (a instanceof Float || b instanceof Float) {
            System.out.println("F");
            return a.floatValue() / b.floatValue();
        } else if (a instanceof Long || b instanceof Long) {
            System.out.println("L");
            return a.longValue() / b.longValue();
        } else {
            System.out.println("I");
            return a.doubleValue() / b.doubleValue();
        }
    }

    public static Number multiplyNumbers(Number a, Number b) {
        if (a instanceof Double || b instanceof Double) {
            System.out.println("D");
            return a.doubleValue() * b.doubleValue();
        } else if (a instanceof Float || b instanceof Float) {
            System.out.println("F");
            return a.floatValue() * b.floatValue();
        } else if (a instanceof Long || b instanceof Long) {
            System.out.println("L");
            return a.longValue() * b.longValue();
        } else {
            System.out.println("I");
            return a.intValue() * b.intValue();
        }
    }

    public static String negateNumber(Number a) {
        if (a instanceof Double) {
            System.out.println("D");
            String numStr = add_removeMinus(a);
            return numStr;
        } else if (a instanceof Float) {
            System.out.println("F");
            String numStr = add_removeMinus(a);
            return numStr;
        } else if (a instanceof Long) {
            System.out.println("L");
            String numStr = add_removeMinus(a);
            return numStr;
        } else {
            System.out.println("I");
            String numStr = add_removeMinus(a);
            return numStr;
        }
    }

    public static String add_removeMinus(Number a) {

        String numberStr = a.toString();

        int findMinus = numberStr.indexOf("-");

//        System.out.println("numberStr:" + numberStr);
//        System.out.println("findMinus:" + findMinus);
        if (findMinus == 0) {
            //                                   1         2
            numberStr = numberStr.replaceAll("([-]*)(\\d*\\.*\\d*)", "$2");
        } // -1
        else {
            numberStr = "-".concat(numberStr);
        }

        return numberStr;
    }

    public static String getSqrt(Number n) {

        String numStr = n.toString();

        int findMinus = numStr.indexOf("-");

        String numberStr;
        if (findMinus == 0) {
            numberStr = "Invalid input";
            return numberStr;
            //throw new mathException("Invalid input");
        } // -1
        else {
            Double number = Math.sqrt((double) n);
            numberStr = number.toString();
            return numberStr;
        }
    }

    // 1/x
    public static Number formulaOneDivideX(Number a) {
        if (a instanceof Double) {
            System.out.println("D");
            return 1 / a.doubleValue();
        } else if (a instanceof Float) {
            System.out.println("F");
            return 1 / a.floatValue();
        } else if (a instanceof Long) {
            System.out.println("L");
            return 1 / a.longValue();
        } else {
            System.out.println("I");
            return 1 / a.doubleValue();
        }
    }
    
//     public static String formulaFindPercent(String a, String b) {
//           // System.out.println("D");
//            // 500 * 20% = 500 * (500 * 20/100) = 50000 
//            // 500 / 20% = 500 / (500 * 20/100) = 
//            // 500 + 20% = 500 + (500 * 20/100) = 
//            // 500 - 20% = 500 - (500 * 20/100) = 
//            
//            
//            
//            Number percent = a.doubleValue() * (b.doubleValue()/100);
//            
//            return removeEndZeroFromInteger(percent.toString());
//    }
     
     public static Number parseNumberFromString(String text)  {
         
         NumberFormat nf = NumberFormat.getInstance();
         Number num = null;
         
        try {
            nf.parse(text).getClass().getName();
            
            return  Double.parseDouble(text); 
        } catch (ParseException ex) {
           
        }
        
        return  Double.parseDouble(text);  
     }

}
