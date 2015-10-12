package presentation.jsr310;

import presentation.jsr310.periodandduration.PeriodLauncher;

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
import java.util.Locale;

/**
 * Hello world!
 *
 */
public class Examples {

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