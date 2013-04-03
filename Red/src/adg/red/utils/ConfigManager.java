/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package adg.red.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
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
            properties.load(new FileInputStream("config.properties"));
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

    public void setProperties(Properties properties)
    {
        //   this.properties.store(new FileOutputStream(propertiesFile, "Properties for MyApp"), null);
    }
}
