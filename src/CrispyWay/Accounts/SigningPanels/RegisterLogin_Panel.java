package CrispyWay.Accounts.SigningPanels;

import CrispyWay.Accounts.SignIn;
import CrispyWay.Accounts.Sign_up;
import CrispyWay.Accounts.SigningTextFields.RegisterLogin_TextField;
import CrispyWay.Accounts.Signing_Buttons.loginRegisterButton;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public abstract class RegisterLogin_Panel extends JPanel
{
    public static final int SigningPanel_X = 325;

    Image UsernameImage = new ImageIcon("src/CrispyWay/images/usernameTextField.png").getImage();
    Image PasswordImage = new ImageIcon("src/CrispyWay/images/lockTextField.png").getImage();
    RegisterLogin_TextField Username = new RegisterLogin_TextField(275, "Username", UsernameImage);
    RegisterLogin_TextField Password = new RegisterLogin_TextField(310, "Password", PasswordImage);
    loginRegisterButton register_login = new loginRegisterButton();

    public RegisterLogin_Panel() {
        this.setLayout(null);
        this.setBounds(325,0, 443,512);
        this.add(Username);
        this.add(Password);
        register_login.setBounds(120, 370, 190, 40);
        this.add(register_login);
        register_login.addActionListener(new ActionListener() {
            @SuppressWarnings("static-access")
            @Override
            public void actionPerformed(ActionEvent EventButton) {

                if(register_login.signInOk){
                    new SignIn().signInActionListener(Username.getTextField().getText(),Password.getTextField().getText());
                }
                else{
                    new Sign_up().signUpActionListener(Username.getTextField().getText(),Password.getTextField().getText());
                }


            }
        });
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if(!Username.hasFocus()){
                    if(Username.getTextField().getText().isEmpty()){
                        requestFocus();
                        Username.getTextField().setFocusable(false);
                        Username.getTextField().setFocusable(true);
                        Username.getTextField().setForeground(new Color(0xa0a0a0));
                        Username.getTextField().setText(Username.getOriginalText());
                        Username.revalidate();
                        Username.repaint();
                    }
                }
                if(!Password.hasFocus()){
                    requestFocus();
                    Password.getTextField().setFocusable(false);
                    Password.getTextField().setFocusable(true);
                    if(Password.getTextField().getText().isEmpty()){
                        Password.getTextField().setForeground(new Color(0xa0a0a0));
                        Password.getTextField().setText(Password.getOriginalText());
                        Password.revalidate();
                        Password.repaint();
                    }
                }
            }
        });
    }

    @Override
    public void setVisible(boolean aFlag) {
        if (!aFlag) {
            Username.ClearTextField();
            Password.ClearTextField();
        }
        super.setVisible(aFlag);
    }
}
