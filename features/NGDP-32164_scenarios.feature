**Feature File**:

```gherkin
Feature: Set Suggested Order Time in Group Order

  Scenario: View Order Info and Set Suggested Order Time (ASAP)
    Given the user has launched the app
    And the user clicks on the Sign in CTA and logs in using valid credentials
    And the user is landed on the homepage
    And the user clicks on the hamburger icon
    And the user should be able to view the Group order CTA in the secondary navigation
    And on clicking Group order CTA, the user should be able to view the Group order naming screen
    And on clicking Next CTA, the user should be able to view the Enter your name screen
    When the user clicks on the NEXT CTA
    Then the user should be able to view the Group order info screen with the scheduled time as ASAP
    And the user should be able to set suggested order by time
    And the user should be able to click on confirm CTA
    And the ASAP timeframe should not be set until the user clicks on the checkout CTA

  Scenario: Toggle Off Set Suggested Order Time
    Given the user has launched the app
    And the user clicks on the Sign in CTA and logs in using valid credentials
    And the user is landed on the homepage
    And the user clicks on the hamburger icon
    And the user should be able to view the Group order CTA in the secondary navigation
    And on clicking Group order CTA, the user should be able to view the Group order naming screen
    And on clicking Next CTA, the user should be able to view the Enter your name screen
    And the user has selected the scheduled time as ASAP
    When the user toggles off the "Set suggested order by time" option
    Then the user should see the select time field hidden
    And the user should be able to proceed to the next screen
```

***********