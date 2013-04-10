/*
 * The Config class is to convert configuration properties resource file to
 * InputStream.
 */
package adg.red.config;

import java.io.InputStream;

/**
 * The Config class is to convert configuration properties resource file to
 * InputStream.
 * <p/>
 * @author harsimran.maan
 */
public class Config
{

    private static Config config = new Config();

    /**
     * The function to get InputStream of the configuration properties resource.
     * <p/>
     * @param fileName the file name of the configuration properties
     * <p/>
     * @return the InputStream of configuration properties
     */
    public static InputStream getPropFileStream(String fileName)
    {
        return config.getClass().getResourceAsStream(fileName);
    }
}
