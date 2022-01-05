package com.epam.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DeletingParticipantPage {
    WebDriver driver;

    @FindBy(xpath = "//button[text()='Delete ']")
    private WebElement deleteButton;

    @FindBy(xpath = "//input[@type='search']")
    private WebElement searchField;

    @FindBy(xpath = "//i[@class='fa fa-trash']")
    private WebElement deletingData;

    public DeletingParticipantPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void searchParticipantDetails(String participantData) {
        searchField.sendKeys(participantData);

    }


    public ParticipantPage deletingParticipantsData() {
        deletingData.click();
        deleteButton.click();
       return new ParticipantPage(driver);
    }
}
