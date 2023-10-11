package datetime;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.format.TextStyle;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.Locale;

public class DatumUndUhrzeit {

	public static void main(String[] args) {

// alle Datumklasse: java.util.Date
		Date date = new Date();

		System.out.println(date);

		date = new Date(System.currentTimeMillis() + 3600000L);
		System.out.println(date);

		// Achtung: die meisten methoden sind deprecated

		date = new Date(119, 2, 7);

		System.out.println(date);

		// Ab Java 8: neue Datums und Zeitklasse
		// klare trennung von datum und zeit
		// package:java.time

		LocalDate localdate = LocalDate.now();

		System.out.println(localdate);

		// localdate = LocalDate.of(1993, Month.JULY, 2);

		System.out.println(localdate);

		System.out.println(localdate.plusDays(40));
		// Bu methodun plusMonths, plusYears,Plusweeks
		System.out.println(localdate.plus(1, ChronoUnit.DECADES));

		// Einzelene Felder manipulieren
		System.out.println("Manipulation " + localdate.withMonth(Month.FEBRUARY.getValue()));
		System.out.println("2: " + localdate.with(ChronoField.DAY_OF_WEEK, DayOfWeek.MONDAY.getValue()));

		LocalTime localTime = LocalTime.now();

		System.out.println(localTime);

		LocalDateTime localDateTime = LocalDateTime.now();
		System.out.println(localDateTime);

		// mittels printf
		System.out.println("printf");
		System.out.printf("\n%Td.\n", localDateTime);

		System.out.printf("\n%Td.%Tm.%Ty.\n", localDateTime, localdate, localDateTime);

		System.out.println("Day of weeks===============");
		for (DayOfWeek d : DayOfWeek.values()) {
			System.out.println(d.getDisplayName(TextStyle.FULL, Locale.ITALIAN));

		}
		System.out.println("Months of Years===============");
		for (Month m : Month.values()) {
			System.out.println(m.getDisplayName(TextStyle.FULL, Locale.FRENCH));
		}

		System.out.println("Konventieren  von Localdate in Date");

		date = java.sql.Date.valueOf(localdate);
		System.out.println(date);

		System.out.println("String in Date Parsen");
		String s = "#2016-16xJanuar";
		SimpleDateFormat format = new SimpleDateFormat("#yyyy-dd'x'MMMM");
		System.out.println(format.format(date));
		try {
			date = format.parse(s);
			System.out.println(date);
		} catch (ParseException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		System.out.println("=======================================\nZeitmessung\n");
		;
		long start = System.currentTimeMillis();
		for (int i = 0; i < 100_000_000; i++) {
			Math.random();

		}
		long ende = System.currentTimeMillis();

		System.out.println("Dauer: " + (ende - start) + " ms");
	}

}
