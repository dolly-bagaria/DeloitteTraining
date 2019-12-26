package inherit;

public class CurrentAccount extends AccountJava {

	//private static double MINIMUM=0;
	
	public CurrentAccount(String name, int number, double balance) {
		super(name, number, balance);
		System.out.println("CurrentAccount constructor called");
	}

	@Override
	public void withdraw(double amount) {
		if(amount <= balance) {
			balance-=amount;
		}
	}
	
	
			
	}
