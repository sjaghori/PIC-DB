package at.technikum.DataAccessLayer;

import at.technikum.Utils.Configurations;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Database {

    private static final Logger logger = LogManager.getLogger(Database.class);

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
            logger.info("Connected to the Mysql server successfully.");

        } catch (ClassNotFoundException e) {
            logger.error("Unable to load MySQL Driver: " + e.getMessage());
        }

        catch (SQLException e) {
            logger.error("Unable to connect to MySQL: " + e.getMessage());
        }
        return connection;
    }
}
