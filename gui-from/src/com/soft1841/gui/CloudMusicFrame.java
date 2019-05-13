package com.soft1841.gui;

import javax.swing.*;

public class CloudMusicFrame {
    private JPanel mainPanel;
    private JPanel leftPanel;
    private JButton 搜索Button;
    private JButton 发现Button;
    private JButton MVButton;
    private JButton 朋友Button;
    private JPanel centerPanel;
    private JLabel bottomLabel;
    private JLabel bannerLabel;
    private JPanel musicPanel;
    private JLabel music1;
    private JLabel music2;
    private JLabel music3;

    public static void main(String[] args) throws Exception{
        String lookAndFeel = UIManager.getSystemLookAndFeelClassName();
        UIManager.setLookAndFeel(lookAndFeel);
        JFrame frame = new JFrame("CloudMusicFrame");
        frame.setContentPane(new CloudMusicFrame().mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.pack();
        frame.setVisible(true);
    }
}
