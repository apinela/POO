package trabalho1.grupo3;

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
