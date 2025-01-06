*****************

**Step Definition Code**:

```java
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.GroupOrderPage; //Import your Page Object class

public class GroupOrderSteps {

    GroupOrderPage groupOrderPage = new GroupOrderPage(); // Initialize Page Object

    @Given("the user has launched the app")
    public void userHasLaunchedTheApp() {
        // Launch the app logic
        groupOrderPage.launchApp();
    }

    @And("the user clicks on the Sign in CTA and logs in using valid credentials")
    public void userClicksOnSignInCTAAndLogsIn() {
        groupOrderPage.signIn("validUser", "validPassword");
    }

    // Add more step definitions for other Given, When, and Then steps in the scenarios.  
    // Use groupOrderPage object to interact with page elements.  Examples below:

    @And("the user should be able to view the Group order CTA in the secondary navigation")
    public void userShouldSeeGroupOrderCTA() {
        groupOrderPage.verifyGroupOrderCTA();
    }

    @When("the user toggles on the Set suggested order limit")
    public void userTogglesOnSetSuggestedOrderLimit(){
        groupOrderPage.toggleSuggestedOrderLimit();
    }

    @Then("the user should be able to view limit set field with field name as “No Limit Set”")
    public void verifyNoLimitSet(){
        groupOrderPage.verifyNoLimitSet();
    }


    // Add more Step definitions for remaining scenarios similarly.  Refer to Page Object methods below for element interactions.
}
```

***********