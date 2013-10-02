/*******************************************************************************
 * Copyright (c) 2013 Andr� Pinela - ISEL Student 38603.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the GNU Public License v3.0
 * which accompanies this distribution, and is available at
 * http://www.gnu.org/licenses/gpl.html
 * 
 * Contributors:
 *     Andr� Pinela - ISEL Student 38603 - initial API and implementation
 ******************************************************************************/
package grupo3;

public class CourseFilterCriteria extends FilterCriteria {

	private int courseId;

	public CourseFilterCriteria(int courseId) {
		this.courseId = courseId;
	}

	@Override
	boolean filter(Student student, int i) {
		if (student.courseId == this.courseId)
			return true;
		return false;
	}

}
