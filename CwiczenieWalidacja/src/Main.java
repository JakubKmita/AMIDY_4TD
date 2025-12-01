import javax.swing.SwingUtilities;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            WiekModel model = new WiekModel();
            WiekView view = new WiekView();
            WiekController controller = new WiekController(model, view);

            view.setVisible(true);
        });
    }
}
