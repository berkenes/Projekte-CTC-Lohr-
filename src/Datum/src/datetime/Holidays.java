package datetime;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.time.format.TextStyle;
import java.time.temporal.TemporalAdjusters;
import java.util.Locale;
import java.util.Scanner;
import java.util.TreeMap;

public class Holidays {

	private static TreeMap<LocalDate, String> holidays;

	public static void setHolidays(int year) {
		holidays = new TreeMap<>();
		holidays.put(LocalDate.of(year, Month.JANUARY, 1), "Neujahr");
		holidays.put(LocalDate.of(year, Month.MAY, 1), "Tag der Arbeit");
		holidays.put(LocalDate.of(year, Month.OCTOBER, 3), "Tag der Deutschen Einheit");
		holidays.put(LocalDate.of(year, Month.DECEMBER, 25), "1. Weihnachtsfeiertag");
		holidays.put(LocalDate.of(year, Month.DECEMBER, 26), "2. Weihnachtsfeiertag");

		// Adventstage
		LocalDate advent = LocalDate.of(year, Month.DECEMBER, 25).with(TemporalAdjusters.previous(DayOfWeek.SUNDAY));

		holidays.put(advent, "4. Advent");
		holidays.put(advent.plusDays(-7), "3. Advent");
		holidays.put(advent.plusDays(-14), "2. Advent");
		holidays.put(advent.plusDays(-21), "1. Advent");
		holidays.put(getEasterDate(year), "Ostersonntag");
		holidays.put(getEasterDate(year).plusDays(1), "Ostermontag");
		holidays.put(getEasterDate(year).plusDays(-2), "Karfreitag");
		holidays.put(getEasterDate(year).plusDays(49), "Pfingstsonntag");
		holidays.put(getEasterDate(year).plusDays(39), "Christi Himmelfahrt");
		holidays.put(getEasterDate(year).plusDays(50), "Pfingstmontag");
		holidays.put(getEasterDate(year).plusDays(60), "Fronleichnam");

		// Add Schwörmontag (second last Monday of July)
		LocalDate lastMondayOfJuly = LocalDate.of(year, Month.JULY, 31)
				.with(TemporalAdjusters.dayOfWeekInMonth(-2, DayOfWeek.MONDAY));
		holidays.put(lastMondayOfJuly, "Schwoermontag");
	}

	private static LocalDate getEasterDate(int year) {
		// Lichtenberg's Easter formula
		int k = year / 100;
		int m = 15 + (3 * k + 3) / 4 - (8 * k + 13) / 25;
		int s = 2 - (3 * k + 3) / 4;
		int a = year % 19;
		int d = (19 * a + m) % 30;
		int r = d / 29 + (d / 28 - d / 29) * (a / 11);
		int og = 21 + d - r;
		int sz = 7 - (year + year / 4 + s) % 7;
		int oe = 7 - (og - sz) % 7;
		int os = og + oe;

		if (os > 31) {
			return LocalDate.of(year, Month.APRIL, os - 31);
		} else {
			return LocalDate.of(year, Month.MARCH, os);
		}
	}

	public static void printCalendar(int year, int month) {
		LocalDate firstDayOfMonth = LocalDate.of(year, month, 1);

		int dayOfWeek = firstDayOfMonth.getDayOfWeek().getValue();
		System.out.printf("\n");
		System.out.println("Kalender fuer " + firstDayOfMonth.getMonth().getDisplayName(TextStyle.FULL, Locale.GERMAN)
				+ " " + year);
		System.out.println("Mo Di Mi Do Fr Sa So");
		System.out.printf("\n");
		for (int i = 1; i < dayOfWeek; i++) {
			System.out.print("   ");
		}

		TreeMap<LocalDate, String> currentMonthHolidays = new TreeMap<LocalDate, String>();
		for (int day = 1; day <= firstDayOfMonth.lengthOfMonth(); day++) {
			LocalDate currentDate = LocalDate.of(year, month, day);
			if (currentDate.equals(LocalDate.now())) {
				System.out.print("\u001B[34m"); // ANSI blue for today
			}
			if (holidays.containsKey(currentDate)) {
				currentMonthHolidays.put(currentDate, holidays.get(currentDate));
				System.out.print("\u001B[31m"); // ANSI red for holidays
			}
			System.out.printf("%2d ", day);
			System.out.print("\u001B[0m"); // Reset ANSI color

			if ((dayOfWeek) % 7 == 0) {
				System.out.println();
			}
			dayOfWeek++;
		}
		System.out.println();
		System.out.printf("\n");
		for (LocalDate key : currentMonthHolidays.keySet()) {
			System.out.printf("%s ist am %td.%<Tm \n", currentMonthHolidays.get(key), key);
		}
		System.out.printf("\n");
	}

	public static void main(String[] args) {
		int month, year;
		Scanner scanner = new Scanner(System.in);
		System.out.println("Bitte Monat eingeben");
		month = scanner.nextInt();
		System.out.println("Bitte Jahr eingeben");
		year = scanner.nextInt();
		setHolidays(year);

		printCalendar(year, month);
		// 7System.out.println(holidays);
	}
}

///  Feiertage:
///  Weihnachten ist am 2023-12-25
///	 Weihnachten ist am 2023-12-25
///	 Weihnachten ist am 2023-12-25
