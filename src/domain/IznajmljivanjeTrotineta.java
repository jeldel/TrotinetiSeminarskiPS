package domain;

import java.util.Date;

public class IznajmljivanjeTrotineta {

    private Long iznajmljivanjeID;
    private Date datumVreme;
    private double brojSati;
    private double ukupnaCena;
    private Klijent klijent;
    private Administrator administrator;
    private Trotinet trotinet;

    private void izracunajUkupnuCenu(double brojSati, Cenovnik pocetnaCena, Cenovnik cenaPoSatu){
        this.ukupnaCena = pocetnaCena.getPocetnaCena() + (brojSati * cenaPoSatu.getCenaPoSatu());
    }

    public Long getIznajmljivanjeID() {
        return iznajmljivanjeID;
    }

    public void setIznajmljivanjeID(Long iznajmljivanjeID) {
        this.iznajmljivanjeID = iznajmljivanjeID;
    }

    public Date getDatumVreme() {
        return datumVreme;
    }

    public void setDatumVreme(Date datumVreme) {
        this.datumVreme = datumVreme;
    }


    public Klijent getKlijent() {
        return klijent;
    }

    public void setKlijent(Klijent klijent) {
        this.klijent = klijent;
    }

    public Administrator getAdministrator() {
        return administrator;
    }

    public void setAdministrator(Administrator administrator) {
        this.administrator = administrator;
    }

    public Trotinet getTrotinet() {
        return trotinet;
    }

    public void setTrotinet(Trotinet trotinet) {
        this.trotinet = trotinet;
    }
}
