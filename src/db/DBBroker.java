package db;

import domain.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DBBroker {
    private Connection connection;

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

}
