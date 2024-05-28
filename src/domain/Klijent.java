package domain;

public class Klijent {

    private Long klijentID;
    private String ime;
    private String prezime;
    private String email;
    private String username;
    private String sifra;
    private String grad;
    private String telefon;

    public Klijent() {
    }

    public Klijent(Long klijentID, String ime, String prezime, String username, String sifra, String grad, String email, String telefon) {
        this.klijentID = klijentID;
        this.ime = ime;
        this.email = email;
        this.prezime = prezime;
        this.sifra = sifra;
        this.username = username;
        this.grad = grad;
        this.telefon = telefon;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    public String getGrad() {
        return grad;
    }

    public void setGrad(String grad) {
        this.grad = grad;
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
                ", grad='" + grad + '\'' +
                ", telefon='" + telefon + '\'' +
                '}';
    }
}
