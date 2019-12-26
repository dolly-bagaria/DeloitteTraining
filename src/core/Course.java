package core;

public class Course {
	
	private Student[] stud;
	private String sub1,sub2;
	
	private int counter=0;
	private int limit=3;
	private int numCourses=0;

	private Course[] courses=new Course[1];
	
	public Course(String sub1, String sub2){
		//super();
		this.sub1=sub1;
		this.sub2=sub2;
		stud= new Student[limit];
	}
	
	public void addCourse(Course c) {
		if(numCourses<limit)
			courses[numCourses++]=c;
		else
			System.out.println("course is full");
	}
	public void addStudent(Student st) {
		if(counter<limit)
			stud[counter++]=st;
		else
			System.out.println("course is full");
	}
	
	public void display() {
		for(Student p: stud) {
			System.out.println(p);
		}
	}
	
	public void printStudentNames(String subject) {
		for(Course c: courses) {
			if(c.sub1.equalsIgnoreCase(subject) || c.sub2.equalsIgnoreCase(subject)) {
				for(Student st1: c.stud) {
					System.out.println(st1);
				}
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Course phy=new Course("mech","wave theory");
		phy.addStudent(new Student("amit",123456));
		phy.addStudent(new Student("ramesh",43512));
		phy.display();
		phy.addCourse(phy);
		phy.printStudentNames("mech");
		
	}

}
