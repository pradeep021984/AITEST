*****************




import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import static org.junit.Assert.*;
import pages.CartPage;

public class GroupOrderSteps {

    private CartPage cartPage;

    public GroupOrderSteps(CartPage cartPage) {
        this.cartPage = cartPage;
    }


    @Given("the user is on the cart screen")
    public void userIsOnTheCartScreen() {
        cartPage.navigateToCartScreen(); 
    }

    @Given("other group members have successfully submitted items")
    public void otherGroupMembersHaveSubmittedItems() {
        cartPage.ensureItemsSubmittedByOthers();
    }

    @When("the user views the cart")
    public void userViewsTheCart() {
        //No action needed, as this is implied in the scenario setup
    }

    @Then("the user should see all submitted items from other group members")
    public void userShouldSeeAllSubmittedItems() {
        assertTrue(cartPage.areAllItemsVisible());
    }

    @When("the host removes an item submitted by another member")
    public void hostRemovesAnItem() {
        cartPage.removeAnItem();
    }

    @Then("the user should see \"No Items\" message for that member")
    public void userShouldSeeNoItemsMessage() {
        assertTrue(cartPage.isNoItemsMessageVisible());
    }

    @Then("the \"No Items\" message should match the Figma design in terms of text, size, and styling")
    public void noItemsMessageMatchesFigmaDesign() {
        cartPage.verifyNoItemsMessageDesign();
    }


    //Add steps for other scenarios similarly...  Example for negative scenarios below

    @Given("no other group members have submitted items")
    public void noOtherMembersSubmitted() {
        //Implementation to handle the case where no items are submitted
    }

    @Then("the user should see a message indicating no items are available or appropriate empty state")
    public void noItemsMessageDisplayed() {
        //Implementation to verify the empty state message
    }
     @Given("the user is on the home screen")
    public void userIsOnHomeScreen() {
       // Implementation to navigate to home screen
    }

    @When("the user attempts to view group order items")
    public void userAttemptsToViewGroupOrderItems() {
        //Implementation to simulate the attempt to view group items
    }
    // Add similar steps for the remaining scenarios
}


***********