/*******************************************************************************
 * Copyright (c) 2013 André Pinela - ISEL Student 38603.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the GNU Public License v3.0
 * which accompanies this distribution, and is available at
 * http://www.gnu.org/licenses/gpl.html
 * 
 * Contributors:
 *     André Pinela - ISEL Student 38603 - initial API and implementation
 ******************************************************************************/
package grupo1;

import java.util.Calendar;

public class Date {

	private static final int[] MONTH_DAYS_COMMON_YEAR = { 31, 28, 31, 30, 31,
			30, 31, 31, 30, 31, 30, 31 }; // Define days by each month for a common year (365 days)
	private static final int[] MONTH_DAYS_LEAP_YEAR = { 31, 29, 31, 30, 31, 30,
			31, 31, 30, 31, 30, 31 }; // Define days by each month for a leap year (366 days)

	private int year; // field to hold year value
	private int month; // field to hold month value
	private int day; // field to hold day value
	private int[] monthDays; // array that holds days by each month for the year set in constructor


	/**
	 * Initialize Date with year, month and day as separated integers.
	 * 
	 * @param year Year.
	 * @param month Month.
	 * @param day Day.
	 */
	public Date(int year, int month, int day) {

		this.year = year;
		this.month = month;
		this.day = day;

		try {
			initializeClass();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/**
	 * Initialize Date with year, month and day passed as String.
	 * 
	 * @param str Syntax must be "DD-MM-YYYY".
	 */
	public Date(String str) {

		try {

			/*
			 * str syntax: DD-MM-YYYY
			 * 
			 * split map:
			 * 	DD -> 0
			 * 	MM -> 1
			 * 	YYYY -> 2
			 */

			String[] tmpDate = str.split("-");

			this.year = Integer.parseInt(tmpDate[2]);
			this.month = Integer.parseInt(tmpDate[1]);
			this.day = Integer.parseInt(tmpDate[0]);
		} catch (Exception e) {
			e.printStackTrace();
		}

		try {
			initializeClass();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/**
	 * Initialize Date with current year, month and day.
	 */
	public Date() {

		Calendar currDateTime = Calendar.getInstance();

		this.year = currDateTime.get(Calendar.YEAR);
		this.month = currDateTime.get(Calendar.MONTH);
		this.day = currDateTime.get(Calendar.DAY_OF_MONTH);

		try {
			initializeClass();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/**
	 * Verifies if year is common or leap.
	 * 
	 * @param year Year to check.
	 * @return True if is a leap year or False if is a common year.
	 */
	public static boolean isLeapYear(int year) {

		if (year % 400 == 0)
			return true;
		if (year % 4 == 0 && year % 100 != 0)
			return true;
		return false;

	}

	/**
	 * Initialize all necessary variables needed by this class
	 * 
	 * @throws IllegalArgumentException If day/month does not exist in some context.
	 */
	private void initializeClass() throws IllegalArgumentException {

		/* Validate Month */
		
		if (this.month > 12 && this.month < 1)
			throw new IllegalArgumentException("Wrong month.");

		/* Validate Day */

		if (isLeapYear(this.year)) {
			this.monthDays = MONTH_DAYS_LEAP_YEAR;
		} else {
			this.monthDays = MONTH_DAYS_COMMON_YEAR;
		}

		if (this.day > this.monthDays[this.month - 1] && this.month < 1)
			throw new IllegalArgumentException("Wrong day for month and/or year context.");

	}

	/**
	 * Gets the number of days/last day that a month have.
	 * 
	 * @param year Year.
	 * @param month Month.
	 * @return Number of days that month have in year context.
	 */
	private static int getLastDayOfMonthByYear(int year, int month) {
		if (isLeapYear(year)) {
			return MONTH_DAYS_LEAP_YEAR[month - 1];
		} else {
			return MONTH_DAYS_COMMON_YEAR[month - 1];
		}
	}

	/**
	 * Returns this class representation of String.  
	 * 
	 * @return A string in the following syntax: DD-MM-YYYY
	 */
	public String toString() {

		String tmpDay = (String.valueOf(this.day).length() == 1) ? "0"
				+ this.day : Integer.toString(this.day);
		String tmpMonth = (String.valueOf(this.month).length() == 1) ? "0"
				+ this.month : Integer.toString(this.month);
		String tmpYear = Integer.toString(this.year);

		return tmpDay + "-" + tmpMonth + "-" + tmpYear;
	}

	
	/**
	 * Check if this object have the same numerical representation of d.
	 * 
	 * @param d Date to check to.
	 * @return True if year, month and day of this object is equal to the ones of d object.
	 */
	public boolean equals(Date d) {

		return this.toString().equals(d.toString());

	}

	/**
	 * Compares this object date with d Date.
	 * 
	 * @param d Date to compare to.
	 * @return 0 if this object date is equal to d date, 1 if this object date is after to d date or -1 if if this object date is earlier to d date
	 */
	public int compareTo(Date d) {

		String[] tmpNewDate = d.toString().split("-");

		/* Parse date values to integer */

		int newDay = Integer.parseInt(tmpNewDate[0]);
		int newMonth = Integer.parseInt(tmpNewDate[1]);
		int newYear = Integer.parseInt(tmpNewDate[2]);

		if (this.year < newYear)
			return -1;
		else if (this.year > newYear)
			return 1;
		else {
			if (this.month < newMonth)
				return -1;
			else if (this.month > newMonth)
				return 1;
			else {
				if (this.day < newDay)
					return -1;
				else if (this.day > newDay)
					return 1;
				else
					return 0;
			}
		}
	}

	/**
	 * @return Next day after this object date.
	 */
	public Date nextDate() {
		int tmpDay = this.day;
		int tmpMonth = this.month;
		int tmpYear = this.year;

		if (this.day + 1 > getLastDayOfMonthByYear(this.year, this.month)) {
			tmpDay = 1;
			if (this.day + 1 > 12) {
				tmpMonth = 1;
				tmpYear = this.year + 1;
			} else
				tmpMonth = this.month + 1;
		} else
			tmpDay = this.day + 1;

		return new Date(tmpYear, tmpMonth, tmpDay);
	}

}
