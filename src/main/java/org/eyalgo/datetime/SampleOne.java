package org.eyalgo.datetime;

import java.util.Calendar;
import java.util.Date;

public class SampleOne {

	public static void main(String[] args) {
		Date start = new Date(2012, Calendar.FEBRUARY, 1);
		
		Calendar startEmployment = Calendar.getInstance();
		// calendar.set(2011, 2, 1);
		startEmployment.set(2011, Calendar.FEBRUARY, 1);
		
		Calendar now = Calendar.getInstance();
		
		long numberOfDays1 = countDays(startEmployment, now);
		long numberOfDays2 = countDays(startEmployment, now);
		
		System.out.println(String.format("First try=%d , second try=%d", numberOfDays1, numberOfDays2));
	}

	private static long countDays(Calendar start, Calendar end) {
		long totalNumberOfDays = 0;
		while(start.before(end)) {
			start.add(Calendar.DAY_OF_MONTH, 1);
			totalNumberOfDays++;
		}
		return totalNumberOfDays;
	}
}


