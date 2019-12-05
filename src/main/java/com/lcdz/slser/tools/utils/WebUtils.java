package com.lcdz.slser.tools.utils;


import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.*;

public class WebUtils {

    public static Calendar calendar = Calendar.getInstance();

    /**
     * 获取前台提交的参数
     *
     * @return
     */
    public static Map getParameterMap(HttpServletRequest request) {
        Map parametersMap = new HashMap();
        Enumeration paramters = request.getParameterNames();
        while (paramters.hasMoreElements()) {
            String name = (String) paramters.nextElement();
            String[] values = request.getParameterValues(name);
            String value = "";
            if (values != null) {
                for (int i = 0; i < values.length; i++) {
                    value += values[i] + ',';
                }
                value = value.substring(0, value.length() - 1);
                // value=value.replaceAll(".*([';]+|(--)+).*", " ");
            }
            parametersMap.put(name, value.trim());
        }
        return parametersMap;
    }

    /**
     * 获取当前日期
     * dataFormate 日期格式  yyyyMMddHHmmss yyyy-MM-dd
     *
     * @return
     */
    public static String getCurDate(String dataFormate) {
        return (new SimpleDateFormat(dataFormate)).format((Calendar.getInstance()).getTime());
    }

    /**
     * 获取当前年份
     *
     * @return
     */
    public static int getCurYear() {
        return calendar.get(Calendar.YEAR);
    }

    /**
     * 获取当前月份
     *
     * @return
     */
    public static int getJCMMonth() {
        return calendar.get(Calendar.MONTH) + 1;
    }

    /**
     * 获取当前天
     *
     * @return
     */
    public static int getJCMDay() {
        return calendar.get(Calendar.DATE);
    }

    /**
     * 获取当前月份(01,02,03......11,12)
     *
     * @return
     */
    public static String getJCMMonthF() {
        return formatDate(calendar.get(Calendar.MONTH) + 1);
    }

    /**
     * 获取当前天(01,02,03......29,30)
     *
     * @return
     */
    public static String getJCMDayF() {
        return formatDate(calendar.get(Calendar.DATE));
    }

    /**
     * 把月份和日期修改为两位数字
     *
     * @param date
     * @return
     */
    public static String formatDate(int date) {
        String date2 = "0";
        if (date <= 9) {
            date2 += String.valueOf(date);
        } else {
            date2 = String.valueOf(date);
        }
        return date2;
    }

    /**
     * 获取输入流
     *
     * @param request
     * @return
     * @throws IOException
     */
    public static String getStream(HttpServletRequest request) throws IOException {
        InputStream inputStream;
        StringBuffer sb = new StringBuffer();
        inputStream = request.getInputStream();
        String s;
        BufferedReader in = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));
        while ((s = in.readLine()) != null) {
            sb.append(s);
        }
        in.close();
        inputStream.close();
        return sb.toString();
    }


    /**
     * 获取当前时间
     *
     * @return
     */
    public static String getDateTime() {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        return df.format(new Date());
    }


    public static String getDate() {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");//设置日期格式
        return df.format(new Date());
    }


    public static String getYesday() {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");//设置日期格式
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, -1);
        Date date = cal.getTime();
        return df.format(date);
    }


    public static Map<String, String> toStingMap(Map<String, Object> paramap) {
        Map<String, String> remap = new HashMap<>();
        for (String key : paramap.keySet()) {
            remap.put(key, String.valueOf(paramap.get(key)));
        }
        return remap;
    }

    /**
     * 格式化时间
     * @param date
     * @return
     * @throws Exception
     */
    public static String formatDateTime(String date) throws Exception {
        SimpleDateFormat sf = new SimpleDateFormat("yyyyMMddHHmmss");
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        return df.format(sf.parse(date));
    }
}
