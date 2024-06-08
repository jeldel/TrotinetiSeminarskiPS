package repository;

import domain.GradEnum;
import domain.Korisnik;

import java.util.ArrayList;
import java.util.List;

public class KorisnikRepository {

    private List<Korisnik> korisnici;

    public KorisnikRepository() {
        korisnici = new ArrayList<>();
        korisnici.add(new Korisnik(1L, "Pera", "Peric", "peraperic@pp.com",GradEnum.Beograd, "063/1111-111", "peraperic","peraperic"));
    }


    public List<Korisnik> getAll() {
        return korisnici;
    }

    public void add(Korisnik korisnik){
        korisnici.add(korisnik);
    }
}
