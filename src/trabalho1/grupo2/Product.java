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
package trabalho1.grupo2;

import trabalho1.grupo1.Date;

public abstract class Product {

	private String name;
	private Date startDate;
	private Date endDate;

	public Product(String name, Date startDate, Date endDate) {
		this.name = name;
		this.startDate = startDate;
		this.endDate = endDate;
	}

	public String getDescription(String prefix) {
		return prefix + "De " + startDate + " a " + endDate + ", " + name;
	}

	public final String toString() {
		return getDescription("");
	}

	public abstract double getPrice();

	public Date getStartDate() {
		return startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

}
