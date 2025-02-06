*****************


//Step Definition Code (Java) - Example using Cucumber

import io.cucumber.java.en.*;
import pageObjects.*; //Import your page object classes

public class GroupOrderStepDefs {

    CartPage cartPage; //Initialize your page objects


    @Given("the user is on the cart page")
    public void user_is_on_the_cart_page() {
        cartPage = new CartPage(); //Initialize page object
        cartPage.navigateToCartPage();
        // Add assertions to validate page load
    }

    @Given("the {string} section is {string}")
    public void the_section_is(String section, String status) {
        // Add logic to check section status
        if (section.equals("your order")) {
            //Check Your Order section is empty or not
        } else if (section.equals("member order")) {
           //Check Member Order section is empty or not
        }
    }

    @When("the host removes the member items")
    public void the_host_removes_the_member_items() {
        cartPage.removeMemberItems();
        //Add specific logic for removing items
    }

    @Then("the host should be able to view the group ordering cart page")
    public void the_host_should_be_able_to_view_the_group_ordering_cart_page() {
        //Add Assertions to validate cart page is displayed
    }

    // Add more step definitions for other scenarios
}


***********