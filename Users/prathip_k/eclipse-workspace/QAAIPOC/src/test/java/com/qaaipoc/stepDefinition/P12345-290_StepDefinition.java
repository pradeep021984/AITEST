
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public  class RegistrationStepDefinitions {

    private WebDriver driver;
    private RegistrationPage registrationPage;
    private WebDriverWait wait;


    public RegistrationStepDefinitions(WebDriver driver) {
        this.driver = driver;
        this.registrationPage = new RegistrationPage(driver);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @Given("a user is on the registration page")
    public void userIsOnTheRegistrationPage() {
        driver.get("YOUR_REGISTRATION_PAGE_URL"); // Replace with your registration page URL
    }

    @When("the user enters a valid email address: {string}")
    public void theUserEntersAValidEmailAddress(String email) {
        registrationPage.setEmail(email);
    }

    @When("the user enters an invalid email address: {string}")
    public void theUserEntersAnInvalidEmailAddress(String email) {
        registrationPage.setEmail(email);
    }

    @And("the user enters a valid username: {string}")
    public void theUserEntersAValidUsername(String username) {
        registrationPage.setUsername(username);
    }

    @And("the user enters an existing username: {string}")
    public void theUserEntersAnExistingUsername(String username) {
        registrationPage.setUsername(username);
    }

    @And("the user enters a valid password: {string}")
    public void theUserEntersAValidPassword(String password) {
        registrationPage.setPassword(password);
    }

    @And("the user enters an invalid password: {string}")
    public void theUserEntersAnInvalidPassword(String password) {
        registrationPage.setPassword(password);
    }

    @And("the user confirms the password: {string}")
    public void theUserConfirmsThePassword(String password) {
        registrationPage.setConfirmedPassword(password);
    }

    @And("the user confirms the password: {string}")
    public void theUserConfirmsThePassword2(String confirmedPassword) {
        registrationPage.setConfirmedPassword(confirmedPassword);
    }


    @And("the user clicks the \"Register\" button")
    public void theUserClicksTheRegisterButton() {
        registrationPage.clickRegister();
    }

    @Then("the user is redirected to the homepage or a confirmation page")
    public void theUserIsRedirectedToTheHomepageOrAConfirmationPage() {
        // Add assertion to check for redirection to homepage or confirmation page URL
        String currentUrl = driver.getCurrentUrl();
        //assert currentUrl.equals("YOUR_HOMEPAGE_URL") || currentUrl.equals("YOUR_CONFIRMATION_PAGE_URL"); //Replace with your URLs
    }

    @Then("the user sees an error message indicating an invalid email")
    public void theUserSeesAnErrorMessageIndicatingAnInvalidEmail() {
        //Add assertion to check for specific error message
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='error-message'][contains(text(),'Invalid email')]"))); // Replace with your error message locator
    }

    @Then("the user sees an error message indicating an invalid password")
    public void theUserSeesAnErrorMessageIndicatingAnInvalidPassword() {
        //Add assertion to check for specific error message
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='error-message'][contains(text(),'Invalid password')]"))); //Replace with your error message locator
    }

    @Then("the user sees an error message indicating a password mismatch")
    public void theUserSeesAnErrorMessageIndicatingAPasswordMismatch() {
        //Add assertion to check for specific error message
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='error-message'][contains(text(),'Passwords do not match')]"))); //Replace with your error message locator
    }

    @When("the user enters valid registration details")
    public void theUserEntersValidRegistrationDetails() {
        registrationPage.setEmail("validuser@example.com");
        registrationPage.setUsername("validuser");
        registrationPage.setPassword("ValidPassword!");
        registrationPage.setConfirmedPassword("ValidPassword!");
    }

    @Then("the URL changes to the homepage URL")
    public void theURLChangesToTheHomepageURL() {
        String currentUrl = driver.getCurrentUrl();
        //assert currentUrl.equals("YOUR_HOMEPAGE_URL"); //Replace with your homepage URL
    }

    @When("the user enters an invalid email address")
    public void theUserEntersAnInvalidEmailAddress2() {
        registrationPage.setEmail("invalid-email");
    }

    @Then("an error message is visible on the page")
    public void anErrorMessageIsVisibleOnThePage() {
        //Add assertion to check for error message presence
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='error-message']"))); //Replace with your error message locator

    }

    @Then("the email input field has a placeholder {string}")
    public void theEmailInputFieldHasAPlaceholder(String placeholder) {
        String actualPlaceholder = registrationPage.getEmailPlaceholder();
        //assert actualPlaceholder.equals(placeholder);
    }

    @And("the username input field has a placeholder {string}")
    public void theUsernameInputFieldHasAPlaceholder(String placeholder) {
        String actualPlaceholder = registrationPage.getUsernamePlaceholder();
        //assert actualPlaceholder.equals(placeholder);
    }

    @And("the password input field has a placeholder {string}")
    public void thePasswordInputFieldHasAPlaceholder(String placeholder) {
        String actualPlaceholder = registrationPage.getPasswordPlaceholder();
        //assert actualPlaceholder.equals(placeholder);
    }

    @When("the user clicks the \"Register\" button without entering any details")
    public void theUserClicksTheRegisterButtonWithoutEnteringAnyDetails() {
        registrationPage.clickRegister();
    }

    @Then("the \"Register\" button remains enabled")
    public void theRegisterButtonRemainsEnabled() {
        boolean isEnabled = registrationPage.isRegisterButtonEnabled();
        //assert isEnabled;
    }

    @Then("the registration button displays the text {string}")
    public void theRegistrationButtonDisplaysTheText(String text) {
        String buttonText = registrationPage.getRegisterButtonText();
        //assert buttonText.equals(text);
    }

    @Then("the user receives an error message indicating the username already exists")
    public void theUserReceivesAnErrorMessageIndicatingTheUsernameAlreadyExists() {
        //Add assertion to check for specific error message
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='error-message'][contains(text(),'Username already exists')]"))); //Replace with your error message locator
    }


}


