*****************




import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.CartPage; //Import your CartPage object

public class CartStepDefs {

    CartPage cartPage = new CartPage(); //Initialize CartPage

    @Given("the user \\(host\\) is on the cart page")
    public void userIsOnCartPage() {
        //Navigate to Cart Page
        cartPage.navigateToCartPage();
        Assert.assertTrue("User is not on the Cart Page", cartPage.isOnCartPage());
    }

    @And("the user can view the member order section")
    public void userCanViewMemberOrderSection() {
        Assert.assertTrue("Member Order Section not visible", cartPage.isMemberOrderSectionVisible());
    }

    @When("the host clicks on the Edit CTA for a line item in the member order section")
    public void hostClicksEditCTA() {
        cartPage.clickEditCTAForLineItem();
    }

    @Then("the user should see the PDP drawer with modifiers")
    public void userSeesPDPDrawer() {
        Assert.assertTrue("PDP Drawer not visible", cartPage.isPDPDrawerVisible());
    }

    //Add remaining Then steps for error messages, success toasts, confirmation drawers, etc., similarly.  Use cartPage methods to verify UI elements.

    // Add similar step definitions for Scenario 2 and Scenario 3, using appropriate methods from the CartPage class.
}


***********