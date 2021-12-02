package com.epam;

import org.testng.annotations.DataProvider;

public class DataProviderDemo extends CalciTest {
    @DataProvider(name = "dataProviderForAddition")
    public Object[][] dataProviderForAddition() {
        return new Object[][]{
                {980.32, 1024, 1024 + 980.32},
                {3473.534, -335.23, 3473.534 - 335.23},
                {-335435, -433443, -335435 - 433443}};
    }

    @DataProvider(name = "dataProviderForSubtracting")
    public Object[][] dataProviderForSubtraction() {
        return new Object[][]{
                {-324., 234, -324. - 234},
                {8548, 333, 8548 - 333},
                {-538.34, -345.22, -538.34 + 345.22},
                {1974565, -2.4, 1974565 + 2.4},
                {3, 2.4, 3-2.4}
        };
    }

    @DataProvider(name = "dataProviderForMultiplying")
    public Object[][] dataProviderForMultiplication() {
        return new Object[][]{
                {34543.332, 23243.233, 34543.332 * 23243.233},
                {-43432, -2222, -43432 * -2222},
                {3, 0, 0},
                {876.2, -655.00, 876.2 * -655.00}
        };
    }

    @DataProvider(name = "dataProviderForDivision")
    public Object[][] dataProviderDivision() {
        return new Object[][]{
                {-393.68, 6776, -393.68 / 6776},
                {-2344579.876, -56588, -2344579.876 / -56588},
                {4976., 67, 4976. / 67},
                {4656.343, 344.325, 4656.343 / 344.325},
                {1200, 3, 400},
        };
    }

}
