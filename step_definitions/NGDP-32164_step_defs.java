*****************

**Step Definition Code**:

```java
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.GroupOrderPage;
import pages.HomePage;
import pages.LoginPage;

public class GroupOrderSteps {

    private HomePage homePage;
    private LoginPage loginPage;
    private GroupOrderPage groupOrderPage;

    public GroupOrderSteps(HomePage homePage, LoginPage loginPage, GroupOrderPage groupOrderPage){
        this.homePage = homePage;
        this.loginPage = loginPage;
        this.groupOrderPage = groupOrderPage;
    }

    @Given("the user has launched the app")
    public void userHasLaunchedTheApp() {
        // Launch the app - implementation needed
    }

    @And("user clicks on the Sign in CTA and logs in using valid credentials")
    public void userClicksOnTheSignInCTAAndLogsInUsingValidCredentials() {
        loginPage.navigateToLogin();
        loginPage.login("validUser", "validPassword"); // Replace with actual credentials
    }

    @And("user is landed on the homepage")
    public void userIsLandedOnTheHomepage() {
        homePage.verifyHomePage();
    }

    // ... (Add remaining Given steps based on the scenarios) ...

    @When("user clicks on the NEXT cta")
    public void userClicksOnTheNEXTCta() {
        groupOrderPage.clickNext();
    }

    @Then("user should be able to view the Group order info screen with the scheduled time as ASAP")
    public void userShouldBeAbleToViewTheGroupOrderInfoScreenWithTheScheduledTimeAsASAP() {
        groupOrderPage.verifyOrderInfoScreen("ASAP");
    }

    // ... (Add remaining When and Then steps based on the scenarios) ...

    @When("the user toggles off the Set suggested order by time")
    public void theUserTogglesOffTheSetSuggestedOrderByTime() {
        groupOrderPage.toggleSuggestedOrderTime(false);
    }

    @Then("the user should see the select time field hidden")
    public void theUserShouldSeeTheSelectTimeFieldHidden() {
        groupOrderPage.verifyTimeFieldHidden();
    }
}
```

***********