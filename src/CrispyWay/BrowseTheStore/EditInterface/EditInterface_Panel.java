package CrispyWay.BrowseTheStore.EditInterface;

import java.awt.Color;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.RoundRectangle2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.Timer;

import CrispyWay.BrowseTheStore.ProductBlock.Container_Panel;
import CrispyWay.BrowseTheStore.ProductBlock.DetailsProduct;
import CrispyWay.BrowseTheStore.ProductBlock.MainPanel;
import CrispyWay.BrowseTheStore.ProductBlock.ProductBlock_Panel;

public class EditInterface_Panel extends JPanel
{
    public static Timer timerAnimationEditInterfaceOpen, timerAnimationEditInterfaceClose;
    private Timer timerAnimationDetailsProductOpen, timerAnimationDetailsProductClose;
    private int limitDownDetailsTap = 0;
    private boolean start = false;
    private final Image ProductModification_Icon = new ImageIcon("src/CrispyWay/SigningGUI/images/photo_3393229.png").getImage();
    // private final Image NameFoodIcon, PriceIcon;
    private final Image ChangeImage_Icon1 = new ImageIcon("src/CrispyWay/SigningGUI/images/image.png").getImage();
    private final Image ChangeImage_Icon2 = new ImageIcon("src/CrispyWay/SigningGUI/images/image_11305349.png").getImage();
    private final Image EditText_Icon1 = new ImageIcon("src/CrispyWay/SigningGUI/images/font-size (1).png").getImage();
    private final Image EditText_Icon2 = new ImageIcon("src/CrispyWay/SigningGUI/images/font-size_7597464.png").getImage();
    private final Image Close_Icon1 = new ImageIcon("src/CrispyWay/SigningGUI/images/letter-x (1).png").getImage();
    private final Image Close_Icon2 = new ImageIcon("src/CrispyWay/SigningGUI/images/letter-x.png").getImage();
    private final Image Save_Icon1 = new ImageIcon("src/CrispyWay/SigningGUI/images/save.png").getImage();
    private final Image Save_Icon2 = new ImageIcon("src/CrispyWay/SigningGUI/images/save_6047917.png").getImage();

    private EditProduct_Button ChangeImage_Button = new EditProduct_Button(445, 250, 170, 32, ChangeImage_Icon1, ChangeImage_Icon2, "Change Image");
    private EditProduct_Button EditText_Button = new EditProduct_Button(445, 290, 170, 32, EditText_Icon1, EditText_Icon2, "Edit Text");
    private EditProduct_Button CloseEditInterface_Button = new EditProduct_Button(655, 15, 32, 32, Close_Icon1, Close_Icon2, false);
    private EditProduct_Button SaveChanges_Button = new EditProduct_Button(360, 15, 32, 32, Save_Icon1, Save_Icon2, false);
    
    private Image NewImageProduct;
    private String NewPriceProduct;
    private DetailsProduct NewDetails;

    public EditInterface_Panel() {}

