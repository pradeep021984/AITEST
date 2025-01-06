*****************

**Step Definition Code**:

```java
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.AppHomePage; //Import your AppHomePage class

public class StepDefinitions {

    private AppHomePage appHomePage;

    public StepDefinitions(AppHomePage appHomePage){
        this.appHomePage = appHomePage;
    }


    @Given("the app is launched")
    public void the_app_is_launched() {
        // Launch the app - Implementation specific to your app launch mechanism
        appHomePage.launchApp();
    }

    @When("the Kochava Tracker SDK version is checked")
    public void the_kochava_tracker_sdk_version_is_checked() {
        //Check the Kochava SDK version -  Implementation specific to fetching SDK version.
        appHomePage.checkKochavaSDKVersion();

    }

    @Then("the version should be less than 5.4.0")
    public void the_version_should_be_less_than_5_4_0() {
        // Assert that the version is less than 5.4.0. Implementation depends on how you store version information.
        appHomePage.verifyKochavaSDKVersionLessThan("5.4.0");
    }

    @When("the Kochava Tracker SDK is updated to version 5.4.0")
    public void the_kochava_tracker_sdk_is_updated_to_version_5_4_0() {
        // Update the Kochava SDK to 5.4.0 -  Implementation specific to your SDK update mechanism. Might involve using a dependency manager, etc.
        appHomePage.updateKochavaSDK("5.4.0");
    }

    @Then("the updated version should be 5.4.0")
    public void the_updated_version_should_be_5_4_0() {
        // Assert that the version is 5.4.0. Implementation depends on how you store version information.
        appHomePage.verifyKochavaSDKVersion("5.4.0");
    }
}
```

****************