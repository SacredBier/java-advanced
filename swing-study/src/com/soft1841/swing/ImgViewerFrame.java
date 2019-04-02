package com.soft1841.swing;

import org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class ImgViewerFrame extends JFrame implements ActionListener {

    private JButton chooseBtn, preBtn, nextBtn;
    private JFileChooser fileChooser;
    private JPanel centerPanel, bottomPanel;
    private CardLayout cardLayout;
    private JLabel imgLabel;

    public ImgViewerFrame() {
        init();
        setTitle("ImgViewerTest");
        setSize(1920, 1080);
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    private void init() {
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
        centerPanel.setBackground(new Color(150, 0, 150));
        add(centerPanel, BorderLayout.CENTER);
    }

    public static void main(String[] args) {
        try {
            BeautyEyeLNFHelper.frameBorderStyle = BeautyEyeLNFHelper.FrameBorderStyle.osLookAndFeelDecorated;
            org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper.launchBeautyEyeLNF();
        } catch (Exception e) {
            e.printStackTrace();
        }
        new ImgViewerFrame();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == chooseBtn) {
            fileChooser = new JFileChooser();
            fileChooser.setCurrentDirectory(new File("C:\\Users\\SacredBier\\Pictures"));
            //设置文件为多选
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
                        centerPanel.add(imgLabel);
                    } catch (IOException ex) {
                        JOptionPane.showConfirmDialog(null, "IO异常");
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
