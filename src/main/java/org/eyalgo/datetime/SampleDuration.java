package org.eyalgo.datetime;

import java.time.Duration;
import java.time.Instant;
import java.time.temporal.ChronoUnit;

public class SampleDuration {

	public static void main(String[] args) {

		Instant t1 = Instant.now();
		long hours = 2;
		long minutes = 30;
		Instant t2 = t1.plus(hours, ChronoUnit.HOURS).plus(minutes, ChronoUnit.MINUTES);

		System.out.println(String.format("now %s and later %s", t1, t2));
		
		long minutesBetween = Duration.between(t1, t2).toMinutes();
		System.out.println(minutesBetween);

		Duration gap = Duration.ofSeconds(13);
		Instant later = t1.plus(gap);
		System.out.println(later);
		
		System.out.println(ChronoUnit.MILLIS.between(t1, t2));	
	
	}

}
