package steps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import utils.CommonMethods;
import java.util.Map;
import java.util.List;
import static org.junit.Assert.assertTrue;
import static utils.PageInitializer.updatePersonalInfoPage;

public class UpdatePersonalInfoSteps extends CommonMethods {
    WebDriver driver = CommonMethods.driver;

    @When("I navigate to the Update Personal Information page")
    public void iNavigateToTheUpdatePersonalInformationPage() {
        updatePersonalInfoPage.navigateToUpdatePersonalInfoPage();
    }

    @When("I update the following personal information")
    public void iUpdateTheFollowingPersonalInformation(DataTable dataTable) {
        List<Map<String, String>> personalInfoList = dataTable.asMaps(String.class, String.class);
        Map<String, String> personalInfo = personalInfoList.get(0);

        personalInfo.forEach((key, value) -> {
            if (value != null && !value.isEmpty()) {
                switch (key) {
                    case "firstName":
                        updatePersonalInfoPage.enterFirstName(value);
                        break;
                    case "lastName":
                        updatePersonalInfoPage.enterLastName(value);
                        break;
                    case "addressStreet":
                        updatePersonalInfoPage.enterAddressStreet(value);
                        break;
                    case "addressCity":
                        updatePersonalInfoPage.enterAddressCity(value);
                        break;
                    case "addressState":
                        updatePersonalInfoPage.enterAddressState(value);
                        break;
                    case "addressZipCode":
                        updatePersonalInfoPage.enterAddressZipCode(value);
                        break;
                    case "phoneNumber":
                        updatePersonalInfoPage.enterPhoneNumber(value);
                        break;
                }
            }
        });
    }

    @When("I submit the update form")
    public void iSubmitTheUpdateForm() {
        updatePersonalInfoPage.clickUpdateButton();
    }

    @Then("I should see a personal information update success message")
    public void iShouldSeeAPersonalInformationUpdateSuccessMessage() {
        assertTrue(updatePersonalInfoPage.isUpdateSuccessMessageDisplayed());
    }

    @Then("I should see an invalid error message")
    public void iShouldSeeAnErrorMessage() {
        assertTrue(updatePersonalInfoPage.isErrorMessageDisplayed());
    }
}
