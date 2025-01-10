package CrispyWay.BrowseTheStore.ProductBlock;

import CrispyWay.ButtonDesignes.OurButton;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.SwingConstants;


public class ProductBlock_Button extends OurButton
{
    private Image orginalImageButton, enteredImageButton;
    private boolean ChangeImageButton = false, extendsPaint = true;

    public ProductBlock_Button(int pointX, int pointY, int width, int height, MouseAdapter EventButtonAdapter, Image icon1, Image icon2) {
        orginalImageButton = icon1;
        enteredImageButton = icon2;
        
        super.setborder = false;
        super.setBackground(new Color(0xfec20e));
        super.setBackgroundColor(new Color(0xfec20e));
        super.setEnteredColor(Color.WHITE);
        super.setRadius(20);

        this.setBounds(pointX, pointY, width, height);
        this.addMouseListener(EventButtonAdapter);
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

        this.setVisible(false);
    }

    public ProductBlock_Button(int pointX, int pointY, int width, int height, MouseAdapter EventButtonAdapter, Image icon1, Image icon2, boolean extendsPaint) {
        this(pointX, pointY, width, height, EventButtonAdapter, icon1, icon2);
        this.extendsPaint = extendsPaint;
    }

    public ProductBlock_Button(int pointX, int pointY, int width, int height, MouseAdapter EventButtonAdapter, Image icon1, Image icon2, String text) {
        this(pointX, pointY, width, height, EventButtonAdapter, icon1, icon2);
        this.setText(text);
        this.setHorizontalAlignment(SwingConstants.LEFT);
    }
    
    // public ProductBlock_Button(int pointX, int pointY, int width, int height, MouseAdapter EventButtonAdapter, String text) {
    //     this(pointX, pointY, width, height, text);
    //     this.addMouseListener(EventButtonAdapter);
    // }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2D = (Graphics2D)g.create();
        
        g2D.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        
        if (extendsPaint) {
            super.paintComponent(g);
            if (ChangeImageButton)
                g2D.drawImage(enteredImageButton, 60, 3, null);
            else
                g2D.drawImage(orginalImageButton, 60, 3, null);
        } else {
            if (ChangeImageButton)
                g2D.drawImage(enteredImageButton, 0, 0, null);
            else
                g2D.drawImage(orginalImageButton, 0, 0, null);
        }
    }
}
