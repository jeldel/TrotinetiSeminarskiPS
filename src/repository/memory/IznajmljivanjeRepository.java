package repository.memory;

import domain.IznajmljivanjeTrotineta;

import java.util.ArrayList;
import java.util.List;

public class IznajmljivanjeRepository {

    List<IznajmljivanjeTrotineta> iznajmljivanjeTrotinetaLista;

    public IznajmljivanjeRepository() {
        iznajmljivanjeTrotinetaLista = new ArrayList<>();

    }

    public List<IznajmljivanjeTrotineta> getAll(){
        return iznajmljivanjeTrotinetaLista;
    }

    public void add(IznajmljivanjeTrotineta iznajmljivanjeTrotineta){
        iznajmljivanjeTrotinetaLista.add(iznajmljivanjeTrotineta);
    }
}
