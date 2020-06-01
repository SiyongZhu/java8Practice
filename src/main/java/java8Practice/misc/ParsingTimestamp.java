package java8Practice.misc;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.joda.time.Duration;
import org.joda.time.Period;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.joda.time.format.ISODateTimeFormat;

import com.github.javafaker.Faker;

public class ParsingTimestamp {

    private static DateTime fromString(String timestamp) {
        return ISODateTimeFormat.dateTime().parseDateTime(timestamp).toDateTime(DateTimeZone.UTC);
    }
    
    private static DateTime convertDateToPrecedingHour(String strDateTime, String pattern) {
//        DateTimeFormatter formatter = DateTimeFormat.forPattern(pattern);
//        DateTime timeDateTime = formatter.parseDateTime(strDateTime);
        
        DateTime timeDateTime = fromString(strDateTime);
        System.out.println("Before move: "+timeDateTime);
        DateTime time = new DateTime()
                .withYear(timeDateTime.getYear())
                .withMonthOfYear(timeDateTime.getMonthOfYear())
                .withDayOfMonth(timeDateTime.getDayOfMonth())
                .withHourOfDay(timeDateTime.getHourOfDay())
                .withMinuteOfHour(0)
                .withSecondOfMinute(0)
                .withMillisOfSecond(0)
                .withZone(timeDateTime.getZone());
        System.out.println("After move: "+time);
        return time;
    }
    
    private static String buildTimestampListString(DateTime start, DateTime end) {
        Duration d = new Duration(start.getMillis(), end.getMillis());
        int hourDiff = d.toStandardHours().getHours();
        
        if(hourDiff<0) {
            System.out.println("Start time is later than end date");
        }
        
        StringBuilder list = new StringBuilder();
        list.append('(');
        for (int i=0; i<=hourDiff; i++) {
            DateTimeFormatter fmt = DateTimeFormat.forPattern(("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'"));  
            String formattedDate = fmt.print(start.plusHours(i));
            list.append("'" +formattedDate+"', ");
        }
        list.deleteCharAt(list.length()-2);
        list.append(')');
        return list.toString();
    }
    public static void main(String[] args) throws Exception {
        
        String strStart = "2020-01-30T09:20:00.000Z";
        String strEnd = "2020-01-30T11:40:00.000Z";
        
        
        DateTime timeStart = convertDateToPrecedingHour(strStart, "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
        DateTime timeEnd = convertDateToPrecedingHour(strEnd, "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
        
        System.out.println(buildTimestampListString(timeStart, timeEnd));
        
        Faker faker = new Faker();
        
        System.out.println(faker.name().username());
        System.out.println(faker.shakespeare().asYouLikeItQuote().toString());
        
//        StringBuilder timestampBucketList = new StringBuilder();
//        DateTime timeEnd = formatter.parseDateTime(strEnd);
//        
//        DateTime start = new DateTime()
//                .withYear(timeStart.getYear())
//                .withMonthOfYear(timeStart.getMonthOfYear())
//                .withDayOfMonth(timeStart.getDayOfMonth())
//                .withHourOfDay(timeStart.getHourOfDay())
//                .withMinuteOfHour(0)
//                .withSecondOfMinute(0)
//                .withMillisOfSecond(0);
//        String ss = formatter.print(start);
        
        
        System.out.println(timeStart);
        System.out.println(timeEnd);

    }

}
