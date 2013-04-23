/*
 * The localeManager class is responsible for managing the locale of the
 * application. It main functionality is to get the representing String of the
 * resourceId, according to the locale property value.
 */
package adg.red.locale;

import adg.red.utils.ConfigManager;
import java.io.IOException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * The localeManager class is responsible for managing the locale of the
 * application. It main functionality is to get the representing String of the
 * resourceId, according to the locale property value.
 * <p/>
 * @author Witt
 */
public class LocaleManager
{

    private static Properties properties;
    private static String locale;

    static
    {
        setLocale(ConfigManager.getInstance().getPropertyValue("locale"));
    }

    private static void setLocale(String locale)
    {
        LocaleManager.locale = locale;
        properties = new Properties();
        try
        {
            properties.load(LocaleManager.class.getResourceAsStream("locale." + locale + ".properties"));
        }
        catch (IOException ex)
        {
            Logger.getLogger(ConfigManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void changeLocale(String locale)
    {
        setLocale(locale);
    }

    /**
     * The function to get the String that represent the input resourseId
     * number.
     * <p/>
     * @param resourceId the number that we want to get the represented String
     * <p/>
     * @return the String represents the resourceId number
     */
    public static String get(int resourceId)
    {
        String text = "No translation";
        String result = properties.getProperty(Integer.toString(resourceId));
        return (result == null || result.equals("")) ? text : result;
    }

    public static String getLoc()
    {
        return locale;
    }
}
