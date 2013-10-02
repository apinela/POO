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
package trabalho1.grupo1;

import static org.junit.Assert.fail;

import org.junit.Test;

public class DateTest {

	private static final int[] MONTH_DAYS_COMMON_YEAR = { 31, 28, 31, 30, 31,
			30, 31, 31, 30, 31, 30, 31 };
	private static final int[] MONTH_DAYS_LEAP_YEAR = { 31, 29, 31, 30, 31, 30,
			31, 31, 30, 31, 30, 31 };

	@Test
	public final void testDateIntIntInt() {
		try {
			for (int year = 2008; year < 2010; year++) {
				for (int month = 1; month < 13; month++) {
					for (int day = 1; day < ((Date.isLeapYear(year)) ? MONTH_DAYS_LEAP_YEAR[month - 1]
							: MONTH_DAYS_COMMON_YEAR[month - 1]) + 1; day++) {
						new Date(year, month, day);
					}
				}
			}
		} catch (Exception e) {
			fail(e.getMessage());
		}
	}

	@Test
	public final void testDateString() {
		try {
			for (int year = 2008; year < 2010; year++) {
				for (int month = 1; month < 13; month++) {
					for (int day = 1; day < ((Date.isLeapYear(year)) ? MONTH_DAYS_LEAP_YEAR[month - 1]
							: MONTH_DAYS_COMMON_YEAR[month - 1]) + 1; day++) {
						new Date(day + "-" + month + "-" + year);
					}
				}
			}
		} catch (Exception e) {
			fail(e.getMessage());
		}
	}

	@Test
	public final void testDate() {
		try {
			new Date();
		} catch (Exception e) {
			fail(e.getMessage());
		}
	}

	@Test
	public final void testToString() {
		try {
			System.out.println("Date.toString: " + new Date().toString());
		} catch (Exception e) {
			fail(e.getMessage());
		}
	}

	@Test
	public final void testEqualsDate() {
		try {
			System.out.println("Date.equals: "
					+ new Date().equals(new Date("01-01-2000")));
			System.out.println("Date.equals: " + new Date().equals(new Date()));
			System.out.println("Date.equals: "
					+ new Date().equals(new Date("01-01-2020")));
		} catch (Exception e) {
			fail(e.getMessage());
		}
	}

	@Test
	public final void testCompareTo() {
		try {
			System.out.println("Date.compareTo: "
					+ new Date("01-01-2010").compareTo(new Date("01-01-2000")));
			System.out.println("Date.compareTo: "
					+ new Date().compareTo(new Date()));
			System.out.println("Date.compareTo: "
					+ new Date("01-01-2010").compareTo(new Date("01-01-2020")));
			System.out.println("Date.compareTo: "
					+ new Date("22-03-2012").compareTo(new Date("14-03-2012")));
		} catch (Exception e) {
			fail(e.getMessage());
		}
	}

	@Test
	public final void testNextDate() {
		try {
			System.out.println("Date.nextDate: " + new Date().nextDate());
		} catch (Exception e) {
			fail(e.getMessage());
		}
	}

}
