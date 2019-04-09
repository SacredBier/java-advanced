package com.soft1841.tar;

import javax.swing.*;
import java.io.*;

public class ImgCarousel extends JFrame{

    JLabel bgLabel;
    public void init() {
        bgLabel = new JLabel();
        ImgCarouselThread imgCarouselThread = new ImgCarouselThread();
        imgCarouselThread.setBgLabel(bgLabel);
        add(bgLabel);
        Thread thread = new Thread(imgCarouselThread);
        thread.start();
    }

    public ImgCarousel() {
        init();
        setTitle("图片轮播");
        setSize(1980, 1020);
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    public static void main(String[] args) {
        new ImgCarousel();
    }
}

class ImgCarouselThread implements Runnable {

    private String[] imgs = {"D:\\Img\\1.jpg", "D:\\Img\\2.jpg", "D:\\Img\\3.jpg", "D:\\Img\\4.jpg", "D:\\Img\\5.jpg", "D:\\Img\\6.jpg"};
    private JLabel bgLabel;

    public void setBgLabel(JLabel bgLabel) {
        this.bgLabel = bgLabel;
    }

    @Override
    public void run() {
        int i = 0;
        int len = imgs.length;
        while (true) {
            try {
                File file = new File(imgs[i]);
                InputStream inputStream = new FileInputStream(file);
                byte[] bytes = new byte[(int) file.length()];
                inputStream.read(bytes);
                Icon icon = new ImageIcon(bytes);
                bgLabel.setIcon(icon);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                i++;
                if (i == len) {
                    i = 0;
                }
            } catch (InternalError e) {
                e.printStackTrace();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                System.err.println("IO异常");
            }
        }
    }

}