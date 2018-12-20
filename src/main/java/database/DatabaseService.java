package database;

import security.PropertiesService;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseService {

    private static final String JDBC_DRIVER_CLASS_NAME = "com.mysql.cj.jdbc.Driver";
    private final PropertiesService propertiesService;

    public DatabaseService(PropertiesService propertiesService) {
        this.propertiesService = propertiesService;
    }

    public Connection getConnection() {
        try {
            Class.forName(JDBC_DRIVER_CLASS_NAME);
            String connectionUrl = getDatabaseProperties().getConnectionUrl();
            String username = getDatabaseProperties().getUsername();
            String password = getDatabaseProperties().getPassword();
            return DriverManager.getConnection(connectionUrl, username, password);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    private DatabaseProperties getDatabaseProperties() throws IOException {
        return propertiesService.getDatabaseProperties();
    }

    private static DatabaseService databaseService;

    public static DatabaseService getInstance(PropertiesService propertiesService) {
        if (databaseService == null) {
            databaseService = new DatabaseService(propertiesService);
        }
        return databaseService;
    }
}