    public EditInterface_Panel(ProductBlock_Panel Product) {
        // NewImageProduct = Product.ImageProduct;
        // NewPriceProduct = Product.PriceProduct;
        // NewDetails = new DetailsProduct(350, 310, Product.Details.getText(), new Color(0x64ff00));

        this.setLayout(null);
        this.setBounds(MainPanel.width/2, MainPanel.height/2, 0, 0);
        this.setOpaque(false);
        this.add(ChangeImage_Button);
        this.add(EditText_Button);
        this.add(CloseEditInterface_Button);
        this.add(SaveChanges_Button);
        this.add(NewDetails);

        ChangeImage_Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent EventButton) {

            }
        });

        EditText_Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent EventButton) {
                if (limitDownDetailsTap == 0) {
                    start = true;
                    EditText_Button.setEnabled(false);
                    NewDetails.setVisible(true);
                    timerAnimationDetailsProductOpen.start();
                } else {    
                    EditText_Button.setEnabled(false);
                    NewDetails.setVisible(false);
                    timerAnimationDetailsProductClose.start();
                }
            }
        });

        CloseEditInterface_Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent EventButton) {
                if (EventButton.getSource() == CloseEditInterface_Button) {
                    timerAnimationEditInterfaceClose.start();
                }
            }
        });

        // SaveChanges_Button.addActionListener(new ActionListener() {
        //     @Override
        //     public void actionPerformed(ActionEvent EventButton) {
        //         if (EventButton.getSource() == SaveChanges_Button) {
        //             Product.ImageProduct = NewImageProduct;
        //             Product.PriceProduct = NewPriceProduct;
        //             Product.Details.setText(NewDetails.getText());
        //             timerAnimationEditInterfaceClose.start();
        //         }
        //     }
        // });

        timerAnimationDetailsProductOpen = new Timer(1, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent EventPanel) {
                if (limitDownDetailsTap == 310) {                    
                    timerAnimationDetailsProductOpen.stop();
                    EditText_Button.setEnabled(true);
                    EditText_Button.setText("Done");
                } else {
                    repaint();
                    limitDownDetailsTap += 10;
                }
            }
        });
        
        timerAnimationDetailsProductClose = new Timer(1, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent EventPanel) {
                if (limitDownDetailsTap == 0) {
                    timerAnimationDetailsProductClose.stop();
                    start = false;
                    EditText_Button.setEnabled(true);
                    EditText_Button.setText("Edit Details");
                } else {
                    repaint();
                    limitDownDetailsTap -= 10;
                }
            }
        });

        timerAnimationEditInterfaceOpen = new Timer(1, new ActionListener() {   
            @Override
            public void actionPerformed(ActionEvent EventPanel) {
                if (getWidth() >= 700 && getHeight() >= 350) {
                    timerAnimationEditInterfaceOpen.stop();
                } else {
                    EditInterface_Panel.this.setBounds(getX()-10, getY()-5, getWidth()+20, getHeight()+10);
                }
            }
        });
        
        timerAnimationEditInterfaceClose = new Timer(1, new ActionListener() {   
            @Override
            public void actionPerformed(ActionEvent EventPanel) {
                if (getWidth() <= 0 && getHeight() <= 0) {
                    timerAnimationEditInterfaceClose.stop();
                    Container_Panel.timerAnimationContainerOpen.start();
                } else {
                    EditInterface_Panel.this.setBounds(getX()+10, getY()+5, getWidth()-20, getHeight()-10);
                }
            }
        });
    }

    

    // public void setVisibleEditProductButtons(boolean VisibleButton) {
    //     ChangeImage_Button.setVisible(VisibleButton);
    //     EditText_Button.setVisible(VisibleButton);
    //     CloseEditInterface_Button.setVisible(VisibleButton);
    // }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2D = (Graphics2D)g.create();
        RoundRectangle2D round = new RoundRectangle2D.Double(0, 0, getWidth(), getHeight(), 80, 80);
        GradientPaint gradientPaint = new GradientPaint(0, 0, new Color(0xff8f00), getWidth(), getHeight(), new Color(0xffae00), true);

        g2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2D.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        g2D.setPaint(gradientPaint);
        g2D.fill(round);
        g2D.clip(round);
        g2D.drawImage(NewImageProduct, 0, 0, getWidth()/2, getHeight(), null);
        g2D.drawImage(ProductModification_Icon, 475, 10, null);
        gradientPaint = new GradientPaint(0, 0, new Color(0x0967b1), getWidth(), getHeight(), new Color(0x0eb1f3), true);
        g2D.setPaint(gradientPaint);
        g2D.fillRect(0, getHeight()-40, getWidth()/2, getHeight());
        g2D.setFont(new Font("plain", Font.PLAIN, 25));
        g2D.setColor(new Color(0x64ff00));
        g2D.drawString(NewPriceProduct, getWidth()/2-190, getHeight()-12);
        g2D.setColor(new Color(0x3a97d2));
        g2D.setFont(new Font("plain", Font.CENTER_BASELINE, 30));
        g2D.drawString("Edit Product", 435, 170);
        
        if (start) {
            g2D.setColor(Color.WHITE);
            g2D.fillRoundRect(0, 0, getWidth()/2, limitDownDetailsTap, (int)round.getArcWidth(), 0);
        }
    }
}
