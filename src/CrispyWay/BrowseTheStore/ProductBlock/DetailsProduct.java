package CrispyWay.BrowseTheStore.ProductBlock;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import javax.swing.JTextPane;

public class DetailsProduct extends JTextPane
{
    public DetailsProduct(String Text) {
        this.setText(Text);
        this.setFont(new Font("text", Font.ITALIC, 15));
        this.setForeground(new Color(0x64ff00));
        this.setOpaque(false);
        this.setVisible(false);
    }

    public DetailsProduct(int width, int Height, String Text) {
        this(Text);
        this.setBounds(0, 0, width, Height);
    }
    
    public DetailsProduct(int width, int Height, String Text, MouseAdapter mouseEvent) {
        this(width, Height, Text);
        this.setEditable(false);
        this.addMouseListener(mouseEvent);
    }

    protected void setEdit(boolean edit) {
        this.setEditable(edit);
    }
}