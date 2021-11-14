package com.epam.DesignPattern.Decorator;

public class DecoratorDemo {
    public static void main(String[] args) {
        Shape circle = new Circle();

        Shape redCircle = new RedShapeDecorator(new Circle());

        Shape redRectangle = new RedShapeDecorator(new Rectangle());
        System.out.println("Circle with normal border");
        circle.figureName();

        System.out.println("\nCircle of red border");
        redCircle.figureName();

        System.out.println("\nRectangle of red border");
        redRectangle.figureName();
    }
}
