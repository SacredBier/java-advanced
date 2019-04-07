package com.soft1841.swing;

import org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class swingAndIOComposite extends JFrame implements ActionListener {

    private JButton chooseBtn, preBtn, nextBtn;
    private JPanel centerPanel, bottomPanel, cardPanel;
    private JFileChooser fileChooser;
    private JLabel imgLabel, imgInf;
    private CardLayout cardLayout;
    private GroupLayout groupLayout;

    public swingAndIOComposite() {
        init();
        setTitle("test");
        setSize(1920, 1080);
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    public void init() {
        bottomPanel = new JPanel();
        chooseBtn = new JButton("选择图片");
        preBtn = new JButton("前一张");
        nextBtn = new JButton("后一张");
        add(chooseBtn, BorderLayout.NORTH);
        bottomPanel.add(chooseBtn);
        bottomPanel.add(preBtn);
        bottomPanel.add(nextBtn);
        chooseBtn.addActionListener(this);
        preBtn.addActionListener(this);
        nextBtn.addActionListener(this);
        add(bottomPanel, BorderLayout.SOUTH);
        centerPanel = new JPanel();
        cardLayout = new CardLayout();
        centerPanel.setLayout(cardLayout);
        add(centerPanel, BorderLayout.CENTER);
    }

    public static void main(String[] args) {
        try {
            BeautyEyeLNFHelper.frameBorderStyle = BeautyEyeLNFHelper.FrameBorderStyle.osLookAndFeelDecorated;
            org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper.launchBeautyEyeLNF();
        } catch (Exception e) {
            e.printStackTrace();
        }
        new swingAndIOComposite();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == chooseBtn) {
            fileChooser = new JFileChooser();
            fileChooser.setCurrentDirectory(new File("C:\\Users\\SacredBier\\Pictures"));
            fileChooser.setMultiSelectionEnabled(true);
            int result = fileChooser.showOpenDialog(null);
            if (result == JFileChooser.APPROVE_OPTION) {
                File[] files = fileChooser.getSelectedFiles();
                for (File f : files) {
                    try {
                        byte[] bytes = new byte[(int) f.length()];
                        InputStream inputStream = new FileInputStream(f);
                        inputStream.read(bytes);
                        Icon icon = new ImageIcon(bytes);
                        imgLabel = new JLabel();
                        imgLabel.setIcon(icon);
                        String inf = ("图片路径:" + f.getName() + "\n" + "图片大小:" + bytes.length / 1048576 + "MB");
                        imgInf.setText(inf);
                        imgInf = new JLabel();
                        imgInf.setText(inf);
                        groupLayout  = new GroupLayout(null);
                        cardPanel.setLayout(groupLayout);
                        cardPanel.add(imgInf);
                        cardPanel.add(imgLabel);
                        centerPanel.add(cardPanel);
                    } catch (Exception ex) {
                        JOptionPane.showConfirmDialog(null, "异常");
                    }
                }
            }
        }
        if (e.getSource() == preBtn) {
            cardLayout.previous(centerPanel);
        }
        if (e.getSource() == nextBtn) {
            cardLayout.next(centerPanel);
        }
    }
}
