package com.example.demo.utils;


import com.alibaba.fastjson.JSON;
import org.apache.commons.lang3.StringUtils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.*;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.Date;
import java.util.Objects;

/**
 * 日期工具类
 * @author xiqin
 * @version $Id: DateUtils.java, v 0.1 2019-09-12 11:24 AM xiqin Exp $$
 */
public final class DateUtils {


    /**
     * 默认通用日期格式
     */
    public final static String DATE_TIME_FORMAT = "yyyy-MM-dd HH:mm:ss";

    public final static SimpleDateFormat SIMPLE_DATE_TIME_FORMAT = new SimpleDateFormat(DATE_TIME_FORMAT);

    public final static String DATE_TIME_FORMAT_T = "yyyy-MM-dd'T'HH:mm:ss.SSS";

    public final static String DATE_TIME_FORMAT_MILLISECOND = "yyyy-MM-dd HH:mm:ss.SSS";


    public final static String DATE_TIME_FORMAT_SSSSSS = "yyyy-MM-dd HH:mm:ss.SSSSSS";


    /**
     * 天级别日期格式
     */
    public final static String DATE_FORMAT = "yyyy-MM-dd";

    /**
     * 天级别日期短格式
     */
    public final static String SHORT_DATE_FORMAT = "yyyyMMdd";

    /**
     * 天级别日期短格式
     */
    public final static String SHORT_DATE_HOUR_FORMAT = "yyyyMMddHH";

    /**
     * 天级别日期中文格式
     */
    public final static String CN_DATE_FORMAT = "yyyy年MM月dd日";

    /**
     * 禁用构造函数
     */
    private DateUtils() {
        // 禁用构造函数
    }

    /**
     * 得到当前日期前几天日期或者后几天日期
     */
    public static Date getBeforeOrAfterDate(int day) {
        Calendar c = Calendar.getInstance();
        c.add(Calendar.DATE, day);
        return c.getTime();
    }

    /**
     * Date-java8
     * @param date
     * @return
     */
    public static LocalDateTime dateToLocalDateTime(Date date) {
        return Instant.ofEpochMilli(date.getTime()).atZone(ZoneId.systemDefault()).toLocalDateTime();
    }

