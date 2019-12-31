package jdbc;

import java.util.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
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
		
		LocalDate Id=LocalDate.now();
		System.out.println(Id);
		DateTimeFormatter dtf=DateTimeFormatter.ofPattern("dd-MM-YYYY");
		System.out.println(dtf.format(Id));

	}

}
