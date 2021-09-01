package com.h2;

import java.time.LocalDate;
import java.time.YearMonth;

public class SavingsCalculator {

    private float[] credits;
    private float[] debits;

    public static void main(String[] args) {
        String[] creditsAsString = args[0].split(",");
        String[] debitsAsString = args[1].split(",");
        float[] credits = new float[creditsAsString.length];
        float[] debits = new float[debitsAsString.length];

        for(int i = 0; i < creditsAsString.length; i++) {
            credits[i] = Float.parseFloat(creditsAsString[i]);
        }

        for(int i = 0; i < debitsAsString.length; i++) {
            debits[i] = Float.parseFloat(debitsAsString[i]);
        }

    } // End Main

    public SavingsCalculator(float[] credits, float[] debits) {
        this.credits = credits;
        this.debits = debits;
    } // End SavingsCalculator constructor

    private float sumOfCredits() {
        float sum = 0.0f;
        for(int i = 0; i < credits.length; i++) {
            sum += credits[i];
        }
        return sum;
    } // End Sum of Credits Method

    private float sumOfDebits() {
        float sum = 0.0f;
        for(int i = 0; i < debits.length; i++) {
            sum += debits[i];
        }
        return sum;
    } // End sumOfDebits Method

    private static int remainingDaysInMonth(LocalDate date){

        YearMonth yearMonth = YearMonth.of(date.getYear(),date.getMonth());
        int totalDaysInMonth = yearMonth.lengthOfMonth();
        int remainingDays = totalDaysInMonth - date.getDayOfMonth();
        return remainingDays;
    } // End remainingDaysInMonth Method

    public float calculate() {
        return sumOfCredits() - sumOfDebits();
    }

}
