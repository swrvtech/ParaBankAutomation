package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import utils.CommonMethods;
import utils.PageInitializer;
import static utils.PageInitializer.loginPage;


public class LoginSteps extends CommonMethods {

    @Given("I am on the Login page")
    public void i_am_on_the_login_page() {
        driver.get("http://parabank.parasoft.com/parabank/index.htm");
    }

    @When("user enters {string} and {string}")
    public void user_enters_and(String username, String password) {
        loginPage.enterUsername(username);
        loginPage.enterPassword(password);
    }

    @When("user clicks on login button")
    public void user_clicks_on_login_button() {
        loginPage.clickLoginButton();
    }

    @Then("user is successfully logged in")
    public void user_is_successfully_logged_in() {
        String expectedUrl = "http://parabank.parasoft.com/parabank/overview.htm";
        String actualUrl = driver.getCurrentUrl();
        assert expectedUrl.equals(actualUrl) : "Expected URL: " + expectedUrl + ", but got: " + actualUrl;
    }

    @Then("user sees {string}")
    public void user_sees(String expectedMessage) {
        String actualMessage = PageInitializer.loginPage.getErrorMessage();
        assert expectedMessage.equals(actualMessage) : "Expected message: " + expectedMessage + ", but got: " + actualMessage;
    }

    @Given("I am logged into my account")
    public void i_am_logged_into_my_account() {
        i_am_on_the_login_page();
        user_enters_and("john", "demo");
        user_clicks_on_login_button();
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
}
