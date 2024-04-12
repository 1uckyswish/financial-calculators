package com.pluralsight;

import java.util.Scanner;

public class FinancialCalculators {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        promptUserCalculators(scanner);
    }

    public static void mortgageCalculator (Scanner scanner) {
        System.out.println("Welcome to the Mortgage Calculator!");

        // Prompt user for input
        System.out.println("Please enter the following information:");
        double principle = 0;
        int years = 0;
        double interest = 0;

        try {
            System.out.print("Loan Amount (principle): ");
            principle = scanner.nextDouble();

            System.out.print("Loan Term (years): ");
            years = scanner.nextInt();

            System.out.print("Annual Interest Rate: ");
            interest = scanner.nextDouble();
        } catch (Exception e) {
            System.out.println("Invalid input. Please enter a valid number.");
            // Call the method again to prompt user for input
            //since the user typed a string then we need to fix the buffer error
            scanner.nextLine();
            mortgageCalculator(scanner);
            return; // Exit the method so it doesnt stay stuck in error message
        }

        double monthlyInterestRate = interest / 1200;
        int payments = years * 12;
        double monthlyMortgagePayment = principle * (monthlyInterestRate * Math.pow(1 + monthlyInterestRate, payments)) / (Math.pow(monthlyInterestRate + 1, payments) - 1);

        System.out.printf("Your monthly payment will be $%.2f \n", monthlyMortgagePayment);

        double totalLoan = payments * monthlyMortgagePayment;
        double totalInterest = totalLoan - principle;

        System.out.printf("This loan will cost you $%.2f \n", totalLoan);
        System.out.printf("The total interest is $%.2f\n", totalInterest);
        thankUserAndRepeat(scanner);
    }

    public static void futureValue (Scanner scanner) {
        //A = P(1 + r/n)^nt formula:
        System.out.println("Welcome to the Future Value Calculator!");
        // Prompt user for input
        System.out.println("Please enter the following information:");


        double principle = 0;
        double interestRate = 0;
        int time = 0;

        try {
            System.out.print("Initial Balance (Principle): ");
            principle = scanner.nextDouble(); // Initial balance

            System.out.print("Annual Interest Rate (%): ");
            interestRate = scanner.nextDouble() / 100; // Convert interest rate to decimal

            System.out.print("Time in Years: ");
            time = scanner.nextInt(); // Time in years
        } catch (Exception e) {
            System.out.println("Invalid input. Please enter a valid number.");
            scanner.next(); // Clear the scanner buffer
            futureValue(scanner); // Call the method again to prompt user for input
            return; // Exit the method
        }

        // Calculate future value
        int number = 365;
        double nt = number * time;
        double balance = principle * Math.pow((1 + interestRate / number), nt);

        // Calculate total interest earned
        double totalInterest = balance - principle;

        System.out.printf("Your ending balance is $%.2f \n", balance);
        System.out.printf("Total interest earned is $%.2f\n", totalInterest);
        thankUserAndRepeat(scanner);
    }

    public static void presentValueCalculator (Scanner scanner) {
        System.out.println("Welcome to the Present Value Calculator!");
        // prompt for input
        System.out.println("Please enter the following information:");
        double monthly = 0;
        double years = 0;
        double interest = 0;

        try{
            System.out.print("Monthly Payment: ");
             monthly = scanner.nextDouble();
            System.out.print("Number of Periods (in years): ");
             years = scanner.nextDouble();
            System.out.print("Annual Interest Rate (%): ");
            interest = scanner.nextDouble() / 1200; // Convert interest rate to decimal
        }catch (Exception e){
            System.out.println("Invalid input. Please enter a valid number.");
            scanner.next(); // Clear the scanner buffer
            presentValueCalculator(scanner); // Call the method again to prompt user for input
            return; // Exit the method
        }

        // convert the 20 years into monthly payments which is 240
        double periods = years * 12; // Convert years to monthly periods


        double value = monthly * (1 - Math.pow((1 + interest), -periods)) / interest;
        System.out.printf("total annunity $%.2f ", value);
        thankUserAndRepeat(scanner);
    }

    public static void promptUserCalculators(Scanner scanner){
        System.out.println("**** Hello and Welcome to Java Financial ****");
        System.out.println("Which calculation do you need to get done?\n");
        System.out.println("(A) Mortgage Calculator\n" +
                "(B) Future Value Calculator\n" +
                "(C) Present Value Calculator");
        System.out.print("Select one of the three above to continue: ");
        String userChoice = scanner.next();
        switch (userChoice.toUpperCase()){
            case "A":
                 mortgageCalculator(scanner); return;
            case "B":
                futureValue(scanner); return;
            case "C":
                presentValueCalculator(scanner);return;
            default:
                System.out.println("*** Sorry, please choose one of the three options above *** \n");
                promptUserCalculators(scanner);
                return;
        }

    }

    public static void thankUserAndRepeat(Scanner scanner){
        System.out.println("Thank you for using Java Financial");
        System.out.print("Do you need help with anything else? (yes/no) ");
        String userChoice = scanner.next();
        if(!userChoice.equalsIgnoreCase("yes") && !userChoice.equalsIgnoreCase("no")){
            System.out.println("**** Please type either (yes/no) thank you ****\n");
            thankUserAndRepeat(scanner);
        }else if(userChoice.equalsIgnoreCase("yes")){
            promptUserCalculators(scanner);
        }else{
            System.out.println("Bye now don't hesitate to reach out again if needed - Java Financial EST 1995");
        }
    }

}
