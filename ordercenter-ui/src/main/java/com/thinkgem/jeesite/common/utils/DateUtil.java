package com.thinkgem.jeesite.common.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * 
 */
public class DateUtil {

    private static Logger logger = LoggerFactory.getLogger(DateUtil.class);
    private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    /**
     * @Description : 获取系统当前时间的前 多少分钟、小时等 之后的时间;
     * @Method_Name : getDateAfter;
     * @param amount
     *            : 时间值
     * @param filed
     *            ：日历
     * @return :Calendar 常量值 例如Calendar.DATE
     * @Creation Date : 2016年8月11日 下午4:54:27 ;
     * @Author : wujingxiong;
     */
    public static Date getDateAfter(int amount, int filed) {
        Calendar calendar = Calendar.getInstance();
        calendar.add(filed, amount);
        return calendar.getTime();
    }

    /**
     * @Description : 获取多少天后的时间;
     * @Method_Name : getDateAfter;
     * @param day
     * @return :
     * @Creation Date : 2016年8月17日 下午3:49:59 ;
     * @Author : wujingxiong;
     */
    public static Date getDateAfter(int day) {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DATE, day);
        return calendar.getTime();
    }

    /**
     * @Description : 获取系统当前时间的前 多少分钟、小时等信息;
     * @Method_Name : getDateToString;
     * @param amount
     *            : 时间值
     * @param filed
     *            ：日历
     * @return :Calendar 常量值 例如Calendar.DATE
     * @Creation Date : 2016年8月11日 下午4:54:27 ;
     * @Author : wujingxiong;
     */
    public static String getDateToString(String amount, int filed) {
        int time = Integer.valueOf(amount);
        Calendar calendar = Calendar.getInstance();
        calendar.add(filed, -time);
        return sdf.format(calendar.getTime());
    }

    /**
     * @Description : 将字符串转换为时间类型;
     * @Method_Name : convertStringToDate;
     * @param date
     * @return :
     * @Creation Date : 2016年8月11日 下午6:49:50 ;
     * @Author : wujingxiong;
     */
    public static Date convertStringToDate(String date) {
        try {
            if (date == null || "".equals(date))
                return null;
            return sdf.parse(date);
        } catch (ParseException e) {
            logger.error("时间：" + date + "转换失败，错误信息:", e);
        }
        return null;
    }

    /**
     * 得到给定日期
     * 
     * @param date
     *            给定日期
     * @param pattern
     *            给定日期格式
     * @return Date 给定日期
     */
    public static Date getDate(String date, String pattern) {
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        Date date_o = null;
        try {
            date_o = sdf.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date_o;
    }

    /**
     * 得到给定日期
     * 
     * @param date
     *            给定日期
     * @param pattern
     *            给定日期格式
     * @return String 给定日期
     */
    public static String getDate(Date date, String pattern) {
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        return sdf.format(date);
    }

    /***
     * 获取当前时间
     * 
     * @return String 当前时间yyyy-MM-dd HH:mm:ss
     */
    public static String getDate() {
        return sdf.format(new Date());
    }

    public static String formatTime(long ms) {
        int ss = 1000;
        int mi = ss * 60;
        int hh = mi * 60;

        long hour = ms / hh;
        long minute = (ms - hour * hh) / mi;
        double second = (ms - hour * hh - minute * mi) / 1.0 / ss;

        String strHour = hour < 10 ? "0" + hour : "" + hour;// 小时
        String strMinute = minute < 10 ? "0" + minute : "" + minute;// 分钟
        String strSecond = second < 10 ? "0" + second : "" + second;// 秒

        return strHour + "小时" + strMinute + " 分钟 " + strSecond + " 秒";
    }
    
    
    
    public static Date getStartDayOfDay(Date date) throws Exception{
        Calendar calender=Calendar.getInstance();
        calender.setTime(date);
        calender.set(Calendar.HOUR_OF_DAY, 0);
        calender.set(Calendar.MINUTE, 0);
        calender.set(Calendar.SECOND, 0);
        SimpleDateFormat sfd=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return sfd.parse(sfd.format(calender.getTime()));
    };
    
    public static Date getEndDayOfDay(Date date) throws Exception{
        Calendar calender=Calendar.getInstance();
        calender.setTime(date);
        calender.set(Calendar.HOUR_OF_DAY, 23);
        calender.set(Calendar.MINUTE, 59);
        calender.set(Calendar.SECOND, 59);
        SimpleDateFormat sfd=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return sfd.parse(sfd.format(calender.getTime()));
    };

    /**
     *  获取目标时间
     * @param amount    +-数字
     * @param filed
     *  1则代表的是对年份操作，2是对月份操作，3是对星期操作，5是对日期操作，
     *  11是对小时操作，12是对分钟操作，13是对秒操作，14是对毫秒
     * @param date  指定计算时间
     * @return
     */
    public static Date getTargetDate(int amount, int filed,Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime ( date );
        calendar.add(filed, amount);
        return calendar.getTime();
    }


}
