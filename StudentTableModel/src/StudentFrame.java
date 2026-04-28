import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class StudentFrame {
    private JTable table;
    private JPanel mainPanel;

    public StudentFrame() {
        List<Student> data = new ArrayList<>();
        data.add(new Student("Alan", "Łyskawa", 1));
        data.add(new Student("Filip", "Stenka", 3));
        data.add(new Student("Piotr", "Tobiszowski", 6));

        table.setModel(new StudentTableModel(data));
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Studenci");
        frame.setContentPane(new StudentFrame().mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}