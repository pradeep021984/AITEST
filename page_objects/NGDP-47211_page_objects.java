*****************


//Page Object Code (Java) - Example

package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CartPage {

    private static final Logger logger = LoggerFactory.getLogger(CartPage.class);
    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(id = "yourOrderSection") //Replace with actual locators
    private WebElement yourOrderSection;

    @FindBy(id = "memberOrderSection")
    private WebElement memberOrderSection;


    @FindBy(id = "proceedToCheckout")
    private WebElement proceedToCheckoutButton;


    // Add other WebElements as needed

    public CartPage(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Adjust timeout as needed
        PageFactory.initElements(driver, this);
    }


    public void navigateToCartPage() {
        // Add navigation logic here, e.g., driver.get("cart_page_url");
        logger.info("Navigating to cart page");

        wait.until(ExpectedConditions.visibilityOf(yourOrderSection)); // Wait for elements to load

        logger.info("Cart page loaded");
    }

    public boolean isYourOrderEmpty() {
        // Add logic to check if the Your Order section is empty, e.g., check for empty list or message
        logger.info("Checking Your Order section");
        return yourOrderSection.getText().isEmpty(); // Example - Replace with appropriate logic
    }


    public boolean isMemberOrderEmpty() {
        // Add logic to check if the Member Order section is empty
        logger.info("Checking Member Order section");
        return memberOrderSection.getText().isEmpty();// Example - Replace with appropriate logic
    }

    public void removeMemberItems() {
        // Add logic to remove items from Member Order section, e.g., click on remove buttons
        logger.info("Removing items from Member Order");
        //Implement removal logic
    }

    //Add other methods as needed for other scenarios.  For example, methods to interact with elements.

}


//Create other Page Objects as needed (e.g., LoginPage)
