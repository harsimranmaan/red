/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
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
        loc = Locale.findByName("chCH");
        resourceList = ResourceDictionary.getResourceByLocaleId(loc.getId());
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
