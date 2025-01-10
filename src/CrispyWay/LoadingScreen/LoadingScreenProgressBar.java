package CrispyWay.LoadingScreen;

import CrispyWay.Accounts.SigningFrame;
import CrispyWay.Saving.Accounts;
import CrispyWay.Saving.Food;

import java.awt.Color;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JProgressBar;
import javax.swing.SwingWorker;
import javax.swing.border.Border;

public class LoadingScreenProgressBar extends JProgressBar
{
    LoadingScreen_Frame frame;
    Border borderLoadingBar = BorderFactory.createLineBorder(new Color(0xfca800));
    LoadingScreenProgressBar(LoadingScreen_Frame frame) {
        this.frame = frame;
        this.setStringPainted(true);
        this.setBounds(80, 400, 600, 32);
        this.setBackground(Color.WHITE);
        this.setForeground(new Color(0x74d1fc));
        this.setBorder(borderLoadingBar);
        this.setVisible(true);
        
        SwingWorker<Void, Integer> worker = new SwingWorker<Void, Integer>() {
            @Override
            protected Void doInBackground() throws Exception {
                for (int i = 0; i <= 100; i++) {
                    Thread.sleep(50);
        
                    publish(i);
        
                    if (isCancelled()) {
                        break;
                    }
                }
                LoadingScreenProgressBar.this.setString("Complete");
                frame.dispose();
                new Food().starting();
                Accounts.singingFrame = new SigningFrame(frame.getLocation());


                return null;
            }
        
            @Override
            protected void process(List<Integer> chunks) {
                for (int progress : chunks) {
                    LoadingScreenProgressBar.this.setValue(progress);
                }
            }
        };
        worker.execute();
    }
}