package domain;

import java.util.Date;

public class Cenovnik {

    private Trotinet trotinet;
    private double pocetnaCena;
    private double cenaPoSatu = 40;

    private void vratiCenuPoTipu(Trotinet t){
        VrstaTrotinetaEnum vrsta = t.getVrstaTrotineta().getVrstaEnum();

        if(vrsta == VrstaTrotinetaEnum.Sharp){
            pocetnaCena = 80;
        } else if (vrsta == VrstaTrotinetaEnum.Soflow) {
            pocetnaCena =  100;
        } else if (vrsta == VrstaTrotinetaEnum.Segway) {
            pocetnaCena =  75;
        } else if (vrsta == VrstaTrotinetaEnum.XIAOMI) {
            pocetnaCena =  110;
        } else if (vrsta == VrstaTrotinetaEnum.MS_Energy) {
            pocetnaCena =  60;
        }
    }


    public double getPocetnaCena() {
        return pocetnaCena;
    }

    public double getCenaPoSatu() {
        return cenaPoSatu;
    }

}
