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
