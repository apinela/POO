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

public class Collection extends ShelveItem {

	private ShelveItem[] collection;

	public Collection(String n, int stand, int numItems) {
		super(n, stand);
		this.collection = new ShelveItem[numItems];
	}

	@Override
	public boolean isOfSameType(ShelveItem item) {
		return false;
	}

	public boolean add(ShelveItem item) throws IllegalArgumentException {

		for (ShelveItem i : collection) {
			if (!i.isOfSameType(item))
				throw new IllegalArgumentException();
		}

		for (int i = 0; i < collection.length; i++) {
			if (collection[i] == null) {
				collection[i] = item;
				return true;
			}

		}

		return false;
	}

	public boolean isAvailable() {

		for (ShelveItem i : collection) {
			if (!i.isAvaliable())
				return false;
		}

		return true;
	}

	public void setAvailable(boolean state) {
		for (ShelveItem i : collection) {
			i.setAvaliable(state);
		}
	}

}
