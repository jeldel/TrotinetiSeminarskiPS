package repository;

import domain.GradEnum;
import domain.Klijent;

import java.util.ArrayList;
import java.util.List;

public class KlijentRepository {

    private List<Klijent> klijenti;

    public KlijentRepository() {
        klijenti = new ArrayList<>();
        klijenti.add(new Klijent(1L, "Pera", "Peric","peraperic","pera", GradEnum.Beograd,"peraperic@pp.com","063/1111-111"));
    }


    public List<Klijent> getAll() {
        return klijenti;
    }

    public void add(Klijent klijent){
        klijenti.add(klijent);
    }
}
