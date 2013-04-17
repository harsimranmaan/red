/*
 * The localeManager class is responsible for managing the locale of the
 * application. It main functionality is to get the representing String of the
 * resourceId, according to the locale property value.
 */
package adg.red.utils;

import adg.red.models.Locale;
import adg.red.models.ResourceDictionary;
import java.util.List;

/**
 * The localeManager class is responsible for managing the locale of the
 * application. It main functionality is to get the representing String of the
 * resourceId, according to the locale property value.
 * <p/>
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
