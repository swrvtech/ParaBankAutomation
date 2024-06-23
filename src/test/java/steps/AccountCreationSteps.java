package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import utils.CommonMethods;

import java.io.IOException;

public class AccountCreationSteps extends CommonMethods {

    @Given("I am on the Registration page")
    public void i_am_on_the_registration_page() throws IOException {
        driver.findElement(By.xpath("//a[contains(@href, 'register.htm')]")).click();
    }

    @When("I enter valid account details")
    public void i_enter_valid_account_details() {
        driver.findElement(By.id("customer.firstName")).sendKeys("John");
        driver.findElement(By.id("customer.lastName")).sendKeys("Foe");
        driver.findElement(By.id("customer.address.street")).sendKeys("123 Main St");
        driver.findElement(By.id("customer.address.city")).sendKeys("New York");
        driver.findElement(By.id("customer.address.state")).sendKeys("NY");
        driver.findElement(By.id("customer.address.zipCode")).sendKeys("10001");
        driver.findElement(By.id("customer.phoneNumber")).sendKeys("1234567890");
        driver.findElement(By.id("customer.ssn")).sendKeys("123456789");
        driver.findElement(By.id("customer.username")).sendKeys("johnfoe");
        driver.findElement(By.id("customer.password")).sendKeys("Password123");
        driver.findElement(By.id("repeatedPassword")).sendKeys("Password123");
    }

    @When("I submit the registration form")
    public void i_submit_the_registration_form() {
        driver.findElement(By.xpath("//input[@type='submit' and @value='Register']")).click();    }

    @Then("I should see an account creation success message")
    public void i_should_see_an_account_creation_success_message() {
        String successMessage = driver.findElement(By.xpath("//p[contains(text(), 'Your account was created successfully. You are now logged in.')]")).getText();
        System.out.println(successMessage);

    }

    @When("I enter invalid account details")
    public void i_enter_invalid_account_details() {
        driver.findElement(By.id("customer.firstName")).sendKeys("John");
        driver.findElement(By.id("customer.lastName")).sendKeys("Joe");
        driver.findElement(By.id("customer.address.street")).sendKeys("123 Main St");
        driver.findElement(By.id("customer.address.city")).sendKeys("New York");
        driver.findElement(By.id("customer.address.state")).sendKeys("NY");
        driver.findElement(By.id("customer.address.zipCode")).sendKeys("10001");
        driver.findElement(By.id("customer.phoneNumber")).sendKeys("1234567890");
        driver.findElement(By.id("customer.ssn")).sendKeys("123456789");
        driver.findElement(By.id("customer.username")).sendKeys("johnjoe");
        driver.findElement(By.id("customer.password")).sendKeys("Password123");
        driver.findElement(By.id("repeatedPassword")).sendKeys("Password1234");
    }

    @Then("I should see an error message")
    public void i_should_see_an_error_message() {
        String errorMessage = driver.findElement(By.xpath("//span[@id='repeatedPassword.errors']")).getText();
        System.out.println(errorMessage);

    }

    @Given("I have successfully created an account")
    public void i_have_successfully_created_an_account() throws IOException {
        setUp();
        driver.findElement(By.xpath("//a[contains(@href, 'register.htm')]")).click();
        driver.findElement(By.id("customer.firstName")).sendKeys("John");
        driver.findElement(By.id("customer.lastName")).sendKeys("Hoe");
        driver.findElement(By.id("customer.address.street")).sendKeys("123 Main St");
        driver.findElement(By.id("customer.address.city")).sendKeys("New York");
        driver.findElement(By.id("customer.address.state")).sendKeys("NY");
        driver.findElement(By.id("customer.address.zipCode")).sendKeys("10001");
        driver.findElement(By.id("customer.phoneNumber")).sendKeys("1234567890");
        driver.findElement(By.id("customer.ssn")).sendKeys("123456789");
        driver.findElement(By.id("customer.username")).sendKeys("johnhoe");
        driver.findElement(By.id("customer.password")).sendKeys("Password123");
        driver.findElement(By.id("repeatedPassword")).sendKeys("Password123");
        driver.findElement(By.xpath("//input[@type='submit' and @value='Register']")).click();
    }

    @Then("I should see the correct success message")
    public void i_should_see_the_correct_success_message() {
        String successMessage = driver.findElement(By.xpath("//p[contains(text(), 'Your account was created successfully. You are now logged in.')]")).getText();
        System.out.println(successMessage);

    }
}
