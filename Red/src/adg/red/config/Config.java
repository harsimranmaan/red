/*
 * 
 * 
 */
package adg.red.config;

import java.io.InputStream;

/**
 *
 * @author harsimran.maan
 */
public class Config
{

    private static Config config = new Config();

    public static InputStream getPropFileStream(String fileName)
    {
        return config.getClass().getResourceAsStream(fileName);
    }
}
