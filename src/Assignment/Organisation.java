package Assignment;

public class Organisation {

	public static void main(String[] args) {
		
		Department HR= new Department("HR","Hyd");
		Department Dev= new Department("Developer","Blr");
		Department Test= new Department("Test","Pune");
		
		Address a1= new Address(14,"AECS","blr","karnataka");
		Employee e1=new Employee("Akhil",a1, 132, HR);
		
		Address a2= new Address(15,"itpl","blr","karnataka");
		Employee e2=new Employee("nikkhil",a2, 1, Dev);
		
		Address a3= new Address(124,"hal","blr","karnataka");
		Employee e3=new Employee("neha",a3, 2, Dev);
		
		Address a4= new Address(514,"kundal","blr","karnataka");
		Employee e4=new Employee("sneha",a4, 4, Dev);
		
		Address a5= new Address(146,"marth","blr","karnataka");
		Employee e5=new Employee("amit",a5, 1, Test);
		
		System.out.println(e1);
		System.out.println(e2);

	}

}
