package trabalho1.grupo3;

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