package CrispyWay.BrowseTheStore.ProductBlock;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.RoundRectangle2D;
import java.util.ArrayList;
import java.util.*;
import javax.swing.*;
import javax.swing.Timer;

import CrispyWay.Saving.Food;


public class ProductBlock_Panel extends JLabel
{
    boolean paintGreen1ToGreen2 = true;
    private int Green1 = 80, Green2 = 120;
    private GradientPaint gradientColorBlock = new GradientPaint(0, 0, new Color(255, Green1, 0), getWidth(), getHeight(), new Color(255, Green2, 0),true);
    private GradientPaint gradientShadowBlock = new GradientPaint(0, getHeight(), new Color(0, 0, 0, 175), 0, 0, new Color(0, 0, 0, 0));

    private int limitDownDetailsTap = 0;
    private boolean start = false;
    private boolean VisibleInterfaceProductButtons = true, VisibleBackfaceProductButtons = false;


    public String getNameProduct() {
        return NameProduct;
    }

    public Image getImageProduct() {
        return ImageProduct;
    }

    public DetailsProduct getDescriptionProduct() {
        return DescriptionProduct;
    }
    public String getPriceProduct(){
        return PriceProduct;
    }

    public static final Dimension ZoomIn = new Dimension(175, 195), ZoomOut = new Dimension(155, 175);
    private Timer timerAnimationProductBlockZoomIn, timerAnimationProductBlockZoomOut;
    private Timer timerAnimationDetailsProductOpen, timerAnimationDetailsProductClose;
    private Timer timerAnimationGradientColor;

    private boolean setShadow = false;
    private String ImagePathProduct;
    private Image ImageProduct;
    private String PriceProduct;
    private String NameProduct;
    protected DetailsProduct DescriptionProduct;

    public String getImagePathProduct() {
        return ImagePathProduct;
    }

    MouseAdapter mouseEvent = new MouseAdapter() {
        @Override
        public void mouseEntered(MouseEvent e) {
            timerAnimationProductBlockZoomOut.stop();
            timerAnimationProductBlockZoomIn.start();
        }

        @Override
        public void mouseExited(MouseEvent e) {
            timerAnimationProductBlockZoomIn.stop();
            timerAnimationProductBlockZoomOut.start();
        }
    };

    private final Image imageArrowButton1 = new ImageIcon("src/CrispyWay/images/arrows_exit.png").getImage();
    private final Image imageArrowButton2 = new ImageIcon("src/CrispyWay/images/arrows_entered.png").getImage();
    private final Image imageCartButton1 = new ImageIcon("src/CrispyWay/images/shopping-cart_exit.png").getImage();
    private final Image imageCartButton2 = new ImageIcon("src/CrispyWay/images/shopping-cart_entered.png").getImage();
    private final Image imageDetailsButton1 = new ImageIcon("src/CrispyWay/images/book_exit.png").getImage();
    private final Image imageDetailsButton2 = new ImageIcon("src/CrispyWay/images/book_entered.png").getImage();
    private final Image imageBasketDeleteButton1 = new ImageIcon("src/CrispyWay/images/delete_exit.png").getImage();
    private final Image imageBasketDeleteButton2 = new ImageIcon("src/CrispyWay/images/delete_entered.png").getImage();
    private final Image imageEditeButton1 = new ImageIcon("src/CrispyWay/images/edit_exit.png").getImage();
    private final Image imageEditeButton2 = new ImageIcon("src/CrispyWay/images/edit_entered.png").getImage();

    private ProductBlock_Button closeDetails_Button = new ProductBlock_Button(144, 165, 24, 24, mouseEvent, imageArrowButton1, imageArrowButton2, false);
    private ProductBlock_Button addToCart_Button = new ProductBlock_Button(37, 130, 101, 32, mouseEvent, imageCartButton1, imageCartButton2, "Add To");
    private ProductBlock_Button details_Button = new ProductBlock_Button(37, 75, 101, 32, mouseEvent, imageDetailsButton1, imageDetailsButton2, "Details");
    private ProductBlock_Button delete_Button = new ProductBlock_Button(145, 7, 24, 24, mouseEvent, imageBasketDeleteButton1, imageBasketDeleteButton2, false);
    private ProductBlock_Button Edit_Button = new ProductBlock_Button(37, 130, 101, 32, mouseEvent, imageEditeButton1, imageEditeButton2, "Editing");

