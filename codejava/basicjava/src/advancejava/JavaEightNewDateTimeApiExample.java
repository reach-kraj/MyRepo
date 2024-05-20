package advancejava;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class JavaEightNewDateTimeApiExample {

	public static void main(String[] args) {

		LocalDate localDate = LocalDate.now();
		System.out.println("Printing the current date : " + localDate);

		LocalTime localTime = LocalTime.now();
		System.out.println("Printing the current time  : " + localTime);

		LocalDateTime localDateandTime = LocalDateTime.now();
		System.out.println("Priting the current date and current time : " + localDateandTime);

		DateTimeFormatter specifiedFormat = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		String format = localDateandTime.format(specifiedFormat);
		System.out.println("Printing the date in the specified format : " + format);

		System.out.println(
				"Printing the name of current day of the week : " + localDateandTime.getDayOfWeek().toString());

		System.out.println("Prnting the current month : " + localDateandTime.getMonth());

		System.out.println("Prnting the current day of the month : " + localDateandTime.getDayOfMonth());

	}

}
