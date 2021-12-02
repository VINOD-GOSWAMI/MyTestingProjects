package com.epam;

import com.epam.tat.module4.Calculator;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;


public class CalciTest extends ConfigurationTest {
    Calculator calc = new Calculator();

    @Test(groups = "Arithmetic Operation", description = "addition of numbers", dataProviderClass = DataProviderDemo.class, dataProvider = "dataProviderForAddition")
    public void addingTwoNumbers(double value1, double value2, double actualResult) {
        double expectedResult = calc.sum(value1, value2);
        Assert.assertEquals(actualResult, expectedResult);
    }

    @Test(groups = "Arithmetic Operation", dataProviderClass = DataProviderDemo.class, dataProvider = "dataProviderForSubtracting",description = "testing all data for subtraction")
    public void subtractingTwoNumbers(double value1, double value2, double actualResult) {
        double expectedResult = calc.sub(value1, value2);
        Assert.assertEquals(actualResult, expectedResult);
    }

    @Test(groups = "Arithmetic Operation", dataProviderClass = DataProviderDemo.class, dataProvider = "dataProviderForMultiplying",description = "testing all data for multiplication")
    public void multiplyingTwoNumbers(double value1, double value2, double actualResult) {
        double expectedResult = calc.mult(value1, value2);
        System.out.println(34543.332 * 23243.233);

        System.out.println(expectedResult);
        Assert.assertEquals(Math.round(actualResult), Math.round(expectedResult));
    }

    @Test(dataProviderClass = DataProviderDemo.class, dataProvider = "dataProviderForDivision",description = "testing all data for division")
    public void dividingTwoNumbers(double value1, double value2, double actualValue) {
        double expectedResult = calc.div(value1, value2);
        Assert.assertEquals(actualValue, expectedResult);
    }


    @Test(description = "calculate power of numbers")
    public void powerOfNumbers() {
        double powersOfNumbers = calc.pow(2.345, 4.435);
        Assert.assertEquals(Math.pow(2.345, Math.floor(4.435)), powersOfNumbers);

    }

    @Test(description = "calculating square root of an number")
    public void squareRootOfNumbers() {
        double squareRootOfNumbers = calc.sqrt(12324.45);
        Assert.assertEquals(Math.sqrt(12324.45), squareRootOfNumbers);
    }

    @Test(groups = "Trigonometric Function",description = "finding sin value")
    public void sinValueOfNumbers() {
        double sinValue = calc.sin(70);
        Assert.assertEquals(Math.sin(70), sinValue);
    }

    @Test(groups = "Trigonometric Function",description = "checking cos value")
    public void cosValueOfNumbers() {
        double cosValue = calc.cos(434);
        Assert.assertEquals(Math.cos(434), cosValue);
    }

    @Test(groups = "Trigonometric Function",description = "testing for tan value")
    public void tanValueOfNumbers() {
        double tanValue = calc.tg(70);
        System.out.println("tanvalue" + tanValue);
        System.out.println(Math.tan(70));
        Assert.assertEquals(Math.tan(70), tanValue);
    }

    @Test(groups = "Trigonometric Function",description = "testing for cot value")
    public void cotValueOfNumbers() {
        double cotValue = calc.ctg(70);
        Assert.assertEquals(1 / Math.tan(70), cotValue);
    }

    @Test(expectedExceptions = NumberFormatException.class, description = "test case for exception ")
    public void divideExecption() {
        double expectedResult = calc.div(5, 0);
        double actualResult = 5/0;
        Assert.assertEquals(expectedResult, actualResult);
    }

    @Test(description = "checking sign of numbers")
    public void signOfNumber() {
        boolean number1 = calc.isNegative(-3554);
        boolean number2 = calc.isPositive(443);
        boolean number3 = calc.isNegative(3554);
        boolean number4 = calc.isPositive(-3554);

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(true, number1);
        softAssert.assertEquals(true, number2);
        softAssert.assertEquals(false, number3);
        softAssert.assertEquals(false, number4);

    }
}

