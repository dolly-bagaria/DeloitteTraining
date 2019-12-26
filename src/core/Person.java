package core;

public class Person {
	
	private String name;
	private long mobileNumber;
	private static int instances=0;
	
	//default or no-arg constructor (used to create instances of this class)
	public Person() {
		++instances;
	}
	
	//1-args constructor
	public Person(String name) {
		this(name,0L);
		//this.name=name;
	}
	
	//2-args constructor
	public Person(String name, long number) {
		this();
		this.name=name;
		mobileNumber=number;
	}
	
	//setter or mutator
	public void setName(String name) {
		this.name=name;
	}
	
	//getter or accessor
	public String getName() {
		return name;
	}
	
	public long getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(long num) {
		mobileNumber=num;
	}
	
	@Override
	public String toString() {
		return name+": "+mobileNumber;
	}

	public static void main(String[] args) {
		Person neha= new Person();
		neha.setName("Neha Murk");
		neha.setMobileNumber(1111111111);
		
		System.out.println(neha.getName());
		System.out.println(neha.getMobileNumber());
		System.out.println(neha.toString());
		
		Person sneha= new Person();
		sneha.setName("Sneha rask");
		sneha.setMobileNumber(5485111);
		
		System.out.println(sneha.getName()+" : "+ sneha.getMobileNumber());
		
		
		System.out.println("count: "+ instances);
		
		Person Ramesh=new Person("Ram",16525);
		System.out.println(Ramesh);
		
		Person doll= new Person("Dolly");
		doll.setMobileNumber(157865);
		System.out.println(doll);
		
		System.out.println("count: "+ instances);
		
				
	}

}
