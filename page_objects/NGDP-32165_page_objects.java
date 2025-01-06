*****************

**Page Object Code**:

```java
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class GroupOrderPage {

    private WebDriver driver;
    private WebDriverWait wait;

    //Locators for elements on the page using Selenium locators like @FindBy, etc.
    @FindBy(id = "signInButton")
    private WebElement signInButton;

    @FindBy(id = "usernameField")
    private WebElement usernameField;

    @FindBy(id = "passwordField")
    private WebElement passwordField;

    @FindBy(id = "loginButton")
    private WebElement loginButton;

    //Add more @FindBy annotations for all UI elements

    @FindBy(id = "suggestedOrderLimitSwitch")
    private WebElement suggestedOrderLimitSwitch;


    @FindBy(id = "suggestedOrderLimitField")
    private WebElement suggestedOrderLimitField;

    @FindBy(id = "suggestedOrderLimitChevron")
    private WebElement suggestedOrderLimitChevron;


    // Constructor to initialize the page
    public GroupOrderPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    public void launchAppAndLogin() {
        //Code to launch the app and perform login actions.  Use your WebDriver methods.
        wait.until(ExpectedConditions.visibilityOf(signInButton)).click();
        usernameField.sendKeys("validUser");
        passwordField.sendKeys("validPassword");
        loginButton.click();

    }

    public void navigateToGroupOrderInfoScreen() {
        // Code to navigate to the group order info screen.  Use page actions or clicks.
    }


    public void toggleSwitch(String switchName, String toggleState) {
        //Implement logic to toggle the switch based on switchName and toggleState
        if (switchName.equals("Set suggested order limit") && toggleState.equals("on")) {
            suggestedOrderLimitSwitch.click();
        }
        //Handle other cases accordingly
    }


    public void verifyFieldDisplay(String fieldName, String value) {
        WebElement field = driver.findElement(By.id(fieldName)); //Change Id as per your actual element
        String actualValue = field.getText();
        if(value.isEmpty()){
            if(actualValue != null && !actualValue.isEmpty())
                throw new AssertionError("Expected empty value but found "+ actualValue);
        } else{
            if (!actualValue.equals(value)) {
                throw new AssertionError("Expected value: " + value + ", but found: " + actualValue);
            }
        }
    }

    public void verifyFieldHighlight(String color) {
       //Implement logic to verify field highlight color using CSS or other Selenium methods
    }

    public void verifySubtext(String subtext) {
        //Implement logic to verify subtext using Selenium methods
    }

    public void clickChevronIcon(String fieldName) {
        if(fieldName.equals("No Limit Set")){
            suggestedOrderLimitChevron.click();
        }
        //Implement for other cases.
    }

    public void verifyDrawerAttributes(io.cucumber.datatable.DataTable dataTable) {
        //Implement logic to verify drawer attributes using dataTable
    }

    public void setSuggestedOrderLimit(String limit, String button) {
        //Implement logic to set limit and click button
    }

    public void clickSetLimitWithoutValue(String button) {
         //Implement logic to click Set Limit button without entering a value
    }


    // Add more methods as needed for different page interactions
}
```

Remember to replace placeholder IDs and implement the actual logic within the page object methods using Selenium WebDriver commands.  This provides a basic structure; you'll need to adapt it based on your specific application's implementation details.  You'll also need to add appropriate dependency management (e.g., using Maven or Gradle) for Cucumber and Selenium.  Consider adding error handling and more robust assertions to enhance the reliability of your tests.