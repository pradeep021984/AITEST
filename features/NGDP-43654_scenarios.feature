
Feature: Group Order Creation

  Scenario Outline: Successful Group Order Creation
    Given the user has launched the app
    And the user clicks on the Sign in CTA and logs in with valid credentials "<username>", "<password>"
    And the user is landed on the homepage
    And the user clicks on the hamburger icon
    And the user views the Group order CTA in the secondary navigation
    When the user clicks on the Group order CTA
    And the user enters group order name "<groupName>"
    And the user clicks on the Next CTA
    And the user enters their name "<userName>"
    And the user clicks on the Next CTA
    And the user is on the Group order info screen
    When the user clicks on the Confirm CTA
    Then the user should see the invite drawer
    And the user's personal cart should be cleared
    Examples:
      | username     | password    | groupName   | userName     |
      | testuser1@example.com | password123 | GroupOrder1 | John Doe     |
      | testuser2@example.com | securepass  | GroupOrder2 | Jane Smith   |

  Scenario: Unsuccessful Group Order Creation - System Error
    Given the user has launched the app
    And the user clicks on the Sign in CTA and logs in with valid credentials "testuser3@example.com", "securepass"
    And the user is landed on the homepage
    And the user clicks on the hamburger icon
    And the user views the Group order CTA in the secondary navigation
    When the user clicks on the Group order CTA
    And the user enters group order name "GroupOrder3"
    And the user clicks on the Next CTA
    And the user enters their name "Peter Jones"
    And the user clicks on the Next CTA
    And the user is on the Group order info screen
    When the user clicks on the Confirm CTA
    Then the user should see a full-screen error message "Unable to Create a Group Order"
    And the error message should contain the subtext "We’re experiencing a system hiccup. Please try creating your group order again."
    And the error screen should have a "Try again" CTA
    When the user clicks on the "Try again" CTA
    Then the user should be redirected to the Group order naming screen


  Scenario: Confirm CTA functionality - Invalid Input
    Given the user is on the Group order info screen with invalid input
    When the user clicks on the Confirm CTA
    Then the system should display appropriate error messages for invalid input

  Scenario: UI Test - Confirm CTA visibility
    Given the user is on the Group order info screen
    Then the Confirm CTA should be visible and enabled


  Scenario: UI Test - Error Message Styling
    Given the user sees the full-screen error message
    Then the error message should follow the specified design and styling (as per Figma)

  Scenario: Negative Test - User not logged in
    Given the user has launched the app
    When the user tries to access the Group Order flow without logging in
    Then the user should be redirected to the login screen

  Scenario: Negative Test - Invalid Credentials
    Given the user has launched the app
    When the user attempts to login with invalid credentials
    Then the user should see an error message indicating invalid credentials.

  Scenario: Functional Test - Personal Cart Clearing
    Given the user has items in their personal cart
    When the user creates a successful group order
    Then the user's personal cart should be empty.


***********