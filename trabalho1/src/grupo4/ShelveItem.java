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
package grupo4;

public abstract class ShelveItem {
	private final String name; // Nome do elemento
	private int stand; // Prateleira em que se encontra
	private boolean isAvailable = true; // Indica se o elemento está disponível

	public ShelveItem(String n, int stand) {
		this.name = n;
		this.stand = stand;
	}

	public boolean match(String n) {
		return name.equals(n);
	}

	public boolean isAvaliable() {
		return isAvailable;
	}

	public void setAvaliable(boolean state) {
		isAvailable = state;
	}

	public String toString() {
		return stand + ": " + name;
	}

	public abstract boolean isOfSameType(ShelveItem item);
}
