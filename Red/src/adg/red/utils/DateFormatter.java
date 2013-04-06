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
        if (date != null)
        {
            SimpleDateFormat sdf = new SimpleDateFormat("dd MMM yyyy");
            return sdf.format(date);
        }
        else
        {
            return "";
        }
    }

    public static String formatTime(Date date)
    {
        if (date != null)
        {
            SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
            return sdf.format(date);
        }
        else
        {
            return "";
        }
    }

    public static String formatDateTime(Date date)
    {
        if (date != null)
        {
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MMM/yyyy HH:mm");
            return sdf.format(date);
        }
        else
        {
            return "";
        }
    }
}
