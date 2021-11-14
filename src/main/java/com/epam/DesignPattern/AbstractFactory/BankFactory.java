package com.epam.DesignPattern.AbstractFactory;

public class BankFactory extends AbstractFactoryBank {
    @Override
    public Bank getBank(String bank) {
        if (bank.equalsIgnoreCase("ICICI")) {
            return new ICICI();
        } else if (bank.equalsIgnoreCase("SBI")) {
            return new SBI();
        }
        return null;
    }

    @Override
    public Loan getLoan(String loan) {
        return null;
    }
}