    public ProductBlock_Panel(){}
    public ProductBlock_Panel(String ImagePathProduct, String PriceProduct, String NameProduct, String Description) {
        this.ImagePathProduct = ImagePathProduct;
        this.ImageProduct = new ImageIcon(ImagePathProduct).getImage();
        this.PriceProduct = PriceProduct;
        this.NameProduct = NameProduct;
        this.DescriptionProduct = new DetailsProduct(155, 175, Description, mouseEvent);

        this.setLayout(null);
        this.setBounds(0, 0, (int)ZoomOut.getWidth(), (int)ZoomOut.getHeight());
        this.addMouseListener(mouseEvent);
        this.add(addToCart_Button);
        this.add(Edit_Button);
        this.add(details_Button);
        this.add(delete_Button);
        this.add(closeDetails_Button);
        this.add(DescriptionProduct);
        this.setOpaque(false);

        timerAnimationGradientColor = new Timer(500, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent EventPanel) {
                if (Green1 <= 200) {
                    Green1++;
                } else {
                    Green1 = 80;
                    paintGreen1ToGreen2 = true;
                }

                if (Green2 <= 200) {
                    Green2++;
                } else {
                    Green2 = 80;
                    paintGreen1ToGreen2 = false;
                }

                if (paintGreen1ToGreen2)
                    gradientColorBlock = new GradientPaint(0, 0, new Color(255, Green1, 0), getWidth(), getHeight(), new Color(255, Green2, 0), true);
                else
                    gradientColorBlock = new GradientPaint(0, 0, new Color(255, Green2, 0), getWidth(), getHeight(), new Color(255, Green1, 0), true);

                repaint();
            }
        });
        timerAnimationGradientColor.start();

        addToCart_Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent EventButton) {
                if (EventButton.getSource() == addToCart_Button) {

                }
            }
        });

        details_Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent EventButton) {
                if (EventButton.getSource() == details_Button) {
                    start = true;
                    DescriptionProduct.setVisible(true);
                    ProductBlock_Panel.this.VisibleInterfaceProductButtons = false;
                    ProductBlock_Panel.this.setVisibleInterfaceProductButtons(ProductBlock_Panel.this.VisibleInterfaceProductButtons);
                    timerAnimationDetailsProductOpen.start();
                }
            }
        });

        delete_Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent EventButton) {
                if (EventButton.getSource() == delete_Button) {
                  DeleteThread delete =new DeleteThread(ProductBlock_Panel.this);
                   delete.start();



                }
            }
        });

