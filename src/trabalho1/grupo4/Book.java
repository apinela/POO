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
package trabalho1.grupo4;

public class Book extends ShelveItem {

	private String authors;

	public Book(String n, int stand, String authors) {
		super(n, stand);
		this.authors = authors;
	}

	@Override
	public boolean isOfSameType(ShelveItem item) {
		return item.getClass().getName().equals(this.getClass().getName());
	}

	public String toString() {
		return super.toString() + ": " + authors;
	}

}
