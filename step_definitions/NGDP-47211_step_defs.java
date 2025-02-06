*****************




import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.CartPage;

public class CartStepDefs {

    CartPage cartPage = new CartPage();

    @Given("the user is on the cart page")
    public void userIsOnCartPage() {
        cartPage.navigateToCartPage();
    }

    @And("the your order section is empty")
    public void yourOrderSectionIsEmpty() {
        cartPage.verifyYourOrderIsEmpty();
    }

    @And("the member order section is empty")
    public void memberOrderSectionIsEmpty() {
        cartPage.verifyMemberOrderIsEmpty();
    }

    @When("the host removes the last member item")
    public void hostRemovesLastMemberItem() {
        cartPage.removeLastMemberItem();
    }


    @Then("the host should be taken to the group ordering cart page")
    public void hostShouldSeeGroupOrderingCartPage() {
        cartPage.verifyGroupOrderingCartPage();

    }
}


***********