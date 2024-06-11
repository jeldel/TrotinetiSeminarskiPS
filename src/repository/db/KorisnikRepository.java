package repository.db;

import domain.GradEnum;
import domain.Korisnik;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class KorisnikRepository extends DBRepository{

    Connection connection;

    public KorisnikRepository() {}

    public List<Korisnik> getAll() {
        try {
            List<Korisnik> korisnici = new ArrayList<>();
            String query = "SELECT korisnikID, ime, prezime, email, grad, telefon, username, sifra FROM korisnik";
            System.out.println(query);
            connection = DBConnectionFactory.getInstance().getConnection();
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

    public List<Korisnik> getAllByCriteria(String username) {
        try {
            List<Korisnik> korisnici = new ArrayList<>();
            String query = "SELECT korisnikID, ime, prezime, email, grad, telefon, username, sifra FROM korisnik WHERE username = '" + username +"'";
            System.out.println(query);
            connection = DBConnectionFactory.getInstance().getConnection();
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

    public void add(Korisnik korisnik){
        try {
            String query = "INSERT INTO korisnik (ime, prezime, email, grad, telefon, username, sifra) VALUES (?,?,?,?,?,?,?)";
            System.out.println(query);
            connection = DBConnectionFactory.getInstance().getConnection();

            PreparedStatement statement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, korisnik.getIme());
            statement.setString(2, korisnik.getPrezime());
            statement.setString(3, korisnik.getEmail());
            statement.setString(4, String.valueOf(korisnik.getGrad()));
            statement.setString(5, korisnik.getTelefon());
            statement.setString(6, korisnik.getUsername());
            statement.setString(7, korisnik.getSifra());

            statement.executeUpdate();
            ResultSet rs = statement.getGeneratedKeys();
            if (rs.next()) {
                korisnik.setkorisnikID(rs.getLong(1));
            }

            rs.close();
            statement.close();
            System.out.println("Uspesno kreiran korisnik");
        } catch (SQLException e) {
            System.out.println("Neuspesno kreiran korisnik");
            throw new RuntimeException(e);
        }
    }

    public void delete(String username) {
        try {
            String query = "DELETE FROM korisnik WHERE username = ? ";
            System.out.println(query);
            connection = DBConnectionFactory.getInstance().getConnection();

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
}
