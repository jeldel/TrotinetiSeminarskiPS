package controller;

import domain.Administrator;
import domain.IznajmljivanjeTrotineta;
import domain.Korisnik;
import domain.Trotinet;
import domain.VrstaTrotinetaEnum;
import repository.db.IznajmljivanjeRepository;
import repository.db.KorisnikRepository;
import repository.db.TrotinetRepository;
import repository.db.AdministratorRepository;

import java.sql.SQLException;
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

    //add
    public void addTrotinet(Trotinet trotinet) throws Exception {
        storageTrotinet.connect();
        try{
            storageTrotinet.add(trotinet);
            storageTrotinet.commit();
        } catch(SQLException e){
            storageTrotinet.rollback();
            e.printStackTrace();
            throw e;
        }finally{
            storageTrotinet.disconnect();
        }
    }

    public void addKorisnik(Korisnik korisnik) throws Exception{
       storageKorisnik.connect();
        try{
            storageKorisnik.add(korisnik);
            storageKorisnik.commit();
        } catch(SQLException e){
            storageKorisnik.rollback();
            e.printStackTrace();
            throw e;
        }finally{
            storageKorisnik.disconnect();
        }
    }

    public void addVoznja(IznajmljivanjeTrotineta iznajmljivanjeTrotineta) throws Exception{
        storageIznajmljivanje.connect();
        try{
            storageIznajmljivanje.add(iznajmljivanjeTrotineta);
            storageIznajmljivanje.commit();
        } catch(SQLException e){
            storageIznajmljivanje.rollback();
            e.printStackTrace();
            throw e;
        }finally{
            storageIznajmljivanje.disconnect();
        }
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

    public void addAllVoznje(List<IznajmljivanjeTrotineta> voznje) throws SQLException{
        storageIznajmljivanje.connect();
        try{
            storageIznajmljivanje.addAll(voznje);
            storageIznajmljivanje.commit();
        } catch(SQLException e){
            storageIznajmljivanje.rollback();
            e.printStackTrace();
            throw e;
        }finally{
            storageIznajmljivanje.disconnect();
        }
    }

    //getByID
    public Trotinet getTrotinetById(Long id) {
        return storageTrotinet.getById(id);
    }

    public List<IznajmljivanjeTrotineta> getAllByCriteria(String username){
        return storageIznajmljivanje.getAllByCriteria(username);
    }

    public List<Trotinet> getAllByVrsta(VrstaTrotinetaEnum vrstaTrotinetaEnum) {
        return storageTrotinet.getAllByVrsta(vrstaTrotinetaEnum);
    }

    public void deleteTrotinet(Long trotinetID) throws SQLException {
        storageTrotinet.connect();
        try{
            storageTrotinet.delete(trotinetID);
            storageTrotinet.commit();
        } catch(SQLException e){
            storageTrotinet.rollback();
            e.printStackTrace();
            throw e;
        }finally{
            storageTrotinet.disconnect();
        }
    }

    public List<Korisnik> getAllByUsername(String username){
        return storageKorisnik.getAllByUsername(username);
    }

    public void deleteKorisnik(String username) throws SQLException {
        storageKorisnik.connect();
        try{
            storageKorisnik.delete(username);
            storageKorisnik.commit();
        } catch(SQLException e){
            storageKorisnik.rollback();
            e.printStackTrace();
            throw e;
        }finally{
            storageKorisnik.disconnect();
        }
    }
}
