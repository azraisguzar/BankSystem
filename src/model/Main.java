package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		List<Account> accounts = new ArrayList<>();
		int choice;
		
		do {
            System.out.println("\n===== BANK MENU =====");
            System.out.println("1. Create Savings Account");
            System.out.println("2. Create Checking Account");
            System.out.println("3. Deposit Money");
            System.out.println("4. Withdraw Money");
            System.out.println("5. Show Account Info");
            System.out.println("6. Calculate Interest (Savings only)");
            System.out.println("7. List All Accounts");
            System.out.println("0. Exit");
            System.out.print("Choice: ");
            choice = Integer.parseInt(input.nextLine());
            
            
            switch(choice) {
               
            case 1:
            	 System.out.print("Account Number: ");
                 String accNum1 = input.nextLine();
                 System.out.print("Owner Name: ");
                 String owner1 = input.nextLine();
                 System.out.print("Initial Balance: ");
                 double balance1 = Double.parseDouble(input.nextLine());
                 System.out.print("Interest Rate (e.g. 0.05 for 5%): ");
                 double rate = Double.parseDouble(input.nextLine());
                 accounts.add(new SavingsAccount(accNum1, owner1, balance1, rate));
                 System.out.println("Savings account created.");
                 break;
                 
            case 2: 
                System.out.print("Account Number: ");
                String accNum2 = input.nextLine();
                System.out.print("Owner Name: ");
                String owner2 = input.nextLine();
                System.out.print("Initial Balance: ");
                double balance2 = Double.parseDouble(input.nextLine());
                System.out.print("Overdraft Limit: ");
                double overdraft = Double.parseDouble(input.nextLine());
                accounts.add(new CheckingAccount(accNum2, owner2, balance2, overdraft));
                System.out.println("Checking account created.");
                break;
           
            case 3:
                System.out.print("Account Number: ");
                String depAccNum = input.nextLine();
                Account depAcc = findAccount(accounts, depAccNum);
                if (depAcc != null) {
                    System.out.print("Amount to deposit: ");
                    double depAmount = Double.parseDouble(input.nextLine());
                    depAcc.deposit(depAmount);
                    System.out.println("Deposit successful. New balance: " + depAcc.getBalance());    
          
               }else {
                    System.out.println("Account not found.");
               }
               break;
               
            case 4: 
            	 System.out.print("Account Number: ");
                 String wAccNum = input.nextLine();
                 Account wAcc = findAccount(accounts, wAccNum);
                 if (wAcc != null) {
                     System.out.print("Amount to withdraw: ");
                     double wAmount = Double.parseDouble(input.nextLine());
                     wAcc.withdraw(wAmount);
                 } else {
                     System.out.println("Account not found.");
                 }
                 break;
                 
            case 5:
            	 System.out.print("Account Number: ");
                 String infoAccNum = input.nextLine();
                 Account infoAcc = findAccount(accounts, infoAccNum);
                 if (infoAcc != null) {
                     infoAcc.showAccountType();
                     System.out.println("Owner: " + infoAcc.getOwnerName());
                     System.out.println("Balance: " + infoAcc.getBalance());
                 } else {
                     System.out.println("Account not found.");
                 }
                 break;
                 
            case 6:
                System.out.print("Account Number: ");
                String intAccNum = input.nextLine();
                Account intAcc = findAccount(accounts, intAccNum);
                if (intAcc instanceof InterestBearing) {
                    InterestBearing ib = (InterestBearing) intAcc;
                    System.out.println("Interest earned: " + ib.calculateInterest());
                } else {
                    System.out.println("This account does not earn interest.");
                }
                break;  
                
            case 7:
                System.out.println("---- All Accounts ----");
                for (Account a : accounts) {
                    a.showAccountType();
                    System.out.println("  Account Number: " + a.getAccountNumber());
                    System.out.println("  Owner: " + a.getOwnerName());
                    System.out.println("  Balance: " + a.getBalance());
                }
                break;
                
            case 0:
                System.out.println("Exiting...");
                break;

            default:
                System.out.println("Invalid choice.");
           }    
		}   while (choice != 0);
 
        input.close();

	}
	 private static Account findAccount(List<Account> accounts, String accountNumber) {
	        for (Account a : accounts) {
	            if (a.getAccountNumber().equals(accountNumber)) {
	                return a;
	            }
	        }
	        return null;
	    }

}
