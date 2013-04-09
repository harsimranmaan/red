/*
 * 
 * 
 */
package adg.red.utils;

import adg.red.models.Locale;
import adg.red.models.ResourceDictionary;
import java.util.List;

/**
 *
 * @author Witt
 */
public class LocaleManager
{

    private static final List<ResourceDictionary> resourceList;
    private static final Locale loc;

    static
    {
        loc = Locale.findByName(ConfigManager.getInstance().getPropertyValue("locale"));
        resourceList = ResourceDictionary.getResourceByLocaleId(loc.getId());
//        Encryptor.encryptAES(ConfigManager.getInstance().getPropertyValue("connection"));
//        Encryptor.decryptAES(Encryptor.encryptAES(ConfigManager.getInstance().getPropertyValue("userId")));
//        Encryptor.decryptAES(Encryptor.encryptAES(ConfigManager.getInstance().getPropertyValue("userToken")));
//        Encryptor.decryptAES(Encryptor.encryptAES(ConfigManager.getInstance().getPropertyValue("connection")));
    }

    /**
     *
     * @param resourceId <p/>
     * @return
     */
    public static String get(int resourceId)
    {

        String text = "Invalid Resource Id";

        for (ResourceDictionary reDict : resourceList)
        {
            if (reDict.getResourceDictionaryPK().getResourceId() == resourceId)
            {
                text = reDict.getTextString();
            }
        }
        return text;
    }
}
