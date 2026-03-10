import com.formdev.flatlaf.FlatDarkLaf;
import com.formdev.flatlaf.FlatLightLaf;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Properties;

public class ProfessionalSettingsManager extends JFrame {

    private static final String CONFIG_FILE = "config.properties";
    private static final String THEME_KEY = "theme";

    public ProfessionalSettingsManager() {
        setTitle("Professional Settings Manager");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        createMenu();
        createUI();
    }

    private void createMenu() {

        JMenuBar menuBar = new JMenuBar();
        JMenu viewMenu = new JMenu("Widok");

        JMenuItem lightMode = new JMenuItem("Light Mode");
        JMenuItem darkMode = new JMenuItem("Dark Mode");

        lightMode.addActionListener(e -> changeTheme("light"));
        darkMode.addActionListener(e -> changeTheme("dark"));

        viewMenu.add(lightMode);
        viewMenu.add(darkMode);

        menuBar.add(viewMenu);
        setJMenuBar(menuBar);
    }

    private void createUI() {

        JPanel panel = new JPanel(new BorderLayout());

        JPanel topPanel = new JPanel();

        JButton button = new JButton("Kliknij mnie");
        JTextField textField = new JTextField(15);
        JCheckBox checkBox = new JCheckBox("Akceptuję");

        topPanel.add(button);
        topPanel.add(textField);
        topPanel.add(checkBox);

        // Dane tabeli (zmienione)
        String[] columns = {"ID", "Imię", "Wiek"};

        Object[][] data = {
                {"101", "Kamil", "21"},
                {"102", "Magda", "23"},
                {"103", "Tomasz", "20"},
                {"104", "Karolina", "22"},
                {"105", "Michał", "24"}
        };

        JTable table = new JTable(new DefaultTableModel(data, columns));

        JScrollPane scrollPane = new JScrollPane(table);

        panel.add(topPanel, BorderLayout.NORTH);
        panel.add(scrollPane, BorderLayout.CENTER);

        add(panel);
    }

    private void changeTheme(String theme) {

        try {

            if (theme.equals("dark")) {
                UIManager.setLookAndFeel(new FlatDarkLaf());
            } else {
                UIManager.setLookAndFeel(new FlatLightLaf());
            }

            SwingUtilities.updateComponentTreeUI(this);
            saveTheme(theme);

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private static void saveTheme(String theme) {

        try {

            Properties properties = new Properties();
            properties.setProperty(THEME_KEY, theme);

            properties.store(new FileOutputStream(CONFIG_FILE), "App Settings");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static String loadTheme() {

        try {

            Properties properties = new Properties();
            properties.load(new FileInputStream(CONFIG_FILE));

            return properties.getProperty(THEME_KEY, "light");

        } catch (Exception e) {
            return "light";
        }
    }

    public static void main(String[] args) {

        try {

            String theme = loadTheme();

            if (theme.equals("dark")) {
                UIManager.setLookAndFeel(new FlatDarkLaf());
            } else {
                UIManager.setLookAndFeel(new FlatLightLaf());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        SwingUtilities.invokeLater(() -> {
            new ProfessionalSettingsManager().setVisible(true);
        });
    }
}