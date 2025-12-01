import javax.swing.SwingUtilities;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            ZadanieModel model = new ZadanieModel();
            ZadanieView view = new ZadanieView();
            ZadanieController controller = new ZadanieController(model, view);

            view.setVisible(true);
        });
    }
}
