package CrispyWay.Accounts.SigningPanels;

import javax.swing.*;
import java.awt.*;

public class RegisterPanel extends RegisterLogin_Panel
{
    private Image ImageCreateAccount = new ImageIcon("src/CrispyWay/images/AddUser.png").getImage();

    public RegisterPanel() {
        super();
        super.register_login.setText("Sign Up");
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D)g;

        g2d.setColor(new Color(0xfec20e));
        g2d.setFont(new Font("Create Account", Font.CENTER_BASELINE, 40));
        g2d.drawString("Create Account", 70, 210);

        g2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        g2d.drawImage(ImageCreateAccount, 155, 25, null);     
    }
}
