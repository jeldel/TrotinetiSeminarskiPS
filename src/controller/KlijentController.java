package controller;

import domain.IznajmljivanjeTrotineta;
import domain.Klijent;
import repository.IznajmljivanjeRepository;
import repository.KlijentRepository;
import repository.Repository;
import repository.TrotinetRepository;

import java.rmi.server.ExportException;
import java.util.List;

public class KlijentController {
    private final KlijentRepository storageKlijent;

    public KlijentController() {
        storageKlijent = new KlijentRepository();
    }

    public Klijent login(String username, String password) {
        List<Klijent> klijenti = storageKlijent.getAll();

        for (Klijent klijent : klijenti){
            if(klijent.getUsername().equals(username) && klijent.getSifra().equals(password)){
                return klijent;
            }
        }

        return null;
    }




}
