*****************


//Page Object Code (Java) -Skeleton code.  Expand based on app structure

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage {

    private WebDriver driver;

    @FindBy(id = "cart-items-container") //Replace with actual locator
    private WebElement cartItemsContainer;

    @FindBy(id = "no-items-message") //Replace with actual locator
    private WebElement noItemsMessage;


    public CartPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public boolean areItemsVisible(){
        //Implementation to check if items are visible
        return cartItemsContainer.isDisplayed();
    }

    public String getNoItemsMessage(){
        return noItemsMessage.getText();
    }

    public void removeItem(String itemName){
        //Implementation to remove a specific item
    }

    //Add other methods as per your application's structure.  For example methods to get the text, styling details for UI validation.

}

//Add more Page Objects as needed (e.g., LoginPage, etc.)