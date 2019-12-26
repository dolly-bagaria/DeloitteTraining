package core;

public class Student {
	
	private String name;
	private long rollNo;
	
	public Student(String name, long rollNo) {
		this.name=name;
		this.rollNo=rollNo;
	}
	
	

	@Override
	public String toString() {
		return "Student [name=" + name + ", rollNo=" + rollNo + "]";
	}



	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
