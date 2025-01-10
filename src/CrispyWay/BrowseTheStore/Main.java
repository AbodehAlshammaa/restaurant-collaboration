package CrispyWay.BrowseTheStore;

import java.awt.Color;
import java.awt.Image;

import javax.swing.ImageIcon;

import javax.swing.JFrame;

import CrispyWay.Admin.MainFrame;
import CrispyWay.BrowseTheStore.ProductBlock.MainPanel;
import CrispyWay.Saving.Food;


public class Main
{
    public static void main(String [] args) {
         new Food().starting();
        MainFrame frame = new MainFrame("idk" , "idk");

    }
}
