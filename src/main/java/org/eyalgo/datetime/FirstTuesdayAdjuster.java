package org.eyalgo.datetime;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.Temporal;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;

@SuppressWarnings("unused")


public class FirstTuesdayAdjuster implements TemporalAdjuster {

	@Override
	public Temporal adjustInto(Temporal input) {
		LocalDate date = LocalDate.from(input);
		LocalDate nextMonth = date.plusMonths(1);
		LocalDate firstTuesdayInNextMonth = nextMonth.with(TemporalAdjusters
				.firstInMonth(DayOfWeek.TUESDAY));
		return input.with(firstTuesdayInNextMonth);
	}

	public static void main(String[] args) {
		LocalDate july_2014 = LocalDate.of(2014, 7, 20);
		LocalDate nextPayday = july_2014.with(new FirstTuesdayAdjuster());
		System.out.println(nextPayday);
		LocalDate august_2009 = LocalDate.of(2009, 8, 20);
		nextPayday = august_2009.with(new FirstTuesdayAdjuster());
		System.out.println(nextPayday);
	}
}




