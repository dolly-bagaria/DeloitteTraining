package compare;

public class EmployeeTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Employee e1= new Employee("akhil", 123);
		Employee e2= new Employee("akhil", 456);
		
		System.out.println(e1.equals(e2));
		
	}

}
