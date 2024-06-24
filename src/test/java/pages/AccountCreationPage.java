package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.CommonMethods;

public class AccountCreationPage extends CommonMethods {

    // Locators for account creation fields
    By firstName = By.id("customer.firstName");
    By lastName = By.id("customer.lastName");
    By street = By.id("customer.address.street");
    By city = By.id("customer.address.city");
    By state = By.id("customer.address.state");
    By zipCode = By.id("customer.address.zipCode");
    By phoneNumber = By.id("customer.phoneNumber");
    By ssn = By.id("customer.ssn");
    By username = By.id("customer.username");
    By password = By.id("customer.password");
    By repeatedPassword = By.id("repeatedPassword");
    By registerButton = By.xpath("//input[@type='submit' and @value='Register']");
    By successMessage = By.xpath("//p[contains(text(), 'Your account was created successfully. You are now logged in.')]");
    By errorMessage = By.xpath("//span[@id='repeatedPassword.errors']");

    // Constructor
    public AccountCreationPage(WebDriver driver) {
        this.driver = CommonMethods.driver;
    }

    // Methods to interact with the fields
    public void enterFirstName(String fName) {
        driver.findElement(firstName).sendKeys(fName);
    }

    public void enterLastName(String lName) {
        driver.findElement(lastName).sendKeys(lName);
    }

    public void enterStreet(String str) {
        driver.findElement(street).sendKeys(str);
    }

    public void enterCity(String cty) {
        driver.findElement(city).sendKeys(cty);
    }

    public void enterState(String st) {
        driver.findElement(state).sendKeys(st);
    }

    public void enterZipCode(String zip) {
        driver.findElement(zipCode).sendKeys(zip);
    }

    public void enterPhoneNumber(String phone) {
        driver.findElement(phoneNumber).sendKeys(phone);
    }

    public void enterSSN(String social) {
        driver.findElement(ssn).sendKeys(social);
    }

    public void enterUsername(String user) {
        driver.findElement(username).sendKeys(user);
    }

    public void enterPassword(String pwd) {
        driver.findElement(password).sendKeys(pwd);
    }

    public void enterRepeatedPassword(String rPwd) {
        driver.findElement(repeatedPassword).sendKeys(rPwd);
    }

    public void clickRegisterButton() {
        driver.findElement(registerButton).click();
    }

    public String getSuccessMessage() {
        return driver.findElement(successMessage).getText();
    }

    public String getErrorMessage() {
        return driver.findElement(errorMessage).getText();
    }
}