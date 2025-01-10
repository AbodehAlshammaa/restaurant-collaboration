package CrispyWay.Saving;

import CrispyWay.Admin.MainFrame;
import CrispyWay.BrowseTheStore.ProductBlock.Container_Panel;
import CrispyWay.BrowseTheStore.ProductBlock.DetailsProduct;
import CrispyWay.BrowseTheStore.ProductBlock.ProductBlock_Panel;
import CrispyWay.Interfaces.FilesMemorization;


import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;



public class Food implements FilesMemorization<List<Food>>{
    @Serial
    private static final long serialVersionUID = 1L;
   private static List<Food> arr;
   private static List<ProductBlock_Panel> foodArray;

    private String description ;
    private final String name , imagePath , price;
      public String getDescription() {
          return description;
      }
      public String getImagePath() {
          return imagePath;
      }public String getName() {
          return name;
      }
      public String getPrice() {
          return price;
      }
      
    public Food(){
        description = "test";
        name = "test" ;
        imagePath ="wda";
        price= "wda";
    }
    public Food(String description, String name, String imagePath, String price) {
        this.description = description;
        this.name = name;
        this.imagePath = imagePath;
        this.price = price;
    }

    @Override
    public void initialize() {
        List<Food> arr = new ArrayList<>();
        writeObject(arr);
    }

    @Override
    public boolean add() {
       Food f = new Food(description , name , imagePath , price);
       arr.add(f);
       ProductBlock_Panel p = new ProductBlock_Panel(f.imagePath,f.price,f.name,f.description);
       foodArray.add(p);
       writeObject(arr);
        return false;
    }
    @SuppressWarnings("unchecked")
    @Override
    public List<Food> getObject() {

        File fileTest = new File("src/Files/FoodList.txt");
        if (fileTest.length() == 0) {
            initialize();
        }
        try (FileInputStream file = new FileInputStream("src/Files/FoodList.txt");
             ObjectInputStream in = new ObjectInputStream(file)) {

            return (List<Food>) in.readObject();

        } catch (IOException | ClassNotFoundException e) {
            JOptionPane.showMessageDialog(null, "An error happened. Please try again.", "Error", JOptionPane.INFORMATION_MESSAGE);
        }

        return null;
    }

    @Override
    public void deleteObject() {

           List<Food> arr = getObject();
           arr.clear();
           writeObject(arr);
    }

    @Override
    public void writeObject(List<Food> object) {
        try (FileOutputStream file = new FileOutputStream("src/Files/FoodList.txt");
             ObjectOutputStream objectOutputStream = new ObjectOutputStream(file)) {
            objectOutputStream.writeObject(object);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "An error happened. Please try again.", "Error", JOptionPane.INFORMATION_MESSAGE);
        }
    }
    public void starting(){
          arr = getObject();
          foodArray = new ArrayList<>();

        for(Food it : arr){
            foodArray.add(new ProductBlock_Panel(it.imagePath , it.price , it.name ,
                    it.description));
        }
    }
    public int LoadFood(Container_Panel p){
        p.removeAll();
        int startingX=20;
        int currX = startingX , currY = 20;
        int endingX = 700 - ProductBlock_Panel.ZoomOut.width;

        for(ProductBlock_Panel it : foodArray){
            if(currX > endingX){
                currX = startingX;
                currY += ProductBlock_Panel.ZoomOut.height +20;
            }
            it.setBounds(currX, currY , ProductBlock_Panel.ZoomOut.width, ProductBlock_Panel.ZoomOut.height);
            currX+=ProductBlock_Panel.ZoomOut.width + 20;
            p.add(it);
        }
            p.repaint();
       return currY+400;
    }
    public static List<ProductBlock_Panel> getProductArray(){
       return foodArray;
    }
    public static List<Food> getFoodArray(){
          return arr;
    }
}
