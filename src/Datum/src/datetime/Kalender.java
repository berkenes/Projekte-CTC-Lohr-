package datetime;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.time.YearMonth;

public class Kalender {
	private static int year;
	private static Month month;

	public Kalender(int year, Month month) {
		Kalender.year = year;
		Kalender.month = month;
	}

	public static void createCalender() {
//		int row = 5;
//		int column = 7;

		YearMonth yearMonth = YearMonth.of(year, month);
		LocalDate startDate = LocalDate.of(year, month, 1);

		System.out.println(yearMonth.getMonth() + " " + year);
		System.out.println("Mon Tue Wed Thu Fri Sat Son");

		DayOfWeek startDay = startDate.getDayOfWeek();
		int startDayValue = startDay.getValue();

		for (int i = 1; i < startDayValue; i++) {
			System.out.print("   ");
		}

		while (startDate.getMonth() == month) {
			System.out.printf("%3d", startDate.getDayOfMonth());
			if (startDate.getDayOfWeek() == DayOfWeek.SUNDAY) {
				System.out.println();
			} else {
				System.out.print(" ");
			}
			startDate = startDate.plusDays(1);
			if (startDate.getDayOfWeek() == DayOfWeek.MONDAY) {
				System.out.println();
			}

		}

		System.out.println();
	}

//	public static String getMonthName(Month month) {
//		switch (month) {
//		case JANUARY:
//			return "January";
//		case FEBRUARY:
//			return "February";
//		case MARCH:
//			return "March";
//		case APRIL:
//			return "April";
//		case MAY:
//			return "May";
//		case JUNE:
//			return "June";
//		case JULY:
//			return "July";
//		case AUGUST:
//			return "August";
//		case SEPTEMBER:
//			return "September";
//		case OCTOBER:
//			return "October";
//		case NOVEMBER:
//			return "November";
//		case DECEMBER:
//			return "December";
//		default:
//			return "Invalid Month";
//		}
//	}

	public static void main(String[] args) {

		Kalender kalender = new Kalender(2023, Month.OCTOBER);
		Kalender.createCalender();
	}
}
