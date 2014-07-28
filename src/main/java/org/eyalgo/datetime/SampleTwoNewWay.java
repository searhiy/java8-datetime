package org.eyalgo.datetime;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Month;
import java.time.MonthDay;
import java.time.Period;

public class SampleTwoNewWay {

	@SuppressWarnings("unused")
	
	public static void main(String[] args) {
		
		int hours = 12;
		int minutes = 30;
		LocalTime classStart = LocalTime.of(hours, minutes);
		
		int year = 2014;
		Month month = Month.JULY;
		int dayOfMonth = 14;
		LocalDate jugILThisYear = LocalDate.of(year, month, dayOfMonth);
		
		MonthDay jugIL = MonthDay.of(month, dayOfMonth);
		
		int yearsAtEbay = 3;
		int monthsAtEbay = 6;
		Period timeAtEbay = Period.ofYears(yearsAtEbay).withMonths(monthsAtEbay);
		
		System.out.println(timeAtEbay.getYears());
		System.out.println(timeAtEbay.getMonths());
		
	}

}
