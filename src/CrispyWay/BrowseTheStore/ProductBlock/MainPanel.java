package CrispyWay.BrowseTheStore.ProductBlock;

import java.awt.*;

import javax.swing.*;

import CrispyWay.BrowseTheStore.EditInterface.EditInterface_Panel;

public class MainPanel extends JLabel
{
    public static int width = 1024, height = 768;
    Image ProductImage = new ImageIcon("src/CrispyWay/SigningGUI/images/Cheese Chicken Burger.jpg").getImage();
    protected static Container_Panel ProductsContainer = new Container_Panel();

    public static Container_Panel getProductsContainer() {
        return ProductsContainer;
    }

    EditInterface_Panel EditProduct = new EditInterface_Panel();
    public MainPanel() {
        this.setLayout(new BorderLayout());
        this.setSize(width, height);
        
        this.setBackground(Color.RED);
        this.add(EditProduct);
        this.add(ProductsContainer);
    }
}
