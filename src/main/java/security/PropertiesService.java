package security;

import database.DatabaseProperties;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesService {

    private final Properties properties;
    private final ClassLoader classLoader;
    private final String CONFIG_FILE_NAME = "config.properties";
    private static final String DB_CONNECTION_URL = "dbconnectionurl";
    private static final String DB_USERNAME = "dbusername";
    private static final String DB_PASSWORD = "dbpassword";

    public PropertiesService(ClassLoader classLoader, Properties properties) {
        this.properties = properties;
        this.classLoader = classLoader;
    }

    public DatabaseProperties getDatabaseProperties() throws IOException {

        InputStream inputStream = classLoader.getResourceAsStream(CONFIG_FILE_NAME);

        if (inputStream != null) {
            properties.load(inputStream);
        } else {
            throw new FileNotFoundException("property file '" + CONFIG_FILE_NAME + "' not found in the classpath");
        }

        String connectionUrl = properties.getProperty(DB_CONNECTION_URL);
        String username = properties.getProperty(DB_USERNAME);
        String password = properties.getProperty(DB_PASSWORD);
        return new DatabaseProperties(connectionUrl, username, password);
    }


    private static PropertiesService filesService;

    public static PropertiesService getInstance(ClassLoader classLoader, Properties properties) {
        if (filesService == null) {
            filesService = new PropertiesService(classLoader, properties);
        }
        return filesService;
    }
}
