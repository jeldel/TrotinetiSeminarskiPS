package domain;

import java.math.BigDecimal;
import java.util.Date;

public class Cenovnik {

    private Long cenovnikID;
    private Long trotinetID;
    private double pocetnaCena;
    private final double cenaPoSatu = 40;

     void vratiCenuPoTipu(Trotinet t) {
        VrstaTrotinetaEnum vrsta = t.getVrstaTrotineta();

        switch (vrsta) {
            case Sharp:
                pocetnaCena = 80;
                break;
            case Soflow:
                pocetnaCena = 100;
                break;
            case Segway:
                pocetnaCena = 75;
                break;
            default:
            case XIAOMI:
                pocetnaCena = 110;
                break;
            case MS_Energy:
                pocetnaCena = 60;
                break;
        }
    }



    public double getPocetnaCena() {
        return pocetnaCena;
    }

    public double getCenaPoSatu() {
        return cenaPoSatu;
    }

}
