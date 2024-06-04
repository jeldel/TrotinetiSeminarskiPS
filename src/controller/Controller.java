package controller;

import domain.Administrator;
import domain.Klijent;
import domain.Trotinet;
import repository.AdministratorRepository;
import repository.KlijentRepository;
import repository.TrotinetRepository;

import java.util.List;

public class Controller {
    private static Controller instance;
    private final KlijentRepository storageKlijent;
    private final TrotinetRepository storageTrotinet;
    private final AdministratorRepository storageAdmin;

    private Controller(){
        storageAdmin = new AdministratorRepository();
        storageKlijent = new KlijentRepository();
        storageTrotinet = new TrotinetRepository();
    }

    public static Controller getInstance(){
        if (instance == null){
            instance = new Controller();
        }
        return instance;
    }



    public List<Trotinet> getAllTrotinet(){
        return storageTrotinet.getAll();
    }

    public void addTrotinet(Trotinet t) throws Exception {
        if(storageTrotinet.getAll().contains(t)){
            throw new Exception("Trotinet vec postoji!");
        }
        storageTrotinet.add(t);
    }

    public Klijent loginKlijent(String username, String password) {
        List<Klijent> klijenti = storageKlijent.getAll();

        for (Klijent klijent : klijenti){
            if(klijent.getUsername().equals(username) && klijent.getSifra().equals(password)){
                return klijent;
            }
        }

        return null;
    }


    public List<Klijent> getAllKlijent(){
        return storageKlijent.getAll();
    }

    public void addKlijent(Klijent klijent) throws Exception{
        if(storageKlijent.getAll().contains(klijent)){
            throw new Exception("Korisnik vec postoji!");
        }
        storageKlijent.add(klijent);
    }


    public Administrator loginAdmin(String username, String password){
        List<Administrator> administratori  = storageAdmin.getAll();

        for (Administrator administrator : administratori){
            if(administrator.getUsername().equals(username) && administrator.getPassword().equals(password)){
                return administrator;
            }
        }

        return null;
    }

}
