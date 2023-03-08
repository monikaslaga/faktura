package dokumenty;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Date;

import magazyn.Towar;
import main.Konfiguracja;
import rabaty.IObliczCenePoRabacie;
import rabaty.ObliczCenePoRabacieProcentowym;


public class Faktura {
    Date dataSprzedazy;
    String kontrahent;
    ArrayList<Pozycja> pozycje;
    double suma;
    IObliczCenePoRabacie liczbaRabatu;

    public Faktura(Date dataSprzedazy, String kontrahent) {
        this.dataSprzedazy = dataSprzedazy;
        this.kontrahent = kontrahent;
        pozycje = new ArrayList<Pozycja>();
        suma = 0;
        Konfiguracja k = Konfiguracja.getInstance();
        liczbaRabatu = k.getBiezacyRabat();
    }

    public void setliczarkaRabatu(IObliczCenePoRabacie lr) {
        this.liczbaRabatu = lr;
    }


    public void dodajPozycje(Towar towar, double ilosc) {
        pozycje.add(new Pozycja(towar, ilosc));
        this.przeliczSume();
    }

    public double getSuma() {
        return suma;
    }

    public Date getDataSprzedazy() {
        return dataSprzedazy;
    }

    //jak sie zmieni cos na fakturze to trzeba wywolac te metode
    private void przeliczSume() {
        Iterator<Pozycja> iteratorPozycji = pozycje.iterator();
        Pozycja pozycja;
        suma = 0;


        while (iteratorPozycji.hasNext()) {
            pozycja = iteratorPozycji.next();
//			 pozycja.setCena(liczarkaRabatu.obliczCenePoRabacie);
            suma += pozycja.getWartosc();
        }
        suma = liczbaRabatu.obliczCenePoRabacie(suma);
    }

    public Iterator<Pozycja> getIteratorPozycji() {
        return pozycje.iterator();
    }

    public String getKontrahent() {
        return this.kontrahent;
    }


}
