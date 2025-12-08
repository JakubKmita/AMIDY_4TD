import javax.swing.*;
import java.util.List;

public class NaprawionaWersja extends JFrame {

    public NaprawionaWersja() {
        setTitle("Wersja z SwingWorker");
        setSize(300, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JButton startButton = new JButton("Start");
        JLabel statusLabel = new JLabel("Oczekuję...");

        add(startButton, "North");
        add(statusLabel, "Center");

        startButton.addActionListener(e -> {

            SwingWorker<Void, String> worker = new SwingWorker<>() {

                @Override
                protected Void doInBackground() throws Exception {
                    for (int i = 0; i < 5; i++) {
                        Thread.sleep(1000);
                        publish("Pracuję... " + (i + 1) + "s");
                    }
                    return null;
                }

                @Override
                protected void process(List<String> chunks) {
                    String newest = chunks.get(chunks.size() - 1);
                    statusLabel.setText(newest);
                }

                @Override
                protected void done() {
                    statusLabel.setText("Zakończono pomyślnie!");
                }
            };

            worker.execute();
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new NaprawionaWersja().setVisible(true));
    }
}
