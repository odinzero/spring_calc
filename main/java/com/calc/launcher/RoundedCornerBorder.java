package com.calc.launcher;

import java.awt.*;
import java.awt.geom.*;
import javax.swing.border.AbstractBorder;

class RoundedCornerBorder extends AbstractBorder {
  private static final Color ALPHA_ZERO = new Color(0x0, true);
  @Override public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
    Graphics2D g2 = (Graphics2D) g.create();
    g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
    Shape border = getBorderShape(x, y, width - 1, height - 1);
    g2.setPaint(ALPHA_ZERO);
    Area corner = new Area(new Rectangle2D.Double(x, y, width, height));
    corner.subtract(new Area(border));
    g2.fill(corner);
    g2.setPaint(Color.GRAY);
    g2.draw(border);
    g2.dispose();
  }
  public Shape getBorderShape(int x, int y, int w, int h) {
    //int r = h; //h / 2;
    return new RoundRectangle2D.Double(x, y, w, h, 8, 8);
  }
  @Override public Insets getBorderInsets(Component c) {
    return new Insets(2, 2, 2, 2);
  }
  @Override public Insets getBorderInsets(Component c, Insets insets) {
    insets.set(2, 2, 2, 2);
    return insets;
  }
}