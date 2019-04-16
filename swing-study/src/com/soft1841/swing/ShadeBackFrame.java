package com.soft1841.swing;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

/**
 * 渐变色背景背景
 */
public class ShadeBackFrame extends JFrame implements ActionListener {
    private int width;
    private int height;

    public ShadeBackFrame() {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        width = screenSize.width;
        height = screenSize.height;
        init();
        setTitle("渐变色背景窗体");
        setSize(width, height);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void init() {
        setLayout(null);
        ShadePanel shadePanel = new ShadePanel();
        shadePanel.setLayout(null);
        shadePanel.setBounds(0, 0, width, height);

        MyButton btn = new MyButton();
        btn.setPreferredSize(new Dimension(128, 128));
        btn.setBgIcon("2.png");
        btn.setFocusPainted(false);
        btn.setContentAreaFilled(true);
        btn.setBorderPainted(false);
        btn.addActionListener(this);
        btn.setBounds(200, -100, 300, 80);


        ImgPanel imgPanel = new ImgPanel();
        imgPanel.setLayout(null);
        imgPanel.setImgPath("bg3.png");
        imgPanel.setBounds(500, 200, 800, 800);

        JTextField iDTextField = new JTextField();
        iDTextField.setToolTipText("账号");
        iDTextField.setOpaque(false);
        iDTextField.setBounds(200, 180, 400, 40);
        JPasswordField passwordField = new JPasswordField();
        passwordField.setToolTipText("密码");
        passwordField.setOpaque(false);
        passwordField.setBounds(200, 260, 400, 40);

        MyButton loginBtn = new MyButton();
        loginBtn.setPreferredSize(new Dimension(128, 128));
        loginBtn.setBgIcon("login.png");
        loginBtn.setText("登录");
        loginBtn.setFocusPainted(false);
        loginBtn.setContentAreaFilled(false);
        loginBtn.setBorderPainted(false);
        loginBtn.addActionListener(this);
        loginBtn.setBounds(200, 380, 128, 80);

        MyButton siginUpBtn = new MyButton();
        siginUpBtn.setPreferredSize(new Dimension(128, 128));
        siginUpBtn.setBgIcon("siginUp.png");
        siginUpBtn.setText("取消");
        siginUpBtn.setFocusPainted(false);
        siginUpBtn.setContentAreaFilled(false);
        siginUpBtn.setBorderPainted(false);
        siginUpBtn.addActionListener(this);
        siginUpBtn.setBounds(400, 380, 128, 80);

        imgPanel.add(btn);
        imgPanel.add(passwordField);
        imgPanel.add(iDTextField);
        imgPanel.add(loginBtn);
        imgPanel.add(siginUpBtn);
        shadePanel.add(imgPanel);
        add(shadePanel);
    }

    public static void main(String[] args) {
        new ShadeBackFrame();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        new ShadeBackFrame();
    }
}

/**
 * 继承JPanel的自定义面板，实现渐变背景色，paintComponent重绘组件
 */
class ShadePanel extends JPanel {

    @Override
    protected void paintComponent(Graphics g1) {
        Graphics2D g = (Graphics2D) g1;
        super.paintComponent(g);
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                Color color1 = new Color(new Random().nextInt(255), new Random().nextInt(255), new Random().nextInt(255));
                Color color2 = new Color(new Random().nextInt(255), new Random().nextInt(255), new Random().nextInt(255));
                int width = getWidth();
                int height = getHeight();
                //创建填充模式对象
                GradientPaint paint = new GradientPaint(0, 0, color1, 0, height, color2);
                g.setPaint(paint);
                g.fillRect(0, 0, width, height);
            }

        };
        Timer timer = new Timer();
        timer.schedule(task, 0, 100);
    }
}

/**
 * 继承JPanel的自定义面板，绘制背景图
 */
class ImgPanel extends JPanel {
    private String imgPath;

    public void setImgPath(String imgPath) {
        this.imgPath = imgPath;
    }

    @Override
    protected void paintComponent(Graphics g) {
        String basePath = System.getProperty("user.dir");
        Image bg = null;
        try {
            bg = ImageIO.read(new File(basePath + "/swing-study/src/img/" + imgPath));
        } catch (IOException e) {
            e.printStackTrace();
        }
        g.drawImage(bg, 0, 0, getWidth(), getHeight(), this);
    }
}

/**
 * 自定义按钮，绘制背景图
 */
class MyButton extends JButton {
    private String bgIcon;

    public void setBgIcon(String bgIcon) {
        this.bgIcon = bgIcon;
    }

    @Override
    protected void paintComponent(Graphics g) {
        String basePath = System.getProperty("user.dir");
        Image bg = null;
        try {
            bg = ImageIO.read(new File(basePath + "/swing-study/src/img/" + bgIcon));
        } catch (IOException e) {
            e.printStackTrace();
        }
        g.drawImage(bg, 0, 0, getWidth(), getHeight(), this);
    }
}