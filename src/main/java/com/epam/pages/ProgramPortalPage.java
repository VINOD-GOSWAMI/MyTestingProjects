package com.epam.pages;

import com.epam.utilityClass.Utility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static com.epam.utilityClass.Utility.waitForElement;

public class ProgramPortalPage {
    WebDriver driver;

    @FindBy(className = "uui-toggle-box")
    private WebElement hamburgerMenu;


    @FindBy(linkText = "PROGRAMS MANAGEMENT")
    private WebElement programManagement;

    @FindBy(linkText = "Participants")
    private WebElement participantsPage;

    public ProgramPortalPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickingOnHamburger() {
        hamburgerMenu.click();
    }

    public void clickingOnProgramManagementButton() {
        waitForElement(driver,programManagement).click();
    }

    public ParticipantPage navigatingToParticipantsPage() {
        waitForElement(driver,participantsPage).click();
        return new ParticipantPage(driver);
    }

}
