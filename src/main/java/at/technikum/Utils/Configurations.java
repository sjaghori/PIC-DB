package at.technikum.Utils;

import at.technikum.DataAccessLayer.Database;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Configurations {
    public static Properties readProperties() {
        // create and load default properties Properties
        java.util.Properties defaultProps = new java.util.Properties();
        Path defaultPropsPath = Paths.get("default.properties");

        try {
            BufferedReader bf = Files.newBufferedReader(defaultPropsPath, StandardCharsets.UTF_8);
            defaultProps.load(bf);
        } catch (IOException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }

        // create application properties with default
        java.util.Properties applicationProps = new java.util.Properties(defaultProps);
        Path applicationPropsPath = Paths.get("app.properties");

        try {
            BufferedReader bf = Files.newBufferedReader(applicationPropsPath, StandardCharsets.UTF_8);
            applicationProps.load(bf);
        } catch (IOException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
        return applicationProps;
    }
}
