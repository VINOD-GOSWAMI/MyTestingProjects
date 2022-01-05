package com.epam.bddTesting;

import com.epam.api_data.ApiTesting;
import com.epam.api_data.ParticipantPojo;
import com.epam.utilityClass.Utility;
import com.epam.database.ReadingDatabase;
import com.epam.drivers.BrowserList;
import com.epam.drivers.DriverHandler;
import com.epam.pages.*;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import java.io.IOException;
import java.sql.SQLException;
import java.time.Duration;
import java.util.LinkedList;
import java.util.List;


@Log4j2
public class ProgramPortalCRUD {
    WebDriver driver;
    SignUpPage signUp;
    SignInPage signIn;
    ProgramPortalPage programPortalPage;
    ParticipantPage participantPage;
    AddParticipantPage addParticipant;
    EditParticipantPage editParticipant;
    DeletingParticipantPage deleteParticipant;
    ApiTesting apiTesting;
    ReadingDatabase readingDatabase;
    ParticipantService participantService;

    @Before
    public void setUp() {
        driver= DriverHandler.givingNameForDriver(BrowserList.CHROME);
        driver.manage().window().maximize();
        signIn = new SignInPage(driver);
        signUp=new SignUpPage(driver);
        programPortalPage =new ProgramPortalPage(driver);
        participantPage = new ParticipantPage(driver);
        addParticipant=new AddParticipantPage(driver);
        editParticipant=new EditParticipantPage(driver);
        deleteParticipant=new DeletingParticipantPage(driver);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }
    @Given("I search baseUrl in browser")
    public void iSearchBaseUrlInBrowser() {
           signIn.openingSignInUrl();
    }

    @Given("I search {string} in browser")
    public void iSearchInBrowser(String baseUrl) {
        signIn.navigatingToBaseUrl(baseUrl);
    }

    @When("I click on signUp url on signIn page")
    public void iClickOnSignUpUrlOnSignInPage() {
        signUp= signIn.navigateToSignUpPage();
    }

    @And("I type {string} in the email field on to the signUp page")
    public void iTypeInTheEmailFieldOnToTheSignUpPage(String email) {
        signUp.addingEmail(email);
    }

    @And("I type {string} in the password field on to the signUp page")
    public void iTypeInThePasswordFieldOnToTheSignUpPage(String password) {
        signUp.addingPassword(password);
    }

    @And("I click on SignUp button on to the on to the signUp page")
    public void iClickOnSignUpButtonOnToTheOnToTheSignUpPage() throws InterruptedException, IOException {
        signIn =signUp.submittingSignUpForm();
        Utility.takingScreenShot(driver,"signUpDetails");
        signIn.signInPageVisible();
        log.info("signUp is Completed");
    }

    @And("I type {string} in the email field on to the signIn page")
    public void iTypeInTheEmailFieldOnToTheSignInPage(String email) {
        signIn.addingEmail(email);
    }

    @And("I type {string} in the password field on to the signIn page")
    public void iTypeInThePasswordFieldOnToTheSignInPage(String password) {
        signIn.addingPassword(password);
    }


    @And("I click on Submit button")
    public void iClickOnSubmitButton() throws IOException {
        programPortalPage = signIn.navigateToProgramPortalPage();
        Utility.takingScreenShot(driver,"sigInDetails");
        log.info("signIn process is completed");
    }

    @And("I click on hamburger menu")
    public void iClickOnHamburgerMenu() {
        programPortalPage.clickingOnHamburger();
    }

    @And("I click on program management dropdown menu")
    public void iClickOnProgramManagementDropdownMenu()  {
        programPortalPage.clickingOnProgramManagementButton();
    }

    @And("I click on participant button")
    public void iClickOnParticipantButton()  {
        participantPage = programPortalPage.navigatingToParticipantsPage();
    }

    @And("I selected r-d batch from dropdown menu in program management column on to participants page")
    public void iSelectedRDBatchFromDropdownMenuInProgramManagementColumnOnToParticipantsPage() {
        participantPage.selectingDropDownMenu();
    }

    @When("I click on add Participant Button in the program management column on participant page")
    public void iClickOnAddParticipantButtonInTheProgramManagementColumnOnParticipantPage() {
      addParticipant= participantPage.navigatingToAddParticipantPage();
    }



