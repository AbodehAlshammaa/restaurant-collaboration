package CrispyWay.Accounts;

import CrispyWay.Accounts.SigningPanels.CoverSigningPanel;
import CrispyWay.Accounts.SigningPanels.LoginPanel;
import CrispyWay.Accounts.SigningPanels.RegisterPanel;

import javax.swing.*;
import java.awt.*;


public class SigningFrame extends JFrame
{
    public final static int WidthFrame = 768, HeightFrame = 512;

    RegisterPanel register = new RegisterPanel();
    LoginPanel login = new LoginPanel();
    CoverSigningPanel CoverSigning = new CoverSigningPanel(register, login);

    public SigningFrame(Point p) {        
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setLayout(null);
        this.setResizable(false);
        this.setSize(WidthFrame, HeightFrame);
        if(p == null)this.setLocationRelativeTo(null);
        else this.setLocation(p);

        // this.setBounds(400,125, 768, 512);
        
        this.add(CoverSigning);
        this.add(register);
        this.add(login);
        this.setVisible(true);
    }
}