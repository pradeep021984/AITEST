*****************


//Page Object Code (Example - needs expansion based on your framework and specific UI elements)

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {

    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(id = "hamburgerIcon")
    private WebElement hamburgerIcon;

    @FindBy(id = "groupOrderCTA")
    private WebElement groupOrderCTA;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 10);
        PageFactory.initElements(driver, this);
    }


    public void clickHamburgerIcon() {
        wait.until(ExpectedConditions.elementToBeClickable(hamburgerIcon)).click();
    }


    public GroupOrderPage navigateToGroupOrder() {
        wait.until(ExpectedConditions.elementToBeClickable(groupOrderCTA)).click();
        return new GroupOrderPage(driver);
    }
}

// Add other page objects (GroupOrderPage, etc.) similarly.  Include methods for interacting with specific UI elements.  
