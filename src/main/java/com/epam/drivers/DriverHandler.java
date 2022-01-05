package com.epam.drivers;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;

public class DriverHandler {
    public static WebDriver givingNameForDriver(BrowserList browserName) {

        switch (browserName) {
            case CHROME:
                WebDriverManager.chromedriver().setup();
                return new ChromeDriver();
            case FIREFOX:
                WebDriverManager.firefoxdriver().setup();
                return new FirefoxDriver();
            case EDGE:
                WebDriverManager.edgedriver().setup();
                return new EdgeDriver();
            case OPERA:
                WebDriverManager.operadriver().setup();
            case IE:
                WebDriverManager.iedriver().setup();
                return new InternetExplorerDriver();
            case SAFARI:
                WebDriverManager.safaridriver().setup();
                return new SafariDriver();
            default:
                throw new IllegalStateException("Unexpected value: " + browserName);
        }
    }
}
