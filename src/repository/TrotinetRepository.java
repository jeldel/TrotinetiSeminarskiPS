package repository;

import domain.Status;
import domain.Trotinet;
import domain.VrstaTrotinetaEntity;
import domain.VrstaTrotinetaEnum;

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
}
