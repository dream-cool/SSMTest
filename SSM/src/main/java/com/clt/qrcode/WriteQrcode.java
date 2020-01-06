package com.clt.qrcode;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;



public class WriteQrcode {

    /**
     *
     *
     * @param content 显示的内容
     * @param inPath  生成成功后存放的路径
     * @param srcPath 二维码中添加的图片路径
     */

//    public  static  void  getQrcodeImage(String content, String inPath, String srcPath) {
//
//        int width = 235;
//
//        int height = 235;
//        // 实例化一个对象
//        Qrcode qrcode = new Qrcode();
//        // 编码方式
//        qrcode.setQrcodeEncodeMode('B');
//        // 设置拍错率
//        qrcode.setQrcodeErrorCorrect('H');
//        // 二维码的版本
//        qrcode.setQrcodeVersion(15);
//        // 绘制二维码
//        // 画板
//        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
//        // 画笔
//        Graphics2D gs = image.createGraphics();
//        // 设置背景颜色 白色
//        gs.setBackground(Color.white);
//        // 设置二维码的颜色
//        gs.setColor(Color.black);
//        // 创建一个二维码的绘制区域
//        gs.clearRect(0, 0, width, height);
//        byte[] codeOut;
//        try {
//            codeOut = content.getBytes("utf-8");
//            boolean[][] code = qrcode.calQrcode(codeOut);
//            for (int i = 0; i < code.length; i++) {
//                for (int j = 0; j < code.length; j++) {
//                    if (code[j][i]) {
//                        gs.fillRect(j * 3 + 2, i * 3 + 2, 3, 3);
//                    }
//                }
//            }
//
//            // 加载logo  D:/111.png 这个你需要改成你自己的
//            if (srcPath != null) {
//                File file = new File(srcPath);
//                Image srcImage = ImageIO.read(file);
////            int imgWidth = srcImage.getWidth(null);
////            int imgHeith = srcImage.getHeight(null);
//                gs.drawImage(srcImage, (width-width/5)/2, (height-height/5)/2, width/5, height/5, null);
//            }
//            // 释放资源
//            gs.dispose();
//            image.flush();
//            // 写入指定路径
//            System.out.println(inPath);
//            ImageIO.write(image, "jpg", new File(inPath));
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }

//    public static void main(String[] args) {
//        getQrcodeImage("sss","./src/main/webapp/images/a.png",null);
//    }
}
