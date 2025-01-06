**Feature File**:

```gherkin
Feature: Update Kochava Tracker SDK

  Scenario: Verify Kochava Tracker SDK version before update
    Given the app is launched
    When the Kochava Tracker SDK version is checked
    Then the version should be less than 5.4.0

  Scenario: Update Kochava Tracker SDK to version 5.4.0
    Given the app is launched
    When the Kochava Tracker SDK is updated to version 5.4.0
    Then the updated version should be 5.4.0

  Scenario: Verify Kochava Tracker SDK version after update
    Given the app is launched
    When the Kochava Tracker SDK version is checked
    Then the version should be 5.4.0
```

****************