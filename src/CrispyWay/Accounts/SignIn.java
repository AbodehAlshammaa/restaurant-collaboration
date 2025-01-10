package CrispyWay.Accounts;

import CrispyWay.Admin.MainFrame;
import CrispyWay.Saving.Accounts;
import javax.swing.*;
import java.util.List;

public class SignIn extends Accounts {

   private int check(String name , String password){
       List<Accounts> arr = getObject();
       for(Accounts it : arr) {
           if (it.getName().equals(name) && it.getPassword().equals(password)) {
               if(it.getRole() == 1)return 1;
               if(it.getRole() == 2)return 2;
               else return 0;
           }
       }


        return -1;
    }
  public void signInActionListener(String name, String password){
      if(name.isEmpty() || password.isEmpty())return;
      int res = check(name , password);

      if(res == 2 ){
          // MANAGER
          Accounts.singingFrame.dispose();
          new MainFrame(name,password);
          System.out.println("MANAGER");
      }
      else if(res == 1){
          // EMPLOYEE
          System.out.println("EMPLOYEE");

      }
     else if(res == 0){
          // USER
          System.out.println("USER");

      }
     else if(res == -1){
          JOptionPane.showMessageDialog(
                  null,
                  "Invalid username or password. Please try again.",
                  "Done",
                  JOptionPane.WARNING_MESSAGE);
      }

   }

    @Override
    public boolean add() {
      return true;
    }
}
