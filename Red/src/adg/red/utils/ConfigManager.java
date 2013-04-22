/*
 * The ConfigManager class to load the configuration file "config.properties" to
 * the Properties of the application.
 *
 */
package adg.red.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * The ConfigManager class to load the configuration file "config.properties" to
 * the Properties of the application.
 * <p/>
 * @author harsimran.maan
 */
public class ConfigManager
{

    private static ConfigManager configManager = new ConfigManager();
    private Properties properties;

    /**
     * The default constructor for ConfigManager class.
     */
    private ConfigManager()
    {
        properties = new Properties();
        try
        {
            properties.load(new FileInputStream(new File("config.properties")));
        }
        catch (IOException ex)
        {
            Logger.getLogger(ConfigManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * The getter function for configManager variable.
     * <p/>
     * @return the configManager variable
     */
    public static ConfigManager getInstance()
    {
        return configManager;
    }

    /**
     * The getter function for properties variable.
     * <p/>
     * @return the properties variable
     */
    public Properties getProperties()
    {
        return properties;
    }

    /**
     * The function to get String of property by given String keyword.
     * <p/>
     * @param key the String keyword to get property value for
     * <p/>
     * @return the String value of the properties
     */
    public String getPropertyValue(String key)
    {
        return properties.getProperty(key);

    }
}
