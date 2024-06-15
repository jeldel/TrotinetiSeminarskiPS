package repository.db;

import domain.Administrator;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class AdministratorRepository {
    Connection connection;

    public AdministratorRepository() {
    }
    public List<Administrator> getAll() {
        try {
            List<Administrator> administratori = new ArrayList<>();
            String query = "SELECT administratorID, ime, prezime, username, password FROM administrator";
            System.out.println(query);
            connection = DBConnectionFactory.getInstance().getConnection();
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(query);
            while (rs.next()) {
                Administrator a = new Administrator();
                a.setAdministratorID(rs.getLong("administratorID"));
                a.setIme(rs.getString("ime"));
                a.setPrezime(rs.getString("prezime"));
                a.setUsername(rs.getString("username"));
                a.setPassword(rs.getString("password"));
                administratori.add(a);
            }
            rs.close();
            statement.close();
            System.out.println("Uspesno ucitana lista korisnika");
            return administratori;
        } catch (SQLException e) {
            System.out.println("Neuspesno ucitana lista korisnika");
            throw new RuntimeException(e);
        }

    }
}
