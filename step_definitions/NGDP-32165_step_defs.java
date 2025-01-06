*****************

**Step Definition Code**:

```java
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebElement;
import pages.GroupOrderPage;


public class GroupOrderStepDefs {

    private GroupOrderPage groupOrderPage;

    // Inject the page object using dependency injection
    public GroupOrderStepDefs(GroupOrderPage groupOrderPage) {
        this.groupOrderPage = groupOrderPage;
    }


    @Given("the user has launched the app and logged in successfully")
    public void userHasLaunchedAppAndLoggedInSuccessfully() {
        groupOrderPage.launchAppAndLogin();
    }

    @Given("the user is on the group order info screen")
    public void userIsOnTheGroupOrderInfoScreen() {
        groupOrderPage.navigateToGroupOrderInfoScreen();
    }

    @When("the user toggles the {string} switch {string}")
    public void userTogglesTheSwitch(String switchName, String toggleState) {
        groupOrderPage.toggleSwitch(switchName, toggleState);
    }

    @Then("the {string} field should display {string}")
    public void theFieldShouldDisplay(String fieldName, String value) {
        groupOrderPage.verifyFieldDisplay(fieldName, value);
    }

    @And("the field should be highlighted {string}")
    public void theFieldShouldBeHighlighted(String color) {
        groupOrderPage.verifyFieldHighlight(color);
    }

    @And("the subtext should be {string}")
    public void theSubtextShouldBe(String subtext) {
        groupOrderPage.verifySubtext(subtext);
    }

    @When("the user clicks the chevron icon in the {string} field")
    public void userClicksTheChevronIcon(String fieldName) {
        groupOrderPage.clickChevronIcon(fieldName);
    }

    @Then("the user should see a drawer with the following attributes:")
    public void theUserShouldSeeADrawerWithTheFollowingAttributes(io.cucumber.datatable.DataTable dataTable) {
        groupOrderPage.verifyDrawerAttributes(dataTable);
    }

    @When("the user sets the suggested order limit to {string} and clicks {string}")
    public void userSetsTheSuggestedOrderLimitToAndClicks(String limit, String button) {
        groupOrderPage.setSuggestedOrderLimit(limit, button);
    }

    @When("the user clicks the {string} button without entering a value")
    public void userClicksTheSetLimitButtonWithoutEnteringAValue(String button) {
        groupOrderPage.clickSetLimitWithoutValue(button);
    }

    // Add more step definitions as needed...

}
```

***********