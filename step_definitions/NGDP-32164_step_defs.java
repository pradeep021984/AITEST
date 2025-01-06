*****************

**Step Definition Code**:

```java
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.HomePage;
import pages.GroupOrderPage;
import pages.SignInPage;
import pages.OrderConfirmationPage;


public class GroupOrderSteps {

    private HomePage homePage;
    private SignInPage signInPage;
    private GroupOrderPage groupOrderPage;
    private OrderConfirmationPage orderConfirmationPage;


    // Inject page objects using dependency injection (e.g., using Cucumber's dependency injection)

    @Given("the user has launched the app")
    public void launchApp() {
        // Launch the app and navigate to the home screen.
        homePage = new HomePage();
        homePage.launchApp();

    }

    @And("the user clicks on the Sign in CTA and logs in using valid credentials")
    public void login() {
        signInPage = new SignInPage();
        signInPage.clickSignIn();
        signInPage.login("validUser", "validPassword");
    }


    @And("the user is landed on the homepage")
    public void onHomePage() {
        homePage.isOnHomePage();
    }

    @And("the user clicks on the hamburger icon")
    public void clickHamburger() {
        homePage.clickHamburger();
    }


    @And("the user should be able to view the Group order CTA in the secondary navigation")
    public void verifyGroupOrderCTA() {
        homePage.verifyGroupOrderCTA();
    }

    @And("on clicking Group order CTA, the user should be able to view the Group order naming screen")
    public void navigateToGroupOrderNaming() {
        homePage.clickGroupOrderCTA();
        // Add assertions to verify on naming screen.
    }

    @And("on clicking Next CTA, the user should be able to view the Enter your name screen")
    public void navigateToEnterNameScreen(){
        groupOrderPage = new GroupOrderPage();
        groupOrderPage.clickNext();
    }


    @When("the user clicks on the NEXT CTA")
    public void clickNext() {
        groupOrderPage.clickNext();

    }

    @Then("the user should be able to view the Group order info screen with the scheduled time as ASAP")
    public void verifyOrderinfoScreen() {
        groupOrderPage.verifyASAPSelected();
    }

    @And("the user should be able to set suggested order by time")
    public void setSuggestedOrderTime() {
        groupOrderPage.setSuggestedOrderTime();
    }

    @And("the user should be able to click on confirm CTA")
    public void clickConfirm() {
        groupOrderPage.clickConfirm();
    }

    @And("the ASAP timeframe should not be set until the user clicks on the checkout CTA")
    public void verifyASAPNotSetBeforeCheckout(){
       //Add assertions
    }

    @When("the user toggles off the \"Set suggested order by time\" option")
    public void toggleOffSuggestedTime() {
        groupOrderPage.toggleOffSuggestedTime();
    }

    @Then("the user should see the select time field hidden")
    public void verifyTimeFieldHidden() {
        groupOrderPage.verifyTimeFieldHidden();
    }

    @And("the user should be able to proceed to the next screen")
    public void proceedToNextScreen() {
        // Add assertions to verify navigation to the next screen
    }


}
```

***********