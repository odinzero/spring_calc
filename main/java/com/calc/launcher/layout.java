package com.calc.launcher;

import java.awt.*;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Insets;
import java.util.ArrayList;
import java.util.List;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.WindowConstants;
import javax.swing.border.Border;

public class layout {

    public static void setAlignments(JButton b) {
        //b.setSize(35, 25);
        b.setMinimumSize(new Dimension(45, 25));
        b.setPreferredSize(new Dimension(45, 25));
        b.setFont(new Font("TimesRoman", Font.PLAIN, 18));
        b.setMargin(new Insets(0, 0, 0, 0));
    }

    public static void setBigVerticalButton(JButton b) {
        b.setMinimumSize(new Dimension(45, 55));
        b.setPreferredSize(new Dimension(45, 55));
        b.setFont(new Font("TimesRoman", Font.PLAIN, 18));
        b.setMargin(new Insets(0, 0, 0, 0));
    }

    public static void setBigHorizontalButton(JButton b) {
        b.setMinimumSize(new Dimension(90, 25));
        b.setPreferredSize(new Dimension(90, 25));
        b.setFont(new Font("TimesRoman", Font.PLAIN, 18));
        b.setMargin(new Insets(0, 0, 0, 0));
    }

    public static void main(String[] args) {
        JFrame f = new JFrame();
        f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        //f.setSize(new Dimension(200, 400));

        JCheckBox ch_submenu1 = new JCheckBox();
        JCheckBox ch_submenu2 = new JCheckBox();
        JCheckBox ch_submenu3 = new JCheckBox();

        //  List<JCheckBox> view_box = new ArrayList();
        JMenuBar menuBar = new JMenuBar();

        JMenu view = new JMenu("View");

         JMenuItem standard   = new JMenuItem("Standard             Alt+1");
//        JButton standard = new JButton("MenuItem");
//        standard.setOpaque(true);
//        standard.setContentAreaFilled(false);
//        standard.setBorderPainted(false);
//        standard.setFocusable(false);
       // button.addActionListener(new buttonHandler());

        JMenuItem scientific = new JMenuItem("Sientific             Alt+2");
        JMenuItem programmer = new JMenuItem("Programmer      Alt+3");
        JMenuItem statistics = new JMenuItem("Statistics      Alt+4");
        JMenuItem history = new JMenuItem("History      Ctrl+H");
        JMenuItem digit_grouping = new JMenuItem("Digit grouping");
        JMenuItem basic = new JMenuItem("Basic    Ctrl+F4");
        JMenuItem unit_converion = new JMenuItem("Unit conversion    Ctrl+U");
        JMenuItem date_calculation = new JMenuItem("Date calculation      Ctrl+E");

        JMenu worksheets = new JMenu("Worksheets  ->");
        JMenuItem mortgage = new JMenuItem("Mortgage");
        JMenuItem vehicle_lease = new JMenuItem("Vehicle lease");
        JMenuItem fuel_economy_mpg = new JMenuItem("Fuel economy (mpg)");
        JMenuItem fule_economy_l = new JMenuItem("Fule economy (L/100km)");
        worksheets.add(mortgage);
        worksheets.add(vehicle_lease);
        worksheets.add(fuel_economy_mpg);
        worksheets.add(fule_economy_l);

//        JPanel pi = new JPanel();
//        pi.add(ch_submenu1);
//        pi.add(new JSeparator(SwingConstants.VERTICAL));
//        pi.add(standard);


        standard.add(new JSeparator(SwingConstants.VERTICAL));
        scientific.add(new JSeparator(SwingConstants.VERTICAL));
        programmer.add(new JSeparator(SwingConstants.VERTICAL));
        statistics.add(new JSeparator(SwingConstants.VERTICAL));

        history.add(new JSeparator(SwingConstants.VERTICAL));
        digit_grouping.add(new JSeparator(SwingConstants.VERTICAL));

        basic.add(new JSeparator(SwingConstants.VERTICAL));
        unit_converion.add(new JSeparator(SwingConstants.VERTICAL));
        date_calculation.add(new JSeparator(SwingConstants.VERTICAL));
        worksheets.add(new JSeparator(SwingConstants.VERTICAL));

        view.add(standard);
        view.add(scientific);
        view.add(programmer);
        view.add(statistics);
        view.add(new JSeparator());
        view.add(history);
        view.add(digit_grouping);
        view.add(new JSeparator());
        view.add(basic);
        view.add(unit_converion);
        view.add(date_calculation);
        view.add(worksheets);
        
        JMenu edit = new JMenu("Edit");
        JMenuItem copy = new JMenuItem("Copy      Ctrl+C");
        JMenuItem paste = new JMenuItem("Paste      Ctrl+V");
        
        JMenu history_submenu = new JMenu("History      -->");
        JMenuItem copy_history = new JMenuItem("Copy     ");
        JMenuItem edit_history = new JMenuItem("Edit      F2");
        JMenuItem cancel_edit = new JMenuItem("Cancel edit      Esc");
        JMenuItem clear = new JMenuItem("Clear      Ctrl+Shift+D");
        history_submenu.add(copy_history);
        history_submenu.add(edit_history);
        history_submenu.add(cancel_edit);
        history_submenu.add(clear);
        
        copy.add(new JSeparator(SwingConstants.VERTICAL));
        paste.add(new JSeparator(SwingConstants.VERTICAL));
        
        edit.add(copy);
        edit.add(paste);
        edit.add(new JSeparator());
        edit.add(history_submenu);
        
        JMenu help = new JMenu("Help");
        
        JMenuItem about = new JMenuItem("About");
        help.add(about);

        menuBar.add(view);
        menuBar.add(edit);
        menuBar.add(help);

        JPanel pField = new JPanel(); // +
        pField.setLayout(new BoxLayout(pField, BoxLayout.Y_AXIS)); //+

        JTextField tf = new JTextField() {
            @Override
            protected void paintComponent(Graphics g) {
                if (!isOpaque() && getBorder() instanceof RoundedCornerBorder) {
                    Graphics2D g2 = (Graphics2D) g.create();
                    g2.setPaint(getBackground());
                    g2.fill(((RoundedCornerBorder) getBorder()).getBorderShape(
                            0, 0, getWidth() - 1, getHeight() - 1));
                    g2.dispose();
                }
                super.paintComponent(g);
            }

            @Override
            public void updateUI() {
                super.updateUI();
                setOpaque(false);
                Border outsideBorder = new RoundedCornerBorder();
                Border insideBorder = BorderFactory.createEmptyBorder(10, 10, 10, 10);
                Border cb = BorderFactory.createCompoundBorder(outsideBorder, insideBorder);
                setBorder(cb);
                //setBackground(Color.red); 
            }
        };
        //tf.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        //tf.setBorder(BorderFactory.createRaisedBevelBorder());
        tf.setMinimumSize(new Dimension(240, 50)); // +
        tf.setPreferredSize(new Dimension(240, 50)); // +
        tf.setMaximumSize(new Dimension(240, 50)); // +
        tf.setBackground(Color.white);  // +
        pField.add(Box.createRigidArea(new Dimension(0, 10)));  // +
        pField.add(tf); // +

        JButton mc = new JButton("MC");
//        mc.setMaximumSize(new Dimension(25,25)); 
        JButton mr = new JButton("MR");
        JButton ms = new JButton("MS");
        JButton mplus = new JButton("M+");
        JButton mminus = new JButton("M-");
        setAlignments(mc);
        setAlignments(mr);
        setAlignments(ms);
        setAlignments(mplus);
        setAlignments(mminus);

        JButton arrleft = new JButton("<--");
        JButton ce = new JButton("CE");
        JButton c = new JButton("C");
        JButton plusminus = new JButton("+-");
        JButton sqrt = new JButton("sqr");
        setAlignments(arrleft);
        setAlignments(ce);
        setAlignments(c);
        setAlignments(plusminus);
        setAlignments(sqrt);

        JButton b7 = new JButton("7");
        JButton b8 = new JButton("8");
        JButton b9 = new JButton("9");
        JButton divide = new JButton("/");
        JButton percent = new JButton("%");
        setAlignments(b7);
        setAlignments(b8);
        setAlignments(b9);
        setAlignments(divide);
        setAlignments(percent);

        JButton b4 = new JButton("4");
        JButton b5 = new JButton("5");
        JButton b6 = new JButton("6");
        JButton multiply = new JButton("*");
        JButton one_x = new JButton("1/x");
        setAlignments(b4);
        setAlignments(b5);
        setAlignments(b6);
        setAlignments(multiply);
        setAlignments(one_x);

        JButton b1 = new JButton("1");
        JButton b2 = new JButton("2");
        JButton b3 = new JButton("3");
        JButton minus = new JButton("-");
        JButton equality = new JButton("=");
        setAlignments(b1);
        setAlignments(b2);
        setAlignments(b3);
        setAlignments(minus);
        setBigVerticalButton(equality);

        JButton b0 = new JButton("0");
        JButton point = new JButton(".");
        JButton plus = new JButton("+");
        setBigHorizontalButton(b0);
        setAlignments(point);
        setAlignments(plus);

        JPanel p0 = new JPanel(); // +                              
        p0.setBorder(BorderFactory.createEmptyBorder(10, 10, 0, 10));
        p0.setLayout(new GridLayout(0, 5, 5, 5));
        p0.add(mc);
        p0.add(mr);
        p0.add(ms);
        p0.add(mplus);
        p0.add(mminus);

        p0.add(arrleft);
        p0.add(ce);
        p0.add(c);
        p0.add(plusminus);
        p0.add(sqrt);

        p0.add(b7);
        p0.add(b8);
        p0.add(b9);
        p0.add(divide);
        p0.add(percent);

        p0.add(b4);
        p0.add(b5);
        p0.add(b6);
        p0.add(multiply);
        p0.add(one_x);

        JPanel pLow = new JPanel();
        GridBagLayout gbl = new GridBagLayout();
        pLow.setLayout(gbl);
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
        pLow.add(b1, gbc);
        // '2'
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.insets = new Insets(5, 5, 0, 0);// (int top, int left, int bottom, int right)
        pLow.add(b2, gbc);
        // '3'
        gbc.gridx = 2;
        gbc.gridy = 0;
        pLow.add(b3, gbc);
        // '-'
        gbc.gridx = 3;
        gbc.gridy = 0;
        pLow.add(minus, gbc);
        // '='
        gbc.gridx = 4;
        gbc.gridy = 0;
        gbc.gridheight = 2;
        gbc.insets = new Insets(5, 5, 0, 10);// (int top, int left, int bottom, int right)
        pLow.add(equality, gbc);
        // ------- last row ---------
        // '0'
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.NORTH;
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridheight = 1;
        gbc.gridwidth = 2;
        gbc.insets = new Insets(5, 10, 5, 0);// (int top, int left, int bottom, int right)
        pLow.add(b0, gbc);
        // '.'
        gbc.gridx = 2;
        gbc.gridy = 1;
        gbc.gridheight = 1;
        gbc.gridwidth = 1;
        gbc.insets = new Insets(5, 5, 5, 0);// (int top, int left, int bottom, int right)
        pLow.add(point, gbc);
        // '+'
        gbc.gridx = 3;
        gbc.gridy = 1;
        pLow.add(plus, gbc);
        
//        Icon icon = new ImageIcon("arrow-left.jpg");
//        JButton b = new JButton();
//        b.setIcon(icon); 
        
//        layout l = new layout();

        JPanel pMain = new JPanel();
        pMain.setLayout(new BoxLayout(pMain, BoxLayout.Y_AXIS));
        pMain.add(pField);
        pMain.add(p0);
        pMain.add(pLow);
//        pMain.add(l.setB());
        

        f.setJMenuBar(menuBar);
        // f.add(pMain);'
        f.setContentPane(pMain);
        f.pack();
        f.setVisible(true);
        f.setState(Frame.NORMAL);
    }
    
    public  JButton setB() {
         JButton b = new JButton();
         try {
            Image img = ImageIO.read(getClass().getResource("/spring_calc/src/main/resources/img/arrow-left.jpg"));
            b.setIcon(new ImageIcon(img));
        } catch (Exception ex) {
            System.out.println(ex);
        }
         return b;
    }
    
}
