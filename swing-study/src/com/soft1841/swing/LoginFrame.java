package com.soft1841.swing;

import org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper;
import org.jb2011.lnf.beautyeye.ch3_button.BEButtonUI;

import javax.swing.*;
import java.awt.*;

public class LoginFrame extends JFrame {

    private JLabel accountLabel,passwordLabel;
    private JTextField accountField;
    private JPasswordField passwordField;
    private JButton confirmButton,cancelButton;
    private JLabel bgLabel;
    private JCheckBox passwordJCheckBox;
    private JCheckBox autoJCheckBox;

    public LoginFrame() {
        init();
        setTitle("登录窗口");
        setSize(640,480);
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    private void init(){
        Font font = new Font("方正喵呜体",Font.PLAIN,18);
        accountLabel = new JLabel("账号");
        accountLabel.setFont(font);
        accountField = new JTextField();
        accountField.setFont(font);
        passwordLabel = new JLabel("密码");
        passwordLabel.setFont(font);
        passwordField = new JPasswordField();
        passwordField.setFont(font);
        passwordJCheckBox = new JCheckBox("记住密码");
        passwordJCheckBox.setFont(font);
        autoJCheckBox = new JCheckBox("自动登录");
        autoJCheckBox.setFont(font);
        confirmButton = new JButton("确认");
        confirmButton.setFont(font);
        cancelButton = new JButton("取消");
        cancelButton.setFont(font);
        setLayout(null);
        accountLabel.setBounds(140,60,140,35);
        accountField.setBounds(240,60,260,35);
        passwordLabel.setBounds(140,130,140,35);
        passwordField.setBounds(240,130,260,35);
        passwordJCheckBox.setBounds(140,200,100,35);
        autoJCheckBox.setBounds(240,200,100,35);
        confirmButton.setBounds(160,300,100,40);
        cancelButton.setBounds(380,300,100,40);
//        confirmButton.setUI(new BEButtonUI.setNormalColor(BEButtonUI.NormalColor.green));
//        cancelButton.setUI(new BEButtonUI.setNormalColor(BEButtonUI.NormalColor.green));
        add(accountField);
        add(accountLabel);
        add(passwordField);
        add(passwordLabel);
        add(passwordJCheckBox);
        add(autoJCheckBox);
        add(cancelButton);
        add(confirmButton);
        bgLabel = new JLabel();
        Icon bgIcon = new ImageIcon(LoginFrame.class.getResource("/img/bg.jpg"));
        bgLabel.setIcon(bgIcon);
        bgLabel.setBounds(0,0,640,480);
        add(bgLabel);
    }

    public static void main(String[] args) {
//        BeautyEyeLNFHelper.frameBorderStyle = BeautyEyeLNFHelper.FrameBorderStyle.osLookAndFeelDecorated;
//        try {
//            BeautyEyeLNFHelper.launchBeautyEyeLNF();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        new LoginFrame();
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }
        new LoginFrame();
    }
}
