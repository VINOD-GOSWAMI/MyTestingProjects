package com.epam.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignUpPage {
    WebDriver driver;

    @FindBy(id = "exampleInputEmail1")
    private WebElement inputEmailForSignUp;

    @FindBy(id = "exampleInputPassword1")
    private WebElement passwordForSignUp;

    @FindBy(id = "form_submit")
    private WebElement formSubmitting;

    public SignUpPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void AddingEmailAndPassword(String email, String password) {
        inputEmailForSignUp.sendKeys(email);
        passwordForSignUp.sendKeys(password);
    }


    public SignInPage submittingSignUpForm() {
        formSubmitting.click();
        return new SignInPage(driver);
    }


    public void addingPassword(String password) {
        passwordForSignUp.sendKeys(password);
    }

    public void addingEmail(String email) {
        inputEmailForSignUp.sendKeys(email);
    }

}
