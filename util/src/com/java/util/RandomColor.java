package com.java.util;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.Random;

/**
 * @author SacredBier
 * 随机颜色的测试
 * 2019/3/10
 */
public class RandomColor {
    public static void main(String[] args) throws IOException {
        Random random = new Random();
        //指定图片大小和类型
        BufferedImage bufferedImage = new BufferedImage(120,40,BufferedImage.TYPE_INT_RGB);
        //获取画笔
        Graphics graphics = bufferedImage.getGraphics();
        //获取字体
        Font font = new Font("方正喵呜体",Font.BOLD,20);
        graphics.setFont(font);
        graphics.setColor(Color.WHITE);
        //开始绘制
        graphics.fillRect(0,0,120,40);
        String s = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz1234567890";
        char[] chs= s.toCharArray();
        String string = new String();
        for(int i = 0; i <4 ; i++) {
            char ch = chs[random.nextInt(60)];
            string = string + ch;
        }
        //生成随机验证码
        graphics.setColor(Color.BLACK);
        graphics.drawString(string,40,28);
        //生成干扰线
        for(int i = 0; i < 20;i++) {
            int redRandom = random.nextInt(256);
            int greenRandom = random.nextInt(256);
            int blueRandom = random.nextInt(256);
            int x1 = random.nextInt(120);
            int y1 = random.nextInt(40);
            int x2 = random.nextInt(120);
            int y2 = random.nextInt(40);
            Color color = new Color(redRandom, greenRandom, blueRandom);
            graphics.setColor(color);
            graphics.drawLine(x1,y1,x2,y2);
        }
        //输出图片,并指定文件路径
        File file = new File("D:/code.jpg");
        //获取输出流
        OutputStream outputStream =new FileOutputStream(file);
        //将图片从缓冲区通过字节写到文件
        ImageIO.write(bufferedImage,"jpg",outputStream);
        //关闭输出流
        outputStream.close();
    }
}
