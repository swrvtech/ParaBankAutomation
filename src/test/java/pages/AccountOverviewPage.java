package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.CommonMethods;

public class AccountOverviewPage extends CommonMethods {

    // Define locators for the Account Overview page
    By accountOverviewLink = By.linkText("Accounts Overview");
    By accountTable = By.id("accountTable");

    // Constructor
    public AccountOverviewPage(WebDriver driver) {
        this.driver = driver;
    }

    // Method to navigate to Account Overview page
    public void navigateToAccountOverview() {
        driver.findElement(accountOverviewLink).click();
    }

    // Method to verify account information is displayed
    public boolean isAccountInformationDisplayed() {
        return driver.findElement(accountTable).isDisplayed();
    }
}