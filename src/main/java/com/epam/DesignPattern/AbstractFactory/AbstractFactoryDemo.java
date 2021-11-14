package com.epam.DesignPattern.AbstractFactory;


import java.util.Scanner;

public class AbstractFactoryDemo {
    public static void main(String[] args) throws NullPointerException {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the name of Bank from where you want to take loan amount: ");
        String bankName = sc.nextLine();

        System.out.print("\n");
        System.out.print("Enter the type of loan e.g. home loan or business loan or education loan : ");

        String loanName = sc.nextLine();
        AbstractFactoryBank bankFactory = FactoryCreator.getFactory("Bank");
        Bank b = bankFactory.getBank(bankName);


        System.out.print("\n");
        System.out.print("Enter the interest rate for " + b.getBankName() + ": ");

        double rate = sc.nextDouble();
        System.out.print("\n");
        System.out.print("Enter the loan amount you want to take: ");

        double loanAmount = sc.nextDouble();
        System.out.print("\n");
        System.out.print("Enter the number of years to pay your entire loan amount: ");
        int years = sc.nextInt();

        System.out.print("\n");
        System.out.println("you are taking the loan from " + b.getBankName());

        AbstractFactoryBank loanFactory = FactoryCreator.getFactory("Loan");
        Loan l = loanFactory.getLoan(loanName);
        l.getInterestRate(rate);
        l.calculateLoanPayment(loanAmount, years);

    }
}