    @And("I entered valid data on to add participant page")
    public void iEnteredValidDataOnToAddParticipantPage(DataTable table) throws InterruptedException, IOException {
        List<List<String>> participantValue = table.asLists(String.class);
        participantService= new ParticipantService();
        System.out.println(participantValue.get(2).get(1));
        participantService.enterParticipantData(participantValue,addParticipant);


        Utility.takingScreenShot(driver,"addParticipantData");

    }
    @And("I click on save button on to the add participant page")
    public void iClickOnSaveButtonOnToTheAddParticipantPage() throws InterruptedException {
       // Thread.sleep(1000);
        addParticipant.savingParticipantsData();
        log.info("participant is created.");
    }


    @And("I search {string} in search field on the participant page")
    public void iSearchInSearchFieldOnTheParticipantPage(String participantEmail) throws InterruptedException {
        participantPage.searchParticipantDetails(participantEmail);
    }

    @Then("I verify whether {string} is present in program portal on the participant page")
    public void iverifyWhetherIsPresentInProgramPortalOnTheParticipantPage(String name) throws InterruptedException {
        Thread.sleep(1000);
        String participantEmail= participantPage.verifyingParticipantEmail(name);
        Assert.assertEquals(participantEmail, "tomcruise@gmail.com");
        log.info("verified whether participant is present in UI for add participant Scenarios ");
    }


    @And("I click on edit button to edit participant data")
    public void iClickOnEditButtonToEditParticipantData() {
        editParticipant= participantPage.navigatingToEditParticipantsPage();
        editParticipant.clickOnEditButton();
    }



    @Then("I verify UI data of {string} to api data")
    public void iVerifyUIDataOfToApiData(String email) throws IOException {

        Utility.takingScreenShot(driver,"readingParticipant");
        apiTesting = new ApiTesting();
        Response apiResponse = apiTesting.gettingResponseWithEmail(email);
        ParticipantPojo pojo = apiResponse.as(ParticipantPojo.class);

        Assert.assertEquals(pojo.getParticipantEmail(), email);
        Assert.assertEquals(pojo.getMobile(), "8169322808");
        Assert.assertEquals(pojo.getParticipantName(),"Tom Cruise");

        log.info("api response is : {}",apiResponse.prettyPrint());
        log.info("validation successfully completed for reading participant Scenarios using api. ");


    }

    @Then("I verify UI Data of {string} with database data")
    public void iVerifyUIDataOfWithDatabaseData(String email) throws SQLException, ClassNotFoundException {
        List<String> uIParticipantData = Utility.participantList(driver);
        log.info("participant data from UI : {}",uIParticipantData);

        readingDatabase = new ReadingDatabase();
        List<String> databaseData = readingDatabase.readingParticipantFromDatabase(email);
        log.info("participant data from database : {}",databaseData);

        Assert.assertTrue(databaseData.containsAll(uIParticipantData));
        log.info("successfully verified participant data UI and database for Updating Participants Scenarios");
    }

    @And("I entered valid data on to edit participant page")
    public void iEnteredValidDataOnToEditParticipantPage(DataTable table) throws InterruptedException, IOException {

        List<List<String>> participantValue = table.asLists(String.class);
        participantService= new ParticipantService();
        participantService.editParticipantData(participantValue,editParticipant);


        Utility.takingScreenShot(driver,"editParticipantData");

    }

    @And("I click on save button on to the edit participant page")
    public void iClickOnSaveButtonOnToTheEditParticipantPage() throws InterruptedException {
        editParticipant.savingParticipantsData();

        log.info("participant added successfully.");
    }


    @And("I click on delete button on to the participant page")
    public void iClickOnDeleteButtonOnToTheParticipantPage() throws InterruptedException, IOException {


        deleteParticipant= participantPage.navigatingToDeletingParticipantsInfo();
        deleteParticipant.deletingParticipantsData();


        log.info("successfully deleted participant information.");
    }

    @Then("I verify {string} is not present on to the participant page")
    public void iVerifyIsNotPresentOnToTheParticipantPage(String name) throws InterruptedException, IOException {
        Thread.sleep(2000);
        Utility.takingScreenShot(driver,"deletingParticipant");
        Assert.assertNull(participantPage.verifyingParticipantEmail(name));
        log.info("successfully verified that participant is deleted in Deleting Participants scenarios ");
    }

    @After
    public  void closingDriver(){
        driver.quit();
    }
}









