package com.epam.DesignPattern.Builder;

public class BuilderDemo {
    public static void main(String[] args) {
        Phone p = new PhoneBuilder().setBattery(3100).setOs("Android").setProcessor("Snapdragon 855").getPhone();
        System.out.println(p);
    }
}
