package com.epam.DesignPattern.FactoryDesign;

public class FactoryDesignPattern {
    public static void main(String[] args) {
        OperatingSystemFactory osf = new OperatingSystemFactory();
        OperatingSystem obj = osf.getInstance("Closed  Source");
        obj.specification();
    }
}
