package org.eyalgo.datetime;

import java.time.LocalDate;
import java.time.Period;

public class EmploymentPeriod {
	public static Period period(LocalDate hiringDate) {
		LocalDate today = LocalDate.now();
		return Period.between(hiringDate, today);
	}
}



