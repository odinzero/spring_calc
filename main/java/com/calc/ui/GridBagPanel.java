
package com.calc.ui;

import java.awt.*;
import javax.swing.*;

public class GridBagPanel extends MainPanel {    
    
    public void init2() {
        
        GridBagLayout gbl = new GridBagLayout();
        this.setLayout(gbl);
        GridBagConstraints gbc = new GridBagConstraints();
        // '1'
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.NORTH;
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.gridwidth = 1;
        gbc.insets = new Insets(5, 10, 0, 0);// (int top, int left, int bottom, int right)
        this.add((Component) this.getPanelComponents().get(0), gbc); 
        // '2'
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.insets = new Insets(5, 5, 0, 0);// (int top, int left, int bottom, int right)
        this.add((Component) this.getPanelComponents().get(1), gbc);
        // '3'
        gbc.gridx = 2;
        gbc.gridy = 0;
        this.add((Component) this.getPanelComponents().get(2), gbc);
        // '-'
        gbc.gridx = 3;
        gbc.gridy = 0;
        this.add((Component) this.getPanelComponents().get(3), gbc);
        // '='
        gbc.gridx = 4;
        gbc.gridy = 0;
        gbc.gridheight = 2;
        gbc.insets = new Insets(5, 5, 0, 10);// (int top, int left, int bottom, int right)
        this.add((Component) this.getPanelComponents().get(4), gbc);
        // last row 
        // '0'
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.NORTH;
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridheight = 1;
        gbc.gridwidth = 2;
        gbc.insets = new Insets(5, 10, 5, 0);// (int top, int left, int bottom, int right)
        this.add((Component) this.getPanelComponents().get(5), gbc);
        // '.'
        gbc.gridx = 2;
        gbc.gridy = 1;
        gbc.gridheight = 1;
        gbc.gridwidth = 1;
        gbc.insets = new Insets(5, 5, 5, 0);// (int top, int left, int bottom, int right)
        this.add((Component) this.getPanelComponents().get(6), gbc);
        // '+'
        gbc.gridx = 3;
        gbc.gridy = 1;
        this.add((Component) this.getPanelComponents().get(7), gbc);
    }
}
