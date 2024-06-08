package domain;

import java.util.Date;

public class IznajmljivanjeTrotineta {

    private Long iznajmljivanjeID;
    private Date datumVreme;
    private double brojSati;
    private double ukupnaCena;
    private Korisnik korisnik;
    private Administrator administrator;
    private Trotinet trotinet;

    private void izracunajUkupnuCenu(Double brojSati, Cenovnik pocetnaCena, Cenovnik cenaPoSatu){
        this.ukupnaCena = pocetnaCena.getPocetnaCena() + (brojSati * cenaPoSatu.getCenaPoSatu());
    }

    public IznajmljivanjeTrotineta(Long iznajmljivanjeID, Date datumVreme, double brojSati, double ukupnaCena, Korisnik korisnik, Administrator administrator, Trotinet trotinet) {
        this.iznajmljivanjeID = iznajmljivanjeID;
        this.datumVreme = datumVreme;
        this.brojSati = brojSati;
        this.ukupnaCena = ukupnaCena;
        this.korisnik = korisnik;
        this.administrator = administrator;
        this.trotinet = trotinet;
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

    public Korisnik getKorisnik() {
        return korisnik;
    }

    public void setKorisnik(Korisnik korisnik) {
        this.korisnik = korisnik;
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
