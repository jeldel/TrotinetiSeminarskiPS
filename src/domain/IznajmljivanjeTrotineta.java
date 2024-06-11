package domain;

import java.util.Date;

public class IznajmljivanjeTrotineta {

    private Long iznajmljivanjeID;
    private Date datumVreme;
    private double brojSati;
    private Cenovnik cena = new Cenovnik();
    private double ukupnaCena;
    private Korisnik korisnik;
    private Trotinet trotinet;


    public IznajmljivanjeTrotineta() {
    }

    public IznajmljivanjeTrotineta(Long iznajmljivanjeID, Date datumVreme, double brojSati, Korisnik korisnik, Trotinet trotinet) {
        this.iznajmljivanjeID = iznajmljivanjeID;
        this.datumVreme = datumVreme;
        this.brojSati = brojSati;
        this.korisnik = korisnik;
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

    public void setUkupnaCena(double ukupnaCena) {
        this.ukupnaCena = ukupnaCena;
    }

    public double getUkupnaCena() {
        return izracunajUkupnuCenu(this.brojSati, this.cena.getPocetnaCena(this.trotinet), this.cena.getCenaPoSatu(this.trotinet), this.trotinet);
    }

    private double izracunajUkupnuCenu(Double brojSati, Double pocetnaCena, Double cenaPoSatu, Trotinet t){
        this.ukupnaCena = cena.getPocetnaCena(t) + (brojSati * cena.getCenaPoSatu(t));
        return ukupnaCena;
    }

    public Korisnik getKorisnik() {
        return korisnik;
    }

    public void setKorisnik(Korisnik korisnik) {
        this.korisnik = korisnik;
    }

//    public Administrator getAdministrator() {
//        return administrator;
//    }
//
//    public void setAdministrator(Administrator administrator) {
//        this.administrator = administrator;
//    }

    public Trotinet getTrotinet() {
        return trotinet;
    }

    public void setTrotinet(Trotinet trotinet) {
        this.trotinet = trotinet;
    }

    @Override
    public String toString() {
        return "IznajmljivanjeTrotineta{" +
                "iznajmljivanjeID=" + iznajmljivanjeID +
                ", datumVreme=" + datumVreme +
                ", brojSati=" + brojSati +
                ", ukupnaCena=" + ukupnaCena +
                ", korisnik=" + korisnik +
                ", trotinet=" + trotinet +
                '}';
    }
}
