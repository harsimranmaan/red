/*
 * 
 * 
 */
package adg.red.utils;

import adg.red.config.Config;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author harsimran.maan
 */
public class ConfigManager
{

    private static ConfigManager configManager = new ConfigManager();
    private Properties properties;

    private ConfigManager()
    {
        properties = new Properties();
        try
        {
            properties.load(Config.getPropFileStream("config.properties"));
        }
        catch (IOException ex)
        {
            Logger.getLogger(ConfigManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static ConfigManager getInstance()
    {
        return configManager;
    }

    public Properties getProperties()
    {
        return properties;
    }

    public String getPropertyValue(String key)
    {
        return properties.getProperty(key);

    }
}
