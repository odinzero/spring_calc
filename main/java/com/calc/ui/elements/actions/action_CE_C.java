
package com.calc.ui.elements.actions;

import com.calc.base.IActionListener;
import java.awt.event.ActionEvent;

public class action_CE_C extends  actionCommon {
    
    public boolean turnOnCalc = false;
    int typeButton;
    boolean c_pressed = false;
    public actionPoint action_point;

    public void setTypeButton(int typeButton) {
        this.typeButton = typeButton;
    }

    public int getTypeButton() {
        return typeButton;
    }

    public void setC_pressed(boolean c_pressed) {
        this.c_pressed = c_pressed;
    }

    public boolean isC_pressed() {
        return c_pressed;
    }
    
     public void setTurnOnCalc(boolean turnOnCalc) {
        this.turnOnCalc = turnOnCalc;
    }

    public boolean isTurnOnCalc() {
        return turnOnCalc;
    }

    public void setAction_point(actionPoint action_point) {
        this.action_point = action_point;
    }

    public actionPoint getAction_point() {
        return action_point;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        switch(typeButton){
            default: break;
            case 0: 
                if(histor != null) {
                   histor.getHistory().clear();
                   //System.out.println("__ histor:" + histor.getHistory().size());
                }
               // histor.getHistory().add(getPressKey());
                if(!isTurnOnCalc()) {
                    setTurnOnCalc(true); 
                }
                
                action_point.points.clear();
                
                getActResult().countPressedResult = 0;
                getActResult().resHistoryOperations.clear();
                
                getAct_percent().countPressedPercent = 0;
                getAct_percent().percentHistoryOperations.clear();
                
                System.out.println("___histor___" + getActResult().countPressedResult);
                
                setC_pressed(true);
                result.setText(getPressKey());
                break;
            case 1:
                break;
        }
        
    }
    
}
