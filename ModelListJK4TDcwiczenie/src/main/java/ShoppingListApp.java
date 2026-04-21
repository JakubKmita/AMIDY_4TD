import javax.swing.*;
import java.awt.*;

public class ShoppingListApp extends JFrame {

    private JButton addButton;
    private JTextField itemInput;
    private JList<String> itemsList;
    private JButton deleteButton;
    private DefaultListModel<String> listModel;

    public ShoppingListApp() {
        setTitle("Lista zakupów");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        listModel = new DefaultListModel<>();
        itemsList = new JList<>(listModel);
        itemInput = new JTextField(20);
        addButton = new JButton("Dodaj");
        deleteButton = new JButton("Usuń");

        JPanel topPanel = new JPanel();
        topPanel.add(itemInput);
        topPanel.add(addButton);

        JScrollPane scrollPane = new JScrollPane(itemsList);

        JPanel bottomPanel = new JPanel();
        bottomPanel.add(deleteButton);

        add(topPanel, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);
        add(bottomPanel, BorderLayout.SOUTH);

        addButton.addActionListener(e -> {
            String text = itemInput.getText().trim();
            if (!text.isEmpty()) {
                listModel.addElement(text);
                itemInput.setText("");
            }
        });

        deleteButton.addActionListener(e -> {
            int selectedIndex = itemsList.getSelectedIndex();
            if (selectedIndex == -1) {
                JOptionPane.showMessageDialog(this, "Najpierw zaznacz element z listy!", "Błąd", JOptionPane.WARNING_MESSAGE);
            } else {
                listModel.remove(selectedIndex);
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            ShoppingListApp app = new ShoppingListApp();
            app.setVisible(true);
        });
    }
}