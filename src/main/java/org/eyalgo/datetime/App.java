package org.eyalgo.datetime;

import java.time.Clock;
import java.time.DayOfWeek;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.MonthDay;
import java.time.Period;
import java.time.Year;
import java.time.YearMonth;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;
import java.time.temporal.TemporalQueries;
import java.time.temporal.TemporalQuery;
import java.time.temporal.TemporalUnit;
import java.util.Date;
import java.util.Locale;

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
		space();
		instant();
		space();
		adjusters();
		space();
		queries();
		space();
		duration();
		space();
		period();
		space();
		calculations();
		space();
		int year = 2015;
		thanksgiving(year);
	}

	private static void thanksgiving(int year) {
		LocalDate thanksGiving = Year.of(year).atMonth(Month.NOVEMBER).atDay(1)
				.with(TemporalAdjusters.lastInMonth(DayOfWeek.WEDNESDAY));
		System.out.println(thanksGiving);
	}

	private static void general() {

		// Current Time
		System.out.println("Clock");
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

	@SuppressWarnings("unused")
	private static void basicClasses() {

		LocalDate currentDate = LocalDate.now(); // 2014-06-27
		LocalDate tenthFeb2014 = LocalDate.of(2014, Month.FEBRUARY, 10);
		LocalDate sixtyFifthDayOf2010 = LocalDate.ofYearDay(2010, 65); // 2014-03-06

		LocalTime currentTime = LocalTime.now(); // current time 09:04:47.526
		LocalTime midday = LocalTime.of(12, 0); // 12:00
		LocalTime fromSecondsOfDay = LocalTime.ofSecondOfDay(12345); // 03:25:45

		LocalDateTime currentDateTime = LocalDateTime.now(); // 2014-06-27T09:04:47.527
		LocalDateTime christmas2014 = LocalDateTime.of(2014, Month.DECEMBER, 24, 12, 0);

	}

	private static void localDate() {
		System.out.println("localDate");
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
		System.out.println("localTime");
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
		System.out.println("localDateTime");
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
		System.out.println("timeUsingZone");

		// current (local) time in Los Angeles
		LocalTime currentTimeInLosAngeles = LocalTime.now(ZoneId.of("America/Los_Angeles"));
		System.out.println(currentTimeInLosAngeles); // 23:08:18.104

		// current time in UTC time zone
		LocalTime nowInUtc = LocalTime.now(Clock.systemUTC());
		System.out.println(nowInUtc); // 06:08:18.125

		DateTimeFormatter format = DateTimeFormatter.ofPattern("MMM d yyyy  HH:mm");

		LocalDateTime leaving = LocalDateTime.of(2014, Month.JULY, 16, 23, 00);
		ZoneId leavingZone = ZoneId.of("Asia/Tel_Aviv");
		ZonedDateTime departure = ZonedDateTime.of(leaving, leavingZone);
		ZoneId arrivingZone = ZoneId.of("America/New_York");
		ZonedDateTime arrival = departure.withZoneSameInstant(arrivingZone).plusHours(11).plusMinutes(51);
		System.out.println(String.format("Departure: %s", departure.format(format)));
		System.out.println(String.format("Arrival: %s", arrival.format(format)));
	}

	@SuppressWarnings("unused")
	private static void timeUsingZoneExamples() {

		// current (local) time in Los Angeles
		LocalTime currentTimeInLosAngeles = LocalTime.now(ZoneId.of("America/Los_Angeles"));

		// current time in UTC time zone
		// Injecting Clock. We can do tests based on different zones
		LocalTime nowInUtc = LocalTime.now(Clock.systemUTC()); // 06:08:18.125

		// Calculation using zones

		LocalDateTime leaving = LocalDateTime.of(2014, Month.JULY, 16, 23, 00);

		ZoneId tlv = ZoneId.of("Asia/Tel_Aviv");
		ZonedDateTime departure = ZonedDateTime.of(leaving, tlv);

		ZoneId ny = ZoneId.of("America/New_York");

		ZonedDateTime arrival = departure.withZoneSameInstant(ny).plusHours(11).plusMinutes(51);

	}

	private static void information() {
		monthInformation();
		yearInformation();
		dayInformation();
		timeInformation();
	}

	@SuppressWarnings("unused")
	public static void partialAndInformation() {

		LocalDate date = LocalDate.of(2014, Month.FEBRUARY, 15); // 2014-02-15
		Month february = date.getMonth();
		february.getValue(); // = 2

		Month firstMonthOfQuarter = february.firstMonthOfQuarter(); // JANUARY

		date.getYear(); // 2014
		date.getDayOfYear(); // 46

		Year year_2014 = Year.of(2014);
		year_2014.isLeap(); // false

		DayOfWeek dayOfWeek = date.getDayOfWeek(); // SATURDAY

		dayOfWeek = DayOfWeek.FRIDAY;
		Locale locale = Locale.getDefault();
		dayOfWeek.getDisplayName(TextStyle.FULL, locale); // Friday
		dayOfWeek.getDisplayName(TextStyle.NARROW, locale); // F
		dayOfWeek.getDisplayName(TextStyle.SHORT, locale); // Fri

	}

	private static void monthInformation() {
		System.out.println("monthInformation");
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
		System.out.println("yearInformation");
		LocalDate date = LocalDate.of(2014, 2, 15); // 2014-02-15
		System.out.println(date.getYear()); // 2014
		System.out.println(date.getDayOfYear()); // 46
		System.out.println(date.lengthOfYear()); // 365
		System.out.println(date.isLeapYear()); // false

		Year year_2014 = Year.of(2014);
		System.out.println(year_2014.isLeap()); // false
	}

	private static void dayInformation() {
		System.out.println("dayInformation");
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

		System.out.println("DayOfWeek");
		dayOfWeek = DayOfWeek.FRIDAY;
		Locale locale = Locale.getDefault();
		System.out.println(dayOfWeek.getDisplayName(TextStyle.FULL, locale)); // Friday
		System.out.println(dayOfWeek.getDisplayName(TextStyle.NARROW, locale)); // F
		System.out.println(dayOfWeek.getDisplayName(TextStyle.SHORT, locale)); // Fri
	}

	private static void timeInformation() {
		System.out.println("timeInformation");

		LocalTime time = LocalTime.of(15, 30, 23, 234); // 15:30:00
		System.out.println(time.getHour()); // 15
		System.out.println(time.getMinute()); // 30
		System.out.println(time.getSecond()); // 23
		System.out.println(time.getNano()); // 234
		System.out.println(time.toSecondOfDay()); // 55823
		System.out.println(time.toNanoOfDay()); // 55823000000234

	}

	@SuppressWarnings("unused")
	private static void showDsl() {

		Year year_2014 = Year.of(2014);
		LocalDate year_month_day = Year.of(2014).atMonth(3).atDay(23);
		LocalDate year_and_day = Year.of(1974).atDay(77); // 1974-03-18
		MonthDay.of(Month.FEBRUARY, 29);

	}

	private static void dslCreation() {
		System.out.println("dslCreation");
		Year year_2014 = Year.of(2014);
		System.out.println(year_2014); // 2014

		LocalDate year_month_day = Year.of(2014).atMonth(3).atDay(23);
		System.out.println(year_month_day); // 2014-03-23

		LocalDate year_and_day = Year.of(1974).atDay(77);
		System.out.println(year_and_day); // 1974-03-18

		System.out.println(YearMonth.now());
		System.out.println(MonthDay.of(Month.FEBRUARY, 29));
	}

	@SuppressWarnings("unused")
	private static void instantInformation() {

		// Instant is useful for generating a time stamp to represent machine time.
		Instant timestamp = Instant.now();

		// How many seconds have occurred since the beginning of the Java epoch.
		long secondsFromEpoch = Instant.ofEpochSecond(0L).until(Instant.now(), ChronoUnit.SECONDS);

		// Convert "machine time" to human units
		LocalDateTime humanTime = LocalDateTime.ofInstant(timestamp, ZoneId.systemDefault());

	}

	private static void instant() {
		System.out.println("instant");
		// This class is useful for generating a time stamp to represent machine
		// time.
		Instant timestamp = Instant.now();
		System.out.println(timestamp);
		System.out.println(timestamp.plus(1, ChronoUnit.HOURS));
	}

	@SuppressWarnings("unused")
	private static void adjusters() {
		System.out.println("adjusters");

		LocalDate date = LocalDate.of(2014, Month.JULY, 16);

		LocalDate firstDayOfJuly = date.with(TemporalAdjusters.firstDayOfMonth()); // 2014-07-01

		LocalDate dateOfFirstMonday = date.with(TemporalAdjusters.firstInMonth(DayOfWeek.MONDAY)); // 2014-07-07

	}

	@SuppressWarnings("unused")
	private static void queriesInfo() {

		// Smallest unit
		TemporalQuery<TemporalUnit> precision = TemporalQueries.precision();
		LocalDate.now().query(precision); // Days
		LocalTime.now().query(precision); // Nanos
		YearMonth.now().query(precision); // Months

		// Custom query - check is month in school holiday
		SchoolHolidayQuery schoolHolidayQuery = new SchoolHolidayQuery();

		YearMonth yearMonth = YearMonth.of(2014, Month.JUNE);
		Boolean isSchoolHoliday = yearMonth.query(schoolHolidayQuery); // false

		YearMonth.of(2014, Month.JULY).query(schoolHolidayQuery); // true
		YearMonth.of(2014, 8).query(schoolHolidayQuery); // true

		// Custom Query - Returns a yearly quarter (custom enum)
		YearQuarter quarter2 = YearMonth.of(2014, 6).query(YearQuarterQuery::findQuarter); // Q2
		YearQuarter quarter4 = YearMonth.of(2011, Month.DECEMBER).query(YearQuarterQuery::findQuarter); // Q4

	}

	private static void queries() {
		System.out.println("queries");
		TemporalQuery<TemporalUnit> precision = TemporalQueries.precision();
		System.out.println(LocalDate.now().query(precision)); // Days
		System.out.println(LocalTime.now().query(precision)); // Nanos
		System.out.println(YearMonth.now().query(precision)); // Months

		YearMonth yearMonth = YearMonth.of(2014, 6);
		System.out.println(yearMonth.query(new SchoolHolidayQuery())); // false
		System.out.println(YearMonth.of(2014, Month.JULY).query(new SchoolHolidayQuery())); // true
		System.out.println(YearMonth.of(2014, 8).query(new SchoolHolidayQuery())); // true
		System.out.println();
		System.out.println(YearMonth.of(2014, 6).query(YearQuarterQuery::findQuarter)); // Q2
		System.out.println(YearMonth.of(2011, Month.DECEMBER).query(YearQuarterQuery::findQuarter)); // Q4
	}

	@SuppressWarnings("unused")
	private static void durationInfo() {

		// If you want to measure machine-based time
		// A Duration can have a negative value
		Instant t1 = Instant.now();
		Instant t2 = Instant.now().plusSeconds(12);
		long nanosecondsBetweenTwoInstants = Duration.between(t1, t2).toNanos();

		// Using ChronoUnit enum
		long millisecondsBetweenTwoInstants = ChronoUnit.MILLIS.between(t1, t2); // 12000

		Duration gap = Duration.ofSeconds(13);
		Instant later = t1.plus(gap);

	}

	private static void duration() {
		System.out.println("duration");
		Instant t1 = Instant.now();
		Instant t2 = Instant.now().plusSeconds(12);
		long nanos = Duration.between(t1, t2).toNanos();
		System.out.println(nanos);

		Duration gap = Duration.ofSeconds(13); // 12000000000
		Instant later = t1.plus(gap);
		System.out.println(t1); // 2014-07-02T19:55:00.956Z
		System.out.println(later); // 2014-07-02T19:55:13.956Z

		System.out.println(ChronoUnit.MILLIS.between(t1, t2)); // 12000
	}

	@SuppressWarnings("unused")
	private static void periodInfo() {

		Period employmentPeriod = EmploymentPeriod.period(LocalDate.of(2011, Month.FEBRUARY, 1));
		int years = employmentPeriod.getYears(); // 3
		int months = employmentPeriod.getMonths(); // 5
		int days = employmentPeriod.getDays(); // 1

	}

	private static void period() {
		System.out.println("period");
		Period employmentPeriod = EmploymentPeriod.period(LocalDate.of(2011, Month.FEBRUARY, 1));
		System.out.println(employmentPeriod.getYears()); // 3
		System.out.println(employmentPeriod.getMonths()); // 5
		System.out.println(employmentPeriod.getDays()); // 1
	}

	@SuppressWarnings("unused")
	private static void calculations() {

		// Immutable objects are returned
		LocalDate tomorrow = LocalDate.now().plusDays(1);
		LocalDate yesterday = LocalDate.now().minusDays(1);
		LocalDate lastWeek = LocalDate.now().minusWeeks(1);
		LocalDate nextYear = LocalDate.now().plusYears(1);
		LocalDateTime inThreeHoursAndTwentyMinutes = LocalDateTime.now().plusHours(3).plusMinutes(20);

	}

	@SuppressWarnings("unused")
	private static void convertLegacy() {

		// Old to new
		Date date = new Date();
		LocalDateTime localDateTime = LocalDateTime.ofInstant(date.toInstant(), ZoneId.systemDefault());

		// New to old
		LocalDateTime now = LocalDateTime.now();
		Instant instant = now.atZone(ZoneId.systemDefault()).toInstant();
		Date dateFromOld = Date.from(instant);

	}

	private static void space() {

		System.out.println();
		System.out.println();
	}
}