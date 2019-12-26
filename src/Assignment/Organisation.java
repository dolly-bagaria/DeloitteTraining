package Assignment;

public class Organisation {
	
	static Employee[] emps= new Employee[5];
	static Department[] depts=new Department[3];
	static int c=0;
	
	public static void addEmployee(Employee e) {
		if(c<5) {
			emps[c++]=e;
		}
	}
	/*
	public static void printEmployees(String de) {
		System.out.println("employess belonging to department: "+ de);
		for(Employee e:emps) {
			if(e.dept.name == de)
				System.out.println(e.name);
		}
	}
	*/
	 public static void printEmployees(String dept)
	{
		System.out.println("employess belonging to department: "+ dept);
		
		
		for(Employee e:emps)
		{
			Department d=e.getDept();
			if(d!=null) {
				
			
			if(d.getName().equals(dept))
			{
				System.out.println(e.getName());
			}
			}
		}
		
	}
	
	public static void getDepartment(String empName) {
		System.out.println(empName+ " belongs to the following dept: ");
		for(Employee e: emps) {
			if(e.getName().equalsIgnoreCase(empName)) {
				System.out.println(e.getDept().getName());
			}
		}
	}
	 
	public static void employeeNoDept() {
		System.out.println("employees not belonging to any dept");
		for(Employee e: emps) {
			Department d=e.getDept();
			if(d==null) {
				System.out.println(e.getName());
			}
		}
	}

	public static void main(String[] args) {
		
		Department HR= new Department("HR","Hyd");
		Department Dev= new Department("Developer","Blr");
		Department Test= new Department("Test","Pune");
		
		depts[0]=HR;
		depts[1]=Dev;
		depts[2]=Test;
		
		Address a1= new Address(14,"AECS","blr","karnataka");
		Employee e1=new Employee("Akhil",a1, 132, HR);
		addEmployee(e1);
		
		Address a2= new Address(15,"itpl","blr","karnataka");
		Employee e2=new Employee("nikkhil",a2, 1, Dev);
		addEmployee(e2);
		
		Address a3= new Address(124,"hal","blr","karnataka");
		Employee e3=new Employee("neha",a3, 2, Dev);
		addEmployee(e3);
		
		Address a4= new Address(514,"kundal","blr","karnataka");
		Employee e4=new Employee("sneha",a4, 4, Dev);
		addEmployee(e4);
		
		Address a5= new Address(146,"marth","blr","karnataka");
		Employee e5=new Employee("amit",a5, 1, null);
		addEmployee(e5);
		
		printEmployees("HR");
		getDepartment("neha");
		employeeNoDept();
		//System.out.println(e1);
		//System.out.println(e2);

	}

}
