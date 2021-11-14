package com.epam.DesignPattern.Decorator;

public abstract class ShapeDecorator implements Shape {
    Shape decoratedShape;

    public ShapeDecorator(Shape decoratedShape) {
        this.decoratedShape = decoratedShape;
    }

    public void figureName() {
        decoratedShape.figureName();
    }
}
