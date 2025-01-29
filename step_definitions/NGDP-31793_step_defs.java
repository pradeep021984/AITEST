*****************

**Step Definition Code**:

```java
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class GroupOrderStepDefs {

    private WebDriver driver; // Inject WebDriver instance - manage this in your test runner
    private CartPage cartPage; // Inject CartPage object

    public GroupOrderStepDefs(WebDriver driver, CartPage cartPage) {
        this.driver = driver;
        this.cartPage = cartPage;
    }

    @Given("the group member is on the cart page")
    public void theGroupMemberIsOnTheCartPage() {
        // Navigate to the cart page.  Implement logic in CartPage class
        cartPage.navigateToCartPage();
    }

    @Given("the user adds items to the cart")
    public void theUserAddsItemsToTheCart() {
        // Add items to the cart. Implement logic in CartPage class.
        cartPage.addItemsToCart();
    }

    @Given("the user can view the CART Title")
    public void theUserCanViewTheCARTTitle() {
        Assert.assertTrue(cartPage.isCartTitleVisible());
    }

    @Given("the user can view the group order's name")
    public void theUserCanViewTheGroupOrderSName() {
        Assert.assertTrue(cartPage.isGroupNameVisible());
    }

    @Given("the user can view the order by date and time")
    public void theUserCanViewTheOrderByDateAndTime() {
        Assert.assertTrue(cartPage.isOrderDateTimeVisible());
    }

    @Given("the user can view the order limit of $15")
    public void theUserCanViewTheOrderLimitOf15() {
        String orderLimit = cartPage.getOrderLimit();
        Assert.assertEquals("15", orderLimit); // Adjust assertion based on how limit is displayed
    }

    @Given("the user can view their order with added items")
    public void theUserCanViewTheirOrderWithAddedItems() {
        Assert.assertTrue(cartPage.areItemsVisibleInCart());
    }


    @When("the user exceeds the order limit")
    public void theUserExceedsTheOrderLimit() {
        // Add items until the limit is exceeded.  Implement in CartPage
        cartPage.exceedOrderLimit();
    }

    @Then("the user sees the message {string} with an Info icon")
    public void theUserSeesTheMessageWithAnInfoIcon(String message) {
        WebElement messageElement = driver.findElement(By.xpath("//*[contains(text(),'" + message + "')]")); //Adjust locator as needed
        Assert.assertTrue(messageElement.isDisplayed());
    }


    @Then("the user can still proceed with the {string} CTA")
    public void theUserCanStillProceedWithTheCTA(String ctaText) {
        WebElement ctaButton = driver.findElement(By.xpath("//*[contains(text(),'" + ctaText + "')]")); //Adjust locator as needed
        Assert.assertTrue(ctaButton.isDisplayed());
        Assert.assertTrue(ctaButton.isEnabled());
    }
}
```

***********