//        Edit_Button.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent EventButton) {
//                if (EventButton.getSource() == Edit_Button) {
//                    mainPanel.remove(mainPanel.EditProduct);
//                    mainPanel.EditProduct = new EditInterface_Panel(/* photo, text, Details.getText(),  */ProductBlock.this);
//                    mainPanel.add(mainPanel.EditProduct);
//                    Container_Panel.timerAnimationContainerClose.start();
//                }
//            }
//        });

        closeDetails_Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent EventButton) {
                if (EventButton.getSource() == closeDetails_Button) {
                    DescriptionProduct.setVisible(false);
                    VisibleBackfaceProductButtons = false;
                    closeDetails_Button.setVisible(VisibleBackfaceProductButtons);
                    timerAnimationDetailsProductClose.start();
                }
            }
        });

        timerAnimationDetailsProductOpen = new Timer(1, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent EventPanel) {

                if (limitDownDetailsTap == 200) {
                    VisibleBackfaceProductButtons = true;
                    closeDetails_Button.setVisible(VisibleBackfaceProductButtons);
                    timerAnimationDetailsProductOpen.stop();
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

                    ProductBlock_Panel.this.VisibleInterfaceProductButtons = true;
                    start = false;
                    timerAnimationDetailsProductClose.stop();
                } else {
                    repaint();
                    limitDownDetailsTap -= 10;
                }
            }
        });

        timerAnimationProductBlockZoomIn = new Timer(1, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent EventPanel) {
                setShadow = true;
                if (getWidth() >= ZoomIn.getWidth() && getHeight() >= ZoomIn.getHeight()) {
                    timerAnimationProductBlockZoomIn.stop();
                    closeDetails_Button.setVisible(VisibleBackfaceProductButtons);
                    setVisibleInterfaceProductButtons(VisibleInterfaceProductButtons);
                } else {
                    ProductBlock_Panel.this.setBounds(getX()-1, getY()-1, getWidth()+2, getHeight()+2);
                    gradientShadowBlock = new GradientPaint(0, getHeight(), gradientShadowBlock.getColor1(), 0, (int)gradientShadowBlock.getPoint2().getY()+2, gradientShadowBlock.getColor2());
                    repaint();
                }
            }
        });

        timerAnimationProductBlockZoomOut = new Timer(1, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent EventPanel) {
                if (getWidth() <= ZoomOut.getWidth() && getHeight() <= ZoomOut.getHeight()) {
                    timerAnimationProductBlockZoomOut.stop();
                } else {
                    setShadow = false;
                    closeDetails_Button.setVisible(false);
                    setVisibleInterfaceProductButtons(false);
                    ProductBlock_Panel.this.setBounds(getX()+1, getY()+1, getWidth()-2, getHeight()-2);
                    gradientShadowBlock = new GradientPaint(0, getHeight(), gradientShadowBlock.getColor1(), 0, (int)gradientShadowBlock.getPoint2().getY()-2, gradientShadowBlock.getColor2());
                    repaint();
                }
            }
        });
    }

    public void setImageProduct(String NewImagePathProduct) {
        ImagePathProduct = NewImagePathProduct;
        ImageProduct = new ImageIcon(NewImagePathProduct).getImage();
    }

    public void setPriceProduct(String NewPriceProduct) {
        PriceProduct = NewPriceProduct;
    }

    public void setDetails(DetailsProduct NewDescription) {
        DescriptionProduct = NewDescription;
    }



    public void setVisibleInterfaceProductButtons(boolean VisibleInterfaceProductButtons) {
        addToCart_Button.setVisible(VisibleInterfaceProductButtons);
        details_Button.setVisible(VisibleInterfaceProductButtons);
        delete_Button.setVisible(VisibleInterfaceProductButtons);
        Edit_Button.setVisible(VisibleInterfaceProductButtons);
    }


    @Override
    public void paintComponent(Graphics g) {

        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D)g.create();
        RoundRectangle2D roundBlock = new RoundRectangle2D.Double(0, 0, getWidth(), getHeight(), 40, 40);
        GradientPaint gradientColorBackgroundBlock = new GradientPaint(0, 0, new Color(0x0967b1), getWidth(), getHeight(), new Color(0x0eb1f3),true);

        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        g2d.setPaint(gradientColorBackgroundBlock);
        g2d.setFont(new Font("plain", Font.PLAIN, 15));

        g2d.fill(roundBlock);
        g2d.clip(roundBlock);
        g2d.drawImage(ImageProduct, 0, 0, getWidth(), getHeight()-20,null);
        g2d.setColor(new Color(0x64ff00));
        g2d.drawString("50$", getWidth()/2-10, getHeight()-5);
        g2d.setPaint(gradientShadowBlock);
        if (setShadow)
        g2d.fillRect(0, 0, getWidth(), getHeight());

        if (start) {
            g2d.setPaint(gradientColorBlock);
            g2d.fillRoundRect(0, 0, getWidth(), limitDownDetailsTap, (int)roundBlock.getArcWidth(), 0);
        } else {
            g2d.setFont(new Font("italic", Font.ITALIC, 14));
            g2d.setColor(Color.WHITE);
            g2d.drawString(NameProduct, 7, 20);
        }
    }
    @Override
    protected void paintBorder(Graphics g) {
    }

}
