package CrispyWay.Accounts.Signing_Buttons;


public class CoverRegisterLogin_Button extends loginRegisterButton
{
    public Boolean isLogging = true;
    public Boolean isPress = false;
    public CoverRegisterLogin_Button() {
        super();
        this.setText("Switch");

        this.setFocusable(true);
        this.setBounds(55, 370, 200, 40);
    }




}
