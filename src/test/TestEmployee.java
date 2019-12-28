package test;

public class TestEmployee {
	static Employee[] emps= new Employee[4];
	static Department[] depts=new Department[3];
	static Role[] roles=new Role[3];
	//static boolean[] flag=new boolean[5];
	static int count_emp=0;
	static int count_dept=0;
	static int count_role=0;
	//static int c=0;
	
	public static void main(String[] args) {
		Department d1= new Department("HR","Hyd");
		Department d2= new Department("Developer","Blr");
		Department d3= new Department("Test","Pune");
		
		depts[0]=d1;
		depts[1]=d2;
		depts[2]=d3;
		
		Role r1= new Role("manager");
		Role r2= new Role("developer");
		Role r3=new Role("tester");
		roles[0]=r1;
		roles[1]=r2;
		roles[2]=r3;
		
		Employee m1= new Employee("Akhil",1,300000,r1,d3,null);
		addEmployee(m1);
		
		Employee m2= new Employee("Ram",2,300000,r1,d1,null);
		addEmployee(m2);
		
		Employee e3= new Employee("Neha",3,300000,r3,d3,m1);
		addEmployee(e3);
		
		Employee e4= new Employee("Rakesh",4,300000,r2,d1,m2);
		addEmployee(e4);
		
		System.out.println("======Task 1======");
		System.out.println("printing employee details");
		listEmployees();
		
		System.out.println("======Task 2======");
		System.out.println("printing employees given department");
		printEmployeesDept("HR");
		
		System.out.println("======Task 3======");
		System.out.println("printing employees given a role");
		printEmployeesRole("manager");
		
		System.out.println("======Task 4 & 5======");
		IncrementSalary("manager",10);
		System.out.println("===salary incremented of the following employees===");
		employeeIncrementSalary();
		
		System.out.println("======Task 6======");
		printEmployeesManager("Akhil");
	}
	
	public static void listEmployees() {
		for(Employee e:emps) {
			System.out.println(e);
		}
	}
	public static void printEmployeesDept(String dept)
	{
		System.out.println("employess belonging to department: "+ dept);
		
		
		for(Employee e:emps)
		{
			String d= e.getDepartment().getName();
			
			if(d.equals(dept))
			{
				System.out.println(e.getName());
			}
			
		}
		
	}
	public static void printEmployeesRole(String role)
	{
		System.out.println("employess belonging to role: "+ role);
		
		
		for(Employee e:emps)
		{
			String d= e.getRole().getName();
			
			if(d.equals(role))
			{
				System.out.println(e.getName());
			}
			
		}
		
	}
	public static void IncrementSalary(String r, int x) {
		for(Employee e: emps) {
			String role=e.getRole().getName();
			
			if(role.equalsIgnoreCase(r)) {
				
				e.setSalary(e.getSalary()+(e.getSalary()*x/100));
				//System.out.println(e.getName()+": "+e.getSalary());
				e.setSalaryInc(true);
			}
			
		}
	}
	public static void printEmployeesManager(String n)
	{
		System.out.println("employess under manager: "+ n);
		
		
		for(Employee e:emps)
		{
			if(e.getManager()!=null) {
			String manger=e.getManager().getName();
			
				if(manger.equalsIgnoreCase(n)) {
					System.out.println(e.getName());
				}
			}
		}
		
	}
	
	public static void employeeIncrementSalary()
	{
		
		for(Employee e:emps)
		{
			if(e.getSalaryInc())
				System.out.println(e);
			
		}
	}
	
	public static void addEmployee(Employee e) {
		if(count_emp<4) {
			emps[count_emp++]=e;
		}
	}
	
	
}
