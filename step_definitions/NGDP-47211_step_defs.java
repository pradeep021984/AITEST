*****************

# Step Definition Code (Java - Example)


import io.cucumber.java.en.*;
import pages.*; //Import your page object classes

public class GroupOrderStepDefs {

    CartPage cartPage; // Initialize page objects


    @Given("the user is on the cart page")
    public void user_is_on_the_cart_page() {
        // Navigate to the cart page
        cartPage = new CartPage(); 
        cartPage.navigateToCartPage(); 
    }

    @Given("the your order section is {string}")
    public void your_order_section_is(String status) {
        // Verify Your Order section status (empty or not empty)
        cartPage.verifyYourOrderStatus(status);
    }

    @Given("the member order section is {string}")
    public void member_order_section_is(String status) {
        //Verify Member Order section status
        cartPage.verifyMemberOrderStatus(status);

    }

    @When("the host removes the last member item")
    public void the_host_removes_the_last_member_item() {
        // Simulate removing the last member item
        cartPage.removeLastMemberItem();
    }

    @Then("the host should be taken to the group ordering cart page")
    public void the_host_should_be_taken_to_the_group_ordering_cart_page() {
        // Verify navigation to the cart page
        cartPage.verifyCartPageDisplayed();
    }


    //Add Step definitions for other scenarios
}



***********