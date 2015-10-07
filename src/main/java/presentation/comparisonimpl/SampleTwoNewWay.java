package presentation.comparisonimpl;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Month;
import java.time.MonthDay;
import java.time.Period;

public class SampleTwoNewWay {

	public static void main(String[] args) {
		
		int hours = 12;
		int minutes = 30;
		LocalTime classStart = LocalTime.of(hours, minutes);
		System.out.println(classStart);


		// sample two new way
		LocalTime twoHoursAndThirtyMinutesFromNow = LocalTime.now().plusHours(2).plusMinutes(30);
		System.out.println(twoHoursAndThirtyMinutesFromNow);
		
		int year = 2014;
		Month month = Month.JULY;
		int dayOfMonth = 14;
		LocalDate jugILThisYear = LocalDate.of(year, month, dayOfMonth);
		System.out.println(jugILThisYear);
		
		MonthDay jugIL = MonthDay.of(month, dayOfMonth);
		System.out.println(jugIL);
		
		int yearsAtEbay = 3;
		int monthsAtEbay = 6;
		Period timeAtEbay = Period.ofYears(yearsAtEbay).withMonths(monthsAtEbay);
		
		System.out.println(timeAtEbay.getYears());
		System.out.println(timeAtEbay.getMonths());
		
	}

}
