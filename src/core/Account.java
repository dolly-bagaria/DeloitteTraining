package core;

public class Account {
	
	String accHolder;
	double accBalance;
	int accPin;
	public static final double minBalance=10000;
	public String getAccHolder() {
		return accHolder;
	}

	public Account(String accHolder, int accBalance, int accPin) {
		super();
		this.accHolder = accHolder;
		this.accBalance = accBalance;
		this.accPin = accPin;
	}

	public void setAccHolder(String accHolder) {
		this.accHolder = accHolder;
	}

	public int getAccPin() {
		return accPin;
	}

	public void setAccPin(int accPin) {
		this.accPin = accPin;
	}

	public double getAccBalance() {
		return accBalance;
	}

	@Override
	public String toString() {
		return "Account [accHolder=" + accHolder + ", accBalance=" + accBalance + ", accPin=" + accPin + "]";
	}

	public void setAccBalance(double accBalance) {
		this.accBalance = accBalance;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}

}
