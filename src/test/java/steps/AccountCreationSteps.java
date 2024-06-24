package steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import utils.CommonMethods;
import utils.PageInitializer;

import java.io.IOException;

public class AccountCreationSteps extends CommonMethods {

    @When("I enter invalid account details")
    public void i_enter_invalid_account_details() {
        PageInitializer.accountCreationPage.enterFirstName("John");
        PageInitializer.accountCreationPage.enterLastName("Joe");
        PageInitializer.accountCreationPage.enterStreet("123 Main St");
        PageInitializer.accountCreationPage.enterCity("New York");
        PageInitializer.accountCreationPage.enterState("NY");
        PageInitializer.accountCreationPage.enterZipCode("10001");
        PageInitializer.accountCreationPage.enterPhoneNumber("1234567890");
        PageInitializer.accountCreationPage.enterSSN("123456789");
        PageInitializer.accountCreationPage.enterUsername("johnjoe");
        PageInitializer.accountCreationPage.enterPassword("Password123");
        PageInitializer.accountCreationPage.enterRepeatedPassword("Password1234");
    }

    @Then("I should see an account creation error message")
    public void i_should_see_an_account_creation_error_message() {
        String errorMessage = PageInitializer.accountCreationPage.getErrorMessage();
        System.out.println(errorMessage);
    }
}
