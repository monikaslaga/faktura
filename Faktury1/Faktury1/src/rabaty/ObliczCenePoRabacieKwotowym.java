package rabaty;

import main.Konfiguracja;

public class ObliczCenePoRabacieKwotowym implements IObliczCenePoRabacie {
    @Override
    public double obliczCenePoRabacie(double cena) {
        Konfiguracja k = Konfiguracja.getInstance();
        double kwotaRabatu = k.getKwotaRabatu();
        return cena -= kwotaRabatu;
    }
}
