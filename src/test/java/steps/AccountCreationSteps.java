package steps;

import io.cucumber.java.en.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.CommonMethods;
import utils.PageInitializer;

import java.time.Duration;

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
        PageInitializer.accountCreationPage.enterLastName("Doe");
        PageInitializer.accountCreationPage.enterAddressStreet("123 Main St");
        PageInitializer.accountCreationPage.enterAddressCity("Anytown");
        PageInitializer.accountCreationPage.enterAddressState("VA");
        PageInitializer.accountCreationPage.enterAddressZipCode("12345");
        PageInitializer.accountCreationPage.enterPhoneNumber("123-456-7890");
        PageInitializer.accountCreationPage.enterSSN("123-45-6789");
        PageInitializer.accountCreationPage.enterUsername("johndoe");
        PageInitializer.accountCreationPage.enterPassword("password");
        PageInitializer.accountCreationPage.enterRepeatedPassword("password");
    }

    @When("I enter invalid account details")
    public void iEnterInvalidAccountDetails() {
        PageInitializer.accountCreationPage.enterFirstName("");
        PageInitializer.accountCreationPage.enterLastName("Doe");
        PageInitializer.accountCreationPage.enterAddressStreet("");
        PageInitializer.accountCreationPage.enterAddressCity("Anytown");
        PageInitializer.accountCreationPage.enterAddressState("");
        PageInitializer.accountCreationPage.enterAddressZipCode("12345");
        PageInitializer.accountCreationPage.enterPhoneNumber("123-456-7890");
        PageInitializer.accountCreationPage.enterSSN("");
        PageInitializer.accountCreationPage.enterUsername("johndoe");
        PageInitializer.accountCreationPage.enterPassword("password");
        PageInitializer.accountCreationPage.enterRepeatedPassword("password");
    }

    @When("I submit the registration form")
    public void iSubmitTheRegistrationForm() {
        PageInitializer.accountCreationPage.clickRegisterButton();
    }

    @Then("I should see an account creation success message")
    public void iShouldSeeAnAccountCreationSuccessMessage() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        assertTrue(wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("//h1"), "Account Created!")));
    }

    @Then("I should see an error message")
    public void iShouldSeeAnErrorMessage() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        assertTrue(wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[@class='error']"))).isDisplayed());
    }
}
