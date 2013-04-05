/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package adg.red.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Witt
 */
public class DateFormatter
{

    private final static DateFormatter dateFormater;

    private DateFormatter()
    {
    }

    static
    {
        dateFormater = new DateFormatter();
    }

    public static String formatDate(Date date)
    {
        SimpleDateFormat sdf = new SimpleDateFormat("dd MMM yyyy");
        return sdf.format(date);
    }
}
