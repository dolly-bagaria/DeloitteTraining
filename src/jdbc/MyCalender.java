package jdbc;

import java.util.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;

public class MyCalender {

	public static void main(String[] args) {
		
		Calendar cal=Calendar.getInstance();
		System.out.println(cal);
		int yr=cal.get(Calendar.YEAR);
		int mon=cal.get(Calendar.MONTH);
		int day=cal.get(Calendar.DATE);
		

		System.out.println(day+":"+(mon+1)+":"+yr);
		
		Date dt=new Date();
		long millis=dt.getTime();
		Calendar calndr=Calendar.getInstance();
		calndr.setTime(dt);
		calndr.setTimeInMillis(millis);
		/*
		LocalDate Id=LocalDate.now();
		System.out.println(Id);
		DateTimeFormatter dtf=DateTimeFormatter.ofPattern("dd-MM-YYYY");
		System.out.println(dtf.format(Id));
		*/
		//DaysToBirthday("19-10-2020");
		DaysToBirthday("19-10-2020");

	}
	
	static void DaysToBirthday(String s) {
		LocalDate Id=LocalDate.now();
		LocalDate today= Id;
		System.out.println(today);
		
		DateTimeFormatter dtf=DateTimeFormatter.ofPattern("dd-MM-yyyy");
		LocalDate futureDate=LocalDate.from(dtf.parse(s));
		int year=futureDate.getYear();
		int month=futureDate.getMonthValue();
		int day=futureDate.getDayOfMonth();
		LocalDate birth= LocalDate.of(year, month, day);
		System.out.println(birth);
		
		long intervalDays = ChronoUnit.DAYS.between(today, birth);
	    System.out.println("Total number of days between dates:" + intervalDays);
	}

}
