package day05.prog53;

public class RetirementAccount extends Account {

	public RetirementAccount(double balance) {
		super(balance);
	}
	
	@Override
	public String getAcctType() {
		return "RETIREMENT";
	}
	
	@Override
	public boolean makeWithdrawal(double amount) {
		double baseBalance = super.getBalance();
		if (amount > super.getBalance()) {
			System.out.println("Given amount is more than the current balance.");
			return false;
		} else  {
			super.setBalance(baseBalance - (amount + baseBalance * 0.02));
		}
		return true;
	}
}
