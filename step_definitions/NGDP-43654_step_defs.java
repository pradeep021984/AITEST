*****************




import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.And;
import pages.HomePage;
import pages.GroupOrderPage;
import pages.ErrorPage;

public class GroupOrderSteps {

    private HomePage homePage;
    private GroupOrderPage groupOrderPage;
    private ErrorPage errorPage;

    // Inject page objects using dependency injection (e.g., using Spring or a similar framework)
    // ...

    @Given("the user has launched the app")
    public void launchApp() {
        // Launch the app and handle any initial setup
    }

    @And("the user is logged in with valid credentials")
    public void login() {
        homePage.login("validUser", "validPassword");
    }

    @And("the user is on the homepage")
    public void onHomepage() {
        homePage.isOnHomePage();
    }

    // ... Add step definitions for other steps, using your page objects. Example below:
    @And("the user clicks on the \"(.*)\" CTA")
    public void clickCTA(String ctaText){
        groupOrderPage.clickCTA(ctaText);
    }

    @Then("the user should see the invite drawer")
    public void verifyInviteDrawer() {
        groupOrderPage.isInviteDrawerVisible();
    }

    @And("the user's personal cart should be cleared")
    public void verifyCartCleared() {
        groupOrderPage.isCartEmpty();
    }

    @Then("the user should see a full-screen error message with:")
    public void verifyErrorMessage(io.cucumber.datatable.DataTable dataTable) {
        errorPage.verifyErrorMessage(dataTable);
    }

}


***********