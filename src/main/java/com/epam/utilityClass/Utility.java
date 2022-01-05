package com.epam.utilityClass;

import lombok.extern.log4j.Log4j2;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.LinkedList;
import java.util.List;

@Log4j2
public class Utility {


    public static List<String> participantList(WebDriver driver) {
        LinkedList<String> participantsDetails = new LinkedList();
        for (int i = 1; i < 5; i++) {
            participantsDetails.add(driver.findElement(By.xpath("//td[" + i + "]")).getText());
        }
        return participantsDetails;
    }

    public static void takingScreenShot(WebDriver driver, String filePath) throws IOException {
        File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(file, new File("C:\\Users\\Vinodpuri_Goswami\\IdeaProjects\\M-8Task\\TakeScreenShot\\" + filePath + ".png"));
    }


    public static WebElement waitForElement(WebDriver driver,  WebElement element) {
        WebElement element1= new WebDriverWait(driver, Duration.ofSeconds(30)).until(ExpectedConditions.visibilityOf(element));
        return  element1;
    }

    public static WebElement waitForClickable(WebDriver driver,  WebElement element) {
       WebElement element1=new WebDriverWait(driver, Duration.ofSeconds(15)).until(ExpectedConditions.elementToBeClickable(element));
        return element1;
    }



}





