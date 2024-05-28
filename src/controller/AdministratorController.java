package controller;

import domain.Administrator;
import domain.Klijent;
import repository.AdministratorRepository;

import java.util.List;

public class AdministratorController {

    private final AdministratorRepository storageAdmin;

    public AdministratorController() {
        storageAdmin = new AdministratorRepository();
    }

    public Administrator login(String username, String password){
        List<Administrator> administratori  = storageAdmin.getAll();

        for (Administrator administrator : administratori){
            if(administrator.getUsername().equals(username) && administrator.getPassword().equals(password)){
                return administrator;
            }
        }

        return null;
    }

}
