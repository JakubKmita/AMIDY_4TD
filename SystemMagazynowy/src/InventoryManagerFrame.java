import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class InventoryManagerFrame {
    private JPanel mainPanel;
    private JTable table;
    private JTextField idField;
    private JTextField nameField;
    private JTextField quantityField;
    private JTextField categoryField;
    private JButton addButton;
    private JButton deleteButton;

    private ItemTableModel model;

    public InventoryManagerFrame() {
        List<Item> data = new ArrayList<>();
        model = new ItemTableModel(data);
        table.setModel(model);

        addButton.addActionListener(e -> addItem());
        deleteButton.addActionListener(e -> deleteItem());
    }

    private void addItem() {
        try {
            int id = Integer.parseInt(idField.getText());
            String name = nameField.getText();
            int quantity = Integer.parseInt(quantityField.getText());
            String category = categoryField.getText();

            Item item = new Item(id, name, quantity, category);
            model.addItem(item);

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(mainPanel,
                    "Ilość musi być liczbą!",
                    "Błąd",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    private void deleteItem() {
        int selectedRow = table.getSelectedRow();

        if (selectedRow != -1) {
            model.removeItem(selectedRow);
        } else {
            JOptionPane.showMessageDialog(mainPanel,
                    "Wybierz wiersz do usunięcia!");
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Magazyn");
        frame.setContentPane(new InventoryManagerFrame().mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}