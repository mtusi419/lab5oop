package labb5;

import java.awt.*;
import java.awt.image.BufferedImage;

import static java.awt.image.BufferedImage.TYPE_INT_RGB;

public class JImageDisplay extends javax.swing.JComponent{
    private java.awt.image.BufferedImage bufferedImage;
    JImageDisplay(int width, int height){
        bufferedImage = new BufferedImage(width, height, TYPE_INT_RGB);
        super.setPreferredSize(new Dimension(width, height));
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage (bufferedImage, 0, 0, bufferedImage.getWidth(), bufferedImage.getHeight(), null);
    }

    public void clearImage(){
        int[] rgbData = new int[bufferedImage.getWidth()*bufferedImage.getHeight()];
        //создаем массив нулевых значений, чтобы окрасить все полотно в черный цвет
        for (int i=0; i < rgbData.length; i++){
            rgbData[i] = 0;
        }
        bufferedImage.setRGB(0, 0, bufferedImage.getWidth(),
                bufferedImage.getHeight(), rgbData, 0, bufferedImage.getWidth());
    }

    public void drawPixel(int x, int y, int rgbColor){
        bufferedImage.setRGB(x, y, rgbColor);
    }

    public java.awt.image.BufferedImage getBufferedImage(){
        return bufferedImage;
    }
}
