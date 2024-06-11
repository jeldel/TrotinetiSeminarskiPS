package db;

import domain.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DBBroker {
    private Connection connection;

    //Rad sa bazom
    public void uspostaviKonekciju() throws Exception {
        try {
            if (connection == null || connection.isClosed()) {
                String url = "jdbc:mysql://localhost:3306/trotineti";
                String username = "root";
                String password = "root123!";
                connection = DriverManager.getConnection(url, username, password);
                connection.setAutoCommit(false);
                System.out.println("Uspesna konekcija na bazu");
            }
        } catch (SQLException e) {
            System.out.println("Neuspesna konekcija na bazu");
            throw e;
        }
    }

    public void raskiniKonekciju() throws Exception {
        try {
            if (connection != null) {
                connection.close();
                System.out.println("Uspesno raskinuta konekcija");
            }
        } catch (SQLException e) {
            System.out.println("Neuspesno raskinuta konekcija");
            throw e;
        }
    }

    public void potvrdiTransakciju() throws SQLException {
        try {
            if (connection != null) {
                connection.commit();
                System.out.println("Uspesno potvrdjena transakcija");
            }
        } catch (SQLException e) {
            System.out.println("Neuspesno potvrdjena transakcija");
            throw e;
        }
    }

    public void ponistiTransakciju() throws SQLException {
        try {
            if (connection != null) {
                connection.rollback();
                System.out.println("Uspesno ponistena transakcija");
            }
        } catch (SQLException e) {
            System.out.println("Neuspesno ponistena transakcija");
            throw e;
        }
    }

    //CRUD trotinet
    public void kreirajTrotinet(Trotinet t) {
        try {
            String query = "INSERT INTO trotinet (vrstaTrotineta, karakteristike, status) VALUES (?,?,?)";
            System.out.println(query);
            PreparedStatement statement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, String.valueOf(t.getVrstaTrotineta()));
            statement.setString(2, t.getKarakteristike());
            statement.setString(3, String.valueOf(t.getStatus()));

            statement.executeUpdate();
            ResultSet rs = statement.getGeneratedKeys();
            if (rs.next()) {
                t.setTrotinetID(rs.getLong(1));
            }
            rs.close();
            statement.close();
            System.out.println("Uspesno kreiran trotinet");
        } catch (SQLException e) {
            System.out.println("Neuspesno kreiran trotinet");
            throw new RuntimeException(e);
        }
    }

    public List<Trotinet> vratiSveTrotinete() {
        try {
            List<Trotinet> trotineti = new ArrayList<>();
            String query = "SELECT trotinetID, vrstaTrotineta, karakteristike, status, ocena FROM trotinet";
            System.out.println(query);

            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(query);
            while (rs.next()) {
                Trotinet t = new Trotinet();
                t.setTrotinetID(rs.getLong("trotinetID"));
                t.setVrstaTrotineta(VrstaTrotinetaEnum.valueOf(rs.getString("vrstaTrotineta")));
                t.setKarakteristike(rs.getString("karakteristike"));
                t.setStatus(Status.valueOf(rs.getString("status")));
                t.setOcena(rs.getInt("ocena"));
                trotineti.add(t);
            }
            rs.close();
            statement.close();
            System.out.println("Uspesno ucitana lista trotineta");
            return trotineti;
        } catch (SQLException e) {
            System.out.println("Neuspesno ucitana lista trotineta");
            throw new RuntimeException(e);
        }

    }

    public List<Trotinet> vratiTrotinetePoKriterijumu(VrstaTrotinetaEnum vrstaTrotinetaEnum) {
        try {
            List<Trotinet> trotineti = new ArrayList<>();
            String query = "SELECT trotinetID, vrstaTrotineta, karakteristike, status, ocena FROM trotinet WHERE vrstaTrotineta = '" + vrstaTrotinetaEnum +"'";
            System.out.println(query);

            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(query);
            while (rs.next()) {
                Trotinet t = new Trotinet();
                t.setTrotinetID(rs.getLong("trotinetID"));
                t.setVrstaTrotineta(VrstaTrotinetaEnum.valueOf(rs.getString("vrstaTrotineta")));
                t.setKarakteristike(rs.getString("karakteristike"));
                t.setStatus(Status.valueOf(rs.getString("status")));
                t.setOcena(rs.getInt("ocena"));
                trotineti.add(t);
            }
            rs.close();
            statement.close();
            System.out.println("Uspesno ucitana lista trotineta po unesenom kriterijumu");
            return trotineti;
        } catch (SQLException e) {
            System.out.println("Neuspesno ucitana lista trotineta po unesenom kriterijumu");
            throw new RuntimeException(e);
        }

    }

    public void obrisiTrotinet(VrstaTrotinetaEnum vrstaTrotinetaEnum) {
        try {
            String query = "DELETE FROM trotinet WHERE vrstaTrotineta = ? ";
            System.out.println(query);

            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, String.valueOf(vrstaTrotinetaEnum));
            statement.executeUpdate();
            statement.close();
            System.out.println("Uspesno brisanje trotineta");
        } catch (SQLException e) {
            System.out.println("Neuspesno brisanje trotineta");
            throw new RuntimeException(e);
        }

    }

    //CRUD korisnik
    public void kreirajKorisnika(Korisnik k) {
        try {
            String query = "INSERT INTO korisnik (ime, prezime, email, grad, telefon, username, sifra) VALUES (?,?,?,?,?,?,?)";
            System.out.println(query);
            PreparedStatement statement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, k.getIme());
            statement.setString(2, k.getPrezime());
            statement.setString(3, k.getEmail());
            statement.setString(4, String.valueOf(k.getGrad()));
            statement.setString(5, k.getTelefon());
            statement.setString(6, k.getUsername());
            statement.setString(7, k.getSifra());

            statement.executeUpdate();
            ResultSet rs = statement.getGeneratedKeys();
            if (rs.next()) {
                k.setkorisnikID(rs.getLong(1));
            }

            rs.close();
            statement.close();
            System.out.println("Uspesno kreiran korisnik");
        } catch (SQLException e) {
            System.out.println("Neuspesno kreiran korisnik");
            throw new RuntimeException(e);
        }
    }

    public List<Korisnik> vratiSveKorisnike() {
        try {
            List<Korisnik> korisnici = new ArrayList<>();
            String query = "SELECT korisnikID, ime, prezime, email, grad, telefon, username, sifra FROM korisnik";
            System.out.println(query);

            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(query);
            while (rs.next()) {
                Korisnik k = new Korisnik();
                k.setkorisnikID(rs.getLong("korisnikID"));
                k.setIme(rs.getString("ime"));
                k.setPrezime(rs.getString("prezime"));
                k.setEmail(rs.getString("email"));
                k.setGrad(GradEnum.valueOf(rs.getString("grad")));
                k.setTelefon(rs.getString("telefon"));
                k.setUsername(rs.getString("username"));
                k.setSifra(rs.getString("sifra"));
                korisnici.add(k);
            }
            rs.close();
            statement.close();
            System.out.println("Uspesno ucitana lista korisnika");
            return korisnici;
        } catch (SQLException e) {
            System.out.println("Neuspesno ucitana lista korisnika");
            throw new RuntimeException(e);
        }

    }

    public List<Korisnik> vratiKorisnikePoKriterijumu(String username) {
        try {
            List<Korisnik> korisnici = new ArrayList<>();
            String query = "SELECT korisnikID, ime, prezime, email, grad, telefon, username, sifra FROM korisnik WHERE username = '" + username +"'";
            System.out.println(query);

            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(query);
            while (rs.next()) {
                Korisnik k = new Korisnik();
                k.setkorisnikID(rs.getLong("korisnikID"));
                k.setIme(rs.getString("ime"));
                k.setPrezime(rs.getString("prezime"));
                k.setEmail(rs.getString("email"));
                k.setGrad(GradEnum.valueOf(rs.getString("grad")));
                k.setTelefon(rs.getString("telefon"));
                k.setUsername(rs.getString("username"));
                k.setSifra(rs.getString("sifra"));
                korisnici.add(k);
            }
            rs.close();
            statement.close();
            System.out.println("Uspesno ucitana lista korisnika po zadatom kriterijumu");
            return korisnici;
        } catch (SQLException e) {
            System.out.println("Neuspesno ucitana lista korisnika po zadatom kriterijumu");
            throw new RuntimeException(e);
        }

    }

    public void obrisiKorisnika(String username) {
        try {
            String query = "DELETE FROM korisnik WHERE username = ? ";
            System.out.println(query);

            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, username);
            statement.executeUpdate();
            statement.close();
            System.out.println("Uspesno brisanje korisnika");
        } catch (SQLException e) {
            System.out.println("Neuspesno brisanje korisnika");
            throw new RuntimeException(e);
        }
    }

    //CRUD voznja
    public void kreirajVoznju(IznajmljivanjeTrotineta it) {
        Date sqlDate = new Date(it.getDatumVreme().getTime());
        try {
            String query = "INSERT INTO iznajmljivanjeTrotineta (datumVreme, brojSati, ukupnaCena, korisnikID, trotinetID)  VALUES (?,?,?,?,?)";
            System.out.println(query);
            PreparedStatement statement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            statement.setDate(1, sqlDate);
            statement.setDouble(2, it.getBrojSati());
            statement.setDouble(3, it.getUkupnaCena());
            statement.setLong(4, it.getKorisnik().getkorisnikID());
            statement.setLong(5, it.getTrotinet().getTrotinetID());

            statement.executeUpdate();
            ResultSet rs = statement.getGeneratedKeys();

            if (rs.next()) {
                it.setIznajmljivanjeID(rs.getLong(1));
            }
            rs.close();
            statement.close();
            System.out.println("Uspesno kreirana voznja");
        } catch (SQLException e) {
            System.out.println("Neuspesno kreirana voznja");
            throw new RuntimeException(e);
        }
    }

    public List<IznajmljivanjeTrotineta> vratiSveVoznje() {
        try {
            List<IznajmljivanjeTrotineta> iznajmljivanjeTrotinetaList = new ArrayList<>();
            String query = "SELECT it.iznajmljivanjeID," +
                    " it.datumVreme," +
                    " it.brojSati," +
                    " it.ukupnaCena," +
                    " it.korisnikID," +
                    " it.trotinetID," +
                    " t.trotinetID," +
                    " t.vrstaTrotineta," +
                    " t.karakteristike," +
                    " t.status, " +
                    "t.ocena," +
                    " k.korisnikID," +
                    " k.ime," +
                    " k.prezime," +
                    " k.email, " +
                    "k.grad," +
                    " k.telefon," +
                    " k.username," +
                    " k.sifra " +
                    "FROM iznajmljivanjeTrotineta it INNER JOIN trotinet t ON it.trotinetID = t.trotinetID " +
                    "INNER JOIN korisnik k ON it.korisnikID = k.korisnikID";
            System.out.println(query);

            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(query);

            while (rs.next()) {
                IznajmljivanjeTrotineta it = new IznajmljivanjeTrotineta();
                it.setIznajmljivanjeID(rs.getLong("it.iznajmljivanjeID"));
                it.setDatumVreme(rs.getDate("it.datumVreme"));
                it.setBrojSati(rs.getDouble("it.brojSati"));
                it.setUkupnaCena(rs.getDouble("it.ukupnaCena"));

                Trotinet t = new Trotinet();
                t.setTrotinetID(rs.getLong("t.trotinetID"));
                t.setVrstaTrotineta(VrstaTrotinetaEnum.valueOf(rs.getString("t.vrstaTrotineta")));
                t.setKarakteristike(rs.getString("t.karakteristike"));
                t.setStatus(Status.valueOf(rs.getString("t.status")));
                t.setOcena(rs.getInt("t.ocena"));
                it.setTrotinet(t);

                Korisnik k = new Korisnik();
                k.setkorisnikID(rs.getLong("k.korisnikID"));
                k.setIme(rs.getString("k.ime"));
                k.setPrezime(rs.getString("k.prezime"));
                k.setEmail(rs.getString("k.email"));
                k.setGrad(GradEnum.valueOf(rs.getString("k.grad")));
                k.setTelefon(rs.getString("k.telefon"));
                k.setUsername(rs.getString("k.username"));
                k.setSifra(rs.getString("k.sifra"));
                it.setKorisnik(k);

                iznajmljivanjeTrotinetaList.add(it);
            }
            rs.close();
            statement.close();
            System.out.println("Uspesno ucitana lista voznji");
            return iznajmljivanjeTrotinetaList;
        } catch (SQLException e) {
            System.out.println("Neuspesno ucitana lista voznji");
            throw new RuntimeException(e);
        }
    }

    public List<IznajmljivanjeTrotineta> vratiVoznjePoKriterijumu(String username) {
        try {
            List<IznajmljivanjeTrotineta> iznajmljivanjeTrotinetaList = new ArrayList<>();
            String query = "SELECT it.iznajmljivanjeID," +
                    " it.datumVreme," +
                    " it.brojSati," +
                    " it.ukupnaCena," +
                    " it.korisnikID," +
                    " it.trotinetID," +
                    " t.trotinetID," +
                    " t.vrstaTrotineta," +
                    " t.karakteristike," +
                    " t.status, " +
                    "t.ocena," +
                    " k.korisnikID," +
                    " k.ime," +
                    " k.prezime," +
                    " k.email, " +
                    "k.grad," +
                    " k.telefon," +
                    " k.username," +
                    " k.sifra " +
                    "FROM iznajmljivanjeTrotineta it INNER JOIN trotinet t ON it.trotinetID = t.trotinetID " +
                    "INNER JOIN korisnik k ON it.korisnikID = k.korisnikID WHERE k.username = '"+ username +"'";
            System.out.println(query);

            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(query);

            while (rs.next()) {
                IznajmljivanjeTrotineta it = new IznajmljivanjeTrotineta();
                it.setIznajmljivanjeID(rs.getLong("it.iznajmljivanjeID"));
                it.setDatumVreme(rs.getDate("it.datumVreme"));
                it.setBrojSati(rs.getDouble("it.brojSati"));
                it.setUkupnaCena(rs.getDouble("it.ukupnaCena"));

                Trotinet t = new Trotinet();
                t.setTrotinetID(rs.getLong("t.trotinetID"));
                t.setVrstaTrotineta(VrstaTrotinetaEnum.valueOf(rs.getString("t.vrstaTrotineta")));
                t.setKarakteristike(rs.getString("t.karakteristike"));
                t.setStatus(Status.valueOf(rs.getString("t.status")));
                t.setOcena(rs.getInt("t.ocena"));
                it.setTrotinet(t);

                Korisnik k = new Korisnik();
                k.setkorisnikID(rs.getLong("k.korisnikID"));
                k.setIme(rs.getString("k.ime"));
                k.setPrezime(rs.getString("k.prezime"));
                k.setEmail(rs.getString("k.email"));
                k.setGrad(GradEnum.valueOf(rs.getString("k.grad")));
                k.setTelefon(rs.getString("k.telefon"));
                k.setUsername(rs.getString("k.username"));
                k.setSifra(rs.getString("k.sifra"));
                it.setKorisnik(k);

                iznajmljivanjeTrotinetaList.add(it);
            }
            rs.close();
            statement.close();
            System.out.println("Uspesno ucitana lista voznji");
            return iznajmljivanjeTrotinetaList;
        } catch (SQLException e) {
            System.out.println("Neuspesno ucitana lista voznji");
            throw new RuntimeException(e);
        }
    }

}
