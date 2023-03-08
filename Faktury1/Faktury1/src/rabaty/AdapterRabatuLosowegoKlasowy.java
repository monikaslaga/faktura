package rabaty;

import rabatlosowy.LosowyRabat;

public class AdapterRabatuLosowegoKlasowy extends LosowyRabat implements IObliczCenePoRabacie {
    @Override
    public double obliczCenePoRabacie(double cena) {
        double procentRabatuLosowy = losujRabat() / 10;
        return cena = cena - cena * procentRabatuLosowy;
    }
}
