*****************




import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class CartPage {
    private WebDriver driver;
    private WebDriverWait wait;

    //Locators for Cart Page Elements
    @FindBy(id = "memberOrderSection") //Replace with actual ID
    private WebElement memberOrderSection;

    @FindBy(id = "editCTA") //Replace with actual ID
    private WebElement editCTA;

    @FindBy(id = "removeCTA") //Replace with actual ID
    private WebElement removeCTA;

    @FindBy(id = "duplicateCTA") //Replace with actual ID
    private WebElement duplicateCTA;

    //Add locators for all other elements needed in your scenarios: PDP drawer, confirmation drawer, success toast, error messages, etc.


    public CartPage(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver,10);
        PageFactory.initElements(driver, this);
    }

    public void navigateToCartPage(){
        //Add logic to navigate to Cart page
    }

    public boolean isOnCartPage(){
        // Add logic to check if current page is the cart page
        return true; //Replace with actual logic
    }

    public boolean isMemberOrderSectionVisible(){
        wait.until(ExpectedConditions.visibilityOf(memberOrderSection));
        return memberOrderSection.isDisplayed();
    }

    public void clickEditCTAForLineItem(){
        wait.until(ExpectedConditions.elementToBeClickable(editCTA)).click();
    }

    public boolean isPDPDrawerVisible(){
       //Add logic to check if PDP drawer is visible
        return true; //Replace with actual logic
    }

    //Add methods for other actions like clicking Remove CTA, Duplicate CTA, verifying success toast, error messages, etc.
}
