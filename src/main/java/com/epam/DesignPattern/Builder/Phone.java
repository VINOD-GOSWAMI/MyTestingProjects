package com.epam.DesignPattern.Builder;

public class Phone {
    private String os;
    private String processor;
    private double screenSize;
    private int battery;
    private int ram;


    public Phone(String os, String processor, double screenSize, int battery, int ram) {

        this.os = os;
        this.processor = processor;
        this.screenSize = screenSize;
        this.battery = battery;
        this.ram = ram;
    }

    @Override
    public String toString() {
        return "Phone{" +
                "os='" + os + '\'' +
                ", processor='" + processor + '\'' +
                ", screenSize=" + screenSize +
                ", battery=" + battery +
                ", ram=" + ram +
                '}';
    }
}
