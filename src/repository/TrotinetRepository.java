package repository;

import domain.Trotinet;

import java.util.ArrayList;
import java.util.List;

public class TrotinetRepository {

    private List<Trotinet> trotineti;

    public TrotinetRepository() {
        trotineti = new ArrayList<>();
    }

    public List<Trotinet> getAll(){
        return trotineti;
    }

    public void add(Trotinet trotinet){
        trotineti.add(trotinet);
    }
}
