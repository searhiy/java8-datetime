package presentation.jsr310.periodandduration;

import java.time.LocalDate;
import java.time.Month;
import java.time.Period;

public class PeriodLauncher {

	public static Period period(LocalDate hiringDate) {
		LocalDate today = LocalDate.now();
		return Period.between(hiringDate, today);
	}

	private static void period() {
		System.out.println("period");
		Period employmentPeriod = PeriodLauncher.period(LocalDate.of(2011, Month.FEBRUARY, 1));
		System.out.println(employmentPeriod.getYears()); // 3
		System.out.println(employmentPeriod.getMonths()); // 5
		System.out.println(employmentPeriod.getDays()); // 1
	}

	private static void periodInfo() {

		Period employmentPeriod = PeriodLauncher.period(LocalDate.of(2011, Month.FEBRUARY, 1));
		int years = employmentPeriod.getYears(); // 3
		int months = employmentPeriod.getMonths(); // 5
		int days = employmentPeriod.getDays(); // 1

	}
}



