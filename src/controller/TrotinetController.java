package controller;

import domain.Trotinet;
import repository.Repository;
import repository.TrotinetRepository;

import java.util.List;

public class TrotinetController {

    private final TrotinetRepository storageTrotinet;

    public TrotinetController() {
        storageTrotinet = new TrotinetRepository();
    }

    public List<Trotinet> getAll(){
        return storageTrotinet.getAll();
    }

    public void add(Trotinet t) throws Exception {
        if(storageTrotinet.getAll().contains(t)){
            throw new Exception("Trotinet vec postoji!");
        }
        storageTrotinet.add(t);
    }
}
