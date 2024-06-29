package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.CommonMethods;

public class UpdatePersonalInfoPage extends CommonMethods {
    WebDriver driver;

    public UpdatePersonalInfoPage(WebDriver driver) {
        this.driver = driver;
    }

    By firstName = By.id("customer.firstName");
    By lastName = By.id("customer.lastName");
    By addressStreet = By.id("customer.address.street");
    By addressCity = By.id("customer.address.city");
    By addressState = By.id("customer.address.state");
    By addressZipCode = By.id("customer.address.zipCode");
    By phoneNumber = By.id("customer.phoneNumber");
    By updateButton = By.xpath("//input[@value='Update Profile']");
    By successMessage = By.xpath("//p[text()='Your updated address and phone number have been added to the system.']");
    By errorMessage = By.xpath("//span[@class='error']");

    public void navigateToUpdatePersonalInfoPage() {
        driver.findElement(By.linkText("Update Contact Info")).click();
    }

    public void enterFirstName(String fname) {
        driver.findElement(firstName).sendKeys(fname);
    }

    public void enterLastName(String lname) {
        driver.findElement(lastName).sendKeys(lname);
    }

    public void enterAddressStreet(String street) {
        driver.findElement(addressStreet).sendKeys(street);
    }

    public void enterAddressCity(String city) {
        driver.findElement(addressCity).sendKeys(city);
    }

    public void enterAddressState(String state) {
        driver.findElement(addressState).sendKeys(state);
    }

    public void enterAddressZipCode(String zipCode) {
        driver.findElement(addressZipCode).sendKeys(zipCode);
    }

    public void enterPhoneNumber(String phone) {
        driver.findElement(phoneNumber).sendKeys(phone);
    }

    public void clickUpdateButton() {
        driver.findElement(updateButton).click();
    }

    public boolean isUpdateSuccessMessageDisplayed() {
        return driver.findElement(successMessage).isDisplayed();
    }

    public boolean isErrorMessageDisplayed() {
        return driver.findElement(errorMessage).isDisplayed();
    }
}
