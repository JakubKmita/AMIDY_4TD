import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ToDoListApp extends JFrame {

    private DefaultListModel<String> listModel;
    private JList<String> taskList;

    private JTextField inputField;
    private JLabel counterLabel;

    public ToDoListApp() {
        setTitle("Zaawansowany Menedżer Zadań");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(450, 350);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(10, 10));

        JPanel northPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        inputField = new JTextField(25);
        JButton addButton = new JButton("Dodaj zadanie");

        northPanel.add(inputField);
        northPanel.add(addButton);
        add(northPanel, BorderLayout.NORTH);

        listModel = new DefaultListModel<>();
        taskList = new JList<>(listModel);
        taskList.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2) {
                    int index = taskList.locationToIndex(e.getPoint());
                    if (index != -1) {
                        listModel.remove(index);
                        updateCounter();
                    }
                }
            }
        });
        add(new JScrollPane(taskList), BorderLayout.CENTER);

        JPanel southPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JButton removeButton = new JButton("Usuń zaznaczone");
        counterLabel = new JLabel("Liczba zadań: 0");

        southPanel.add(removeButton);
        southPanel.add(counterLabel);
        add(southPanel, BorderLayout.SOUTH);

        addButton.addActionListener(e -> addTask());

        inputField.addActionListener(e -> addTask());

        removeButton.addActionListener(e -> {
            int selectedIndex = taskList.getSelectedIndex();
            if (selectedIndex != -1) {
                listModel.remove(selectedIndex);
                updateCounter();
            } else {
                JOptionPane.showMessageDialog(this,
                        "Najpierw zaznacz zadanie do usunięcia!",
                        "Informacja",
                        JOptionPane.WARNING_MESSAGE);
            }
        });
    }

    private void addTask() {
        String taskText = inputField.getText().trim();

        if (taskText.isEmpty()) {
            JOptionPane.showMessageDialog(this,
                    "Zadanie nie może być puste!",
                    "Błąd walidacji",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }

        listModel.addElement(taskText);
        inputField.setText("");
        inputField.requestFocus();
        updateCounter();
    }

    private void updateCounter() {
        counterLabel.setText("Liczba zadań: " + listModel.getSize());
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            ToDoListApp manager = new ToDoListApp();
            manager.setVisible(true);
        });
    }
}