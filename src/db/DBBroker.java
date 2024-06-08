package db;

import domain.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DBBroker {
    private Connection connection;

    public void uspostaviKonekciju() throws Exception{
        try {
            if(connection == null || connection.isClosed()) {
                String url = "jdbc:mysql://localhost:3306/trotineti";
                String username = "root";
                String password = "root123!";
                connection = DriverManager.getConnection(url, username, password);
                System.out.println("Uspesna konekcija na bazu");
            }
        } catch (SQLException e) {
            System.out.println("Neuspesna konekcija na bazu");
            throw e;
        }
    }

    public void raskiniKonekciju() throws Exception{
        try {
            if(connection != null) {
                connection.close();
                System.out.println("Uspesno raskinuta konekcija");
            }
        } catch (SQLException e) {
            System.out.println("Neuspesno raskinuta konekcija");
            throw e;
        }
    }

    public void kreirajTrotinet(Trotinet t){
        try {
            String query = "INSERT INTO trotinet  (trotinetID, vrstaTrotineta, karakteristike, status) VALUES (" +
                    "" + t.getTrotinetID() + ", "+
                    "'" + t.getVrstaTrotineta() + "' , "+
                    "'" + t.getKarakteristike() + "' , "+
                    "'" + t.getStatus() + "')";

            System.out.println(query);
            Statement statement = connection.createStatement();
            statement.executeUpdate(query);
            statement.close();
            System.out.println("Uspesno kreiran trotinet");
        } catch (SQLException e) {
            System.out.println("Neuspesno kreiran trotinet");
            throw new RuntimeException(e);
        }
    }


    public List<Trotinet> vratiSveTrotinete(){
        try {
            List<Trotinet> trotineti = new ArrayList<Trotinet>();
            String query = "SELECT trotinetID, vrstaTrotineta, karakteristike, status, ocena FROM trotinet";
            System.out.println(query);

            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(query);
            while(rs.next()){
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

    public void kreirajKorisnika(Korisnik k){
        try {
            String query = "INSERT INTO korisnik (korisnikID, ime, prezime, email, grad, telefon, username, sifra) VALUES (?,?,?,?,?,?,?,?)";
            System.out.println(query);
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setLong(1, k.getkorisnikID());
            statement.setString(2, k.getIme());
            statement.setString(3, k.getPrezime());
            statement.setString(4, k.getEmail());
            statement.setString(5, String.valueOf(k.getGrad()));
            statement.setString(6, k.getTelefon());
            statement.setString(7, k.getUsername());
            statement.setString(8, k.getSifra());

            statement.executeUpdate();
            statement.close();
            System.out.println("Uspesno kreiran korisnik");
        } catch (SQLException e) {
            System.out.println("Neuspesno kreiran korisnik");
            throw new RuntimeException(e);
        }
    }

    public List<Korisnik> vratiSveKorisnike(){
        try {
            List<Korisnik> korisnici = new ArrayList<Korisnik>();
            String query = "SELECT korisnikID, ime, prezime, email, grad, telefon, username, sifra FROM korisnik";
            System.out.println(query);

            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(query);
            while(rs.next()){
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


}
