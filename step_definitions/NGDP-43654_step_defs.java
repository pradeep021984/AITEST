*****************


//Step Definition Code (Java) -  Example using JUnit and Selenium

import io.cucumber.java.en.*;
import org.openqa.selenium.*;
import org.junit.Assert;

public class GroupOrderSteps {

    private WebDriver driver; // Initialize WebDriver (e.g., ChromeDriver)
    private GroupOrderPage groupOrderPage; // Page Object

    // Constructor to inject WebDriver
    public GroupOrderSteps(WebDriver driver) {
        this.driver = driver;
        this.groupOrderPage = new GroupOrderPage(driver); // Initialize Page Object
    }

    @Given("the user has launched the app")
    public void launchApp() {
        // Launch app logic here
    }

    @And("the user clicks on the Sign in CTA and logs in with valid credentials {string}, {string}")
    public void login(String username, String password) {
       groupOrderPage.login(username, password);
    }

    @And("the user is landed on the homepage")
    public void onHomepage() {
        // Assertion to check if on homepage
        Assert.assertTrue(groupOrderPage.isOnHomePage());
    }

    @And("the user clicks on the hamburger icon")
    public void clickHamburger() {
        groupOrderPage.clickHamburger();
    }


    // Add more Step definitions for other Gherkin steps similarly...


    @Then("the user should see the invite drawer")
    public void verifyInviteDrawer(){
        Assert.assertTrue(groupOrderPage.isInviteDrawerVisible());
    }

    @And("the user's personal cart should be cleared")
    public void verifyCartCleared(){
       Assert.assertTrue(groupOrderPage.isPersonalCartEmpty());
    }


    @Then("the user should see a full-screen error message {string}")
    public void verifyFullScreenErrorMessage(String message) {
        Assert.assertTrue(groupOrderPage.isFullScreenErrorMessageDisplayed(message));
    }
    // ...other Step definitions
}


***********