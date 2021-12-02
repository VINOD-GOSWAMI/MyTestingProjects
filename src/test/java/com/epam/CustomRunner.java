package com.epam;

import org.testng.TestListenerAdapter;
import org.testng.TestNG;


public class CustomRunner {
    public static void main(String[] args) {
        TestListenerAdapter tla = new TestListenerAdapter();
        TestNG tng = new TestNG();
        tng.setTestClasses(new Class[]{CalciTest.class});
        tng.addListener(tla);
        tng.run();
    }
}

