package model;

public class CheckingAccount extends Account {
	
	private double overdraftLimit;
	
	public CheckingAccount(String accountNumber, String ownerName, double balance, double overdraftLimit) {
		super(accountNumber,ownerName,balance);
		this.overdraftLimit = overdraftLimit;
	}
	public double getOverdraftLimit() {
		return overdraftLimit;
	}
	@Override
	public void showAccountType() {
	    System.out.println("This is a Checking Account.");
	}
	

}
