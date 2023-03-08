package rabaty;

import main.Konfiguracja;

public class ObliczCenePoRabacieProcentowym implements IObliczCenePoRabacie {
    @Override
    public double obliczCenePoRabacie (double cena) {
        Konfiguracja k = Konfiguracja.getInstance();
        double kwotaRabatu=k.getProcentRabatu();
        return cena -=cena*kwotaRabatu/100;
        }
    }
