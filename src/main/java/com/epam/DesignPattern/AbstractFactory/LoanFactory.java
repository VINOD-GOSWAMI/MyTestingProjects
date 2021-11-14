package com.epam.DesignPattern.AbstractFactory;

public class LoanFactory extends AbstractFactoryBank {
    @Override
    public Bank getBank(String bank) {
        return null;
    }

    @Override
    public Loan getLoan(String loan) {
        if (loan.equalsIgnoreCase("Home")) {
            return new HomeLoan();
        } else if (loan.equalsIgnoreCase("Education")) {
            return new EducationLoan();
        }
        return null;
    }
}
