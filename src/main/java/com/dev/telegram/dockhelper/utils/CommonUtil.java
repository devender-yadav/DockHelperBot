package com.dev.telegram.dockhelper.utils;

import static com.dev.telegram.dockhelper.utils.Constants.EMPTY_STRING;
import static com.dev.telegram.dockhelper.utils.Constants.NEW_LINE;
import static com.dev.telegram.dockhelper.utils.Constants.WAIT_INTERVAL;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * The Class CommonUtil.
 * 
 * @author devender
 */
public class CommonUtil {

	/** The Constant LOGGER. */
	private static final Logger LOGGER = LoggerFactory.getLogger(CommonUtil.class);

	/**
	 * Instantiates a new common util.
	 */
	private CommonUtil() {
	}

	/**
	 * Sleep.
	 */
	public static void sleep() {
		try {
			Thread.sleep(WAIT_INTERVAL);
		} catch (InterruptedException e) {
			LOGGER.error("Error while sleeping!!! ", e);
		}
	}

	/**
	 * Convert date to UTC.
	 *
	 * @param date the date
	 * @return the string
	 */
	public static String convertDateToUTC(Date date) {
		DateFormat formatterUTC = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
		formatterUTC.setTimeZone(TimeZone.getTimeZone("UTC"));
		return formatterUTC.format(date);
	}

	/**
	 * Removes the new line.
	 *
	 * @param str the str
	 * @return the string
	 */
	public static String removeNewLine(String str) {
		return str.replace(NEW_LINE, EMPTY_STRING);
	}

}
