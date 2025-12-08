import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BlokujacaWersja extends JFrame {

    public BlokujacaWersja() {
        setTitle("Wersja blokująca");
        setSize(300, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JButton startButton = new JButton("Start");
        JLabel statusLabel = new JLabel("Oczekuję...");

        add(startButton, "North");
        add(statusLabel, "Center");

        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (int i = 0; i < 5; i++) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException ex) {
                        ex.printStackTrace();
                    }
                    statusLabel.setText("Pracuję... " + (i + 1) + "s");
                }
                statusLabel.setText("Zakończono blokadę.");
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new BlokujacaWersja().setVisible(true));
    }
}
