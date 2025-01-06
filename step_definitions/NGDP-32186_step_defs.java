*****************

**Step Definition Code**:

```java
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.junit.Assert;

public class KochavaSDKUpdateSteps {

    private String appVersion;
    private String kochavaSDKVersion;

    @Given("the app version is {string}")
    public void setAppVersion(String version) {
        this.appVersion = version;
    }

    @Given("the app versions are {string}")
    public void setAppVersions(String versions) {
        //Handle multiple versions, e.g., split the string and store in a list
        this.appVersion = versions; // Placeholder for now.  Needs improvement for multiple versions.
    }


    @When("the Kochava Tracker SDK version is checked")
    public void checkKochavaSDKVersion() {
        // Replace with actual code to retrieve SDK version from the app using appVersion
        // This might involve using reflection or accessing a manifest file.
        this.kochavaSDKVersion = getKochavaSDKVersion(appVersion); //Method to retrieve version needs implementation
    }

    @When("the Kochava Tracker SDK version is checked for all versions")
    public void checkKochavaSDKVersionForAllVersions() {
      //Implement logic to check for multiple versions, based on the list created in the Given step.
        this.kochavaSDKVersion = getKochavaSDKVersion(appVersion); // Placeholder - needs to handle all versions
    }

    @When("the Kochava Tracker SDK is updated to version {string}")
    public void updateKochavaSDK(String version) {
        // Replace with actual code to update the Kochava SDK to the specified version
        // This might involve using a package manager or directly manipulating the app's files.
        this.kochavaSDKVersion = version;
    }

    @Then("the version should be {string}")
    public void verifyKochavaSDKVersion(String expectedVersion) {
        Assert.assertEquals(expectedVersion, kochavaSDKVersion);
    }

    @Then("the version for all app versions should be {string}")
    public void verifyKochavaSDKVersionForAllVersions(String expectedVersion) {
        Assert.assertEquals(expectedVersion, kochavaSDKVersion); // Placeholder - needs to handle all versions
    }

    //Helper function - NEEDS IMPLEMENTATION
    private String getKochavaSDKVersion(String appVersion){
        //Implementation to retrieve Kochava SDK version based on appVersion.  This will likely require external calls or access to app data.
        return "Implementation Needed";
    }
}
```

***********