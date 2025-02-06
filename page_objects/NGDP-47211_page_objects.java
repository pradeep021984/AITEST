*****************




package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CartPage {

    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(id = "yourOrderSection") //Replace with actual locator
    private WebElement yourOrderSection;

    @FindBy(id = "memberOrderSection") //Replace with actual locator
    private WebElement memberOrderSection;


    @FindBy(id = "removeLastMemberItemButton") //Replace with actual locator
    private WebElement removeLastMemberItemButton;

    @FindBy(id = "groupOrderingCartPageTitle") //Replace with actual locator
    private WebElement groupOrderingCartPageTitle;

    public CartPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    public void navigateToCartPage() {
        // Add logic to navigate to the cart page
    }

    public void verifyYourOrderIsEmpty() {
        wait.until(ExpectedConditions.visibilityOf(yourOrderSection));
        // Add assertion to check if your order section is empty
    }

    public void verifyMemberOrderIsEmpty() {
        wait.until(ExpectedConditions.visibilityOf(memberOrderSection));
        // Add assertion to check if member order section is empty
    }

    public void removeLastMemberItem() {
        wait.until(ExpectedConditions.elementToBeClickable(removeLastMemberItemButton));
        removeLastMemberItemButton.click();
    }


    public void verifyGroupOrderingCartPage() {
        wait.until(ExpectedConditions.visibilityOf(groupOrderingCartPageTitle));
        // Add assertion to check if the group ordering cart page is displayed
    }
}
