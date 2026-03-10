import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Cwiczenie2 extends JFrame {

    JComboBox<String> combo;
    UIManager.LookAndFeelInfo[] lafs;

    public Cwiczenie2() {

        setTitle("Ćwiczenie 2 - Zmiana Look and Feel");
        setSize(400,200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        lafs = UIManager.getInstalledLookAndFeels();

        String[] nazwy = new String[lafs.length];
        for(int i=0;i<lafs.length;i++){
            nazwy[i] = lafs[i].getName();
        }

        combo = new JComboBox<>(nazwy);

        combo.addActionListener(e -> zmienStyl());

        add(new JLabel("Wybierz styl:"));
        add(combo);

        add(new JButton("Przycisk 1"));
        add(new JButton("Przycisk 2"));
        add(new JTextField("Pole tekstowe",10));
    }

    private void zmienStyl() {
        int index = combo.getSelectedIndex();

        try {
            UIManager.setLookAndFeel(lafs[index].getClassName());
            SwingUtilities.updateComponentTreeUI(this);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {
            new Cwiczenie2().setVisible(true);
        });

    }
}