    /**
     * java8-Date
     * @param localDateTime
     * @return
     */
    public static Date localDateTimeToDate(LocalDateTime localDateTime) {
        return Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());
    }

    /**
     * 转换日期为字符串,默认格式
     * @param date
     * @return
     */
    public static String format(Date date) {
        return format(date, DATE_TIME_FORMAT);
    }

    /**
     * 转换日期为字符串
     * @param date
     * @param formatPattern 日期格式
     * @return
     */
    public static String format(Date date, String formatPattern) {
        if (date == null) {
            return null;
        }
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat(formatPattern);
            return dateFormat.format(date);
        } catch (Exception e) {
        }
        return null;
    }

    /**
     * 转换日期为字符串
     * @param date
     * @param dateFormat 日期格式format
     * @return
     */
    public static String format(Date date, DateFormat dateFormat) {
        if (date == null || Objects.isNull(dateFormat)) {
            return null;
        }
        try {
            return dateFormat.format(date);
        } catch (Exception e) {
        }
        return null;
    }

    /**
     * 转换字符串为日期,默认格式
     * @param dateStr
     * @return
     */
    public static Date parse(String dateStr) {
        return parse(dateStr, DATE_TIME_FORMAT);
    }

    /**
     * yyyy-MM-dd'T'HH:mm:ss.SSS
     * @param dateStr
     * @return
     */
    public static Date parseWithT(String dateStr) {
        if (StringUtils.isBlank(dateStr)) {
            return null;
        }
        if (dateStr.contains("T")) {
            return parse(dateStr, DATE_TIME_FORMAT_T);
        }
        return parse(dateStr, DATE_TIME_FORMAT);
    }

    /**
     * 转换字符串为日期
     * @param dateStr
     * @param formatPattern 日期格式
     * @return
     */
    public static Date parse(String dateStr, String formatPattern) {
        if (StringUtils.isBlank(dateStr)) {
            return null;
        }
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat(formatPattern);
            return dateFormat.parse(dateStr);
        } catch (Exception e) {
        }
        return null;
    }

    /**
     * 当前日期 + months
     * @param date
     * @param months 可以为负数
     * @return
     */
    public static Date addMonth(Date date, long months) {
        LocalDateTime localDateTime = dateToLocalDateTime(date);
        localDateTime = localDateTime.plusMonths(months);
        return localDateTimeToDate(localDateTime);
    }

    /**
     * 当前日期 + days
     * @param date
     * @param days 可以为负数
     * @return
     */
    public static Date addDay(Date date, long days) {
        LocalDateTime localDateTime = dateToLocalDateTime(date);
        localDateTime = localDateTime.plusDays(days);
        return localDateTimeToDate(localDateTime);
    }

    /**
     * 当前日期 + hours
     * @param date
     * @param hours 可以为负数
     * @return
     */
    public static Date addHour(Date date, long hours) {
        LocalDateTime localDateTime = dateToLocalDateTime(date);
        localDateTime = localDateTime.plusHours(hours);
        return localDateTimeToDate(localDateTime);
    }

    /**
     * 当前日期 + minutes
     * @param date
     * @param minutes 可以为负数
     * @return
     */
    public static Date addMinute(Date date, long minutes) {
        LocalDateTime localDateTime = dateToLocalDateTime(date);
        localDateTime = localDateTime.plusMinutes(minutes);
        return localDateTimeToDate(localDateTime);
    }

    public static Date addMinuteNulNow(Date date, long minutes){
        if (date == null){
            date = new Date();
        }
        return addMinute(date, minutes);
    }

    /**
     * 当前日期 + seconds
     * @param date
     * @param seconds 可以为负数
     * @return
     */
    public static Date addSecond(Date date, long seconds) {
        LocalDateTime localDateTime = dateToLocalDateTime(date);
        localDateTime = localDateTime.plusSeconds(seconds);
        return localDateTimeToDate(localDateTime);
    }

    /**
     * 获取当前日期的0点
     * @param date
     * @return
     */
    public static Date getStartOfDay(Date date) {
        LocalDateTime localDateTime = dateToLocalDateTime(date);
        return getStartOfDay(localDateTime);
    }

    /**
     * 获取当前日期的0点
     * @param localDateTime
     * @return
     */
    public static Date getStartOfDay(LocalDateTime localDateTime) {
        LocalDateTime result = LocalDateTime.of(localDateTime.toLocalDate(), LocalTime.MIN);
        return localDateTimeToDate(result);
    }

    /**
     * 获取当前日期的最后一秒 2019-09-18 23:59:59
     * @param date
     * @return
     */
    public static Date getEndTimeOfDay(Date date) {
        LocalDateTime localDateTime = dateToLocalDateTime(date);
        return getEndTimeOfDay(localDateTime);
    }

    /**
     * 获取当前日期的最后一秒 2019-09-18 23:59:59
     */
    public static Date getEndTimeOfDay(LocalDateTime localDateTime) {
        LocalDateTime result = localDateTime.withHour(23).withMinute(59).withSecond(59).withNano(0);
        return localDateTimeToDate(result);
    }

    public static String getCurrentDateNoSlash() {
        return format(new Date(), SHORT_DATE_FORMAT);
    }

    /**
     * 获取两个日期差的天数
     *
     * @param beforeDate
     * @param afterDate
     * @return
     */
    public static final int getDateBetweenDays(Date beforeDate, Date afterDate) {
        long decrease = getDateBetween(beforeDate, afterDate) / 1000L / 3600L / 24L;
        int dateDiff = (int) decrease;
        return dateDiff;
    }

    /**
     * 获取两个日期差的毫秒数
     *
     * @param dBefore
     * @param dAfter
     * @return
     */
    public static final long getDateBetween(Date dBefore, Date dAfter) {
        return dAfter.getTime() - dBefore.getTime();
    }

    /**
     * 获取两个日期的小时差
     */
    public static long betweenHours(Date start, Date end) {
        LocalDateTime startTime = LocalDateTime.ofInstant(start.toInstant(),
                ZoneId.systemDefault());
        LocalDateTime endTime = LocalDateTime.ofInstant(end.toInstant(), ZoneId.systemDefault());
        return ChronoUnit.HOURS.between(startTime, endTime);
    }

    /**
     * 两个日期相差年数
     * @param start
     * @param end
     * @return
     */
    public static long betweenDays(Date start, Date end){
        if (start == null){
            return -1;
        }
        LocalDateTime startTime = LocalDateTime.ofInstant(start.toInstant(),
                ZoneId.systemDefault());
        LocalDateTime endTime = LocalDateTime.ofInstant(end.toInstant(), ZoneId.systemDefault());
        return ChronoUnit.DAYS.between(startTime, endTime);
    }

    /**
     * 获取两个日期的秒差
     */
    public static long betweenSecond(Date start, Date end) {
        if (start == null || end == null) {
            return -1;
        }
        try {
            LocalDateTime startTime = LocalDateTime.ofInstant(start.toInstant(),
                    ZoneId.systemDefault());
            LocalDateTime endTime = LocalDateTime.ofInstant(end.toInstant(),
                    ZoneId.systemDefault());
            return ChronoUnit.SECONDS.between(startTime, endTime);
        } catch (Exception e) {
        }
        return -1;
    }

    /**
     * 校验时间是否在区间内
     *
     * @param nowTime   被校验时间
     * @param startTime 开始时间
     * @param endTime   结束时间
     * @return
     */
    public static final Boolean checkBetweenTime(Date nowTime, Date startTime, Date endTime) {
        if (nowTime.getTime() == startTime.getTime()
                || nowTime.getTime() == endTime.getTime()) {
            return true;
        }

        Calendar date = Calendar.getInstance();
        date.setTime(nowTime);

        Calendar begin = Calendar.getInstance();
        begin.setTime(startTime);

        Calendar end = Calendar.getInstance();
        end.setTime(endTime);

        if (date.after(begin) && date.before(end)) {
            return true;
        } else {
            return false;
        }

    }

    /**
     * 获取当前自然月第一天
     *
     * @return
     */
    public static Date getFirstDayOfCurrentMonth() {
        LocalDate firstDay = LocalDate.now().withDayOfMonth(1);
        ZonedDateTime zonedDateTime = firstDay.atStartOfDay(ZoneId.systemDefault());
        return Date.from(zonedDateTime.toInstant());
    }
}