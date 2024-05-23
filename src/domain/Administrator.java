package domain;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Administrator {

    private Long administratorID;
    private String ime;
    private String prezime;
    private String username;
    private String password;

    public Administrator(Long administratorID, String ime, String prezime, String username, String password) {
        this.administratorID = administratorID;
        this.ime = ime;
        this.prezime = prezime;
        this.username = username;
        this.password = password;
    }

    public Long getAdministratorID() {
        return administratorID;
    }

    public void setAdministratorID(Long administratorID) {
        this.administratorID = administratorID;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Administrator" + ", ime='" + ime + '\'' + ", prezime='" + prezime;
    }
}