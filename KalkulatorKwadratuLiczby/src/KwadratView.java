import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class KwadratView extends JFrame {

    private JTextField wejscie = new JTextField(10);
    private JButton obliczButton = new JButton("Oblicz");
    private JLabel wynikLabel = new JLabel("Wynik: ");

    public KwadratView() {
        super("Kalkulator Kwadratu - MVC");

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(300, 150);

        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());

        panel.add(new JLabel("Liczba: "));
        panel.add(wejscie);
        panel.add(obliczButton);
        panel.add(wynikLabel);

        this.add(panel);
    }

    public String getLiczbaTekst() {
        return wejscie.getText();
    }

    public void setWynik(int wynik) {
        wynikLabel.setText("Wynik: " + wynik);
    }

    public void addObliczListener(ActionListener listener) {
        obliczButton.addActionListener(listener);
    }

    public void pokazBlad(String komunikat) {
        JOptionPane.showMessageDialog(this, komunikat, "Błąd", JOptionPane.ERROR_MESSAGE);
    }
}
