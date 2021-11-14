package com.epam.DesignPattern.AbstractFactory;

public class FactoryCreator {
    public static AbstractFactoryBank getFactory(String choice) {
        if (choice.equalsIgnoreCase("Bank")) {
            return new BankFactory();
        } else if (choice.equalsIgnoreCase("Loan")) {
            return new LoanFactory();
        }
        return null;
    }
}
