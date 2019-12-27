package collection;

import java.util.Comparator;

public class StudentRollSorter implements Comparator<Student>{

	@Override
	public int compare(Student o1, Student o2) {
		// TODO Auto-generated method stub
		return o1.getRoll()-o2.getRoll();
	}

}
