package kategoria;

public class KategoriaProsta extends Kategoria {
    private String nazwa;

    public KategoriaProsta(String nazwa) {
        this.nazwa = nazwa;
    }

    public void WypiszNazwe() {
        System.out.println(nazwa);
    }
}