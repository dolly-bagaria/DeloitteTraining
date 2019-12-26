package Assignment;

public class Employee extends person {

	protected int id;
	protected Department dept;
	
	public Employee(String name, int id, Department dept) {
		super(name);
		this.id=id;
		this.dept=dept;
		// TODO Auto-generated constructor stub
	}

	public Employee(String name, Address addr, int id, Department dept) {
		super(name,addr);
		this.id=id;
		this.dept=dept;
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Department getDept() {
		return dept;
	}

	public void setDept(Department dept) {
		this.dept = dept;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", dept=" + dept + "]";
	}
	

}
