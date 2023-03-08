package main;

import rabaty.AdapterRabatuLosowegoKlasowy;
import rabaty.AdapterRabatuLosowegoObiektowy;
import rabaty.IObliczCenePoRabacie;
import rabaty.ObliczCenePoRabacieProcentowym;

public class Konfiguracja {
    private static Konfiguracja instance;

    private Konfiguracja() {
    }

    public static Konfiguracja getInstance() {
        if (instance == null) instance = new Konfiguracja();
        return instance;
    }

    public double getKwotaRabatu() {
        return 1;
    }

    public double getProcentRabatu() {
        return 5;
    }

    public IObliczCenePoRabacie getBiezacyRabat() {
        //return new ObliczCenePoRabacieKotowym();
//        return new ObliczCenePoRabacieProcentowym();
//        return new AdapterRabatuLosowegoKlasowy();
        return new AdapterRabatuLosowegoObiektowy();
    }
}
