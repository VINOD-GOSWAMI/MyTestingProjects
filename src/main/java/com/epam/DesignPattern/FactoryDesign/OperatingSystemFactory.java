package com.epam.DesignPattern.FactoryDesign;

public class OperatingSystemFactory {
    public OperatingSystem getInstance(String str) {
        if (str.equals("Open Source")) {
            return new Android();
        } else if (str.equals("Closed Source")) {
            return new IOS();
        } else {
            return new Windows();
        }
    }
}
