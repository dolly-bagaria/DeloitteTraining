package inherit;

public class SavingsAccount extends AccountJava {
	
	private static double MINIMUM=10000;

	public SavingsAccount(String name, int number, double balance) {
		super(name, number, balance);
		System.out.println("SavingsAccount constructor called");
		// TODO Auto-generated constructor stub
	}
	
	public void print(String s) {
		super.print(s);
	}
	@Override
	public void withdraw(double amount) {
		if(balance-amount >= MINIMUM) {
			balance-=amount;
		}
	}

}
