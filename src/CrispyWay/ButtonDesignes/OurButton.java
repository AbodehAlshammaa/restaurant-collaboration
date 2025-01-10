package CrispyWay.ButtonDesignes;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class OurButton extends JButton {
    public static boolean signInOk = false;
    public boolean setborder = true;

    private boolean after;
    private Color backgroundColor;
    private Color enteredColor;
    private Color borderColor;
    private Color clickedColor;
    private int radius = 50;

    public void setBackgroundColor(Color backgroundColor) {
        this.backgroundColor = backgroundColor;
    }

    public void setEnteredColor(Color enteredColor) {
        this.enteredColor = enteredColor;
    }

    public void setBorderColor(Color borderColor) {
        this.borderColor = borderColor;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    public int getRadius() {
        return radius;
    }

    public OurButton() {
        backgroundColor = new Color(255, 223, 128); // Background Yellow
        enteredColor = new Color(255, 235, 85); // Entered Yellow
        borderColor = new Color(255, 205, 0); // Border Yellow
        clickedColor = new Color(220, 210, 140);
        this.setBackground(backgroundColor);

        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                setBackground(enteredColor);
                after = true;
            }

            @Override
            public void mouseExited(MouseEvent e) {
                setBackground(backgroundColor);
                after = false;
            }

            @Override
            public void mousePressed(MouseEvent e) {
                setBackground(clickedColor);
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                if (after) setBackground(enteredColor);
                else setBackground(backgroundColor);
            }
        });

        this.setContentAreaFilled(false);
        this.setFocusPainted(false); // Disable default focus painting
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2D = (Graphics2D) g.create();
        g2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        
        if (setborder) {
            g2D.setColor(borderColor);
            g2D.fillRoundRect(0, 0, getWidth(), getHeight(), radius, radius);
            g2D.setColor(getBackground());
            g2D.fillRoundRect(2, 2, getWidth() - 4, getHeight() - 4, radius, radius);
        } else {
            g2D.setColor(getBackground());
            g2D.fillRoundRect(0, 0, getWidth(), getHeight(), radius, radius);
        }

        g2D.dispose();
        super.paintComponent(g);
    }

    @Override
    protected void paintBorder(Graphics g) {
        // Override without painting the border to remove the focus border
    }
}
