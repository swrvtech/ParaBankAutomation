package steps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import utils.CommonMethods;
import java.util.Map;
import java.util.List;
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
        List<Map<String, String>> accountDetailsList = dataTable.asMaps(String.class, String.class);

        // Since Scenario Outline provides one row at a time, we get the first (and only) row
        Map<String, String> accountDetails = accountDetailsList.get(0);

        if (accountDetails.get("firstName") != null) {
            accountCreationPage.enterFirstName(accountDetails.get("firstName"));
        }
        if (accountDetails.get("lastName") != null) {
            accountCreationPage.enterLastName(accountDetails.get("lastName"));
        }
        if (accountDetails.get("addressStreet") != null) {
            accountCreationPage.enterAddressStreet(accountDetails.get("addressStreet"));
        }
        if (accountDetails.get("addressCity") != null) {
            accountCreationPage.enterAddressCity(accountDetails.get("addressCity"));
        }
        if (accountDetails.get("addressState") != null) {
            accountCreationPage.enterAddressState(accountDetails.get("addressState"));
        }
        if (accountDetails.get("addressZipCode") != null) {
            accountCreationPage.enterAddressZipCode(accountDetails.get("addressZipCode"));
        }
        if (accountDetails.get("phoneNumber") != null) {
            accountCreationPage.enterPhoneNumber(accountDetails.get("phoneNumber"));
        }
        if (accountDetails.get("ssn") != null) {
            accountCreationPage.enterSSN(accountDetails.get("ssn"));
        }
        if (accountDetails.get("username") != null) {
            accountCreationPage.enterUsername(accountDetails.get("username"));
        }
        if (accountDetails.get("password") != null) {
            accountCreationPage.enterPassword(accountDetails.get("password"));
        }
        if (accountDetails.get("repeatedPassword") != null) {
            accountCreationPage.enterRepeatedPassword(accountDetails.get("repeatedPassword"));
        }
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
