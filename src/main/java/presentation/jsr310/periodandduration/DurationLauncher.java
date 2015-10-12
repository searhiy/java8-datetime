package presentation.jsr310.periodandduration;

import java.time.Duration;
import java.time.Instant;
import java.time.temporal.ChronoUnit;

public class DurationLauncher {

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

}
