*****************




package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CartPage {

    private WebDriver driver;

    @FindBy(id = "cartButton") // Replace with actual locator
    private WebElement cartButton;

    @FindBy(className = "item-container") //Replace with actual locator
    private List<WebElement> items;

    @FindBy(id = "noItemsMessage") // Replace with actual locator
    private WebElement noItemsMessage;

    //Add other locators as needed from the Figma design (e.g., text size, styling)


    public CartPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    public void navigateToCartScreen() {
        cartButton.click();
    }

    public void ensureItemsSubmittedByOthers() {
        // Logic to ensure that items are submitted by other members before this step is executed
        // This may involve API calls or checking UI elements
    }

    public boolean areAllItemsVisible() {
        return items.size() > 0; // Adjust condition based on your app's implementation
    }

    public void removeAnItem() {
        // Logic to remove an item from the cart
        items.get(0).findElement(By.className("removeItem")).click(); //Replace with actual locator
    }

    public boolean isNoItemsMessageVisible() {
        return noItemsMessage.isDisplayed();
    }

    public void verifyNoItemsMessageDesign() {
         //Implementation to verify the No Items message against Figma design. 
         // This will likely involve getting the text, size and checking styling attributes using Selenium
    }

    // Add methods for handling other scenarios like empty cart, error messages etc.
}
