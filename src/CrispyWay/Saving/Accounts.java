package CrispyWay.Saving;

import CrispyWay.Accounts.SigningFrame;
import CrispyWay.Interfaces.FilesMemorization;

import javax.swing.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public abstract class Accounts implements FilesMemorization<List<Accounts>> {

    // Attributes
    @Serial
    private static final long serialVersionUID = 1L;
    private String name;
    private String password;
    protected int role = 0;
    transient public static SigningFrame singingFrame = null;

    public void setName(String name) {
        this.name = name;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setRole(int role) {
        this.role = role;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public int getRole() {
        return role;
    }

    // Constructor
    protected Accounts() {

    }

    protected Accounts(String name, String password) {
        this.name = name;
        this.password = password;
    }


    @Override
    public void initialize() {
        List<Accounts> arr = new ArrayList<>();
        writeObject(arr);
    }


    @Override
    public void writeObject(List<Accounts> object) {
        try (FileOutputStream file = new FileOutputStream("src/Files/acc.txt");
             ObjectOutputStream objectOutputStream = new ObjectOutputStream(file)) {
            objectOutputStream.writeObject(object);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "An error happened. Please try again.", "Error", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    @Override
    public List<Accounts> getObject() {
        File fileTest = new File("src/Files/acc.txt");
        if (fileTest.length() == 0) {
            initialize();
        }
        try (FileInputStream file = new FileInputStream("src/Files/acc.txt");
             ObjectInputStream in = new ObjectInputStream(file)) {

            return (List<Accounts>) in.readObject();

        } catch (IOException | ClassNotFoundException e) {
            JOptionPane.showMessageDialog(null, "An error happened. Please try again.", "Error", JOptionPane.INFORMATION_MESSAGE);
        }

        return null;
    }

    @Override
    public void deleteObject() {
        List<Accounts> arr = getObject();
        if (arr != null) {
            arr.clear();
            writeObject(arr);
        }
    }


}