**Feature File**:

```gherkin
Feature: Update Kochava Tracker SDK

  Scenario: Verify Kochava Tracker SDK version before update
    Given the app version is 1000079245
    When the Kochava Tracker SDK version is checked
    Then the version should be less than 5.4.0

  Scenario: Update Kochava Tracker SDK to version 5.4.0
    Given the app version is 1000079245
    When the Kochava Tracker SDK is updated to version 5.4.0
    Then the version should be 5.4.0

  Scenario: Verify Kochava Tracker SDK version after update for multiple versions
    Given the app versions are 1000079245, 1000079338, and 1000079366
    When the Kochava Tracker SDK version is checked for all versions
    Then the version for all app versions should be 5.4.0
```

***********