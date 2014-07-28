package org.eyalgo.datetime;

import java.time.LocalDate;
import java.time.Month;
import java.time.temporal.ChronoUnit;

public class SampleOneNewWay {

	public static void main(String[] args) {
		
		LocalDate startEmployment = LocalDate.of(2011, Month.FEBRUARY, 1);
		
		LocalDate today = LocalDate.now();
		
		long numberOfDays = startEmployment.until(today, ChronoUnit.DAYS);
		
		System.out.println(String.format("%d",  numberOfDays));
		
		LocalDate nextYear = today.plusYears(1);
		
		System.out.println(String.format("Today %s and next year %s", today, nextYear));
		
	}
}


