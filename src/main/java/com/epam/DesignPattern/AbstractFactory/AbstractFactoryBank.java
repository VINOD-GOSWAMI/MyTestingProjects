package com.epam.DesignPattern.AbstractFactory;

public abstract class AbstractFactoryBank {
    public abstract Bank getBank(String bank);

    public abstract Loan getLoan(String loan);
}
