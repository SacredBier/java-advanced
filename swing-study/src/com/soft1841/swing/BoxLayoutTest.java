package com.soft1841.swing;

import org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper;

import javax.swing.*;
import java.awt.*;

/**
 * @author SacredBier
 * 盒子布局
 * 2019/3/29
 */
public class BoxLayoutTest extends JFrame {
    public BoxLayoutTest() {
        init();
        setTitle("BoxLayout布局");
        setSize(410, 730);
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    public void init() {
        //重新设置窗口布局为水平和垂直间距的BoxLayout
        setLayout(new BorderLayout(20, 20));
        //顶部面板
        JPanel topPanel = new JPanel();
        BoxLayout boxLayout = new BoxLayout(topPanel, BoxLayout.X_AXIS);
        topPanel.setLayout(boxLayout);
        topPanel.setBackground(new Color(255, 181, 247));
        topPanel.setPreferredSize(new Dimension(414, 100));
        JButton leftButton = new JButton("扫一扫");
        leftButton.setPreferredSize(new Dimension(80, 30));
        topPanel.add(leftButton);
        //加入一个glue, 会挤占两个按钮之间的空间
        topPanel.add(Box.createHorizontalGlue());
        //右侧按钮
        JButton rightButton = new JButton("会员码");
        rightButton.setPreferredSize(new Dimension(80, 30));
        topPanel.add(rightButton);
        //topPanel加入窗体顶部
        add(topPanel, BorderLayout.NORTH);
        //中间的middlePanel面板，垂直方向的BoxLayout布局
        JPanel middlePanel = new JPanel();
        middlePanel.setLayout(new BoxLayout(middlePanel,
                BoxLayout.Y_AXIS));
        //创建三个面板，加入middlePanel
        for (int i = 0; i < 3; i++) {
            JPanel jPanel = new JPanel();
            jPanel.setPreferredSize(new Dimension(410, 120));
            jPanel.setBackground(new Color(255, 181, 247));
            //分别将每次创建的面板加入middlePanel
            middlePanel.add(jPanel);
            //每个加入的面板下方，加入一个垂直方向的Strut，空出一点距离
            middlePanel.add(Box.createVerticalStrut(20));
        }
        add(middlePanel, BorderLayout.CENTER);
        JPanel bottomPanel = new JPanel();
        JLabel jLabel = new JLabel("1966年3月29日 勃列日涅夫成为苏联最高领导人");
        bottomPanel.add(jLabel);
        bottomPanel.setBackground(new Color(255, 181, 247));
        bottomPanel.add(Box.createVerticalStrut(20));
        add(bottomPanel, BorderLayout.SOUTH);
    }

    public static void main(String[] args) {
        BeautyEyeLNFHelper.frameBorderStyle = BeautyEyeLNFHelper.FrameBorderStyle.osLookAndFeelDecorated;
        try {
            BeautyEyeLNFHelper.launchBeautyEyeLNF();
        } catch (Exception e) {
            e.printStackTrace();
        }
        new BoxLayoutTest();
    }
}
