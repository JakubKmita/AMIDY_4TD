import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ZadanieController {

    private ZadanieModel model;
    private ZadanieView view;

    public ZadanieController(ZadanieModel model, ZadanieView view) {
        this.model = model;
        this.view = view;

        view.addDodajListener(new DodajListener());
        view.addUsunListener(new UsunListener());

        odswiezListe();
    }

    private void odswiezListe() {
        try {
            view.setLista(model.pobierzZadania());
        } catch (Exception e) {
            view.blad("Błąd wczytywania zadań!");
        }
    }

    class DodajListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                String tresc = view.getTresc();
                if (tresc.isEmpty()) {
                    view.blad("Treść zadania nie może być pusta!");
                    return;
                }
                model.dodajZadanie(tresc);
                odswiezListe();
            } catch (Exception ex) {
                view.blad("Nie udało się dodać zadania.");
            }
        }
    }

    class UsunListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                String wybrane = view.getWybrane();
                if (wybrane == null) {
                    view.blad("Najpierw wybierz zadanie!");
                    return;
                }

                int id = Integer.parseInt(wybrane.split(":")[0]);
                model.usunZadanie(id);

                odswiezListe();
            } catch (Exception ex) {
                view.blad("Nie udało się usunąć zadania.");
            }
        }
    }
}
