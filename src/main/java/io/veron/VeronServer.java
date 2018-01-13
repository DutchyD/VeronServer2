package io.veron;

import io.veron.database.Database;
import org.postgresql.PGProperty;
import org.postgresql.ds.PGPooledConnection;
import org.postgresql.jdbc3.Jdbc3ConnectionPool;

import javax.sql.PooledConnection;
import java.sql.SQLException;

public class VeronServer {

    public static void main(String... args) {
        Jdbc3ConnectionPool pool = new Jdbc3ConnectionPool();
        pool.setUser("postgres");
        pool.setPassword("cunt");
        pool.setApplicationName("Veron Server");
        pool.setProperty(PGProperty.PG_HOST, "localhost");
        pool.setPortNumber(5432);
        pool.setDatabaseName("postgres");
        try {
            PooledConnection conn = pool.getPooledConnection();
            conn.getConnection().createStatement().execute("CREATE TABLE IF NOT EXISTS test (id serial PRIMARY KEY NOT NULL, text varchar(100));");
        }
        catch (SQLException e) { e.printStackTrace(); }

        System.out.println("Done");
    }
}
