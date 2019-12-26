package core;

public class HelloWorld {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String hello="Hello World!!";
		System.out.println(hello);
		int len= hello.length();
		System.out.println("length: "+ len);
		System.out.println("is it true: "+ (len==13));
		System.out.println("ASCII values of A-Z");
		for(int i='A';i<='Z';i++)
		{
			System.out.print(i+" ");
		}
		System.out.println("\nASCII values of a-z");
		for(int i='a';i<='z';i++)
		{
			System.out.print(i+" ");
		}
		System.out.println("\nASCII values of 0-9");
		for(int i='0';i<='9';i++)
		{
			System.out.print(i+" ");
		}
		
		
	}
	
	
}
