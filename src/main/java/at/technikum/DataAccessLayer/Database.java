package at.technikum.DataAccessLayer;

import at.technikum.Utils.Configurations;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class Database {

    static Connection connection = null;

    /**
     * Connect to the MySQL database
     *
     * @return a Connection object
     */
    public static Connection getConnection() {
        if (connection != null) return connection;

        Properties properties = Configurations.readProperties();

        String url = properties.getProperty("db.url");
        String user = properties.getProperty("db.user");
        String passwd = properties.getProperty("db.passwd");

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
