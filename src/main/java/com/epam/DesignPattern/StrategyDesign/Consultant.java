package com.epam.DesignPattern.StrategyDesign;

public class Consultant implements Role {
    @Override
    public String responsibilities() {
        return Consultant.class.getSimpleName();
    }

    @Override
    public String description() {
        return "Write Code";
    }
}
