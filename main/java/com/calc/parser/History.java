
package com.calc.parser;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class History {
    
    List<String> history;
    boolean firstTime = true;
    
    public void init() {
        history = new ArrayList();
        
//        history.add("9.5");
//        history.add("5");
        //history.add("4.1"); 
        
    }

    public void setHistory(List<String> history) {
        this.history = history;
    }

    public List<String> getHistory() {
        return history;
    }

    public boolean isFirstTime() {
        return firstTime;
    }

    public void setFirstTime(boolean firstTime) {
        this.firstTime = firstTime;
    }
    
    
    
    public static void main(String[] args) {
        
//        History h = new History();
//        h.init();
//        
//        System.out.println("" + util.isNumeric(h.getHistory().get(h.getHistory().size() - 1)) ); 
        
//        for (Iterator iterator = h.getHistory().iterator(); iterator.hasNext();) {
//            Object next = iterator.next();
//            System.out.println("" + next);
//        }
    }
    
    
}
