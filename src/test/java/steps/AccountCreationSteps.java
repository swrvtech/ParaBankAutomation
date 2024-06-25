package stepDefinitions;

import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import utils.CommonMethods;
import utils.PageInitializer;

import static org.junit.Assert.assertTrue;

public class AccountCreationSteps extends CommonMethods {
    WebDriver driver = CommonMethods.driver;

    @Given("I am on the Registration page")
    public void iAmOnTheRegistrationPage() {
        driver.get("https://parabank.parasoft.com/parabank/register.htm");
    }

    @When("I enter valid account details")
    public void iEnterValidAccountDetails() {
        PageInitializer.accountCreationPage.enterFirstName("John");
        PageInitializer.accountCreationPage.enterLastName("2Toe");
        PageInitializer.accountCreationPage.enterAddressStreet("123 Main St");
        PageInitializer.accountCreationPage.enterAddressCity("Anytown");
        PageInitializer.accountCreationPage.enterAddressState("VA");
        PageInitializer.accountCreationPage.enterAddressZipCode("12345");
        PageInitializer.accountCreationPage.enterPhoneNumber("123-456-7890");
        PageInitializer.accountCreationPage.enterSSN("123-45-6789");
        PageInitializer.accountCreationPage.enterUsername("john2toe");
        PageInitializer.accountCreationPage.enterPassword("password");
        PageInitializer.accountCreationPage.enterRepeatedPassword("password");
    }

    @When("I enter invalid account details")
    public void iEnterInvalidAccountDetails() {
        PageInitializer.accountCreationPage.enterFirstName("Jon");
        PageInitializer.accountCreationPage.enterLastName("Doe");
        PageInitializer.accountCreationPage.enterAddressStreet("");
        PageInitializer.accountCreationPage.enterAddressCity("Anytown");
        PageInitializer.accountCreationPage.enterAddressState("");
        PageInitializer.accountCreationPage.enterAddressZipCode("12345");
        PageInitializer.accountCreationPage.enterPhoneNumber("123-456-7890");
        PageInitializer.accountCreationPage.enterSSN("");
        PageInitializer.accountCreationPage.enterUsername("johnddoe");
        PageInitializer.accountCreationPage.enterPassword("password");
        PageInitializer.accountCreationPage.enterRepeatedPassword("passwordd");
    }

    @When("I submit the registration form")
    public void iSubmitTheRegistrationForm() {
        PageInitializer.accountCreationPage.clickRegisterButton();
    }

    @Then("I should see an account creation success message")
    public void iShouldSeeAnAccountCreationSuccessMessage() {
        assertTrue(PageInitializer.accountCreationPage.isAccountCreationSuccessMessageDisplayed());
    }

    @Then("I should see an error message")
    public void iShouldSeeAnErrorMessage() {
        // Implementation for error message verification
    }
}
