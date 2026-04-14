import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalculatorBMI extends JFrame {
    private JTextField heightField;
    private JTextField weightField;
    private JButton submitButton;
    private JLabel resultLabel;
    private JPanel mainPanel;


    public CalculatorBMI() {
        setContentPane(mainPanel);
        setTitle("Kalkulator BMI");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
        setVisible(true);

        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                submitButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        try {

                            String tekstWaga = weightField.getText();
                            String tekstWzrost = heightField.getText();


                            double waga = Double.parseDouble(tekstWaga.replace(",", "."));
                            double wzrostCm = Double.parseDouble(tekstWzrost.replace(",", "."));


                            double wzrostM = wzrostCm / 100.0;
                            double bmi = waga / (wzrostM * wzrostM);


                            resultLabel.setText(String.format("Twoje BMI: %.2f", bmi));

                        } catch (NumberFormatException ex) {

                            resultLabel.setText("Błąd: Wpisz poprawne liczby!");
                        }
                    }
                });

            }
        });
    }



    public static void main(String[] args) {
        new CalculatorBMI();

    }

}
