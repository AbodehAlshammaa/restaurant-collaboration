package CrispyWay.BrowseTheStore.ProductBlock;

import CrispyWay.Admin.MainFrame;
import CrispyWay.Saving.Food;

import java.awt.*;
import java.util.List;

public class DeleteThread extends Thread{
    ProductBlock_Panel productBlockPanel;
    public DeleteThread(ProductBlock_Panel productBlockPanel){
        this.productBlockPanel=productBlockPanel;
    }
    @Override
    public void run(){
        synchronized (this){

        List<ProductBlock_Panel> arr =  Food.getProductArray();
        List<Food> foods = Food.getFoodArray();
        int x =arr.indexOf(productBlockPanel);
        arr.remove(productBlockPanel);
        foods.remove(x);
        new Food().writeObject(foods);
        MainFrame.getFoodPanel().setPreferredSize(new Dimension(750, (new Food().LoadFood(MainPanel.ProductsContainer))));
        MainFrame.getScrollPane().repaint();

        }

    }
}
