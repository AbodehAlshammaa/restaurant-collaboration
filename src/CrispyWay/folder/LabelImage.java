package CrispyWay.folder;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;

import javax.swing.JLabel;

public class LabelImage extends JLabel
{
    Image photo;

    public LabelImage(int x, int y, int Dimension, Image Logo) {
        photo = Logo;
        this.setBounds(x, 0, Dimension, Dimension);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D)g;
        g2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        g2d.drawImage(photo, 0, 0, null);
    }
}
