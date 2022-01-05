package com.epam.pages;

import com.epam.utilityClass.Utility;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import static com.epam.utilityClass.Utility.waitForClickable;
import static com.epam.utilityClass.Utility.waitForElement;

public class ParticipantPage {
    WebDriver driver;


    @FindBy(name = "batch")
    private WebElement dropdownMenu;

    @FindBy(xpath = "//i[@class='fa fa-plus']//parent::button")
    private WebElement addParticipant;

    @FindBy(xpath = "//input[@type='search']")
    private WebElement searchField;

    @FindBy(xpath = "//td[2]")
    private WebElement emailVerify;


    public ParticipantPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void selectingDropDownMenu() {
        new Select(dropdownMenu).selectByVisibleText("rd training");

    }

    public void searchParticipantDetails(String participantData) throws InterruptedException {
       waitForElement(driver,searchField).sendKeys(participantData);

    }

    public String verifyingParticipantEmail(String participantEmail) throws InterruptedException {
        try {
            Utility.waitForClickable(driver,searchField).sendKeys(participantEmail);
            return emailVerify.getText();
        }
        catch (NoSuchElementException e)
        {
            return null;
        }

    }

    public AddParticipantPage navigatingToAddParticipantPage() {
        addParticipant.click();
        return new AddParticipantPage(driver);
    }


    public DeletingParticipantPage navigatingToDeletingParticipantsInfo() {
        return new DeletingParticipantPage(driver);
    }

    public EditParticipantPage navigatingToEditParticipantsPage() {
        return new EditParticipantPage(driver);
    }


}
