package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class AccountCreationPage {
    WebDriver driver;

    public AccountCreationPage(WebDriver driver) {
        this.driver = driver;
    }

    By firstName = By.id("customer.firstName");
    By lastName = By.id("customer.lastName");
    By addressStreet = By.id("customer.address.street");
    By addressCity = By.id("customer.address.city");
    By addressState = By.id("customer.address.state");
    By addressZipCode = By.id("customer.address.zipCode");
    By phoneNumber = By.id("customer.phoneNumber");
    By ssn = By.id("customer.ssn");
    By username = By.id("customer.username");
    By password = By.id("customer.password");
    By repeatedPassword = By.id("repeatedPassword");
    By registerButton = By.xpath("//input[@value='Register']");
    By successMessage = By.xpath("//p[text()='Your account was created successfully. You are now logged in.']");
<<<<<<< HEAD
    By errorMessage = By.xpath("//p[contains(text(),'error')]"); // Adjust the locator based on the actual error message element
=======
    By errorMessage = By.id("repeatedPassword.errors"); // Updated locator based on the provided HTML snippet
>>>>>>> 33ce62c (error message displayed)

    public void enterFirstName(String fname) {
        if (fname != null) driver.findElement(firstName).sendKeys(fname);
    }

    public void enterLastName(String lname) {
        if (lname != null) driver.findElement(lastName).sendKeys(lname);
    }

    public void enterAddressStreet(String street) {
        if (street != null) driver.findElement(addressStreet).sendKeys(street);
    }

    public void enterAddressCity(String city) {
        if (city != null) driver.findElement(addressCity).sendKeys(city);
    }

    public void enterAddressState(String state) {
        if (state != null) driver.findElement(addressState).sendKeys(state);
    }

    public void enterAddressZipCode(String zipCode) {
        if (zipCode != null) driver.findElement(addressZipCode).sendKeys(zipCode);
    }

    public void enterPhoneNumber(String phone) {
        if (phone != null) driver.findElement(phoneNumber).sendKeys(phone);
    }

    public void enterSSN(String ssnNumber) {
        if (ssnNumber != null) driver.findElement(ssn).sendKeys(ssnNumber);
    }

    public void enterUsername(String uname) {
        if (uname != null) driver.findElement(username).sendKeys(uname);
    }

    public void enterPassword(String pwd) {
        if (pwd != null) driver.findElement(password).sendKeys(pwd);
    }

    public void enterRepeatedPassword(String rpwd) {
        if (rpwd != null) driver.findElement(repeatedPassword).sendKeys(rpwd);
    }

    public void clickRegisterButton() {
        driver.findElement(registerButton).click();
    }

    public boolean isAccountCreationSuccessMessageDisplayed() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement messageElement = wait.until(ExpectedConditions.visibilityOfElementLocated(successMessage));
        return messageElement.isDisplayed();
    }

    public boolean isErrorMessageDisplayed() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement messageElement = wait.until(ExpectedConditions.visibilityOfElementLocated(errorMessage));
        return messageElement.isDisplayed();
    }
}
