import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {

    private JMenuItem saleItem;
    private JMenuItem reportsItem;
    private JMenuItem usersItem;

    private JLabel statusBar;

    public MainFrame() {

        setTitle("System Obsługi Sklepu");
        setSize(600,400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        createMenu();
        createStatusBar();
        applyPermissions();
    }

    private void createMenu() {

        JMenuBar menuBar = new JMenuBar();

        JMenu menu = new JMenu("Menu");

        saleItem = new JMenuItem("Sprzedaż");
        reportsItem = new JMenuItem("Raporty");
        usersItem = new JMenuItem("Zarządzanie użytkownikami");

        menu.add(saleItem);
        menu.add(reportsItem);
        menu.add(usersItem);

        menuBar.add(menu);
        setJMenuBar(menuBar);
    }

    private void createStatusBar() {

        statusBar = new JLabel();
        statusBar.setBorder(BorderFactory.createEmptyBorder(5,5,5,5));

        updateStatus();

        add(statusBar, BorderLayout.SOUTH);
    }

    private void updateStatus() {
        statusBar.setText("Zalogowano jako: "
                + Session.getUser()
                + " | Rola: "
                + Session.getRole());
    }

    private void applyPermissions() {

        if(Session.getRole().equals("ADMIN")){

            saleItem.setVisible(true);
            reportsItem.setEnabled(true);
            usersItem.setVisible(true);

        } else {

            saleItem.setVisible(true);

            reportsItem.setEnabled(false);

            usersItem.setVisible(false);
        }
    }
}