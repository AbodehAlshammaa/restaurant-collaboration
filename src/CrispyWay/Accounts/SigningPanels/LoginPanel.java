package CrispyWay.Accounts.SigningPanels;

import javax.swing.*;
import java.awt.*;

public class LoginPanel extends RegisterLogin_Panel
{
    private Image ImageSignAccount = new ImageIcon("src/CrispyWay/images/Login.png").getImage();

    public LoginPanel() {
        super();
        super.register_login.setText("Sign In");
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D)g;
        
        g2d.setColor(new Color(0xfec20e));
        g2d.setFont(new Font("Sign In", Font.CENTER_BASELINE, 40));
        g2d.drawString("Sign In", 150, 210);

        g2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        g2d.drawImage(ImageSignAccount, 155, 25, null);
    }   
}
