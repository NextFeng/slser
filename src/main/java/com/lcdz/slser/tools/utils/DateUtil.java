package com.lcdz.slser.tools.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @author QinZhenGuo
 * @date 2019/12/21 11:55
 */
public class DateUtil {


    /**
     * 获取当前时间往后七天
     * @return
     */
    public static String getEndDate(){
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE,+8);
        Date date = cal.getTime();
        return df.format(date);
    }


    /**
     * 获取明天的日期
     * @return
     */
    public static String getBeginDate() {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE,+1);
        Date date = cal.getTime();
        return df.format(date);
    }

    /**
     * 获取昨天的日期
     * @return
     */
    public static String getYesterDay(String format) {
        SimpleDateFormat df = new SimpleDateFormat(format);
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE,-1);
        Date date = cal.getTime();
        return df.format(date);
    }


    /**
     * 获取当前时间
     * @return
     */
    public static String getDateTime() {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return df.format(new Date());
    }


    /**
     * 获取当前时间带毫秒
     * @return
     */
    public static String getDateTimeM() {
        SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmssSSS");
        return df.format(new Date());
    }


    /**
     * 获取当前时间
     * @return
     */
    public static String getDate() {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        return df.format(new Date());
    }



    /**
     * 格式化时间
     * @param date
     * @throws Exception
     */
    public static String formatDateTime(String date) throws Exception {
        SimpleDateFormat sf = new SimpleDateFormat("yyyyMMddHHmmss");
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return df.format(sf.parse(date));
    }

    public static Date getForMatSimpleDateStr2(String stringDate) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date=null;
        try {
            date = simpleDateFormat.parse(stringDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }

    public static Date getForMatSimpleDateStr(String stringDate) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = null;
        try {
            date = simpleDateFormat.parse(stringDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }

    /**
     * 获取当前时间戳，单位秒
     *
     * @return
     */
    public static long getCurrentTimestamp() {
        return System.currentTimeMillis() / 1000;
    }

    /**
     * 获取当前时间戳，单位毫秒
     *
     * @return
     */
    public static long getCurrentTimestampMs() {
        return System.currentTimeMillis();
    }



    /**
     * 将字符串转化为DATE
     *
     * @param dtFormat
     *            格式yyyy-MM-dd HH:mm:ss 或 yyyy-MM-dd或 yyyy-M-dd或 yyyy-M-d或
     *            yyyy-MM-d或 yyyy-M-dd
     *            如果格式化失败返回null
     * @return
     */
    public static Date fmtStrToDate(String dtFormat) {
        if (dtFormat == null) {
            return null;
        }
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            return dateFormat.parse(dtFormat);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }


    /**
     * 将字符串转化为DATE
     *
     * @param dtFormatTime
     *            格式yyyy-MM-dd HH:mm:ss 或 yyyy-MM-dd或 yyyy-M-dd或 yyyy-M-d或
     *            yyyy-MM-d或 yyyy-M-dd
     *            如果格式化失败返回null
     * @return
     */
    public static Date fmtStrToDateTime(String dtFormatTime) {
        if (dtFormatTime == null) {
            return null;
        }
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            return dateFormat.parse(dtFormatTime);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}
