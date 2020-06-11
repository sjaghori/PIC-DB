package at.technikum.Utils;

import org.apache.logging.log4j.LogManager;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Properties;

public class Configurations {

    private static final org.apache.logging.log4j.Logger logger = LogManager.getLogger(Configurations.class);

    static Properties applicationProps = null;

    public static Properties readProperties() {

        if (applicationProps != null) return applicationProps;

        //logger.debug("Inside Configurations.java");

        // create and load default properties Properties
        java.util.Properties defaultProps = new java.util.Properties();
        Path defaultPropsPath = Paths.get("default.properties");

        try {
            BufferedReader bf = Files.newBufferedReader(defaultPropsPath, StandardCharsets.UTF_8);
            defaultProps.load(bf);
        } catch (IOException ex) {
            logger.error("Unable to read default.properties file: " + ex.getMessage());
        }

        // create application properties with default
        Properties applicationProps = new java.util.Properties(defaultProps);
        Path applicationPropsPath = Paths.get("app.properties");

        try {
            BufferedReader bf = Files.newBufferedReader(applicationPropsPath, StandardCharsets.UTF_8);
            applicationProps.load(bf);
        } catch (IOException ex) {
            logger.error("Unable to read app.properties file: " + ex.getMessage());
        }
        return applicationProps;
    }
}
