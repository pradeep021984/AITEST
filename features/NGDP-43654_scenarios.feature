


Feature: Group Order Confirmation

  Scenario: Successful Group Order Creation
    Given the user has launched the app
    And the user is logged in with valid credentials
    And the user is on the homepage
    And the user clicks on the hamburger menu
    And the user clicks on the "Group Order" CTA
    And the user completes the group order naming screen
    And the user completes the "Enter your name" screen
    And the user is on the Group Order Info screen
    When the user clicks the "Confirm" CTA
    Then the user should see the invite drawer
    And the user's personal cart should be cleared
    

  Scenario: Unsuccessful Group Order Creation
    Given the user has launched the app
    And the user is logged in with valid credentials
    And the user is on the homepage
    And the user clicks on the hamburger menu
    And the user clicks on the "Group Order" CTA
    And the user completes the group order naming screen
    And the user completes the "Enter your name" screen
    And the user is on the Group Order Info screen
    When the user clicks the "Confirm" CTA
    And group order creation fails
    Then the user should see a full-screen error message with:
      | Attribute                | Detail                                                                  |
      | Back icon                | Takes user back to order details, preserving previous selections        |
      | Decorative image         | Image displayed as per Figma                                           |
      | "Unable to Create a Group Order" | Text, read-only                                                        |
      | "We’re experiencing a system hiccup. Please try creating your group order again." | Sub-text, read-only                                                   |
      | "Try again" CTA          | Takes user to the group order naming screen to restart the order flow |

  Scenario Outline: UI Validation of Error Message
    Given the user has launched the app
    And the user is logged in with valid credentials
    And the user is on the group order info screen
    When the user clicks the "Confirm" CTA
    And group order creation fails
    Then the error message should contain "<Text>"

    Examples:
      | Text                                                                        |
      | "Unable to Create a Group Order"                                          |
      | "We’re experiencing a system hiccup. Please try creating your group order again." |



***********