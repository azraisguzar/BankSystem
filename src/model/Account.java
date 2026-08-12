package model;

public abstract class Account {
	private String accountNumber;
	private String ownerName;
	private double balance;
	
	public Account(String accountNumber, String ownerName, double balance) {
		this.accountNumber = accountNumber;
		this.ownerName = ownerName;
		this.balance = balance;
	}
	
	public String getAccountNumber() {
		return accountNumber;
	}
	
	public String getOwnerName() {
		return ownerName;
	}
	
	public double getBalance() {
		return balance;
	}
	public void deposit(double amount) {
		balance += amount;
	}
	public void withdraw(double amount) {
		if(amount>balance) {
			System.out.println("Insufficient balance");
		}else {
			balance -= amount;
		}
		
	}
	
	public abstract void showAccountType();
	

}
