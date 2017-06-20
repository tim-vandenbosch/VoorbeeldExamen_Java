package be.pxl.tafelboeker.servlets;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class DateUtil {

    /**
     * The following method parses a String representation of a date and creates a java.util.Date instance
     * @param date String in the format DD/MM/YYYY
     * @return a
     */
    public static Date parse(String date) throws ParseException {
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
        Date result = format.parse(date);
        System.out.println("Parsed date = " + result);
        return result;
    }

    public static String parse(Date date){
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
        return dateFormat.format(date);
    }
}
