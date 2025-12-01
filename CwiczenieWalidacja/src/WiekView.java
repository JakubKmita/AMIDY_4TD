import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class WiekView extends JFrame {

    private JTextField poleWiek = new JTextField(10);
    private JButton zapiszBtn = new JButton("Zapisz");
    private JLabel wynikLabel = new JLabel("Wiek: ");

    public WiekView() {
        super("Walidacja - MVC");
        this.setSize(300, 150);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel p = new JPanel(new FlowLayout());

        p.add(new JLabel("Podaj wiek:"));
        p.add(poleWiek);
        p.add(zapiszBtn);
        p.add(wynikLabel);

        this.add(p);
    }

    public String getWiekTekst() {
        return poleWiek.getText();
    }

    public void setWynik(int wiek) {
        wynikLabel.setText("Wiek: " + wiek);
    }

    public void addZapiszListener(ActionListener l) {
        zapiszBtn.addActionListener(l);
    }

    public void blad(String msg) {
        JOptionPane.showMessageDialog(this, msg, "Błąd danych", JOptionPane.ERROR_MESSAGE);
    }
}
