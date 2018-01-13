package io.veron.database;

import java.util.Properties;

public class DatabaseBuilder {

    private DatabaseType type = DatabaseType.POSTGRES;
    private String server = "127.0.0.1";
    private int port = 5432;
    private String database = "veron";
    private Properties props = new Properties();

    public void setDatabaseType(DatabaseType type) {
        this.type = type;
    }

    public void setServer(String server) {
        this.server = server;
    }

    public void setDatabase(String database) {
        this.database = database;
    }

    public void addProperty(String key, String value) {
        this.props.put(key, value);
    }

    public Database build() {
        return new Database(type.format(this), props);
    }


    public enum DatabaseType {
        POSTGRES("jdbc:postgresql://%1$:%2$s/%3$s");

        final String unformatted;

        DatabaseType(String unformatted) {
            this.unformatted = unformatted;
        }

        private String format(DatabaseBuilder builder) {
            return String.format(unformatted, builder.server, builder.port, builder.database);
        }
    }
}