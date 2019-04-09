package com.soft1841.tar;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

/**
 * 绘制彩色线条
 * @author SacredBier
 * 2019/4/10
 */

public class DrawLingFrame extends JFrame {
    public DrawLingFrame(){
        init();
        setTitle("绘制彩色线条");
        setSize(900, 600);
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public  void init(){
        getContentPane().setBackground(new Color(38, 38, 38));
        DrawLineThread drawLineThread=new DrawLineThread();
        drawLineThread.setFrame(this);
        new Thread(drawLineThread).start();
    }
    public static void main (String[] args) {
        new DrawLingFrame();
    }
}

class DrawLineThread implements Runnable {
    int x=200;
    int y=100;
    private JFrame frame;
    private Color[]colors={Color.WHITE,Color.BLUE,Color.GREEN,Color.ORANGE,Color.YELLOW,Color.red,Color.PINK,Color.LIGHT_GRAY};
    public void setFrame(JFrame frame){
        this.frame=frame;
    }
    @Override
    public void run () {
        Random random=new Random();
        while (true){
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Graphics graphics=frame.getGraphics();
            graphics.setColor(colors[random.nextInt(colors.length)]);
            graphics.drawLine(x,y,650,y);
            y+=10;
            if (y>=500){
                y=100;
            }
        }
    }
}
