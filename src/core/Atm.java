package core;

public class Atm {
	
	private double withdrawLimit, totalAmount;
	int p=123;
	private Account acc;
	public Account getAcc() {
		return acc;
	}

	public void setAcc(Account acc) {
		this.acc = acc;
	}

	int c=0;


	

	public Atm(){
		withdrawLimit=4000;
		totalAmount=150000;
	
	}
	
	public double withdraw(double amt,int pin) {
		if(validatePin(pin)) {
			if(amt<=withdrawLimit) {
				if(amt< acc.getAccBalance()-Account.minBalance) {
					totalAmount-=amt;
					acc.setAccBalance(acc.getAccBalance()-amt);
				}
			}
			return amt;
		}
		return 0.0;
	}
	
	@Override
	public String toString() {
		return "Atm [totalAmount=" + totalAmount + "]";
	}

	public double deposit(double amt,int pin) {
		if(validatePin(pin)) {
			totalAmount+=amt;
			return amt;
		}
		return 0.0;
	}
	
	public boolean validatePin(int pin) {
		return acc.getAccPin()==pin;
	}
	
	/*public void addAccount(Account a) {
		
	}*/
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Atm atm=new Atm();
		
		Account p=new Account("amit",20000,1234);
		atm.setAcc(p);
		//atm.addAccount(p);
		atm.withdraw(3000,1234);
		atm.deposit(5000, 1234);
		System.out.println(atm);

		
	}

}
