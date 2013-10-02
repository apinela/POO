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

import java.util.Arrays;

public class Filters {
	public static int ODD = 0;
	public static int EVEN = 1;

	public static int IS_IN_CRITERIA = 0;
	public static int IS_OUT_CRITERIA = 1;

	public static Student[] filterStudents(Student[] students,
			FilterCriteria criteria) {
		Student[] res = new Student[students.length];
		int resCount = 0;
		for (int i = 0; i < students.length; i++) {
			Student student = students[i];
			if (criteria.filter(student, i))
				res[resCount++] = student;
		}
		return Arrays.copyOfRange(res, 0, resCount);
	}

	public static Student[][] filterStudent(Student[] pooStudents) {
		OddFilterCriteria odd = new OddFilterCriteria();
		return seperate(pooStudents, odd);
	}

	public static Student[][] seperate(Student[] pooStudents,
			FilterCriteria criteria) {
		Student[] resInCriteria;
		Student[] resOutCriteria;
		Student[][] res = new Student[2][];

		NotFilterCriteria outCriteria = new NotFilterCriteria(criteria);

		resInCriteria = filterStudents(pooStudents, criteria);
		resOutCriteria = filterStudents(pooStudents, outCriteria);

		res[IS_IN_CRITERIA] = resInCriteria;
		res[IS_OUT_CRITERIA] = resOutCriteria;

		return res;
	}

	public static Student[][] filterStudentByCorse(Student[] iselStudents) {
		CourseFilterCriteria courseFilter = new CourseFilterCriteria(
				iselStudents[0].courseId);
		return seperate(iselStudents, courseFilter);

	}

}