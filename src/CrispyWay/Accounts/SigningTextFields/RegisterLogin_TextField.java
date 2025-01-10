package CrispyWay.Accounts.SigningTextFields;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.*;

public class RegisterLogin_TextField extends JPanel
{
    Image imageSigningTextField;
    Border borderTextField = BorderFactory.createLineBorder(new Color(0xffdd9e));
    JTextField textField;
   public String originalText;

    public String getOriginalText() {
        return originalText;
    }

    public JTextField getTextField() {
        return textField;
    }

    public RegisterLogin_TextField(int y, String Text, Image imageTextField) {
        imageSigningTextField = imageTextField;
        originalText = Text;

        textField = new JTextField(Text);
        textField.setFocusable(true);
        textField.setPreferredSize(new Dimension(160, 28));
        textField.setFont(new Font(getName(), Font.ITALIC, 13));
        textField.setForeground(new Color(0xa0a0a0));
        textField.setHorizontalAlignment(SwingConstants.LEFT);
        textField.setBackground(new Color(0xffdd9e));
        textField.setBorder(borderTextField);
        textField.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                if (textField.getText().equals(originalText)) {
                    textField.setText("");
                    textField.setForeground(Color.BLACK);
                }
            }
            @Override
            public void focusLost(FocusEvent e){
                if(textField.getText().isEmpty()){
                    textField.setForeground(new Color(0xa0a0a0));
                    textField.setText(originalText);
                }
            }
        });



        this.setLayout(new BorderLayout());
        this.add(textField, BorderLayout.EAST);
        this.setBounds(115, y, 200, 28);
        this.setBackground(new Color(0xffdd9e));
    }
    
    public void ClearTextField() {
        textField.setForeground(new Color(0xa0a0a0));
        textField.setText(originalText);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D)g;
        g2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        g2d.drawImage(imageSigningTextField, 10, 6, null);
    }
}

