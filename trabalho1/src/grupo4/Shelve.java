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

public class Shelve {
	private String location;
	private ShelveItem[] items;

	public Shelve(String loc, int maxItems) {
		this.location = loc;
		this.items = new ShelveItem[maxItems];
	}

	public boolean addItem(ShelveItem item) {
		for (int i = 0; i < items.length; i++) {
			if (items[i] == null) {
				items[i] = item;
				return true;
			}

		}
		return false;
	}

	public ShelveItem find(String name) {
		for (ShelveItem i : items) {
			if (i.match(name))
				return i;
		}
		return null;
	}

	public ShelveItem takeAway(String name) {
		ShelveItem tmpItem = find(name);
		if (tmpItem != null) {
			if (tmpItem.isAvaliable()) {
				tmpItem.setAvaliable(false);
				return tmpItem;
			}
		}
		return null;
	}

	public boolean restore(ShelveItem item) {
		for (ShelveItem i : items) {
			if (i.toString().split(":")[0].trim().equals(
					item.toString().split(":")[0].trim())
					&& i.toString().split(":")[1].trim().equals(
							item.toString().split(":")[1].trim())) {
				item.setAvaliable(true);
				return true;
			}
		}

		return addItem(item);
	}

}
