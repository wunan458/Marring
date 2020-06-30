package cn.marring.common;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class TimeUtil {

    private final static int SECONDS = 24*60*60*1000;

    public static Timestamp getTimestamp() {
        return new Timestamp(new Date().getTime());
    }

    public static Date stringToDate(String str) throws ParseException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");//注意月份是MM
        return simpleDateFormat.parse(str);
    }

    public static String dateToString(Date date) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");//注意月份是MM
        return simpleDateFormat.format(date);
    }

    public static long countDay(Date startDate, Date endDate) throws ParseException {
        return (endDate.getTime()-startDate.getTime())/SECONDS;
    }

    public static Date afterDay(Date currentDate) {
        Calendar c = Calendar.getInstance();
        c.setTime(currentDate);
        c.add(Calendar.DAY_OF_MONTH, 1);
        return c.getTime();
    }
}
