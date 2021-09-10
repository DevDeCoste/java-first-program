package com.h2;

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

    }


} // End MortgageCalculator class
