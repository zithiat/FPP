package day05.prog53;

public class CheckingAccount extends Account {
	
	public CheckingAccount(double balance) {
		super(balance);
	}
	
	@Override
	public String getAcctType() {
		return "CHECKING";
	}
	
	@Override
	public double getBalance() {
		// $5 monthly service charge
		return super.getBalance() - 5;
	}
}
