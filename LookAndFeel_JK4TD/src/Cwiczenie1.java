import javax.swing.*;

public class Cwiczenie1 {

    public static void main(String[] args) {


        UIManager.LookAndFeelInfo[] lafs = UIManager.getInstalledLookAndFeels();

        System.out.println("Dostępne Look and Feel:");

        for (UIManager.LookAndFeelInfo laf : lafs) {
            System.out.println(laf.getName() + " -> " + laf.getClassName());
        }


        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Ćwiczenie 1 - Look and Feel");
            frame.setSize(400, 200);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            JPanel panel = new JPanel();
            panel.add(new JButton("Przycisk 1"));
            panel.add(new JButton("Przycisk 2"));
            panel.add(new JButton("Przycisk 3"));

            frame.add(panel);
            frame.setVisible(true);
        });
    }
}