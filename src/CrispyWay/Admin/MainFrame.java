package CrispyWay.Admin;


import CrispyWay.Accounts.SigningFrame;
import CrispyWay.Accounts.Signing_Buttons.loginRegisterButton;
import CrispyWay.BrowseTheStore.ProductBlock.Container_Panel;
import CrispyWay.BrowseTheStore.ProductBlock.MainPanel;
import CrispyWay.BrowseTheStore.ProductBlock.ProductBlock_Panel;
import CrispyWay.ButtonDesignes.OurButton;
import CrispyWay.LoadingScreen.LoadingScreen_Frame;
import CrispyWay.Saving.Accounts;
import CrispyWay.Saving.Food;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainFrame extends JFrame {
    String name , password;
   private final static MainPanel foodPanel = new MainPanel();
    private final static JScrollPane scrollPane = new JScrollPane();

    public static JScrollPane getScrollPane() {
        return scrollPane;
    }

    public static MainPanel getFoodPanel() {
        return foodPanel;
    }

    private final static ButtonsPanel buttonPanel = new ButtonsPanel();
       int height=0 ,  width = 0;
   public MainFrame(String name , String password){
       this.name = name;
       this.password = password;
       this.setSize(new Dimension(1000,780));
       this.setResizable(false);
       this.setLayout(null);
       foodPanel.setPreferredSize(new Dimension(750,  new Food().LoadFood(MainPanel.getProductsContainer())));
       scrollPane.setViewportView(foodPanel);
       scrollPane.setBounds(220, 50, 750, 630);
       scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
       scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
       this.add(scrollPane);
       this.add(buttonPanel);
       scrollPane.setVisible(false);
       ButtonsPanel.getMealButton().addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
               scrollPane.setVisible(true);
                width = 0 ; height = 0;
               Timer timer = new Timer(1, new ActionListener() {
                   @Override
                   public void actionPerformed(ActionEvent e) {
                       width = Math.min(750, width + 40);
                       height = Math.min(630, height + 40);
                       scrollPane.setBounds(220, 50, width, height);
                       if ( width >= 750 ) {
                           ((Timer) e.getSource()).stop();
                       }

                   }
               });
               timer.start();


           }
       });
       ButtonsPanel.getReportButton().addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
               scrollPane.setVisible(false);
           }
       });
       ButtonsPanel.getAccountDetailsButton().addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
               scrollPane.setVisible(false);
           }
       });

       ButtonsPanel.getLogoutButton().addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
               MainFrame.this.dispose();
               loginRegisterButton.signInOk=false;
               Accounts.singingFrame = new SigningFrame(null);
           }
       });
       this.setDefaultCloseOperation(EXIT_ON_CLOSE);
       this.setVisible(true);

   }


}
