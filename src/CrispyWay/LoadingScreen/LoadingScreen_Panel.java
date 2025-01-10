package CrispyWay.LoadingScreen;

import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;

import javax.swing.*;

import CrispyWay.folder.LabelImage;

public class LoadingScreen_Panel extends JPanel
{
    JFrame frame;
    Image LoadingScreenLogo =  new ImageIcon("src/CrispyWay/images/CrispyWay_Word.png").getImage();
    LabelImage Image = new LabelImage(180, 0, 400, LoadingScreenLogo);
    LoadingScreenProgressBar LoadingBar;

    LoadingScreen_Panel(LoadingScreen_Frame frame) {
        this.frame = frame;
        LoadingBar =new LoadingScreenProgressBar(frame);
        this.setLayout(null);
        this.setSize(LoadingScreen_Frame.WidthFrame, LoadingScreen_Frame.HEIGHT);
        this.add(Image);
        this.add(LoadingBar);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D)g;
        GradientPaint gradientLoadingScreen = new GradientPaint(0, getHeight()/2-300, new Color(0x74d1fc), 0, getHeight(), new Color(0xffb200), true);
        g2d.setPaint(gradientLoadingScreen);
        g2d.fillRect(0, 0, getWidth(), getHeight());
    }
}
