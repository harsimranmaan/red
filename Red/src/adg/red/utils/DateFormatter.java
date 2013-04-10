/*
 * The DateFormatter class is responsible for date and time formatting.
 *
 */
package adg.red.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * The DateFormatter class is responsible for date and time formatting.
 * <p/>
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

    /**
     * The function to format input date to the specific date format.
     * <p/>
     * @param date the input date the be formatted
     * <p/>
     * @return the formatted String of input date
     */
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

    /**
     * The function to format input date to the specific date and time format.
     * <p/>
     * @param date the input date the be formatted
     * <p/>
     * @return the formatted String of input date
     */
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

    /**
     * The function to format input date to the specific time format.
     * <p/>
     * @param date the input date the be formatted
     * <p/>
     * @return the formatted String of input date
     */
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

    /**
     * The function to format input date to the specific hour format.
     * <p/>
     * @param date the input date the be formatted
     * <p/>
     * @return the formatted String of input date
     */
    public static String formatHour(Date date)
    {
        if (date != null)
        {
            SimpleDateFormat sdf = new SimpleDateFormat("HH");
            return sdf.format(date);
        }
        else
        {
            return "";
        }
    }

    /**
     * The function to format input date to the specific minute format.
     * <p/>
     * @param date the input date the be formatted
     * <p/>
     * @return the formatted String of input date
     */
    public static String formatMins(Date date)
    {
        if (date != null)
        {
            SimpleDateFormat sdf = new SimpleDateFormat("mm");
            return sdf.format(date);
        }
        else
        {
            return "";
        }
    }

    /**
     * The function to get current day date in a specific format.
     * <p/>
     * @return the formatted String of the current date
     */
    public static String getCurrentDayDate()
    {
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("E, MMM dd, yyyy");
        return sdf.format(date);

    }
}
