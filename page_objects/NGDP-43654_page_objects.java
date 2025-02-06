*****************


//Page Object Code (Java)

import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;


public class GroupOrderPage {

    private WebDriver driver;
    // Use PageFactory to initialize WebElements (By locators)
    //Example:  @FindBy(id = "signInButton") WebElement signInButton; 

    public GroupOrderPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    public void login(String username, String password){
        //Implementation to log in
        // driver.findElement(By.id("username")).sendKeys(username);
    }

    public boolean isOnHomePage(){
        //Implementation to check if on home page
        return true; // Replace with actual check
    }

    public void clickHamburger(){
        //Implementation to click the hamburger
    }

    public boolean isInviteDrawerVisible() {
        //Implementation
        return true; //Replace with actual check
    }

    public boolean isPersonalCartEmpty() {
        //Implementation
        return true; //Replace with actual check
    }

    public boolean isFullScreenErrorMessageDisplayed(String message) {
        //Implementation
        return driver.findElement(By.id("error-message")).getText().contains(message); //Replace with actual locator
    }
    //Add other methods for page interactions

}

// Other page objects (e.g., HomePage, SignInPage) would be created similarly.
