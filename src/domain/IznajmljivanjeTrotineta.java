package domain;

import java.util.Date;

public class IznajmljivanjeTrotineta {

    private Long iznajmljivanjeID;
    private Date datumVreme;
    private double brojSati;
    private double ukupnaCena;
    private Long klijentID;
    private Long administratorID;
    private Long trotinetID;

    private void izracunajUkupnuCenu(Double brojSati, Cenovnik pocetnaCena, Cenovnik cenaPoSatu){
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

    public Double getBrojSati() {
        return brojSati;
    }

    public void setBrojSati(Double brojSati) {
        this.brojSati = brojSati;
    }

    public Double getUkupnaCena() {
        return ukupnaCena;
    }

    public void setUkupnaCena(Double ukupnaCena) {
        this.ukupnaCena = ukupnaCena;
    }

    public Long getKlijentID() {
        return klijentID;
    }

    public void setKlijentID(Long klijentID) {
        this.klijentID = klijentID;
    }

    public Long getAdministratorID() {
        return administratorID;
    }

    public void setAdministratorID(Long administratorID) {
        this.administratorID = administratorID;
    }

    public Long getTrotinetID() {
        return trotinetID;
    }

    public void setTrotinetID(Long trotinetID) {
        this.trotinetID = trotinetID;
    }
}
