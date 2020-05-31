package utils;

import org.junit.Test;

import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;

/**
 * @program: mytomcat
 * @description: 时间工具类
 * @author: zhaoxudong
 * @create: 2020-05-28 20:38
 **/
public class DateHelper {

    @Test
    public void localDate(){
        LocalDate now = LocalDate.now();
        int year = now.getYear();
        System.err.println(year);
        Month month = now.getMonth();
        int monthValue = now.getMonthValue();
        System.err.println(monthValue);
    }

    /**
     * 计算时间
     */
    @Test
    public void calcuDate(){
        LocalDate date = LocalDate.of(2017, 1, 5);
        date.withDayOfMonth(5);
        System.err.println(date.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));

    }

}
