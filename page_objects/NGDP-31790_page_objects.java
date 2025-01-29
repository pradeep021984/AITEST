*****************

**Page Object Code**: Write Java PageObject: code with methods related to the scenarios and stepDef with logics and skeleton code for all pages

```java
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class GroupMemberLandingPage {

    private WebDriver driver;

    @FindBy(id = "userName")
    private WebElement userNameField;

    @FindBy(id = "joinGroupOrderButton")
    private WebElement joinGroupOrderButton;

    public GroupMemberLandingPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void enterName(String name) {
        userNameField.sendKeys(name);
    }

    public void clickJoinGroupOrderButton() {
        joinGroupOrderButton.click();
    }
}

public class CategoryLandingPage {
    private WebDriver driver;
    // ... Add WebElements for adding items and clicking "Done Adding Items"

    public CategoryLandingPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    public void addItemsToCart(){
        //add your logic here
    }

    public void clickDoneAddingItemsButton(){
        //add your logic here
    }
}


public class ConfirmationPage {
    private WebDriver driver;

    // ... Add WebElements for logo, image, title, copy text, button, close icon

    public ConfirmationPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void verifyLogoPresent(){
        //add your logic here
    }
    public void verifyImagePresent(){
        //add your logic here
    }
    public void clickCloseIcon(){
        //add your logic here
    }
    // Add other methods for verifying attributes

}
```

Remember to replace `"URL_OF_GROUP_MEMBER_LANDING_PAGE"`  and add the necessary `@FindBy` annotations and methods in the Page Objects based on your actual application's UI elements and IDs.  You will also need to implement the missing logic within the steps and page objects to interact with your application.  The `DataTable` handling in the `verifyConfirmationScreenAttributes` method is a placeholder and needs to be fleshed out with your specific verification logic.  Finally, ensure you have the correct Selenium dependencies in your project.