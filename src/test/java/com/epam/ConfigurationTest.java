package com.epam;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.*;

public class ConfigurationTest {
    private static final Logger logger= LogManager.getLogger(ConfigurationTest.class);
    @BeforeSuite
    public void beforeSuite() {
        logger.info("adding before suite");
    }

    @BeforeClass
    public void beforeClass() {
        logger.info("adding before class method");
    }

    @BeforeMethod
    public void beforeMethod() {
        logger.info("adding before method");
    }

    @BeforeTest
    public void beforetest() {
        logger.info("system pass before test");
    }

    @AfterSuite
    public void afterSuite() {
        logger.info("after suite");
    }

    @AfterTest
    public  void afterTest(){
        logger.info("test result is shown  after test");
    }

    @AfterMethod()
    public  void afterMethod(){
        logger.info("after method calling");
    }

}
