package com.soft1841.tar;

import javax.swing.*;
import java.awt.*;

/**
 * @author SacredBier
 * 2019/4/11
 */
public class DrawImageTest extends JFrame {
    public DrawImageTest() {
        this.setSize(1980, 1020);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        add(new CanvasTest());
        this.setTitle("绘制图像");
    }
    public static void main(String[] args) {
        new DrawImageTest().setVisible(true);
    }
    class CanvasTest extends Canvas {
        public void paint(Graphics g) {
            super.paint(g);
            Graphics2D g2 = (Graphics2D) g;
            Image img = new ImageIcon(this.getClass().getResource("/Img/1.jpg")).getImage();
            g2.drawImage(img, 0, 0, this);
        }
    }
}