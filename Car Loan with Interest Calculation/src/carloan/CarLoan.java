package carloan;
import java.awt.*;

import java.awt.event.*;

import java.util.Scanner;

import javax.swing.*;

//Class CarLoan definition

public class CarLoan

{

//Instance variable to store data

private double yearlyInterestRate;

private int numOfYears;

private double totalLoan;

//Component and container object declared

JFrame jf;

JPanel jp1, jp2, jp3, jp4, jp5, jp6, main;

JLabel lYear, lInterest, lTot, lMonthly, lFinalPay;

JTextField tYear, tInterest, tTot, tMonthly, tFinalPay;

JButton jbOK;

//Default constructor

public CarLoan()

{

//Initializes instance variables

yearlyInterestRate = 0;

numOfYears = 0;

totalLoan = 0;

//Initializes component and container objects

jf = new JFrame("Car Loan Calculator");

lTot = new JLabel("\n Enter car loan amount: ");

lYear = new JLabel("\n Enter number of years: ");

lInterest = new JLabel("\n Enter interest rate: ");

lMonthly = new JLabel("\n Monthly interest: ");

lFinalPay = new JLabel("\n Total loan with interest: ");

tYear = new JTextField(10);

tInterest = new JTextField(10);

tTot = new JTextField(10);

tMonthly = new JTextField(20);

tFinalPay = new JTextField(20);;

jbOK = new JButton("CALCULATE");

jp1 = new JPanel();

jp2 = new JPanel();

jp3 = new JPanel();

jp4 = new JPanel();

jp5 = new JPanel();

jp6 = new JPanel();

main = new JPanel();

//Set the layout of main panel to grid layout with 6 rows and 2 columns

main.setLayout(new GridLayout(6, 2));

//Adds the components to JPanel

jp1.add(lTot);

jp1.add(tTot);

jp2.add(lYear);

jp2.add(tYear);

jp3.add(lInterest);

jp3.add(tInterest);

jp4.add(lMonthly);

jp4.add(tMonthly);

jp5.add(lFinalPay);

jp5.add(tFinalPay);

jp6.add(jbOK);

//Adds panels to main panel

main.add(jp1);

main.add(jp2);

main.add(jp3);

main.add(jp4);

main.add(jp5);

main.add(jp6);

//Adds main panel to frame

jf.add(main);

//Registers action event for button one using anonymous class

//For button click

jbOK.addActionListener(new ActionListener()

{

//Overrides the method

public void actionPerformed(ActionEvent ae)

{

//Extracts data from text box and stores it in instance variable

//Converts the data to double

yearlyInterestRate = Double.parseDouble(tInterest.getText());

//Converts the data to integer

numOfYears = Integer.parseInt(tYear.getText());

//Converts the data to double

totalLoan = Double.parseDouble(tTot.getText());

//Calls the method to calculate monthly and total interest

totalLoanWithInterest();

}//End of method

});//End of class

//Sets the properties of frame

jf.setVisible(true);

jf.setSize(400, 300);

jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

}//End of constructor

//Parameterized constructor

public CarLoan(double yearlyInterestRate, int numOfYears, double totalLoan)

{

this.yearlyInterestRate = yearlyInterestRate;

this.numOfYears = numOfYears;

this.numOfYears = numOfYears;

}//End of constructor

//Method to return yearly interest rate

public double getyearlyInterestRate()

{

return yearlyInterestRate;

}//End of method

// Method to return number of years

public int getnumOfYears()

{

return numOfYears;

}//End of method

// Method to return total loan amount

public double gettotalLoan()

{

return totalLoan;

}//End of method

// Method to set yearly interest rate

public void setyearlyInterestRate(double yearlyInterestRate)

{

this.yearlyInterestRate = yearlyInterestRate;

}//End of method

// Method to set number of year

public void setnumOfYears(int numOfYears)

{

this.numOfYears = numOfYears;

}//End of method

// Method to set the total loan amount

public void settotalLoan(double totalLoan)

{

this.totalLoan = totalLoan;

}//End of method

//Method to calculate monthly interest rate and return it

public double monthlyLoanWithInterest()

{

// Convert interest rate into a decimal example: 6.5% = 0.065

yearlyInterestRate /= 100.0;

// Monthly interest rate is the yearly rate divided by 12

double monthlyRate = yearlyInterestRate / 12.0;

// The length of the term in months is the number of years times 12

int termInMonths = numOfYears * 12;

// Calculate the monthly payments

// The Math.pow() method is used calculate values raised to a power

double monthlyPayment = (totalLoan * monthlyRate) / (1 - Math.pow(1 + monthlyRate, - termInMonths));

//Returns monthly payment

return monthlyPayment;

}//End of method

// Method to calculate and return total loan with interest

// Sets the result in the text field

public double totalLoanWithInterest()

{

//Calls the method monthlyLoanWithInterest() to calculate monthly interest

double monthlyLoan = monthlyLoanWithInterest();

//Calculates total loan amount

totalLoan += monthlyLoan;

//Sets monthly loan amount in text field

tMonthly.setText(String.valueOf(monthlyLoan));

//Sets total loan amount in text field

tFinalPay.setText(String.valueOf(totalLoan));

//Returns total loan amount

return totalLoan;

}//End of method

//main method definition

public static void main(String[] args)

{

//Creates an object of CarLoan class

CarLoan c = new CarLoan();

}//End of main method

}//End of class

