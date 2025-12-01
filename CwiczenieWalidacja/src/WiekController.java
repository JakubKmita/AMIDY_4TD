import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WiekController {

    private WiekModel model;
    private WiekView view;

    public WiekController(WiekModel model, WiekView view) {
        this.model = model;
        this.view = view;

        view.addZapiszListener(new ZapiszListener());
    }

    class ZapiszListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {

            try {
                String tekst = view.getWiekTekst();

                int wiek = Integer.parseInt(tekst);

                if (wiek < 0 || wiek > 150) {
                    view.blad("Wiek musi być z zakresu 0–150!");
                    return;
                }

                model.ustawWiek(wiek);
                view.setWynik(model.getWiek());

            } catch (NumberFormatException ex) {
                view.blad("Wpisz liczbę całkowitą!");
            }
        }
    }
}
