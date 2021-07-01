package 反射;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;
import java.util.Date;

/** @Auther: 刘洋(liuyang @ klec.com.cn) @Date: 2019/5/23 */
public class DateTimeUtils {
  public static final String DEFAULT_PATTERN = "yyyy-MM-dd HH:mm:ss";
  public static final DateTimeFormatter DEFAULT_FARMATTER =
      DateTimeFormatter.ofPattern(DEFAULT_PATTERN);
  public static final ZoneId DEFAULT_ZONE = ZoneId.systemDefault();


  public static String longToStr(long millis) {

    return longToDateTime(millis).format(DEFAULT_FARMATTER);
  }

  public static String longToStr(long millis, String pattern) {
    return longToDateTime(millis).format(DateTimeFormatter.ofPattern(pattern));
  }

  public static long strToLong(String timeStr) {
    return dateTimeToLong(LocalDateTime.parse(timeStr, DEFAULT_FARMATTER));
  }

  public static long strToLong(String timeStr, String pattern) {
    return dateTimeToLong(LocalDateTime.parse(timeStr, DateTimeFormatter.ofPattern(pattern)));
  }

  public static LocalDateTime strToDateTime(String time, String pattern) {
    return LocalDateTime.parse(time, DateTimeFormatter.ofPattern(pattern));
  }

  public static LocalDateTime strToDateTime(String time) {
    return LocalDateTime.parse(time, DEFAULT_FARMATTER);
  }

  public static String dateTimeToStr(LocalDateTime localDateTime, String pattern) {
    return localDateTime.format(DateTimeFormatter.ofPattern(pattern));
  }

  public static String dateTimeToStr(LocalDateTime localDateTime) {
    return localDateTime.format(DEFAULT_FARMATTER);
  }

  public static LocalDateTime longToDateTime(long millis) {
    return LocalDateTime.ofInstant(Instant.ofEpochMilli(millis), DEFAULT_ZONE);
  }

  public static long dateTimeToLong(LocalDateTime localDateTime) {
    return localDateTime.atZone(DEFAULT_ZONE).toInstant().toEpochMilli();
  }

  public static long todayStartTime() {
    return dateTimeToLong(LocalDate.now().atStartOfDay());
  }

  public static long todayEndTime() {
    return dateTimeToLong(LocalDateTime.of(LocalDate.now(), LocalTime.MAX));
  }

  public static long thisWeekStartTime() {
    return dateTimeToLong(
        LocalDate.now().with(TemporalAdjusters.previous(DayOfWeek.MONDAY)).atTime(LocalTime.MIN));
  }

  public static long thisWeekEndTime() {
    return dateTimeToLong(
        LocalDate.now().with(TemporalAdjusters.next(DayOfWeek.SUNDAY)).atTime(LocalTime.MAX));
  }

  public static long thisMonthStartTime() {
    return dateTimeToLong(
        LocalDate.now().with(TemporalAdjusters.firstDayOfMonth()).atTime(LocalTime.MIN));
  }

  public static long thisMonthEndTime() {
    return dateTimeToLong(
        LocalDate.now().with(TemporalAdjusters.lastDayOfMonth()).atTime(LocalTime.MAX));
  }

  public static long getAWeekBeforeTime() {
    return dateTimeToLong(LocalDateTime.now().minusDays(7));
  }

  public static long getAYearBeforeTime() {
    return dateTimeToLong(LocalDateTime.now().minusYears(1));
  }

  public static long getOneMonthBeforeTime() {
    return dateTimeToLong(LocalDateTime.now().minusMonths(1));
  }

  public static long getOneDayBeforeTime() {
    return dateTimeToLong(LocalDateTime.now().minusDays(1));
  }

  public static String getOneDayBeforeTimeStr() {
    return dateTimeToStr(LocalDateTime.now().minusDays(1));
  }

  /**
   * 比较默认格式时间字符串
   * @return
   */
  public static int compare(String timeStr1, String timeStr2) {
    return strToDateTime(timeStr1).compareTo(strToDateTime(timeStr2));
  }

  /**
   * 比较指定格式时间字符串
   * @return
   */
  public static int compare(String timeStr1, String timeStr2, String pattern) {
    return strToDateTime(timeStr1,pattern).compareTo(strToDateTime(timeStr2,pattern));
  }

  /**
   * 将特定格式的时间字符串格式化成默认格式字符串
   * @param timeStr
   * @param sourcePattern
   * @return
   */
  public static String formatToDefaultStr(String timeStr, String sourcePattern) {
    return dateTimeToStr(strToDateTime(timeStr, sourcePattern));
  }

  public static String nowStr() {
    return dateTimeToStr(LocalDateTime.now());
  }

  public static long nowMills() {
    return Instant.now().toEpochMilli();
  }

  public static int nowSecond() {
    return (int) Instant.now().getEpochSecond();
  }

  public static String nowStr(String pattern){
    return dateTimeToStr(LocalDateTime.now(),pattern);
  }



  /**
   * 转java.util.Date
   * @return
   */
  public static Date toUtilsDate(LocalDateTime localDateTime) {
    return Date.from(localDateTime.atZone(DEFAULT_ZONE).toInstant());
  }

  public static LocalDateTime fromUtilsDate(Date date) {
    return LocalDateTime.ofInstant(date.toInstant(),DEFAULT_ZONE);
  }

}
