package repository.db;

import java.sql.SQLException;

public class DBRepository {

    public void connect() throws SQLException {
        DBConnectionFactory.getInstance().getConnection();
    }

    public void disconnect() throws SQLException {
        DBConnectionFactory.getInstance().getConnection().close();
    }

    public void commit() throws SQLException{
        DBConnectionFactory.getInstance().getConnection().commit();
    }
    public void rollback() throws SQLException{
        DBConnectionFactory.getInstance().getConnection().rollback();
    }

}
