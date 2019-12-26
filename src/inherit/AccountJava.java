package inherit;

public abstract class AccountJava implements Printer {
	
	protected String name;
	protected int number;
	protected double balance;


	public AccountJava(String name, int number, double balance) {
		super();
		this.name = name;
		this.number = number;
		this.balance = balance;
		System.out.println("account constructor called");
	}
	
	
	public void print(String s) {
		System.out.println("printing account info");
		
	}
	public abstract void withdraw(double amount);
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	@Override
	public String toString() {
		return "AccountJava [name=" + name + ", number=" + number + ", balance=" + balance + "]";
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
