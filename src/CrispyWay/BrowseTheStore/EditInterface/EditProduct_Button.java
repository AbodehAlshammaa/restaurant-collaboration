package CrispyWay.BrowseTheStore.EditInterface;

import CrispyWay.ButtonDesignes.OurButton;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.SwingConstants;


public class EditProduct_Button extends OurButton
{
    private Image orginalImageButton, enteredImageButton;
    private boolean ChangeImageButton = false, extendsPaint = true;

    public EditProduct_Button(int pointX, int pointY, int width, int height, Image icon1, Image icon2, boolean extendsPaint) {
        this.extendsPaint = extendsPaint;
        orginalImageButton = icon1;
        enteredImageButton = icon2;

        this.setBounds(pointX, pointY, width, height);
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent EventImage) {
                ChangeImageButton = true;
                repaint();
            }
            
            public void mouseExited(MouseEvent EventImage) {
                ChangeImageButton = false;
                repaint();
            }
        });

        this.setVisible(true);
    }

    public EditProduct_Button(int pointX, int pointY, int width, int height, Image icon1, Image icon2, String text) {
        orginalImageButton = icon1;
        enteredImageButton = icon2;

        super.setborder = false;
        super.setBackground(new Color(0x3a97d2));
        super.setBackgroundColor(new Color(0x3a97d2));
        super.setEnteredColor(Color.WHITE);
        super.setRadius(20);
        
        
        this.setText(text);
        this.setHorizontalAlignment(SwingConstants.LEFT);
        this.setFont(new Font("", getFont().getStyle(), getFont().getSize()+3));
        this.setForeground(Color.WHITE);
        this.setBounds(pointX, pointY, width, height);
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent EventImage) {
                EditProduct_Button.this.setForeground(new Color(0xfec20e));
                ChangeImageButton = true;
                repaint();
            }
            
            public void mouseExited(MouseEvent EventImage) {
                EditProduct_Button.this.setForeground(Color.WHITE);
                ChangeImageButton = false;
                repaint();
            }
        });

        this.setVisible(true);
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2D = (Graphics2D)g.create();
        
        g2D.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        if (extendsPaint) {
            super.paintComponent(g);
            if (ChangeImageButton)
                g2D.drawImage(enteredImageButton, 140, 4, null);
            else
                g2D.drawImage(orginalImageButton, 140, 4, null);
        } else {
            if (ChangeImageButton)
                g2D.drawImage(enteredImageButton, 0, 0, null);
            else
                g2D.drawImage(orginalImageButton, 0, 0, null);
        }
    }
}
