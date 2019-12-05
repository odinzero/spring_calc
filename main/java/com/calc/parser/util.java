package com.calc.parser;

public class util {

    public static String parseOperation(String input, String find) {
        //                 1         2            3        4        5         6             7
        String regex = "(\\s*)([-]*\\d*\\.*\\d*)(\\s*)([+-\\/\\*])(\\s*)([-]*\\d*\\.*\\d*)(\\s*)";

        String s = input.replaceAll(regex, find);

//        System.out.println("s:" + s);
        Number num1 = parseNumber(input, "$2");
        Number num2 = parseNumber(input, "$6");

        // num1 and num2 should exist !
        if (num1 != null && num2 != null) {

//        System.out.println("num1:" + num1 + " num2:" + num2);
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

//            System.out.println("num1:" + num1);
            return num1.toString();
        } else if (num1 == null && num2 != null) {

//            System.out.println("num2:" + num2);
            return num2.toString();
        } else {

//            System.out.println("---:");
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

//        System.out.println("numberStr b :" + numberStr);
        // 'numvberStr' canno be equal ""
        if (!numberStr.equals("")) {
            // remove zero after dot  
            numberStr = numberStr.replaceAll("(\\d*)(\\.*)([0]*$)", "$1");

            //System.out.println("numberStr a :" + numberStr);
            int dot = numberStr.indexOf('.');

            // System.out.println("dot:" + dot);
            double numDouble = 0;
            int numInt = 0;
            // number like this 13,25,37,489,5,6,7,8,9
            // Integer
            if (dot == -1) {
                numInt = Integer.parseInt(numberStr);

//            System.out.println("numDouble:" + numDouble);
//            System.out.println("dot:" + dot);
                return numInt;
            } // number, like this 5.46467
            // Double
            else {
                // System.out.println("m: " + numberStr);  
                numDouble = Double.parseDouble(numberStr);
                // numInt = Integer.parseInt(numberStr); 

//            System.out.println("numInt:" + numInt);
//            System.out.println("dot:" + dot);
                return numDouble;
//              return numInt;
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

        return removeEndZeroFromInteger(numberStr);
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
            Number number = Math.sqrt((double) n);
            numberStr = number.toString();

            boolean isInteger = numberStr.endsWith(".0");

            if (isInteger) {
                numberStr = numberStr.substring(0, numberStr.length() - 2);
                return numberStr;
            } else {
                return numberStr;
            }

        }
    }

    // 1/x
    public static String formulaOneDivideX(Number a) {
        if (a instanceof Double) {
//            System.out.println("D");
            Number r = 1 / a.doubleValue();
            return removeEndZeroFromInteger(r.toString());
        } else if (a instanceof Float) {
//            System.out.println("F");
            Number r = 1 / a.floatValue();
            return removeEndZeroFromInteger(r.toString());
        } else if (a instanceof Long) {
//            System.out.println("L");
            Number r = 1 / a.longValue();
            return removeEndZeroFromInteger(r.toString());
        } else {
//            System.out.println("I");
            Number r = 1 / a.doubleValue();
            return removeEndZeroFromInteger(r.toString());
        }
    }

    public static String removeEndZeroFromInteger(String numberStr) {

        boolean isInteger = numberStr.endsWith(".0");

        if (isInteger) {
            numberStr = numberStr.substring(0, numberStr.length() - 2);
            return numberStr;
        } else {
            return numberStr;
        }
    }

    public static boolean isNumeric(String str) {
        return str.matches("^(?:(?:\\-{1})?\\d+(?:\\.{1}\\d+)?)$");
    }

    public static Number parseNumber(String input) {
        //                   1    
        String regex = "([-]*\\d*\\.*\\d*)";

        String numberStr = input.replaceAll(regex, "$1");

        System.out.println("numberStr b :" + numberStr);

        // 'numberStr' cannot be equal ""
        if (!numberStr.equals("")) {
            // remove zero after dot  
            numberStr = numberStr.replaceAll("(\\d*)(\\.*)([0]*$)", "$1");

            System.out.println("numberStr a :" + numberStr);
            int dot = numberStr.indexOf('.');

            // System.out.println("dot:" + dot);
            double numDouble = 0;
            double numInt = 0;
            // number, like this 5.46467
            // Double
            if (dot == -1) {
//                numInt = Integer.parseInt(numberStr);
                numDouble = Double.parseDouble(numberStr);

//            System.out.println("numDouble:" + numDouble);
//            System.out.println("dot:" + dot);
                return numDouble;
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

    public static int findChar(String str, char someChar) {
        int count = 0;

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == someChar) {
                count++;
            }
        }

        return count;
    }

}
