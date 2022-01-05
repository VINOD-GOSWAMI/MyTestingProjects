package com.epam.pages;

import com.epam.utilityClass.Utility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import static com.epam.utilityClass.Utility.waitForClickable;

public class EditParticipantPage {
    WebDriver driver;

    @FindBy(id = "tooltip1")
    private WebElement editButton;

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

    @FindBy(name = "reason")
    private WebElement addComments;

    @FindBy(xpath = "//button[text()='Save']")
    private WebElement saveButton;

    public EditParticipantPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void setParticipantsName(String name) {
        participantsName.clear();
        participantsName.sendKeys(name);
    }

    public void setParticipantsEmail(String email) {
        participantsEmail.sendKeys(email);
    }

    public void setParticipantMobileNumber(String mobileNumber) {
        participantMobileNumber.clear();
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

    public void clickOnEditButton() {
        editButton.click();
    }

    public void setAddComments(String comments) {
        addComments.sendKeys(comments);
    }

    public ParticipantPage savingParticipantsData() throws InterruptedException {
        Thread.sleep(2000);
       saveButton.click();
        Thread.sleep(1000);
       return new ParticipantPage(driver);
    }


    public void cancelButton() {
        cancelButton.click();
    }

    public void setParticipantsCollegeName(String collegeName) {
        new Select(participantsCollegeName).selectByVisibleText(collegeName);
    }
}
