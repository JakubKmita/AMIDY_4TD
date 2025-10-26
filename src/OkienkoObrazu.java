import javax.swing.JFrame;
import javax.swing.JPanel;

public class OkienkoObrazu extends JFrame {

    public OkienkoObrazu() {
        super("Program obrazkowy");

        JPanel obrazPanel = new PanelObrazu();
        add(obrazPanel);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setVisible(true);
    }
}
