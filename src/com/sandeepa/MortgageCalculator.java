package com.sandeepa;

public class MortgageCalculator {
    public final static byte PERCENT = 100;
    public final static byte MONTHS_IN_YEAR = 12;

    private double principal;
    private float annualInterest;


    private byte years;

    public MortgageCalculator(double principal,float annualInterest,byte years){
        this.principal=principal;
        this.annualInterest=annualInterest;
        this.years=years;
    }


    public double calculateMortgage() {

        float monthlyInterest = getMonthlyInterest();
        float numberOfPayments = getNumberOfPayments();

        double mortgage = principal
                * (monthlyInterest * Math.pow(1 + monthlyInterest, numberOfPayments))
                / (Math.pow(1 + monthlyInterest, numberOfPayments) - 1);

        return mortgage;
    }


    public double calculateBalance(short numberOfPaymentsMade) {
        float monthlyInterest = getMonthlyInterest();
        float numberOfPayments = getNumberOfPayments();

        double balance = principal
                * (Math.pow(1 + monthlyInterest, numberOfPayments) - Math.pow(1 + monthlyInterest, numberOfPaymentsMade))
                / (Math.pow(1 + monthlyInterest, numberOfPayments) - 1);

        return balance;
    }

    public float getNumberOfPayments() {
        return years * MONTHS_IN_YEAR;
    }
    private float getMonthlyInterest() {
        return annualInterest / PERCENT / MONTHS_IN_YEAR;
    }
    public byte getYears() {
        return years;
    }
}
