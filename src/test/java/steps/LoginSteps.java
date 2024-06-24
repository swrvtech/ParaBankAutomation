package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import utils.CommonMethods;
import utils.PageInitializer;

public class LoginSteps extends CommonMethods {

    @Given("I am on the Login page")
    public void i_am_on_the_login_page() {
        driver.get("http://parabank.parasoft.com/parabank/index.htm"); // URL of the login page

    }

    @When("I enter valid credentials")
    public void i_enter_valid_credentials() {
        loginPage.enterUsername("validUsername");
        loginPage.enterPassword("validPassword");
    }

    @When("I enter invalid credentials")
    public void i_enter_invalid_credentials() {
        loginPage.enterUsername("invalidUsername");
        loginPage.enterPassword("invalidPassword");
    }

    @When("I click the login button")
    public void i_click_the_login_button() {
        loginPage.clickLoginButton();
    }

    @Then("I should be redirected to the Accounts Overview page")
    public void i_should_be_redirected_to_the_accounts_overview_page() {
        // Verify redirection to Accounts Overview page
        String expectedUrl = "http://parabank.parasoft.com/parabank/overview.htm";
        String actualUrl = driver.getCurrentUrl();
        assert expectedUrl.equals(actualUrl) : "Expected URL: " + expectedUrl + ", but got: " + actualUrl;
    }

    @Then("I should see a login error message")
    public void i_should_see_a_login_error_message() {
        String expectedMessage = "The username and password could not be verified.";
        String actualMessage = PageInitializer.loginPage.getErrorMessage();
        assert expectedMessage.equals(actualMessage) : "Expected message: " + expectedMessage + ", but got: " + actualMessage;
    }

    @Given("I am logged into my account")
    public void i_am_logged_into_my_account() {
        i_am_on_the_login_page();
        i_enter_valid_credentials();
        i_click_the_login_button();
    }

    @When("I click the logout button")
    public void i_click_the_logout_button() {
        driver.findElement(By.linkText("Log Out")).click();
    }

    @Then("I should be redirected to the Login page")
    public void i_should_be_redirected_to_the_login_page() {
        String expectedUrl = "http://parabank.parasoft.com/parabank/index.htm";
        String actualUrl = driver.getCurrentUrl();
        assert expectedUrl.equals(actualUrl) : "Expected URL: " + expectedUrl + ", but got: " + actualUrl;
    }

    @Then("I should see a logout confirmation message")
    public void i_should_see_a_logout_confirmation_message() {
        String expectedMessage = "You are now logged out.";
        String actualMessage = driver.findElement(By.xpath("//p[@class='info']")).getText();
        assert expectedMessage.equals(actualMessage) : "Expected message: " + expectedMessage + ", but got: " + actualMessage;
    }
}