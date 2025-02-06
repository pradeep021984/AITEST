*****************

# Page Object Code (Java - Example)


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CartPage {

    private WebDriver driver;
    private WebDriverWait wait;

    //Page elements (using Selenium locators)

    @FindBy(id = "yourOrderSection")
    private WebElement yourOrderSection;

    @FindBy(id = "memberOrderSection")
    private WebElement memberOrderSection;

    @FindBy(id = "removeMemberItemButton")
    private WebElement removeMemberItemButton;

    @FindBy(id = "groupOrderTitle")
    private WebElement groupOrderTitle;

    @FindBy(id = "createOrderButton")
    private WebElement createOrderButton;


    //Constructor
    public CartPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 10);
        PageFactory.initElements(driver, this);
    }

    public void navigateToCartPage(){
        //logic to navigate to cart
    }

    public void verifyYourOrderStatus(String status){
        //logic to verify your order section
    }

    public void verifyMemberOrderStatus(String status){
        //logic to verify member order section
    }


    public void removeLastMemberItem() {
        wait.until(ExpectedConditions.elementToBeClickable(removeMemberItemButton));
        removeMemberItemButton.click();
    }


    public void verifyCartPageDisplayed(){
        //Logic to verify cart page elements
    }

      public void verifyGroupOrderTitle(){
        wait.until(ExpectedConditions.visibilityOf(groupOrderTitle));
    }

    public void verifyCreateOrderButton(){
        wait.until(ExpectedConditions.visibilityOf(createOrderButton));

    }
     //Add methods for other scenarios
}
