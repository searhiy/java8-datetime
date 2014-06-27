package org.eyalgo.datetime;

import java.time.Clock;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.Year;
import java.time.ZoneId;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) {
	general();
	space();
	localDate();
	space();
	localTime();
	space();
	localDateTime();
	space();
	timeUsingZone();
	space();
	information();
	space();
	dslCreation();
    }

    private static void general() {
	// Current Time
	Clock clock = Clock.systemUTC();
	System.out.println(clock.getZone().getId());
	System.out.println(Clock.systemDefaultZone());

	// Time Zone

	ZoneId zone = ZoneId.systemDefault();
	System.out.println(Clock.system(zone));
	System.out.println(Clock.system(ZoneId.of("Europe/Berlin")));

	// Human Readable
	LocalDate date = LocalDate.now();
	System.out.printf("%s-%s-%s", date.getYear(), date.getMonthValue(), date.getDayOfMonth()); // 2014-6-27
    }

    private static void localDate() {
	// the current date
	LocalDate currentDate = LocalDate.now();
	System.out.println(currentDate); // 2014-06-27

	// 2014-02-10
	LocalDate tenthFeb2014 = LocalDate.of(2014, Month.FEBRUARY, 10);
	System.out.println(tenthFeb2014); // 2014-02-10

	// months values start at 1 (2014-08-01)
	LocalDate firstAug2014 = LocalDate.of(2014, 8, 1);
	System.out.println(firstAug2014); // 2014-08-01

	// the 65th day of 2010 (2010-03-06)
	LocalDate sixtyFifthDayOf2010 = LocalDate.ofYearDay(2010, 65);
	System.out.println(sixtyFifthDayOf2010); // 2014-03-06
    }

    private static void localTime() {
	LocalTime currentTime = LocalTime.now(); // current time
	System.out.println(currentTime); // 09:04:47.526

	LocalTime midday = LocalTime.of(12, 0); // 12:00
	System.out.println(midday); // 12:00

	LocalTime afterMidday = LocalTime.of(13, 30, 15); // 13:30:15
	System.out.println(afterMidday); // 13:30:15

	// 12345th second of day (03:25:45)
	LocalTime fromSecondsOfDay = LocalTime.ofSecondOfDay(12345);
	System.out.println(fromSecondsOfDay); // 03:25:45
    }

    private static void localDateTime() {
	// dates with times, e.g. 2014-02-18 19:08:37.950
	LocalDateTime currentDateTime = LocalDateTime.now();
	System.out.println(currentDateTime); // 2014-06-27T09:04:47.527

	// 2014-10-02 12:30
	LocalDateTime secondAug2014 = LocalDateTime.of(2014, 10, 2, 12, 30);
	System.out.println(secondAug2014); // 2014-10-02T12:30

	// 2014-12-24 12:00
	LocalDateTime christmas2014 = LocalDateTime.of(2014, Month.DECEMBER, 24, 12, 0);
	System.out.println(christmas2014); // 2014-12-24T12:00
    }

    private static void timeUsingZone() {
	// current (local) time in Los Angeles
	LocalTime currentTimeInLosAngeles = LocalTime.now(ZoneId.of("America/Los_Angeles"));
	System.out.println(currentTimeInLosAngeles); // 23:08:18.104

	// current time in UTC time zone
	LocalTime nowInUtc = LocalTime.now(Clock.systemUTC());
	System.out.println(nowInUtc); // 06:08:18.125
    }

    private static void information() {
	monthInformation();
	yearInformation();
	dayInformation();
	timeInformation();
    }

    private static void monthInformation() {
	LocalDate date = LocalDate.of(2014, 2, 15); // 2014-02-15
	Month february = date.getMonth();
	System.out.println(february); // FEBRUARY

	int februaryIntValue = february.getValue();
	System.out.println(februaryIntValue); // 2

	// 28 , 29
	System.out.println(String.format("%s , %s", february.minLength(), february.maxLength()));

	Month firstMonthOfQuarter = february.firstMonthOfQuarter();
	System.out.println(firstMonthOfQuarter); // JANUARY
    }

    private static void yearInformation() {
	LocalDate date = LocalDate.of(2014, 2, 15); // 2014-02-15
	System.out.println(date.getYear()); // 2014
	System.out.println(date.getDayOfYear()); // 46
	System.out.println(date.lengthOfYear()); // 365
	System.out.println(date.isLeapYear()); // false
	
	Year year_2014 = Year.of(2014);
	System.out.println(year_2014.isLeap()); // false
    }

    private static void dayInformation() {
	LocalDate date = LocalDate.of(2014, 2, 15); // 2014-02-15
	// ISO-8601 standard
	// the day-of-week to represent, from 1 (Monday) to 7 (Sunday)
	DayOfWeek dayOfWeek = date.getDayOfWeek();
	System.out.println(dayOfWeek); // SATURDAY

	System.out.println(DayOfWeek.of(3)); // WEDNESDAY

	System.out.println(dayOfWeek.getValue()); // 6
	System.out.println(dayOfWeek.name()); // SATURDAY

	System.out.println(date.getDayOfMonth()); // 15
	System.out.println(date.atStartOfDay()); // 2014-02-15 00:00
    }

    private static void timeInformation() {
	LocalTime time = LocalTime.of(15, 30, 23, 234); // 15:30:00
	System.out.println(time.getHour()); // 15
	System.out.println(time.getMinute()); // 30
	System.out.println(time.getSecond()); // 23
	System.out.println(time.getNano()); // 234
	System.out.println(time.toSecondOfDay()); // 55823
	System.out.println(time.toNanoOfDay()); // 55823000000234
    }

    private static void dslCreation() {
	Year year_2014 = Year.of(2014);
	System.out.println(year_2014); // 2014

	LocalDate year_month_day = Year.of(2014).atMonth(3).atDay(23);
	System.out.println(year_month_day); // 2014-03-23

	LocalDate year_and_day = Year.of(1974).atDay(77);
	System.out.println(year_and_day); // 1974-03-18
    }
    
    private static void calculations() {
	// Immutable objects are returned
	LocalDate tomorrow = LocalDate.now().plusDays(1);
	LocalDate yesterday = LocalDate.now().minusDays(1);
	LocalDate lastWeek = LocalDate.now().minusWeeks(1);
	LocalDate nextYear = LocalDate.now().plusYears(1);
	
	LocalDateTime inThreeHoursAndTwentyMinutes = LocalDateTime.now().plusHours(3).plusMinutes(20);
    }
    
    

    private static void space() {
	System.out.println();
	System.out.println();
    }
}
