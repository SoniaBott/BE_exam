package com.fincons.todo.models.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DataUtils {

	 private static final Logger logger = LoggerFactory.getLogger("DataUtils.class");
	
	private static int numberOfDays=7;
	
	public static Date dueDateDef(Date currentDate) {
		Calendar c = Calendar.getInstance();
		c.setTime(currentDate);
		//Aggiungo i giorni
		c.add(Calendar.DAY_OF_MONTH, numberOfDays);
		//Ritorna la nuova data
		return  c.getTime();
	}
	

}
