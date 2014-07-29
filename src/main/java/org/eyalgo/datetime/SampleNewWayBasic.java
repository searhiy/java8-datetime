package org.eyalgo.datetime;

import java.time.Clock;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;

public class SampleNewWayBasic {

	public static void main(String[] args) {
		
		// Current Time
		Clock clock = Clock.systemUTC();
		System.out.println(Clock.systemDefaultZone());
		
		LocalDateTime dateAndTime = LocalDateTime.now(clock);
		System.out.println(dateAndTime);
		System.out.println(LocalDateTime.now());

		// Time Zone
		ZoneId zone = ZoneId.systemDefault();
		System.out.println(Clock.system(zone));
		System.out.println(Clock.system(ZoneId.of("Europe/Berlin")));

		// Human Readable
		LocalDate date = LocalDate.now();
		System.out.println(String.format("%s-%s-%s", date.getYear(), date.getMonthValue(), date.getDayOfMonth()));

	}

	
}
