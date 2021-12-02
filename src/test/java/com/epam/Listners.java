package com.epam;


import org.testng.ITestListener;
import org.testng.ITestResult;

public class Listners implements ITestListener {
    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println("status " + result.getStatus());
    }
}
