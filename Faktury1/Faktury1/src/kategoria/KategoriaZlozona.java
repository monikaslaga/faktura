package kategoria;

import java.util.ArrayList;

public class KategoriaZlozona extends Kategoria {

    private ArrayList<Kategoria> kolekcjaKategorii = new ArrayList<>();

    public void dodajKategorie(Kategoria k) {
        kolekcjaKategorii.add(k);
    }

    @Override
    public void WypiszNazwe() {
        System.out.println("ZK------------");
        for (Kategoria k : kolekcjaKategorii) {
            k.wypiszNazwe();
        }
    }
}
