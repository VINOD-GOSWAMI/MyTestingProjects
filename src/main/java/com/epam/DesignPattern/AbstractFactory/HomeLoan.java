package com.epam.DesignPattern.AbstractFactory;

public class HomeLoan extends Loan {
    @Override
    public void getInterestRate(double r) {
        rate = r;
    }
}
