package com.h2;

import javax.swing.text.Utilities;
import java.text.DecimalFormat;
import com.h2.Utilities;

public class MortgageCalculator {

    private long loanAmount;
    private int termInYears;
    private float annualRate;
    private double monthlyPayment;

    public MortgageCalculator(long loanAmount, int termInYears, float annualRate) {
        this.loanAmount = loanAmount;
        this.termInYears = termInYears;
        this.annualRate = annualRate;
    } // Mortgage Calc Constructor

    public static void main(String[] args) {

        long loanAmount = Utilities.getLongValue(args[0]);
        int termInYears = Integer.parseInt(args[1]);
        float annualRate = Float.parseFloat(args[2]);

        MortgageCalculator calculator = new MortgageCalculator(loanAmount,termInYears,annualRate);
        calculator.calculateMonthlyPayment();
        System.out.println(calculator.toString());


    } // Main method


    private int getNumberOfPayments() {
        return termInYears * 12;
    } // End getNumberOfPayments method

    private float getMonthlyInterestRate() {
        float interestRate = annualRate / 100;

        return interestRate / 12;
    } // End getMonthlyInterestRate Method


    public void calculateMonthlyPayment() {
        long  P = loanAmount;
        float r = getMonthlyInterestRate();
        int n = getNumberOfPayments();

        double M = P * (((r * Math.pow(1 + r, n))) / ((Math.pow((1 + r), n)) - 1));
        this.monthlyPayment = M;

    } // End calculateMonthlyPayment Method

    public String toString() {
        DecimalFormat df = new DecimalFormat("####0.00");
        return "monthlyPayment: " + df.format(monthlyPayment);
    }


} // End MortgageCalculator class
