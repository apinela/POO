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

public class Program extends Product {
	private Product[] products;
	private Date startDate = null;
	private Date endDate = null;

	public Program(String name, int capacity, Product first) {
		super(name, first.getStartDate(), first.getEndDate());
		this.products = new Product[capacity];

		addProduct(first);
	}

	public boolean addProduct(Product product) throws IllegalArgumentException {

		if (product == null)
			throw new IllegalArgumentException();

		for (int i = 0; i < products.length; i++) {
			if (products[i] == null) {
				products[i] = product;
				if (startDate == null)
					startDate = product.getStartDate();
				else if (product.getStartDate().compareTo(startDate) > 0)
					startDate = product.getStartDate();

				if (endDate == null)
					endDate = product.getEndDate();
				else if (product.getEndDate().compareTo(endDate) < 0)
					endDate = product.getEndDate();

				return true;
			}
		}

		return false;

	}

	@Override
	public double getPrice() {
		// TODO Auto-generated method stub
		return (Double) null;
	}

	public String getDescription(String prefix) {
		int i = 0;
		StringBuilder sb = new StringBuilder();
		sb.append("De " + startDate + " a " + endDate + ", " + name);
		do {
			sb.append(prefix + "\t" + "De " + products[i].getStartDate()
					+ " a " + products[i].getEndDate() + ", "
					+ products[i].name + ", " 
					+ (int) products[i].getPrice()
					+ "€");
			i++;
		} while (products[i] != null);

		return sb.toString();
	}

}
