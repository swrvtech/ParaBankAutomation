package steps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import utils.CommonMethods;

import java.lang.reflect.Method;
import java.util.HashMap;
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
    public void iUpdateTheFollowingPersonalInformation(DataTable dataTable) throws Exception {
        List<Map<String, String>> personalInfoList = dataTable.asMaps(String.class, String.class);
        Map<String, String> personalInfo = personalInfoList.get(0);

        // Map field keys to their corresponding methods
        Map<String, String> fieldMethodMap = new HashMap<>();
        fieldMethodMap.put("firstName", "enterFirstName");
        fieldMethodMap.put("lastName", "enterLastName");
        fieldMethodMap.put("addressStreet", "enterAddressStreet");
        fieldMethodMap.put("addressCity", "enterAddressCity");
        fieldMethodMap.put("addressState", "enterAddressState");
        fieldMethodMap.put("addressZipCode", "enterAddressZipCode");
        fieldMethodMap.put("phoneNumber", "enterPhoneNumber");

        // Update all fields in the map
        for (Map.Entry<String, String> entry : personalInfo.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();

            if (fieldMethodMap.containsKey(key)) {
                // Get the corresponding method name
                String methodName = fieldMethodMap.get(key);
                // Use reflection to call the method
                Method method = updatePersonalInfoPage.getClass().getMethod(methodName, String.class);
                method.invoke(updatePersonalInfoPage, value);
            }
        }
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
