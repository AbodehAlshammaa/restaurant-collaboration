package CrispyWay.LoadingScreen;

import CrispyWay.Accounts.SigningFrame;

import javax.swing.JFrame;

public class LoadingScreen_Frame extends JFrame
{
    public final static int WidthFrame = 768, HightFrame = 512;
    LoadingScreen_Panel LoadingScreen = new LoadingScreen_Panel(this);





    public LoadingScreen_Frame() {
        
        this.setSize(WidthFrame, HightFrame);
        this.setLocationRelativeTo(null);
        // this.setBounds(400, 175, 768, 512);
        this.setResizable(false);
        this.add(LoadingScreen);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setVisible(true);



    }
}
