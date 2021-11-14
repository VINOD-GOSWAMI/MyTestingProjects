package com.epam.DesignPattern.AbstractFactory;

public class EducationLoan extends Loan {
    @Override
    public void getInterestRate(double r) {
        rate = r;
    }
}
