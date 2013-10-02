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
package grupo2;

import grupo1.Date;

public class SimpleProduct extends Product {
	private String name;
	private double price;

	public SimpleProduct(String name, Date startDate, Date endDate, int price) {
		super(name, startDate, endDate);
		this.name = name;
		this.price = price;
	}

	public SimpleProduct(String name, Date startDate, int numberOfDays,
			int pricePerDay) {
		super(name, startDate, getEndDate(startDate, numberOfDays));
		this.name = name;
		this.price = numberOfDays * pricePerDay;
	}

	private static Date getEndDate(Date startDate, int numberOfDays) {
		Date tmpEndDate = startDate;
		for (int d = 0; d < numberOfDays; d++) {
			tmpEndDate = tmpEndDate.nextDate();
		}
		return tmpEndDate;
	}

	@Override
	public double getPrice() {
		return this.price;
	}

	@Override
	public String getDescription(String prefix) {
		return prefix + "De " + this.getStartDate() + " a " + this.getEndDate()
				+ ", " + this.name + ", " + (int) this.getPrice() + "€";
	}
}
