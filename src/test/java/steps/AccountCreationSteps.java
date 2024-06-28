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

        accountDetails.forEach((key, value) -> {
            if (value != null && !value.isEmpty()) {
                switch (key) {
                    case "firstName":
                        accountCreationPage.enterFirstName(value);
                        break;
                    case "lastName":
                        accountCreationPage.enterLastName(value);
                        break;
                    case "addressStreet":
                        accountCreationPage.enterAddressStreet(value);
                        break;
                    case "addressCity":
                        accountCreationPage.enterAddressCity(value);
                        break;
                    case "addressState":
                        accountCreationPage.enterAddressState(value);
                        break;
                    case "addressZipCode":
                        accountCreationPage.enterAddressZipCode(value);
                        break;
                    case "phoneNumber":
                        accountCreationPage.enterPhoneNumber(value);
                        break;
                    case "ssn":
                        accountCreationPage.enterSSN(value);
                        break;
                    case "username":
                        accountCreationPage.enterUsername(value);
                        break;
                    case "password":
                        accountCreationPage.enterPassword(value);
                        break;
                    case "repeatedPassword":
                        accountCreationPage.enterRepeatedPassword(value);
                        break;
                }
            }
        });
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
