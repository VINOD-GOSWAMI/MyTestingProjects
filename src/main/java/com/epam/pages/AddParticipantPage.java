package com.epam.pages;

import com.epam.utilityClass.Utility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AddParticipantPage {
    WebDriver driver;

    @FindBy(xpath = "//button[text()='Cancel']")
    private WebElement cancelButton;

    @FindBy(name = "taskName")
    private WebElement participantsName;

    @FindBy(name = "taskStatus")
    private WebElement participantsEmail;

    @FindBy(name = "mobile")
    private WebElement participantMobileNumber;

    @FindBy(name = "gender")
    private WebElement participantsGender;

    @FindBy(name = "isfaculty")
    private WebElement participantsIsFaculty;

    @FindBy(name = "status")
    private WebElement participantsStatus;

    @FindBy(name = "collegeName")
    private WebElement participantsCollegeName;

    @FindBy(xpath = "//button[text()='Save']")
    private WebElement saveButton;

    public AddParticipantPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    public void setParticipantsName(String name) {

        participantsName.sendKeys(name);
    }

    public void setParticipantsEmail(String email) {
        Utility.waitForElement(driver,participantsEmail).sendKeys(email);
    }

    public void setParticipantMobileNumber(String mobileNumber) {
        participantMobileNumber.sendKeys(mobileNumber);
    }

    public void setGender(String gender) {
        new Select(participantsGender).selectByValue(gender);
    }

    public void setParticipantsIsFaculty(String isFaculty) {
        new Select(participantsIsFaculty).selectByVisibleText(isFaculty);
    }

    public void setParticipantsStatus(String status) {
        new Select(participantsStatus).selectByVisibleText(status);
    }

    public void setParticipantsCollegeName(String collegeName) {
        new Select(participantsCollegeName).selectByVisibleText(collegeName);
    }

    public ParticipantPage savingParticipantsData() {
        Utility.waitForClickable(driver,saveButton).click();
        return new ParticipantPage(driver);
    }

    public void cancelButton() {
        cancelButton.click();
    }
}
