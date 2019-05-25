package util;

import java.util.Date;

import javax.swing.text.html.CSS;

import java.util.Calendar;


public class DateUtil {
    public static long millisecondsOfOneDay = 1000*60*60*24;

    //将日期存储到数据库中
    public static java.sql.Date util2sql(Date d) {
        return new java.sql.Date(d.getTime());
    }

    /**
     * 获取今天，并且把时，分，秒和毫秒都置0. 因为通过日期控件获取到的日期，就是没有时分秒和毫秒的。
     * @return 返回今天
     */
    public static Date today() {
        //使用默认时区和语言环境获得一个日历。
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.set(Calendar.HOUR, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        return calendar.getTime();
    }

    /**
     * 获取周初
     * @return
     */
    public static Date weekBegin() {
        Date date = new Date();
        if (date == null) {
            return null;
        }
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        int dayofweek = cal.get(Calendar.DAY_OF_WEEK);
        if (dayofweek == 1) {
            dayofweek += 7;
        }
        cal.add(Calendar.DATE, 2 - dayofweek);
        return cal.getTime();
    }

    public static Date weekEnd() {
        Calendar cal = Calendar.getInstance();
        cal.setTime(weekBegin());
        cal.add(Calendar.DAY_OF_WEEK, 6);
        Date weekEndSta = cal.getTime();

        return weekEndSta;
    }



    /**
     * 获取月初。使用Calendar获取本月第一天。 在统计消费一览信息的时候，查看本月的消费数据，其实就是从数据库中去把从本月第一天到最后一天的数据查出来，再进行简单统计，所以需要一个获取本月第一天的方法。
     * @return 返回月初的时间
     */
    public static Date monthBegin() {
        Calendar c = Calendar.getInstance();
        c.setTime(new Date());
        c.set(Calendar.DATE, 1);

        c.set(Calendar.HOUR_OF_DAY, 0);
        c.set(Calendar.MINUTE, 0);
        c.set(Calendar.SECOND, 0);
        c.set(Calendar.MILLISECOND,0);
        return c.getTime();
    }

    /**
     * 获取月末
     * @return
     */
    public static Date monthEnd() {
        Calendar c = Calendar.getInstance();
        c.setTime(new Date());
        c.set(Calendar.HOUR, 0);
        c.set(Calendar.MINUTE, 0);
        c.set(Calendar.SECOND, 0);

        c.set(Calendar.DATE, 1);
        c.add(Calendar.MONDAY, 1);
        c.add(Calendar.DATE, -1);
        return c.getTime();
    }

    /**
     *获取本月还剩多少天
     * @return
     */
    public static int thisMonthTotalDay() {
        long lastDayMillSeconds = monthEnd().getTime();
        long firstDayMillSeconds = monthBegin().getTime();

        return (int)((lastDayMillSeconds - firstDayMillSeconds) / millisecondsOfOneDay) + 1;
    }


    /**
     *获取本月还剩多少天
     * @return
     */
    public static int thisMonthLeftDay() {
        long lastDayMilliSeconds = monthEnd().getTime();
        long toDayMilliSeconds = today().getTime();
        return (int)((lastDayMilliSeconds - toDayMilliSeconds) / millisecondsOfOneDay) + 1;
    }

    //测试以上方法
    public static void main(String[] args) {
        System.out.println(weekBegin());
        System.out.println(weekEnd());
        System.out.println(monthBegin());
        System.out.println(monthEnd());
    }


}
