package CrispyWay.Admin;

import CrispyWay.ButtonDesignes.OurButton;

import javax.swing.*;
import java.awt.*;

public class ButtonsPanel extends JPanel {
    private static final OurButton mealButton = new OurButton();
    private static final OurButton reportButton = new OurButton();
    private static final OurButton accountDetailsButton = new OurButton();
    private static final OurButton logoutButton = new OurButton();
    public static OurButton getAccountDetailsButton() {
        return accountDetailsButton;
    }

    public static OurButton getMealButton() {
        return mealButton;
    }

    public static OurButton getReportButton() {
        return reportButton;
    }

    public static OurButton getLogoutButton() {
        return logoutButton;
    }

    public ButtonsPanel(){
        this.setBounds(0,0,200,1000);
         this.setLayout(null);
        this.setBackground(Color.GRAY);
        mealButton.setRadius(8);
        mealButton.setText("Meals");
        reportButton.setText("Report");
        accountDetailsButton.setText("Account Details");
        mealButton.setBounds(20,40,150,50);
        logoutButton.setBounds(20,600,150,50);
        logoutButton.setText("Logout");
        logoutButton.setRadius(8);

        this.add(logoutButton);
        reportButton.setRadius(8);
        reportButton.setBounds(20,110,150,50);
        accountDetailsButton.setRadius(8);
        accountDetailsButton.setBounds(20,180,150,50);
        this.add(mealButton);
        this.add(reportButton);
        this.add(accountDetailsButton);
    }

}
