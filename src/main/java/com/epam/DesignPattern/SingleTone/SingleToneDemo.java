package com.epam.DesignPattern.SingleTone;

class SingleObject {
    static SingleObject obj = new SingleObject();

    private SingleObject() {

    }

    public static SingleObject getInstance() {
        return obj;
    }
}

public class SingleToneDemo {
    public static void main(String[] args) {
        SingleObject obj1 = SingleObject.getInstance();
        SingleObject obj2 = SingleObject.getInstance();
        System.out.println(obj1);
        System.out.println(obj2);
    }
}
