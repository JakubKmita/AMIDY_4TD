import javax.swing.*;

public class App {

    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {

            JFrame dummy = new JFrame();

            LoginDialog login = new LoginDialog(dummy);
            login.setVisible(true);

            if(Session.getUser() != null){

                MainFrame main = new MainFrame();
                main.setVisible(true);

            } else {

                System.exit(0);
            }
        });
    }
}