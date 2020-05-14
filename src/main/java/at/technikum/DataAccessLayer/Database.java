package at.technikum.DataAccessLayer;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Database {

    public static Properties readProperties() {
        // create and load default properties Properties
        Properties defaultProps = new Properties();
        Path defaultPropsPath = Paths.get("default.properties");

        try {
            BufferedReader bf = Files.newBufferedReader(defaultPropsPath, StandardCharsets.UTF_8);
            defaultProps.load(bf);
        } catch (IOException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }

        // create application properties with default
        Properties applicationProps = new Properties(defaultProps);
        Path applicationPropsPath = Paths.get("app.properties");

        try {
            BufferedReader bf = Files.newBufferedReader(applicationPropsPath, StandardCharsets.UTF_8);
            applicationProps.load(bf);
        } catch (IOException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
        return applicationProps;
    }

    /**
     * Connect to the PostgreSQL database
     *
     * @return a Connection object
     */
    public Connection connect() {

        Properties properties = readProperties();

        String url = properties.getProperty("db.url");
        String user = properties.getProperty("db.user");
        String passwd = properties.getProperty("db.passwd");

        Connection connection = null;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(url, user, passwd);
            System.out.println("Connected to the Mysql server successfully.");


        } catch (SQLException | ClassNotFoundException e) {
            System.out.println("Unable to connect to MySQL\n" + e.getMessage());
        }
        return connection;
    }


}
