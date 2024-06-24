package steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utils.CommonMethods;
import utils.PageInitializer;

public class AccountOverviewSteps extends CommonMethods {

    @When("I navigate to the Account Overview page")
    public void i_navigate_to_the_account_overview_page() {
        accountOverviewPage.navigateToAccountOverview();
    }

    @Then("I should see accurate account information")
    public void i_should_see_accurate_account_information() {
        boolean isDisplayed = accountOverviewPage.isAccountInformationDisplayed();
        assert isDisplayed : "Account information is not displayed correctly.";
    }
}
