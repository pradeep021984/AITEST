*****************

**Step Definition Code**: Write Java StepDef: code for the given scenarios.

```java
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class GroupOrderSteps {

    private WebDriver driver; // Inject WebDriver instance
    private GroupMemberLandingPage groupMemberLandingPage;
    private CategoryLandingPage categoryLandingPage;
    private ConfirmationPage confirmationPage;


    // Constructor to inject the WebDriver instance
    public GroupOrderSteps(WebDriver driver) {
        this.driver = driver;
        groupMemberLandingPage = new GroupMemberLandingPage(driver);
        categoryLandingPage = new CategoryLandingPage(driver);
        confirmationPage = new ConfirmationPage(driver);

    }


    @Given("the user is on the Group Member Landing page")
    public void userIsOnGroupMemberLandingPage() {
        // Navigate to the Group Member Landing page
        driver.get("URL_OF_GROUP_MEMBER_LANDING_PAGE");
    }

    @When("the user provides his name and clicks on the Join Group Order Button")
    public void userJoinsGroupOrder() {
        groupMemberLandingPage.enterName("John Doe"); // Example name
        groupMemberLandingPage.clickJoinGroupOrderButton();
    }

    @And("the user adds items to the cart and clicks on the Done Adding Items Button")
    public void userAddsItemsToCart() {
        categoryLandingPage.addItemsToCart();
        categoryLandingPage.clickDoneAddingItemsButton();
    }

    @And("the user clicks on the Confirm Order Button")
    public void userConfirmsOrder() {
        //Implement logic here based on your UI
    }

    @And("the user is redirected to the confirmation page")
    public void userRedirectedToConfirmationPage() {
        //Assertion to check if the user is on confirmation page
    }

    @And("the user clicks on the close icon on the confirmation page")
    public void userClosesConfirmationPage() {
        confirmationPage.clickCloseIcon();
    }

    @When("the user clicks on the group order link")
    public void userClicksGroupOrderLink() {
        //Implement logic here based on your UI
    }

    @Then("the user should see the confirmation screen with the following attributes:")
    public void verifyConfirmationScreenAttributes(io.cucumber.datatable.DataTable dataTable) {
        // Verify attributes based on the DataTable
        for (io.cucumber.datatable.TableRow row : dataTable.asMaps(String.class, String.class)) {
            String attribute = row.get("Attribute");
            String detail = row.get("Details");
            // Add assertions to verify the presence and details of each attribute
            switch(attribute) {
                case "Moes Logo":
                    confirmationPage.verifyLogoPresent();
                    break;
                case "Decorative Image":
                    confirmationPage.verifyImagePresent();
                    break;
                // ...add other attributes
            }
        }
    }
}
```

***********