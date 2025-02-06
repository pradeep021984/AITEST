
Feature: Group Order Creation

  Scenario Outline: Successful Group Order Creation
    Given the user has launched the app
    And the user clicks on the Sign in CTA and logs in using valid credentials
    And the user is landed on the homepage
    And the user clicks on the hamburger icon
    And the user should be able to view the Group order CTA in the secondary navigation
    And on clicking Group order CTA, user should be able to view the Group order naming screen
    And on clicking Next CTA, user should be able to view the Enter your name screen
    And the user clicks on the NEXT cta on enter your name screen
    And the user should be able to view the Group order info screen
    When the user enters "<orderDetails>" in the order info screen and clicks on confirm order CTA
    Then the user should be able to view the invite drawer
    And if the host has a personal cart, the personal cart should be cleared when the group order is created

    Examples:
      | orderDetails |
      | Valid order details |


  Scenario: Group Order Creation Failure - System Hiccup
    Given the user has launched the app
    And the user clicks on the Sign in CTA and logs in using valid credentials
    And the user is landed on the homepage
    And the user clicks on the hamburger icon
    And the user should be able to view the Group order CTA in the secondary navigation
    And on clicking Group order CTA, user should be able to view the Group order naming screen
    And on clicking Next CTA, user should be able to view the Enter your name screen
    And the user clicks on the NEXT cta on enter your name screen
    And the user should be able to view the Group order info screen
    When the user clicks on the confirm CTA and group order creation fails
    Then the user should be able to see a full screen takeover screen with the attributes:
    | Attribute                   | Detail                                                                          |
    | Back icon                   | On clicking, user should be taken to the order details screen; previous selections persist |
    | Decorative image            | Image displayed as per Figma                                                    |
    | Unable to Create a Group Order | Text, Read only                                                              |
    | Error Message               | "We’re experiencing a system hiccup. Please try creating your group order again." |
    And the "Try again" CTA should take the user to the group order naming screen


  Scenario Outline: UI Validation - Order Info Screen
    Given the user is on the Group Order Info screen
    When the user interacts with the UI elements
    Then the UI elements should be displayed correctly and functionally

    Examples:
      | UI Element          | Expected Behavior                               |
      | Confirm CTA         | Should be enabled/disabled based on valid data |
      | Input Fields        | Should accept valid input                      |
      | Error Messages      | Should display appropriate error messages       |
      | Back Button         | Should navigate back to the previous screen       |


  Scenario:  Negative Test - Invalid Order Details
    Given the user has launched the app
    And the user clicks on the Sign in CTA and logs in using valid credentials
    And the user is landed on the homepage
    And the user clicks on the hamburger icon
    And the user should be able to view the Group order CTA in the secondary navigation
    And on clicking Group order CTA, user should be able to view the Group order naming screen
    And on clicking Next CTA, user should be able to view the Enter your name screen
    And the user clicks on the NEXT cta on enter your name screen
    And the user should be able to view the Group order info screen
    When the user enters "<invalidOrderDetails>" in the order info screen and clicks on confirm order CTA
    Then an appropriate error message should be displayed

    Examples:
      | invalidOrderDetails |
      | Invalid order details |


  Scenario: Functional Test - Personal Cart Clearing
    Given the user has a personal cart with items
    And the user creates a group order successfully
    Then the personal cart should be empty

