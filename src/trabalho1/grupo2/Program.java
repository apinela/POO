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
	private String name;
	private Product[] products;
	private Date startDate = null;
	private Date endDate = null;
	private double price;

	public Program(String name, int capacity, Product first) {
		super(name, first.getStartDate(), first.getEndDate());
		this.name = name;
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
				else if (product.getStartDate().compareTo(startDate) < 0)
					startDate = product.getStartDate();

				if (endDate == null)
					endDate = product.getEndDate();
				else if (product.getEndDate().compareTo(endDate) > 0)
					endDate = product.getEndDate();

				return true;
			}
		}

		return false;

	}

	@Override
	public double getPrice() {
		price = 0;
		for (Product p : products) {
			price += p.getPrice();
		}
		return price;
	}

	public String getDescription(String prefix) {
		StringBuilder sb = new StringBuilder();

		sb.append(prefix + "De " + startDate + " a " + endDate + ", " + name
				+ "\n");

		for (Product p : products) {
			sb.append(prefix + p.getDescription("  ") + "\n");
		}

		sb.append(prefix + "TOTAL: " + (int) getPrice() + "€");

		return sb.toString();
	}

}
