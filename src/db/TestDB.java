package db;

import domain.*;

import java.util.ArrayList;
import java.util.List;

public class TestDB {
    public static void main(String[] args) throws Exception {
        DBBroker db = new DBBroker();
        db.uspostaviKonekciju();

       // Trotinet t1 = new Trotinet(1L, VrstaTrotinetaEnum.XIAOMI, "brz", Status.Dostupan);

        //Trotinet t = new Trotinet(2L, VrstaTrotinetaEnum.Segway, "dugo trajanje baterije", Status.Iznajmljen);
        //List<Trotinet> trotineti = new ArrayList<>();
       // trotineti.add(t1);
        //trotineti.add(t);

        //System.out.println(db.vratiSveTrotinete());

        Korisnik k1 = new Korisnik(2L, "Jelena", "Delic", "jelenadelic@jd.com", GradEnum.Beograd, "0601333327", "jelenadelic", "jelena");
        List<Korisnik> klijenti = new ArrayList<>();
        klijenti.add(k1);
        db.kreirajKorisnika(k1);

        System.out.println(db.vratiSveKorisnike());

        db.raskiniKonekciju();
    }
}
