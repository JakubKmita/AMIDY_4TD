import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class KwadratController {

    private KwadratModel model;
    private KwadratView view;

    public KwadratController(KwadratModel model, KwadratView view) {
        this.model = model;
        this.view = view;

        view.addObliczListener(new ObliczListener());
    }

    class ObliczListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                String tekst = view.getLiczbaTekst();
                int liczba = Integer.parseInt(tekst);
                int wynik = model.obliczKwadrat(liczba);
                view.setWynik(wynik);

            } catch (NumberFormatException ex) {
                view.pokazBlad("Wpisz poprawną liczbę całkowitą!");
            }
        }
    }
}
