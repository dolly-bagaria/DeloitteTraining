package test;

public class Employee {
	// An employee has a name, id, salary, role, department, manager
	private String name;
	private int id;
	private int salary;
	private Role role;
	private Department department;
	private Employee manager;
	boolean salaryInc=false;
	public Employee(String name, int id, int salary, Role role, Department department, Employee manager) {
		super();
		this.name = name;
		this.id = id;
		this.salary = salary;
		this.role = role;
		this.department = department;
		this.manager = manager;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}
	public Department getDepartment() {
		return department;
	}
	public void setDepartment(Department department) {
		this.department = department;
	}
	public Employee getManager() {
		return manager;
	}
	public void setManager(Employee manager) {
		this.manager = manager;
	}
	
	public boolean getSalaryInc() {
		return salaryInc;
	}
	public void setSalaryInc(boolean salaryInc) {
		this.salaryInc = salaryInc;
	}
	@Override
	public String toString() {
		return "Employee [name=" + name + ", id=" + id + ", salary=" + salary + ", role=" + role + ", department="
				+ department + ", manager=" + manager + "]";
	}
	
}
