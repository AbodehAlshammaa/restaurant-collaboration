package CrispyWay.Accounts.SigningPanels;

import CrispyWay.Accounts.SigningFrame;
import CrispyWay.Accounts.Signing_Buttons.CoverRegisterLogin_Button;
import CrispyWay.Accounts.Signing_Buttons.loginRegisterButton;
// import CrispyWay.folder.LabelImage;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.RoundRectangle2D;

public class CoverSigningPanel extends JPanel
{
    private Image logo = new ImageIcon("src/CrispyWay/images/CrispyWay_Logo.png").getImage();
    private Image imageCoverSigning = new ImageIcon("src/CrispyWay/images/SigningCover.jpg").getImage();

    private CoverRegisterLogin_Button SigningButton = new CoverRegisterLogin_Button();
    private Timer timerAnimationCoverSigningPanel, timerAnimationSigningPanel;
    // private LabelImage CoverSigningImage = new LabelImage(30, 0, 256, logo);

    public CoverSigningPanel(RegisterPanel register, LoginPanel login ) {
        this.setLayout(null);
        this.setBounds(0, 0, 325, 475);
        // this.add(CoverSigningImage);
        this.add(SigningButton);

        SigningButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent buttonEvent) {
                loginRegisterButton.signInOk = !loginRegisterButton.signInOk;
                    SigningButton.isPress = true;
                    timerAnimationCoverSigningPanel.start();
                    timerAnimationSigningPanel.start();

            }
        });

        timerAnimationCoverSigningPanel = new Timer(1, new ActionListener() {
            int TargetX = SigningFrame.WidthFrame - getWidth();
            @Override
            public void actionPerformed(ActionEvent event) {
                if (SigningButton.isLogging) {
                    if (getX() >= TargetX-22) {
                        timerAnimationCoverSigningPanel.stop();
                        SigningButton.isLogging = !SigningButton.isLogging;
                    } else {
                        setLocation(getX()+10, getY());
                    }

                    if (getX() == 180) {
                        register.setVisible(false);
                        login.setVisible(true);
                    }
                } else {
                    if (getX() == 0) {
                        timerAnimationCoverSigningPanel.stop();
                        SigningButton.isLogging = !SigningButton.isLogging;
                    } else {
                        setLocation(getX()-10, getY());
                    }

                    if (getX() == 180) {
                        login.setVisible(false);
                        register.setVisible(true);
                    }
                }
            }
        });

        timerAnimationSigningPanel = new Timer(1, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                if (SigningButton.isLogging) {
                    if (register.getX() <= 0) {
                        timerAnimationSigningPanel.stop();
                    } else {
                        register.setLocation(register.getX()-10, register.getY());
                        login.setLocation(login.getX()-10, login.getY());
                    }
                } else {
                    if (login.getX() == RegisterLogin_Panel.SigningPanel_X) {
                        timerAnimationSigningPanel.stop();
                    } else {
                        register.setLocation(register.getX()+10, register.getY());
                        login.setLocation(login.getX()+10, login.getY());
                    }
                }
            }
        });
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D)g;
        RoundRectangle2D roundCoverSigning = new RoundRectangle2D.Double(0, 0, getWidth(), getHeight(), 75, 75);
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.clip(roundCoverSigning);
        g2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        g2d.drawImage(imageCoverSigning, 0, 0, null);
        g2d.drawImage(logo, getWidth()/2-128, 0, null);
    }


}