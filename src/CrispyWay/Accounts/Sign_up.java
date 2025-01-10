package CrispyWay.Accounts;
import CrispyWay.Saving.Accounts;

import javax.swing.*;
import java.util.List;

public class Sign_up extends Accounts {
    public void signUpActionListener(String name , String password){
        name = fix(name);
        password = fix(password);
        if(name.equals("Username")|| name.isEmpty() || checkSpaces(name)) {
            JOptionPane.showMessageDialog(null,"Enter A valid Username");
             return;

        }
       if( password.isEmpty() || password.equals("Password")|| checkSpaces(password)){
           JOptionPane.showMessageDialog(null,"Enter A valid Password");
           return;
       }
       name = fix(name);
       if(checkSpaces(name)){
           JOptionPane.showMessageDialog(null,"Invalid Username");
           return;
       }
       super.setName(name);
       super.setPassword(password);
       add();

 }
    boolean checkSpaces(String name) {
        for (char x : name.toCharArray()) {
            if (x == ' ')
                return true;
        }
        return false;
    }
    String fix (String name ){
        int index  = 0 ;
        while(index < name.length() && name.charAt(index) == ' '){
            index ++ ;
        }
        if(index < name.length()){
            name = name.substring(index);

        }
        index = name.length()-1;
        while(index >= 0 && name.charAt(index) == ' '){
            index--;
        }
        if(index >= 0){
            name = name.substring(0,index+1);
        }

        return name;
    }


    @Override
    public boolean add() {
        List<Accounts> arr = getObject();
        if (arr == null) {
            return false;
        }
        for (Accounts it : arr) {
            if (it.getName().equals(getName())) {
                JOptionPane.showMessageDialog(null,"Account Already Exists");
                return false;
            }
        }
        int response = JOptionPane.showConfirmDialog(null, "Do you want to proceed?", "Confirmation", JOptionPane.YES_NO_OPTION);
        if(response == JOptionPane.NO_OPTION)return false;
        arr.add(this);
        writeObject(arr);
        JOptionPane.showMessageDialog(null,"Registering Done");
        return true;
    }

}
