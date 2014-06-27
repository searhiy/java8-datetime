package org.eyalgo.datetime;

import java.time.Clock;
import java.time.LocalDate;
import java.time.ZoneId;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) {
	Clock clock = Clock.systemUTC();
	System.out.println(clock.getZone().getId());
	System.out.println(Clock.systemDefaultZone());
	
	ZoneId zone = ZoneId.systemDefault();
	System.out.println(Clock.system(zone));
	
	System.out.println(Clock.system(ZoneId.of("Europe/Berlin")));
	
	LocalDate date = LocalDate.now();
	System.out.printf("%s-%s-%s", 
	    date.getYear(), date.getMonthValue(), date.getDayOfMonth()
	);
	
    }
}
