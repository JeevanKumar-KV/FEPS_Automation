package com.FEPS.utility;
/**
 * Author : JeevanKumar K V
 * Email id  : jeevankumar.kv@conduent.com
 */

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;

public class DateTimeHelper {
	/**
	 * Generates Current Date and Time
	 * @format yyyy-MM-dd_HH-mm-ss
	 */
	public static String getCurrentDateTime() {

		DateFormat dateFormat = new SimpleDateFormat("_yyyy-MM-dd_HH-mm-ss-ms");
		Calendar cal = Calendar.getInstance();
		String time = "" + dateFormat.format(cal.getTime());
		return time;
	}

	public String getZuluCurrentDateTime()
    {
           DateTimeFormatter PARSER = DateTimeFormatter.ofPattern("uuuu-MM-dd HH:mm:ss", Locale.ROOT);
           ZoneId zone = ZoneId.of("America/Chicago");
        
           DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
           Calendar cal = Calendar.getInstance();
           String time = "" + dateFormat.format(cal.getTime());
           
        String dateString = time;
        
        ZonedDateTime dateTime = LocalDateTime.parse(dateString, PARSER).atZone(zone);    
        
        //String isoZuluString = dateTime.withZoneSameInstant(ZoneOffset.UTC).toString();
        
       DateTimeFormatter FORMATTER = new DateTimeFormatterBuilder()
                .append(DateTimeFormatter.ISO_LOCAL_DATE)
                .appendPattern("'T'HH:mm:ss.SSSX")
                .toFormatter(Locale.ROOT);
       String isoZuluString = dateTime.withZoneSameInstant(ZoneOffset.UTC)
                .format(FORMATTER);
        
        System.out.println(isoZuluString);
           
           return isoZuluString;
    }
    
    /**
    * Generates Current Date and Time
    * @format yyyy-MM-dd_HH-mm-ss
    */
    public static String getCurrentDateTime1() {

           DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
           Calendar cal = Calendar.getInstance();
           String time = "" + dateFormat.format(cal.getTime());
           return time;
    }
    
    public static String getCurrentDateTim2() {

           DateFormat dateFormat = new SimpleDateFormat("yyyyMMddhhmmss");
           Calendar cal = Calendar.getInstance();
           String time = "" + dateFormat.format(cal.getTime());
           return time;
    }
    
    /**
    * Add minutes to given time as input
    * This is used in DB time changing logic
    * @return updated time after adding specific minutes
    */
    
    public String addMinutesToGivenTime1(String myTime, int minutesToAdd) throws ParseException, ParseException {
           DateFormat df = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
           Date d = df.parse(myTime);
           Calendar cal = Calendar.getInstance();
           cal.setTime(d);
           cal.add(Calendar.MINUTE, minutesToAdd);
           String newTime = df.format(cal.getTime());
           return newTime.toUpperCase();
    }
    
    public String addMinutesToGivenTime2(String myTime, int minutesToAdd) throws ParseException, ParseException {
           DateFormat df = new SimpleDateFormat("yyyyMMddhhmmss");
           Date d = df.parse(myTime);
           Calendar cal = Calendar.getInstance();
           cal.setTime(d);
           cal.add(Calendar.MINUTE, minutesToAdd);
           String newTime = df.format(cal.getTime());
           return newTime.toUpperCase();
    }
    
    public String addMinutesToGivenTime3(String myTime, int minutesToAdd) throws ParseException, ParseException {
           DateFormat df = new SimpleDateFormat("yyyyMMddhhmmss");
           Date d = df.parse(myTime);
           Calendar cal = Calendar.getInstance();
           cal.setTime(d);
           cal.add(Calendar.SECOND, minutesToAdd);
           String newTime = df.format(cal.getTime());
           return newTime.toUpperCase();
    }
    
    

	
	
	
	
	/**
	 * Generates Current Date
	 */
	public static String getCurrentDate() {
		return getCurrentDateTime().substring(0, 11);
	}

	/**
	 * Generates Current Day in 'Monday' format
	 * @return current day of the week
	 */
	public String getCurrentDay(){
		Date date = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("EEEEE");
		String dayOfWeek = dateFormat.format(date);
		return dayOfWeek;
	}

	/**
	 * Add minutes to given time as input
	 * This is used in DB time changing logic
	 * @return updated time after adding specific minutes
	 */
	public String addMinutesToGivenTime(String myTime, int minutesToAdd) throws ParseException, ParseException {
		DateFormat df = new SimpleDateFormat("hh:mm a");
		Date d = df.parse(myTime);
		Calendar cal = Calendar.getInstance();
		cal.setTime(d);
		cal.add(Calendar.MINUTE, minutesToAdd);
		String newTime = df.format(cal.getTime());
		return newTime.toUpperCase();
	}

	/**
	 * Returns Current Time in hh:mm aa 12:30 PM format
	 */
	public static String get_current_time() {
		// Create object of SimpleDateFormat class and decide the format
		DateFormat dateFormat = new SimpleDateFormat("hh:mm aa");

		//get current date time with Date()
		Date date = new Date();

		// Now format the date and return

		return dateFormat.format(date);
	}

	/**
	 * Returns Current Hour -> 01 to 12
	 */
	public String get_current_hour() {
		// Create object of SimpleDateFormat class and decide the format
		DateFormat dateFormat = new SimpleDateFormat("hh");

		//get current date time with Date()
		Date date = new Date();

		// Now format the date and return

		return dateFormat.format(date);
	}

	/**
	 * Returns Current Minutes -> 01 to 60
	 */
	public String get_current_minutes() {
		// Create object of SimpleDateFormat class and decide the format
		DateFormat dateFormat = new SimpleDateFormat("mm");

		//get current date time with Date()
		Date date = new Date();

		// Now format the date and return

		return dateFormat.format(date);
	}

	/**
	 * Returns Current Time Period -> A.M or P.M
	 */
	public String get_current_time_period() {
		// Create object of SimpleDateFormat class and decide the format
		DateFormat dateFormat = new SimpleDateFormat("a");

		//get current date time with Date()
		Date date = new Date();

		// Now format the date and return

		return dateFormat.format(date);
	}

	/**
	 * Returns Current Date in MM/dd/yyyy format
	 */
	public String get_current_date() {
		// Create object of SimpleDateFormat class and decide the format
		DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");

		//get current date time with Date()
		Date date = new Date();

		// Now format the date and return

		return dateFormat.format(date);
	}

}
