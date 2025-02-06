*****************




package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;


public class HomePage {
    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(id = "signInButton")
    private WebElement signInButton;

    @FindBy(id = "hamburgerMenu")
    private WebElement hamburgerMenu;

    // ... other page elements

    public HomePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    public void login(String username, String password) {
        signInButton.click();
        // Enter username and password and click login.
    }

    public void isOnHomePage(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("homepageElement")));
    }

    public void clickHamburgerMenu(){
        hamburgerMenu.click();
    }

}


//GroupOrderPage
public class GroupOrderPage {
    private WebDriver driver;
    private WebDriverWait wait;


    //Add all the webElements and methods here for groupOrderPage

    public GroupOrderPage(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }


    public void clickCTA(String ctaText){
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='"+ctaText+"']"))).click();
    }

    public void isInviteDrawerVisible(){
        //Verify if Invite drawer is visible
    }

    public void isCartEmpty(){
        //Verify if the cart is empty
    }
}


//ErrorPage

public class ErrorPage{
    private WebDriver driver;
    private WebDriverWait wait;

    // Add all the webElements and methods here for ErrorPage

    public ErrorPage(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    public void verifyErrorMessage(io.cucumber.datatable.DataTable dataTable){
        //Verify Error Message with the datatable
    }
}


