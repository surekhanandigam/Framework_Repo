package practice.contactTest;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class JavaBasics_Date {
   public static void main(String[] args) {
	Date date = new Date();
    System.out.println(date.toString());
	
    SimpleDateFormat sim=new SimpleDateFormat("yyyy-MM-dd");
    String actDate=sim.format(date);
    System.out.println(actDate);
    
    
    Calendar cal=sim.getCalendar();
    cal.add(Calendar.DAY_OF_MONTH,30);
    String dateRequires=sim.format(cal.getTime());
    System.out.println(dateRequires);
 } 
}
