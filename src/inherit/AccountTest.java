package inherit;

public class AccountTest {
	
	public static void showBalance(AccountJava ac) {
		System.out.println(ac.getBalance());
	}
	
	public static void printAccount(AccountJava ac, Printer p ) {
		ac.print("from accounts");
		p.print("from printer class");
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SavingsAccount sa= new SavingsAccount("neha", 123, 10000);
		System.out.println(sa);
		sa.withdraw(4000);
		System.out.println(sa);
		
		CurrentAccount ca= new CurrentAccount("Niharika", 3455, 50000);
		System.out.println(ca);
		ca.withdraw(94000);
		System.out.println(ca);
		
		AccountJava ac= new SavingsAccount("Amit", 658, 300000);
		System.out.println(ac);
		ac.withdraw(94000);
		System.out.println(ac);
		
		showBalance(sa); //dynamic invocation
		
		ac.print("hello account");
		sa.print("from savings");
		ac.print("hello account");
		
		printAccount(ac,new ConsolePrinter());
		printAccount(ac, new FilePrinter());
		
	}

}
