
package com.calc.base;

import com.calc.parser.History;
import com.calc.ui.elements.TextField;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;


public abstract class IActionListener implements ActionListener {
    
   //================================ '%' ======================================
   // number of pressed percentkey in sequence
   public int countPressedPercent; 
   // keep temporary results when '%' is pressed more then one time
   public List<String> percentHistoryOperations = new ArrayList(); 
    
   //=============================== '=' =======================================
   // keep temporary results when '=' is pressed more then one time
   public List<String> resHistoryOperations = new ArrayList();
   // number of pressed in sequence
   public int countPressedResult;
   
   //=============================== '.' =======================================
   // key point '.' pressed for first double number 
   public List<String> points = new ArrayList();
   
   // keep all processed calculation in memory
   public List<String> calcHistoryOperations = new ArrayList();
   // keep all key pressing for analisys and limitation
   public History histor;
    // JTextField  result
   public TextField result;
   // key like '0','1','2','3','4','5','6','7','8','9'
   public String pressKey ;
   
    public void setHistor(History histor) {
        this.histor = histor;
    }

    public History getHistor() {
        return histor;
    }

    public void setResult(TextField result) {
        this.result = result;
    }

    public TextField getResult() {
        return result;
    }

    public void setPressKey(String pressKey) {
        this.pressKey = pressKey;
    }

    public String getPressKey() {
        return pressKey;
    }
    
    public void setCountPressedResult(int countPressedResult) {
        this.countPressedResult = countPressedResult;
    }

    public int getCountPressedResult() {
        return countPressedResult;
    }

    public void setCalcHistoryOperations(List<String> calcHistoryOperations) {
        this.calcHistoryOperations = calcHistoryOperations;
    }

    public List<String> getCalcHistoryOperations() {
        return calcHistoryOperations;
    }

    public void setResHistoryOperations(List<String> resHistoryOperations) {
        this.resHistoryOperations = resHistoryOperations;
    }

    public List<String> getResHistoryOperations() {
        return resHistoryOperations;
    }

    public void setCountPressedPercent(int countPressedPercent) {
        this.countPressedPercent = countPressedPercent;
    }

    public int getCountPressedPercent() {
        return countPressedPercent;
    }

    public void setPercentHistoryOperations(List<String> percentHistoryOperations) {
        this.percentHistoryOperations = percentHistoryOperations;
    }

    public List<String> getPercentHistoryOperations() {
        return percentHistoryOperations;
    }
    
    
}
