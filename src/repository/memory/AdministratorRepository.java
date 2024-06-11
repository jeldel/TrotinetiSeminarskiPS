package repository.memory;

import domain.Administrator;

import java.util.ArrayList;
import java.util.List;

public class AdministratorRepository {

    private List<Administrator> administratori;

    public AdministratorRepository(){
        administratori = new ArrayList<>();
        administratori.add(new Administrator(1L, "Admin", "Admin", "admin", "admin"));
    }

    public List<Administrator> getAll(){
        return administratori;
    }


    public void add(Administrator admin){
        administratori.add(admin);
    }
}
