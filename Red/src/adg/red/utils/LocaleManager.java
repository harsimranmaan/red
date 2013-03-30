/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package adg.red.utils;

import adg.red.models.Locale;
import adg.red.models.ResourceDictionary;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Witt
 */
public class LocaleManager {
    
    private static final List <ResourceDictionary> resourceList; 
    private static final Locale loc;
    
    static {
        loc = new Locale(2);
        resourceList = new ResourceDictionary().getResourceByLocaleId(loc.getId());
    }
    
    /**
     *
     * @param resourceId
     * @return
     */
    public static String getTextbyResourceId(int resourceId) {
        
        String text = "";
        try {
            for (ResourceDictionary reDict : resourceList)
                {
                    if (reDict.getResourceDictionaryPK().getResourceId() == resourceId) {
                        text = reDict.getTextString();
                    }
                }
        } catch (Exception ex) {
                    Logger.getLogger(LocaleManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return text;
    }
}
