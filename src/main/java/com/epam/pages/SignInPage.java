package com.epam.pages;

import com.epam.utilityClass.Utility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignInPage {
    WebDriver driver;

    @FindBy(linkText = "Sign up")
    private WebElement signUp;

    @FindBy(id = "exampleInputEmail1")
    private WebElement inputEmailForSignIn;

    @FindBy(id = "exampleInputPassword1")
    private WebElement passwordForSignIn;

    @FindBy(id = "form_submit")
    private WebElement form_submit;

    @FindBy(xpath = "//h4[text()='Sign In']")
    private WebElement signInVerify;

    public SignInPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void openingSignInUrl() {
        driver.get("http://epinhydw0087/programs/#/admin/participants");
    }

    public SignUpPage navigateToSignUpPage() {
        signUp.click();
        return new SignUpPage(driver);
    }

    public void addingUserNameAndPassword(String email, String password) {
        inputEmailForSignIn.sendKeys(email);
        passwordForSignIn.sendKeys(password);

    }

    public ProgramPortalPage navigateToProgramPortalPage() {
        form_submit.click();
        return new ProgramPortalPage(driver);
    }

    public void addingEmail(String email) {
        Utility.waitForElement(driver,inputEmailForSignIn).sendKeys(email);
    }

    public void addingPassword(String password) {
        passwordForSignIn.sendKeys(password);
    }


    public void navigatingToBaseUrl(String baseUrl) {
        driver.get(baseUrl);
    }

    public void signInPageVisible() {
        Utility.waitForElement(driver,signInVerify);
    }
}
