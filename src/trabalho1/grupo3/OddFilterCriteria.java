package trabalho1.grupo3;

public class OddFilterCriteria extends FilterCriteria {

	@Override
	boolean filter(Student student, int i) {
		if (i % 2 == 0) {
			return false;
		} else {
			return true;
		}
	}

}
