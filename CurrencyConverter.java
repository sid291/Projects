package crt;
import java.util.Scanner;

public class CurrencyConverter {

	

	    // Method to convert from one currency to another
	    public static double convert(double amount, double rate) {
	        return amount * rate;
	    }

	    public static void main(String[] args) {
	        Scanner scanner = new Scanner(System.in);

	        // Display menu for currency options
	        System.out.println("Welcome to the Currency Converter");
	        System.out.println("Available Currencies:");
	        System.out.println("1. USD to EUR");
	        System.out.println("2. USD to GBP");
	        System.out.println("3. USD to INR");
	        System.out.println("4. EUR to USD");
	        System.out.println("5. GBP to USD");
	        System.out.println("6. INR to USD");

	        // Pre-defined exchange rates
	        double usdToEurRate = 0.94;
	        double usdToGbpRate = 0.78;
	        double usdToInrRate = 84.4;
	        double eurToUsdRate = 1.06;
	        double gbpToUsdRate = 1.27;
	        double inrToUsdRate = 0.012;

	        // User selects conversion type
	        System.out.print("Select an option (1-6): ");
	        int choice = scanner.nextInt();

	        // User enters amount to convert
	        System.out.print("Enter amount: ");
	        double amount = scanner.nextDouble();

	        // Convert based on the selected choice
	        double convertedAmount = 0;
	        switch (choice) {
	            case 1:
	                convertedAmount = convert(amount, usdToEurRate);
	                break;
	            case 2:
	                convertedAmount = convert(amount, usdToGbpRate);
	                break;
	            case 3:
	                convertedAmount = convert(amount, usdToInrRate);
	                break;
	            case 4:
	                convertedAmount = convert(amount, eurToUsdRate);
	                break;
	            case 5:
	                convertedAmount = convert(amount, gbpToUsdRate);
	                break;
	            case 6:
	                convertedAmount = convert(amount, inrToUsdRate);
	                break;
	            default:
	                System.out.println("Invalid option selected.");
	                scanner.close();
	                return;
	        }

	        // Output the result
	        System.out.println("Converted amount: " + convertedAmount);
	        scanner.close();
	    }
	}
