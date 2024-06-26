package steps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import utils.CommonMethods;
import utils.PageInitializer;

import java.util.Map;

import static org.junit.Assert.assertTrue;
import static utils.PageInitializer.accountCreationPage;

public class AccountCreationSteps extends CommonMethods {
    WebDriver driver = CommonMethods.driver;

    @Given("I am on the Registration page")
    public void iAmOnTheRegistrationPage() {
        driver.get("https://parabank.parasoft.com/parabank/register.htm");
    }

    @When("I enter the following account details")
    public void iEnterTheFollowingAccountDetails(DataTable dataTable) {
        Map<String, String> accountDetails = dataTable.asMap(String.class, String.class);

        accountCreationPage.enterFirstName(accountDetails.get("firstName"));
        accountCreationPage.enterLastName(accountDetails.get("lastName"));
        accountCreationPage.enterAddressStreet(accountDetails.get("addressStreet"));
        accountCreationPage.enterAddressCity(accountDetails.get("addressCity"));
        accountCreationPage.enterAddressState(accountDetails.get("addressState"));
        accountCreationPage.enterAddressZipCode(accountDetails.get("addressZipCode"));
        accountCreationPage.enterPhoneNumber(accountDetails.get("phoneNumber"));
        accountCreationPage.enterSSN(accountDetails.get("ssn"));
        accountCreationPage.enterUsername(accountDetails.get("username"));
        accountCreationPage.enterPassword(accountDetails.get("password"));
        accountCreationPage.enterRepeatedPassword(accountDetails.get("repeatedPassword"));
    }

    @When("I submit the registration form")
    public void iSubmitTheRegistrationForm() {
        accountCreationPage.clickRegisterButton();
    }

    @Then("I should see an account creation success message")
    public void iShouldSeeAnAccountCreationSuccessMessage() {
        assertTrue(accountCreationPage.isAccountCreationSuccessMessageDisplayed());
    }

    @Then("I should see an error message")
    public void iShouldSeeAnErrorMessage() {
        assertTrue(accountCreationPage.isErrorMessageDisplayed());
    }
}
