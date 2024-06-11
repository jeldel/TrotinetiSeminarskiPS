package domain;

import java.math.BigDecimal;
import java.util.Date;

public class Cenovnik {

    private final double cenaPoSatu = 40;

    private double vratiCenuPoTipu(Trotinet t) {
        VrstaTrotinetaEnum vrsta = t.getVrstaTrotineta();
        double pocetnaCena;
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
        return pocetnaCena;
    }

    public double getPocetnaCena(Trotinet t) {
        return vratiCenuPoTipu(t);
    }

    public double getCenaPoSatu(Trotinet t) {
        return cenaPoSatu;
    }

}
