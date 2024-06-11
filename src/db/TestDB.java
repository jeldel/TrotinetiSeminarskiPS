package db;

import domain.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.Calendar;
import java.util.List;

public class TestDB {
    public static void main(String[] args) throws Exception {
        DBBroker db = new DBBroker();
        db.uspostaviKonekciju();

       //Trotinet t1 = new Trotinet(1L, VrstaTrotinetaEnum.XIAOMI, "brz", Status.Dostupan);

        //Trotinet t = new Trotinet(null, VrstaTrotinetaEnum.Segway, "dugo trajanje baterije", Status.Iznajmljen);
       //List<Trotinet> trotineti = new ArrayList<>();
        //db.kreirajTrotinet(t);

      // List <Trotinet> trotineti = db.vratiSveTrotinete();
        //for(Trotinet t3: trotineti) System.out.println(t);

//        db.obrisiTrotinet(VrstaTrotinetaEnum.Segway);
//        trotineti = db.vratiSveTrotinete();
//        for(Trotinet t3: trotineti) System.out.println(t);



        //korisnici
       //Korisnik k1 = new Korisnik(null, "Jelena", "Delic", "jelenadelic@jd.com", GradEnum.Beograd, "0601333327", "jelenadelic", "jelena");
       // List<Korisnik> klijenti = new ArrayList<>();
        //klijenti.add(k1);
        //db.kreirajKorisnika(k1);
//        List <Korisnik> korisnici = db.vratiSveKorisnike();
//        for(Korisnik k :korisnici) System.out.println(k);
//
//        db.obrisiKorisnika("jelenadelic");
//        korisnici = db.vratiSveKorisnike();
//        for(Korisnik k :korisnici) System.out.println(k);



//        Calendar calendar = Calendar.getInstance();
//        calendar.set(2024, Calendar.APRIL, 3);
//        Date newDate = calendar.getTime();
//
//        Korisnik k2 = new Korisnik(null, "Marko", "Markovic", "markomarkovic@mm.com", GradEnum.Zrenjanin, "0601353327", "markomarkovic", "marko");
//        db.kreirajKorisnika(k2);
//
//        IznajmljivanjeTrotineta it = new IznajmljivanjeTrotineta(1L, newDate, 5, k2, t);
//        List<IznajmljivanjeTrotineta> iznajmljivanjeTrotinetaList = new ArrayList<>();
//        iznajmljivanjeTrotinetaList.add(it);
//        db.kreirajVoznju(it);



//        System.out.println("Kreiran je user sa id " + k2.getkorisnikID());

       // System.out.println(db.vratiVoznjePoKriterijumu("markomarkovic"));
        try{
            db.potvrdiTransakciju();
        }catch(Exception e){
            db.ponistiTransakciju();
        }finally {
            db.raskiniKonekciju();
        }

    }
}
