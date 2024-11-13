package crt;

import java.util.Scanner;

public class BankingSystem {
	    // Inner Account class to handle account operations
	    static class Account {
	        private String accountHolder;
	        private double balance;

	        // Constructor to initialize account holder and starting balance
	        public Account(String accountHolder, double initialBalance) {
	            this.accountHolder = accountHolder;
	            this.balance = initialBalance;
	        }

	        // Method to check balance
	        public double getBalance() {
	            return balance;
	        }

	        // Method to deposit money
	        public void deposit(double amount) {
	            if (amount > 0) {
	                balance += amount;
	                System.out.println("Successfully deposited: $" + amount);
	            } else {
	                System.out.println("Invalid deposit amount.");
	            }
	        }

	        // Method to withdraw money
	        public void withdraw(double amount) {
	            if (amount > 0 && amount <= balance) {
	                balance -= amount;
	                System.out.println("Successfully withdrew: $" + amount);
	            } else if (amount > balance) {
	                System.out.println("Insufficient funds.");
	            } else {
	                System.out.println("Invalid withdrawal amount.");
	            }
	        }
	    }

	    public static void main(String[] args) {
	        Scanner scanner = new Scanner(System.in);

	        // Create a new account with an initial balance
	        System.out.print("Enter account holder name: ");
	        String accountHolder = scanner.nextLine();
	        System.out.print("Enter initial balance: ");
	        double initialBalance = scanner.nextDouble();

	        Account account = new Account(accountHolder, initialBalance);

	        // Display the menu
	        while (true) {
	            System.out.println("\n--- Banking System ---");
	            System.out.println("1. Check Balance");
	            System.out.println("2. Deposit");
	            System.out.println("3. Withdraw");
	            System.out.println("4. Exit");
	            System.out.print("Choose an option: ");
	            int choice = scanner.nextInt();

	            switch (choice) {
	                case 1:
	                    System.out.println("Current Balance: $" + account.getBalance());
	                    break;
	                case 2:
	                    System.out.print("Enter amount to deposit: ");
	                    double depositAmount = scanner.nextDouble();
	                    account.deposit(depositAmount);
	                    break;
	                case 3:
	                    System.out.print("Enter amount to withdraw: ");
	                    double withdrawAmount = scanner.nextDouble();
	                    account.withdraw(withdrawAmount);
	                    break;
	                case 4:
	                    System.out.println("Thank you for using the banking system. Goodbye!");
	                    scanner.close();
	                    System.exit(0);
	                    break;
	                default:
	                    System.out.println("Invalid option. Please try again.");
	            }
	        }
	    }
	}
