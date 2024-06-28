package repository.memory;

import domain.Osoba;

import java.util.ArrayList;
import java.util.List;

public class OsobaRepository {

    private List<Osoba> osobe;

    public OsobaRepository(){
        osobe = new ArrayList<>();
        osobe.add(new Osoba(84019291L, "Proba", "Proba"));
    }

    public List<Osoba> getAll(){
        return osobe;
    }


    public void add(Osoba admin){
        osobe.add(admin);
    }
}
