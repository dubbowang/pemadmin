package com.qinke.pemadmin.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtil {

    /**
     * yyyy-MM-dd.
     */
    private static SimpleDateFormat smallDateFormat = new SimpleDateFormat("yyyy-MM-dd");

    /**
     * yyyy-MM-dd HH:mm:ss.
     */
    private static SimpleDateFormat longDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    /**
     * 时间格式化.
     *
     * @param date
     *            要格式化的时间
     * @return<br>
     */
    public static String formateDateToSmallString(Date date) {
        String dateString = smallDateFormat.format(new Date());
        return dateString;
    }

    public static String formateDateToLongString(Date date) {
        String dateString = longDateFormat.format(new Date());
        return dateString;
    }

    /**
     * 格式化日期-时间.
     * @param dateString dateString
     * @return return
     */
    public static Date formateStringToDate(String dateString) {

        Date date = null;
        try {
            date = longDateFormat.parse(dateString);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }

    /**
     * 格式化日期.
     * @param dateString dateString
     * @return return
     */
    public static Date formateSmallStringToDate(String dateString) {

        Date date = null;
        try {
            date = smallDateFormat.parse(dateString);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }

    /**
     * 获得当天0点时间.
     * @param someDay someDay
     * @return result
     */
    public static Date getTimesmorning(Date someDay) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(someDay);
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.MILLISECOND, 0);
        return cal.getTime();
    }

    /**
     * 获得当天24点时间.
     * @param someDay someDay
     * @return return
     */
    public static Date getTimesnight(Date someDay) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(someDay);
        cal.set(Calendar.HOUR_OF_DAY, 24);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.MILLISECOND, 0);
        return cal.getTime();
    }

    /**
     * 获得前时间.
     * @param someDay someDay
     * @return return
     */
    public static String getCurDate() {
        Date date = new Date();
        return longDateFormat.format(date);
    }
}
