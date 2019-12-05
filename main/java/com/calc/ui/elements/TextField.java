
package com.calc.ui.elements;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class TextField extends JTextField {
    
    public void init() {
        this.setEditable(false);
        setFont(new Font("TimesRoman", Font.PLAIN, 20));
        setHorizontalAlignment(SwingConstants.RIGHT);
//        this.setMinimumSize(new Dimension(100,50));
//        this.setPreferredSize(new Dimension(100,50));
//        this.setBackground(Color.white);
//        this.setSize(100, 50);
    }
}
