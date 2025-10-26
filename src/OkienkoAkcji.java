import javax.swing.*;

public class OkienkoAkcji extends JFrame {

    public OkienkoAkcji() {
        super("Test akcji");

        JPanel buttonPanel = new PanelPrzycisku();
        add(buttonPanel);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setVisible(true);
    }
}
