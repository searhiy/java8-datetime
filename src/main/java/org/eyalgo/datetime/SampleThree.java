package org.eyalgo.datetime;

import java.util.Calendar;
import java.util.Date;

@SuppressWarnings("unused")
public class SampleThree {

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

		long ms = 10304004543l;
		StringBuilder text = new StringBuilder("");
		if (ms > DAY) {
			text.append(ms / DAY).append(" days ");
			ms %= DAY;
		}
		if (ms > HOUR) {
			text.append(ms / HOUR).append(" hours ");
			ms %= HOUR;
		}
		if (ms > MINUTE) {
			text.append(ms / MINUTE).append(" minutes ");
			ms %= MINUTE;
		}
		if (ms > SECOND) {
			text.append(ms / SECOND).append(" seconds ");
			ms %= SECOND;
		}
		text.append(ms + " ms");
		System.out.println(text.toString());

	}

}
