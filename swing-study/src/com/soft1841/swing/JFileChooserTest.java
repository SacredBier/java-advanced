package com.soft1841.swing;

import org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

/**
 * 文件选择器组件JFileChooser
 */
public class JFileChooserTest extends JFrame implements ActionListener {

    private JButton chooseBtn;
    private JLabel pathLabel;
    private JFileChooser fileChooser;

    public JFileChooserTest() {
        init();
        setTitle("JFileChooserTest");
        setSize(900, 600);
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    private void init() {
        chooseBtn = new JButton("选择文件");
        pathLabel = new JLabel("暂无选择");
        add(chooseBtn, BorderLayout.NORTH);
        chooseBtn.addActionListener(this);
        Font font = new Font("方正喵呜体", Font.BOLD, 26);
        pathLabel.setFont(font);
        add(pathLabel);
    }

    public static void main(String[] args) {
        try {
            BeautyEyeLNFHelper.frameBorderStyle = BeautyEyeLNFHelper.FrameBorderStyle.osLookAndFeelDecorated;
            org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper.launchBeautyEyeLNF();
        } catch (Exception e) {
            e.printStackTrace();
        }
        new JFileChooserTest();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //创建JFileChooser对象
        fileChooser = new JFileChooser();
        //项目当前路径
        //fileChooser.setCurrentDirectory(new File("."));
        fileChooser.setCurrentDirectory(new File("C:\\Users\\SacredBier\\Pictures"));
        //打开对话框
        int result = fileChooser.showOpenDialog(null);
        if (result == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();
            String str = file.getAbsolutePath();
            pathLabel.setText(str);
        }
    }
}
