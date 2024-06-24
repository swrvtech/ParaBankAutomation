package utils;

import pages.AccountCreationPage;
import pages.AccountOverviewPage;
import pages.LoginPage;
import org.openqa.selenium.WebDriver;

public class PageInitializer {
    public static AccountCreationPage accountCreationPage;
    public static AccountOverviewPage accountOverviewPage;
    public static LoginPage loginPage;
    public static WebDriver driver;

    public static void initializePageObjects() {
        accountCreationPage = new AccountCreationPage(driver);
        accountOverviewPage = new AccountOverviewPage(driver);
        loginPage = new LoginPage(driver);
    }
}