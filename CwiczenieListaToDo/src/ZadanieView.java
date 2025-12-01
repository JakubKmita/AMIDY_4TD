import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class ZadanieView extends JFrame {

    private DefaultListModel<String> modelListy = new DefaultListModel<>();
    private JList<String> lista = new JList<>(modelListy);

    private JTextField poleTresc = new JTextField(20);
    private JButton dodajBtn = new JButton("Dodaj");
    private JButton usunBtn = new JButton("Usuń");

    public ZadanieView() {
        super("Lista To-Do (MVC + SQLite)");

        this.setSize(400, 300);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel(new BorderLayout());

        panel.add(new JScrollPane(lista), BorderLayout.CENTER);

        JPanel dol = new JPanel();
        dol.add(poleTresc);
        dol.add(dodajBtn);
        dol.add(usunBtn);

        panel.add(dol, BorderLayout.SOUTH);

        this.add(panel);
    }

    public String getTresc() {
        return poleTresc.getText();
    }

    public void setLista(java.util.List<String> zadania) {
        modelListy.clear();
        for (String z : zadania) modelListy.addElement(z);
    }

    public String getWybrane() {
        return lista.getSelectedValue();
    }

    public void addDodajListener(ActionListener l) {
        dodajBtn.addActionListener(l);
    }

    public void addUsunListener(ActionListener l) {
        usunBtn.addActionListener(l);
    }

    public void blad(String msg) {
        JOptionPane.showMessageDialog(this, msg, "Błąd", JOptionPane.ERROR_MESSAGE);
    }
}
