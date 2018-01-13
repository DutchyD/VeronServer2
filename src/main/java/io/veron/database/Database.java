package io.veron.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class Database {

    private final String con;
    private final Properties props;

    public Database(String con, Properties props) {
        this.con = con;
        this.props = props;
    }

    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(con, props);
    }
}
