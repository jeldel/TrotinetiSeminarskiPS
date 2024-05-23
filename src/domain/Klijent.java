package domain;

public class Klijent {

    private Long klijentID;
    private String ime;
    private String prezime;
    private String email;
    private String sifra;
    private String adresa;
    private String telefon;

    public Klijent(Long klijentID, String ime, String prezime, String email, String sifra, String adresa, String telefon) {
        this.klijentID = klijentID;
        this.ime = ime;
        this.prezime = prezime;
        this.email = email;
        this.sifra = sifra;
        this.adresa = adresa;
        this.telefon = telefon;
    }

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    public String getAdresa() {
        return adresa;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }

    public String getSifra() {
        return sifra;
    }

    public void setSifra(String sifra) {
        this.sifra = sifra;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public Long getKlijentID() {
        return klijentID;
    }

    public void setKlijentID(Long klijentID) {
        this.klijentID = klijentID;
    }

    @Override
    public String toString() {
        return "Klijent{" +
                "klijentID=" + klijentID +
                ", ime='" + ime + '\'' +
                ", prezime='" + prezime + '\'' +
                ", email='" + email + '\'' +
                ", sifra='" + sifra + '\'' +
                ", adresa='" + adresa + '\'' +
                ", telefon='" + telefon + '\'' +
                '}';
    }
}
