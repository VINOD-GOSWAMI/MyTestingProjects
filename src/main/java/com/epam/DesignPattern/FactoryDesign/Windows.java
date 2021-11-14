package com.epam.DesignPattern.FactoryDesign;

public class Windows implements OperatingSystem {
    @Override
    public void specification() {
        System.out.println("most used Operating System in large devices ie. Windows.");
    }
}
