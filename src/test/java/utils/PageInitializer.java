package utils;

import pages.AccountCreationPage;
import pages.AccountOverviewPage;
import pages.LoginPage;
import pages.UpdatePersonalInfoPage;
import org.openqa.selenium.WebDriver;

public class PageInitializer {
    public static AccountCreationPage accountCreationPage;
    public static AccountOverviewPage accountOverviewPage;
    public static LoginPage loginPage;
    public static UpdatePersonalInfoPage updatePersonalInfoPage; // Added this line

    public static void initializePageObjects(WebDriver driver) {
        accountCreationPage = new AccountCreationPage(driver);
        accountOverviewPage = new AccountOverviewPage(driver);
        loginPage = new LoginPage(driver);
        updatePersonalInfoPage = new UpdatePersonalInfoPage(driver); // Added this line
    }
}
