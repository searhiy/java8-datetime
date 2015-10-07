package presentation.comparisonimpl;

import java.util.Calendar;
import java.util.Date;

public class SampleTwo {

	private static final int SECOND = 1000;
	private static final int MINUTE = 60 * SECOND;
	private static final int HOUR = 60 * MINUTE;
	private static final int DAY = 24 * HOUR;

	public static void main(String[] args) {

		Calendar now = Calendar.getInstance();
		Date nowDate = now.getTime();

		long twoHoursByMillis = 2 * HOUR;
		long thirtyMinutesByMillis = 30 * MINUTE;

		Date twoHoursAndThirtyMinutesFromNow = new Date(twoHoursByMillis
				+ thirtyMinutesByMillis);
		System.out.println(String.format("now %s and later %s", nowDate,
				twoHoursAndThirtyMinutesFromNow));

	}

}
