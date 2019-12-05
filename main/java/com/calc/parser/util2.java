
package com.calc.parser;

public class util2 {
    
     public static Number parseNumber2(String input, String find, int type) {

        String regex1 = "(\\s*)([-]*\\d*)(\\.*)(\\d*)(\\.*)(\\s*)([+-\\/\\*]*)";
         //                 1              2            3       4        5            6               7
        String regex2 = "(\\s*)([-]*\\d*\\.*\\d*\\.*)(\\s*)([+-\\/\\*])(\\s*)([-]*\\d*\\.*\\d*\\.*)(\\s*)";

        String numberStr = "";
        switch(type) {
            default:break;
            case 1: numberStr = input.replaceAll(regex1, find); break;
            case 2: numberStr = input.replaceAll(regex2, find); break;
        }
        
        //String numberStr = input.matches(regex);

//        System.out.println("numberStr b :" + numberStr);

        // 'numvberStr' canno be equal ""
        if (!numberStr.equals("")) {
            
            if(numberStr.equals(".")) 
              numberStr = "0"+numberStr;
          // remove zero after dot  
            numberStr = numberStr.replaceAll("([-]*\\d*)(\\.*)(\\d*)(\\.*)([+-\\/\\*])([0]*$)", "$1$2$3");

//            System.out.println("numberStr a :" + numberStr);
            int dot = numberStr.indexOf('.');

            // System.out.println("dot:" + dot);
            double numDouble = 0;
            int numInt = 0;
            // number like this 13,25,37,489,5,6,7,8,9
            // Integer
            if (dot == -1) {
                
//                System.out.println("numberStr int :" + numberStr);
                numInt = Integer.parseInt(numberStr);

//                System.out.println("numInt:" + numInt);
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

//                System.out.println("numDouble:" + numDouble);

//            System.out.println("dot:" + dot);
                return numDouble;
            }
        } // protection from state when number is equal 'null'
        else {
            return null;
        }

    }
    
    public static String[] parseArguments(String input) {
        
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
            
            return  new String[]{ num1.toString(), "one_point"} ;
        } else if (input.matches(regex2)) {
            
            num1 = parseNumber2(input, "$2$3$4", 1);
            
            operand = input.replaceAll(regex2, "$4");
            System.out.println("bool2: " + input.matches(regex2) + "  " + num1);
            
            return  new String[]{ num1.toString() + operand, "one_point_point" };
        } else if (input.matches(regex3)) {
            
            num1 = parseNumber2(input, "$2", 2); 
            num2 = parseNumber2(input, "$6", 2);
            operand = input.replaceAll(regex3, "$4");
            
            System.out.println("bool3: " + input.matches(regex3) + "  " + num1  + "  " + operand );
            
            return  new String[]{ num1.toString() + operand + num2.toString(), "two_point",
                num1.toString(), operand.toString(), num2.toString() };
        } else {
             return new String[]{"", "no_points"};
        }

    }
    
    
}
