package day05.prog53;

public class SavingsAccount extends Account {

	public SavingsAccount(double balance) {
		super(balance);
	}
	
	@Override
	public String getAcctType() {
		return "SAVINGS";
	}
	
	@Override
	public double getBalance() {
		double baseBalance = super.getBalance();
		double interest = (0.25/100)*baseBalance;
		return baseBalance + interest;
	}
}
