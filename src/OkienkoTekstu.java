import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class OkienkoTekstu extends JFrame {
    public OkienkoTekstu() {
        super("Komponenty tekstowe");
        NasluchLogowania listener = new NasluchLogowania(this);
        JPanel loginPanel = new PanelLogowania(listener);
        add(loginPanel);

        setPreferredSize(new Dimension(600, 400));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setVisible(true);
    }
}
