package model;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class Service {

	public Service() {};
	
	  public Calendar stringToCalendar(String stringDate) {
		    if (stringDate == null) {
		      return null;
		    }
		    Calendar calendar = new GregorianCalendar();
		    try {
		      Timestamp newDate = Timestamp.valueOf(stringDate);
		      calendar.setTime(newDate);
		    }
		    catch (Exception e) {
		      SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");
		      try {
		        calendar.setTime(simpleDateFormat.parse(stringDate));
		      }
		      catch (ParseException pe) {
		        calendar = null;
		      }
		    }
		    return calendar;
		  }
	  
	  public int calculPrix(int place, int prix) {
		  int res = place * prix;
		  return res;
		  
	  }
	
}
