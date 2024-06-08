package controller;

import domain.Administrator;
import domain.IznajmljivanjeTrotineta;
import domain.Korisnik;
import domain.Trotinet;
import repository.AdministratorRepository;
import repository.IznajmljivanjeRepository;
import repository.KorisnikRepository;
import repository.TrotinetRepository;

import java.util.List;

public class Controller {
    private static Controller instance;
    private final KorisnikRepository storageKorisnik;
    private final TrotinetRepository storageTrotinet;
    private final AdministratorRepository storageAdmin;
    private final IznajmljivanjeRepository storageIznajmljivanje;

    private Controller(){
        storageAdmin = new AdministratorRepository();
        storageKorisnik = new KorisnikRepository();
        storageTrotinet = new TrotinetRepository();
        storageIznajmljivanje = new IznajmljivanjeRepository();
    }

    public static Controller getInstance(){
        if (instance == null){
            instance = new Controller();
        }
        return instance;
    }

    //dodavanje
    public void addTrotinet(Trotinet t) throws Exception {
        if(storageTrotinet.getAll().contains(t)){
            throw new Exception("Trotinet vec postoji!");
        }
        storageTrotinet.add(t);
    }

    public void addKorisnik(Korisnik korisnik) throws Exception{
        if(storageKorisnik.getAll().contains(korisnik)){
            throw new Exception("Korisnik vec postoji!");
        }
        storageKorisnik.add(korisnik);
    }

    public void addVoznja(IznajmljivanjeTrotineta it) throws Exception{
        if(storageIznajmljivanje.getAll().contains(it)){
            throw new Exception("Voznja vec postoji!");
        }
        storageIznajmljivanje.add(it);
    }

    //getAll
    public List<Trotinet> getAllTrotinet(){
        return storageTrotinet.getAll();
    }
    public List<Korisnik> getAllKorisnik(){
        return storageKorisnik.getAll();
    }
    public List<IznajmljivanjeTrotineta> getAllVoznje(){
        return storageIznajmljivanje.getAll();
    }

    //login
    public Administrator loginAdmin(String username, String password){
        List<Administrator> administratori  = storageAdmin.getAll();

        for (Administrator administrator : administratori){
            if(administrator.getUsername().equals(username) && administrator.getPassword().equals(password)){
                return administrator;
            }
        }

        return null;
    }

    public Korisnik loginKorisnik(String username, String password) {
        List<Korisnik> korisnici = storageKorisnik.getAll();

        for (Korisnik korisnik : korisnici){
            if(korisnik.getUsername().equals(username) && korisnik.getSifra().equals(password)){
                return korisnik;
            }
        }

        return null;
    }

}
