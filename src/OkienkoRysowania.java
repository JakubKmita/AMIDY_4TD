import javax.swing.JFrame;
import javax.swing.JPanel;

public class OkienkoRysowania extends JFrame {
    public OkienkoRysowania() {
        super("Rysowanie");
        JPanel panel = new PanelRysowania();

        add(panel);

        pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
}