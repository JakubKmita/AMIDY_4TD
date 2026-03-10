import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class LoginDialog extends JDialog {

    private JTextField loginField;
    private JPasswordField passwordField;

    public LoginDialog(JFrame parent) {
        super(parent, "Logowanie", true);
        setLayout(new GridLayout(3,2,5,5));

        add(new JLabel("Login:"));
        loginField = new JTextField();
        add(loginField);

        add(new JLabel("Hasło:"));
        passwordField = new JPasswordField();
        add(passwordField);

        JButton loginButton = new JButton("Zaloguj");
        add(loginButton);

        loginButton.addActionListener(e -> authenticate());

        setSize(250,150);
        setLocationRelativeTo(parent);
    }

    private void authenticate() {

        String login = loginField.getText();
        String pass = new String(passwordField.getPassword());

        if(login.equals("admin") && pass.equals("admin123")){
            Session.login(login,"ADMIN");
            dispose();
        }
        else if(login.equals("user") && pass.equals("user123")){
            Session.login(login,"USER");
            dispose();
        }
        else{
            JOptionPane.showMessageDialog(this,"Błędny login lub hasło");
        }
    }
}