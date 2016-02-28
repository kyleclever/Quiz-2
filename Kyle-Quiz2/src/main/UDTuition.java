package main;

import java.util.Scanner;

public class UDTuition {

	static Scanner reader = new Scanner(System.in);

	// initial variables
	static double InitialTuition;
	static double percentage_increases;
	static double fixedAPR;
	static int YearsRepay;
	static double loan;
	static double total;

	private static void getInput() {
		// Ask for inputs into variables
		System.out.println("How much is your initial tuition cost per year? ");
		InitialTuition = reader.nextDouble();

		System.out.println("Enter the percentage increases for tuition: ");
		percentage_increases = reader.nextDouble();

		System.out.println("Enter the fixed APR for your student loan as a percentage: ");
		fixedAPR = reader.nextDouble();

		System.out.println("How many years do you plan to pay back after graduation? ");
		YearsRepay = reader.nextInt();
	}

	public static double monthlypayment() {
		// first; second; third; fourth year cost Note: assume UD increase rate
		// annually
		double FirstYearTuition = InitialTuition;
		double SecondYearTuition = InitialTuition * (1 + percentage_increases / 100);
		double ThirdYearTuition = SecondYearTuition * (1 + percentage_increases / 100);
		double FourthYear = ThirdYearTuition * (1 + percentage_increases / 100);

		// sum up all 4 years cost
		loan = FirstYearTuition + SecondYearTuition + ThirdYearTuition + FourthYear;
		System.out.printf("Your total UD tuition is: $ %.2f ", loan);

		// total amount need to pay back after graduation (added interest)
		double total = 0;
		double annualInterest1;
		double annualInterest2;
		double annualInterest3;
		double annualInterest4;

		// interest accumulate from year 1

		for (int i = 1; i < 5; i++) {
			annualInterest1 = FirstYearTuition * Math.pow((1 + fixedAPR / 100), i);
			total += annualInterest1;
		}
		// interest accumulate from year 2
		for (int i = 1; i < 4; i++) {
			annualInterest2 = SecondYearTuition * Math.pow((1 + fixedAPR / 100), i);
			total += annualInterest2;
		}
		// interest accumulate from year 3
		for (int i = 1; i < 3; i++) {
			annualInterest3 = ThirdYearTuition * Math.pow((1 + fixedAPR / 100), i);
			total += annualInterest3;
		}
		// interest accumulate from year 4
		for (int i = 1; i < 2; i++) {
			annualInterest4 = FourthYear * Math.pow((1 + fixedAPR / 100), i);
			total += annualInterest4;
		}
		System.out.printf("\nAfter graducation, you will have debt: $ %.2f", total);

		// calculate monthly payment Note: interest compound monthly
		double monthlyPayment;
		// monthlyPayment = (total * (fixedAPR / 1200)) / (1 - Math.pow(1 +
		// (fixedAPR / 1200), -(YearsRepay * 12)));
		monthlyPayment = total
				* (((fixedAPR / 100) / 12) / ((Math.pow(1 + (fixedAPR / 100) / 12, YearsRepay * 12)) - 1));

		System.out.printf("\nIf you start to pay back after graduation in " + YearsRepay + " years, "
				+ "you must monthly pay $ %.2f", monthlyPayment);

		double totalPayment = total + monthlyPayment * 12 * YearsRepay;
		double totalInterestPaid = totalPayment - loan;
		double percentage = 100 * totalInterestPaid / totalPayment;
		System.out.printf("\nTotal payment: $ %.2f", totalPayment);
		System.out.printf(" and %.2f", percentage);
		System.out.println(" percentage is the interest");
		
		return monthlyPayment;
	}

	public static void main(String[] args) {
		// execute all code
		getInput();
		monthlypayment();
	}

}
