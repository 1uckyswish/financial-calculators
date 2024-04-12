package com.pluralsight;

public class FinancialCalculators {
    public static void main(String[] args) {
//        mortgageCalculator();
        futureValue();
//        presentValueCalculator();
    }

    public static void mortgageCalculator () {
        double principle = 53000;
        int years = 15;
        double interest = 7.625;

        double monthlyInterestRate = interest / 1200;
        int payments = years * 12;
        double monthlyMortgagePayment =
                principle * (monthlyInterestRate * Math.pow(1 + monthlyInterestRate, payments))
                        / (Math.pow(monthlyInterestRate + 1, payments) - 1);

        System.out.printf("Your monthly payment will be $%.2f \n", monthlyMortgagePayment);

        double totalLoan = payments * monthlyMortgagePayment;
        double totalInterest = totalLoan - principle;

        System.out.printf("This loan will cost you $%.2f \n", totalLoan);
        System.out.printf("The total interest is $%.2f", totalInterest);
    }

    public static void futureValue () {
        //        A = P(1 + r/n)^nt, where:
//
//        A = ending amount (this means original balance plus all interest earned after n years).
//
//                P = original balance (or your initial deposit, since there are typically no other contributions to CDs).
//
//                r = interest rate (as a decimal)*.
//
//        n = number of times interest is compounded per year (typically 365 for daily, 12 for monthly, 4 for quarterly).
//
//        t = time (in years).
        double principle = 1000; // Initial balance
        double interestRate = 1.75 / 100; // Annual interest rate (as a decimal)
        int time = 5; // Time in years
        int number = 365; // Number of times interest is compounded per year (daily in this case)

        double nt = number * time;
        double balance = principle * Math.pow((1 + interestRate / number), nt);

        double totalInterest = balance - principle;

        System.out.printf("Your ending balance is $%.2f \n", balance);
        System.out.printf("Total interest earned is $%.2f\n", totalInterest);
    }

    public static void presentValueCalculator () {
        double monthly = 3000;
        double periods = 20 * 12; // convert the 20 years into monthly payments which is 240
        double interest = 2.5 / 1200;

        double value = monthly * (1 - Math.pow((1 + interest), -periods)) / interest;
        System.out.printf("total annunity $%.2f ", value);
    }

}
