import java.awt.EventQueue;
import javax.swing.JFrame;

public class OkienkoTestuMyszki extends JFrame {
    public OkienkoTestuMyszki() {
        super("MouseTest");

        add(new TestMyszki());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }


}
