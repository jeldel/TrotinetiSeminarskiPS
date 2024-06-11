package repository.db;

import domain.Status;
import domain.Trotinet;
import domain.VrstaTrotinetaEnum;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TrotinetRepository extends DBRepository {
    Connection connection;

    public TrotinetRepository() {}

    public List<Trotinet> getAll() {
        try {
            List<Trotinet> trotineti = new ArrayList<>();
            String query = "SELECT trotinetID, vrstaTrotineta, karakteristike, status, ocena FROM trotinet";
            System.out.println(query);
            connection = DBConnectionFactory.getInstance().getConnection();
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

    public List<Trotinet> getAllByCriteria(VrstaTrotinetaEnum vrstaTrotinetaEnum) {
        try {
            List<Trotinet> trotineti = new ArrayList<>();
            String query = "SELECT trotinetID, vrstaTrotineta, karakteristike, status, ocena FROM trotinet WHERE vrstaTrotineta = '" + vrstaTrotinetaEnum +"'";
            System.out.println(query);
            connection = DBConnectionFactory.getInstance().getConnection();
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

    public void add(Trotinet trotinet) {
        try {
            String query = "INSERT INTO trotinet (vrstaTrotineta, karakteristike, status) VALUES (?,?,?)";
            System.out.println(query);
            connection = DBConnectionFactory.getInstance().getConnection();

            PreparedStatement statement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, String.valueOf(trotinet.getVrstaTrotineta()));
            statement.setString(2, trotinet.getKarakteristike());
            statement.setString(3, String.valueOf(trotinet.getStatus()));

            statement.executeUpdate();
            ResultSet rs = statement.getGeneratedKeys();
            if (rs.next()) {
                trotinet.setTrotinetID(rs.getLong(1));
            }
            rs.close();
            statement.close();
            System.out.println("Uspesno kreiran trotinet");
        } catch (SQLException e) {
            System.out.println("Neuspesno kreiran trotinet");
            throw new RuntimeException(e);
        }
    }

    public void delete(VrstaTrotinetaEnum vrstaTrotinetaEnum){
        try {
            String query = "DELETE FROM trotinet WHERE vrstaTrotineta = ? ";
            System.out.println(query);
            connection = DBConnectionFactory.getInstance().getConnection();

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
}
