package CrispyWay.BrowseTheStore.ProductBlock;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import CrispyWay.BrowseTheStore.EditInterface.EditInterface_Panel;
import CrispyWay.Saving.Food;

public class Container_Panel extends JPanel
{
    public static Timer timerAnimationContainerOpen, timerAnimationContainerClose;
    protected Image ProductImage1 = new ImageIcon("src/CrispyWay/SigningGUI/images/Cheese Chicken Burger.jpg").getImage();
    protected Image ProductImage2 = new ImageIcon("src/CrispyWay/SigningGUI/images/square Cheese Potato.jpg").getImage();
    protected ProductBlock_Panel product1;
    protected ProductBlock_Panel product2;
    protected ProductBlock_Panel product3;
    protected ProductBlock_Panel product4;
    protected ProductBlock_Panel product5;
    protected ProductBlock_Panel product6;
    protected ProductBlock_Panel product7;
    protected ProductBlock_Panel product8;
    protected ProductBlock_Panel product9;
    protected ProductBlock_Panel product10;
    protected  ProductBlock_Panel product;

    public Container_Panel() {
        String des = "meat and potato ";
        product1 = new ProductBlock_Panel("src/CrispyWay/images/Cheese Chicken Burger.jpg" , "50$" , "Burger1" , des);
        Food f = new Food(des , product1.getNameProduct() , product1.getImagePathProduct() , product1.getPriceProduct());
        f.add();
        f.LoadFood(this);

        this.setLayout(null);
        this.setBounds(0, 0, 750, 630);
        this.setOpaque(true);
        

        timerAnimationContainerClose = new Timer(1, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent EventPanel) {
                if (getWidth() <= 0 && getHeight() <= 0) {
                    timerAnimationContainerClose.stop();
                    EditInterface_Panel.timerAnimationEditInterfaceOpen.start();
                } else {
                    setBounds(getX()+10, getY()+5, getWidth()-20, getHeight()-10);
                }
            }
        });

        timerAnimationContainerOpen = new Timer(1, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent EventPanel) {
                if (getWidth() >= 900 && getHeight() >= 500) {
                    timerAnimationContainerOpen.stop();
                } else {
                    setBounds(getX()-10, getY()-5, getWidth()+20, getHeight()+10);
                }
            }
        });
    }
}
