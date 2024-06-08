package domain;

public class Korisnik {

    private Long korisnikID;
    private String ime;
    private String prezime;
    private String email;
    private String username;
    private String sifra;
    private GradEnum grad;
    private String telefon;

    public Korisnik() {
    }

    public Korisnik(Long korisnikID, String ime, String prezime, String email, GradEnum grad, String telefon, String username, String sifra) {
        this.korisnikID = korisnikID;
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

    public GradEnum getGrad() {
        return grad;
    }

    public void setGrad(GradEnum grad) {
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

    public Long getkorisnikID() {
        return korisnikID;
    }

    public void setkorisnikID(Long korisnikID) {
        this.korisnikID = korisnikID;
    }

    @Override
    public String toString() {
        return "Korisnik{" +
                "korisnikID=" + korisnikID +
                ", ime='" + ime + '\'' +
                ", prezime='" + prezime + '\'' +
                ", email='" + email + '\'' +
                ", sifra='" + sifra + '\'' +
                ", grad='" + grad + '\'' +
                ", telefon='" + telefon + '\'' +
                '}';
    }
}
