package java8.date;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

/**
 * https://www.journaldev.com/2800/java-8-date-localdate-localdatetime-instant
 *
 * read up the blog for the difference between old date api and new date api
 */
public class NewJavaDateApiDemo {

    public static void main(String... args){
        LocalDate currentDate = LocalDate.now();

        String DATE_PATTERN = "d/MMM/uuuu";
        String DATE_TIME_PATTERN = "d/MMM/uuuu hh:mm:ss a";
        String DATE_TIME_WITH_ZONE_PATTERN = "d/MMM/uuuu HH:mm:ss z";

        System.out.println("current local date = " + currentDate.format(DateTimeFormatter.ofPattern(DATE_PATTERN)));
        System.out.println("current local date + 5 months = " + currentDate.plusMonths(5).format(DateTimeFormatter.ofPattern(DATE_PATTERN)));
        System.out.println("current local date + 10 days = " + currentDate.plusDays(10).format(DateTimeFormatter.ofPattern(DATE_PATTERN)));
        System.out.println("current local date + 2 years = " + currentDate.plusYears(2).format(DateTimeFormatter.ofPattern(DATE_PATTERN)));

        System.out.println("********************************************");
        LocalDate specificDate = LocalDate.of(2019, 9, 22 );
        System.out.println("specific date = " + specificDate.format(DateTimeFormatter.ofPattern(DATE_PATTERN)));
        System.out.println("********************************************");

        LocalDateTime currentDateTime = LocalDateTime.now();
        System.out.println("current date time = " + currentDateTime.format(DateTimeFormatter.ofPattern(DATE_TIME_PATTERN)));
        System.out.println("current date time + 5 hours= " + currentDateTime.plusHours(5).format(DateTimeFormatter.ofPattern(DATE_TIME_PATTERN)));
        System.out.println("current date time + 20 mins= " + currentDateTime.plusMinutes(20).format(DateTimeFormatter.ofPattern(DATE_TIME_PATTERN)));
        System.out.println("current date time + 30 secs= " + currentDateTime.plusSeconds(30).format(DateTimeFormatter.ofPattern(DATE_TIME_PATTERN)));
        System.out.println("********************************************");

        LocalDateTime specificDateTime = LocalDateTime.of(2019, 9, 22, 10, 15, 00);
        System.out.println("specific date time = " + specificDateTime.format(DateTimeFormatter.ofPattern(DATE_TIME_PATTERN)));
        System.out.println("********************************************");

        Instant currentUnixTimeStamp = Instant.now();
        System.out.println("current instant = " + currentUnixTimeStamp);
        System.out.println("epoch millis = " + currentUnixTimeStamp.toEpochMilli());
        System.out.println("********************************************");

        ZonedDateTime currentZonedDateTime = ZonedDateTime.now();
        System.out.println("current zoned date time = " + currentZonedDateTime.format(DateTimeFormatter.ofPattern(DATE_TIME_WITH_ZONE_PATTERN)));
        ZonedDateTime chinaZonedDateTime = ZonedDateTime.now(ZoneId.of("Asia/Shanghai"));
        System.out.println("current zoned date time in Shanghai = " + chinaZonedDateTime.format(DateTimeFormatter.ofPattern(DATE_TIME_WITH_ZONE_PATTERN)));
        ZonedDateTime parisZonedDateTime = ZonedDateTime.now(ZoneId.of("Europe/Paris"));
        System.out.println("current zoned date time in Paris = " + parisZonedDateTime.format(DateTimeFormatter.ofPattern(DATE_TIME_WITH_ZONE_PATTERN)));
        ZonedDateTime sydneyZonedDateTime = ZonedDateTime.now(ZoneId.of("Australia/Sydney"));
        System.out.println("current zoned date time in Paris = " + sydneyZonedDateTime.format(DateTimeFormatter.ofPattern(DATE_TIME_WITH_ZONE_PATTERN)));
        System.out.println("********************************************");


        LocalDate parsedDate = LocalDate.parse("10/Oct/2020", DateTimeFormatter.ofPattern(DATE_PATTERN));
        System.out.println("parsing String 10/Oct/2020 into LocalDate =  " + parsedDate.format(DateTimeFormatter.ofPattern(DATE_PATTERN)));

        System.out.println("********************************************");

        LocalDateTime parsedDateTime = LocalDateTime.parse("10/Oct/2020 03:20:30 PM", DateTimeFormatter.ofPattern(DATE_TIME_PATTERN));
        System.out.println("parse String 10/Oct/2020 03:20:30 PM into LocalDateTime = " + parsedDateTime.format(DateTimeFormatter.ofPattern(DATE_TIME_PATTERN)));
        System.out.println("********************************************");
        ZonedDateTime parsedZonedDateTime = ZonedDateTime.parse("10/Oct/2020 03:20:30 EDT", DateTimeFormatter.ofPattern(DATE_TIME_WITH_ZONE_PATTERN));
        System.out.println("parse String 10/Oct/2020 03:06:26 EDT into ZonedDateTime = " + parsedZonedDateTime.format(DateTimeFormatter.ofPattern(DATE_TIME_WITH_ZONE_PATTERN)));
        System.out.println("********************************************");

        System.out.println("Old date util to new LocalDate");
        Date oldDate = new Date();
        System.out.println("Old date = " + oldDate);
        LocalDate newDate = LocalDate.ofInstant(oldDate.toInstant(), ZoneId.of(ZoneId.SHORT_IDS.get("EST")));
        System.out.println("New date = " + newDate.format(DateTimeFormatter.ofPattern(DATE_PATTERN)));

        System.out.println("********************************************");
        System.out.println("Old Calendar to new LocalDate");
        Calendar oldCalendar = Calendar.getInstance();
        System.out.println("Old Calendar = " + oldCalendar);
        LocalDate localDate = LocalDate.ofInstant(oldCalendar.toInstant(), ZoneId.of(ZoneId.SHORT_IDS.get("EST")));
        System.out.println("New Date = "+ localDate.format(DateTimeFormatter.ofPattern(DATE_PATTERN)));
        System.out.println("********************************************");

        System.out.println("Old Timezone to new ZoneId");
        TimeZone oldTimezone = TimeZone.getDefault();
        System.out.println("Old Timezone = " + oldTimezone);
        ZoneId zoneId = oldTimezone.toZoneId();
        System.out.println("New ZoneId = " + zoneId);

    }

}
