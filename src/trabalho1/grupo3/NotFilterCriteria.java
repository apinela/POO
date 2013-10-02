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
package trabalho1.grupo3;

public class NotFilterCriteria extends FilterCriteria {

	private FilterCriteria inverseCriteria;

	public NotFilterCriteria(FilterCriteria inverseCriteria) {
		this.inverseCriteria = inverseCriteria;
	}

	@Override
	boolean filter(Student student, int i) {
		return !this.inverseCriteria.filter(student, i);
	}

}
