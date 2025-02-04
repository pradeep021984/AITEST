
Feature: Group Order Creation

  Scenario Outline: Successful Group Order Creation
    Given the user has launched the app and logged in with valid credentials
    And the user is on the homepage
    And the user navigates to the Group Order screen
    And the user enters the group order name "<group_order_name>"
    And the user enters their name "<host_name>"
    And the user enters order details: "<order_details>"
    When the user clicks the "Confirm" CTA
    Then the user should see the invite drawer
    And the user's personal cart should be cleared
    And the group order "<group_order_name>" should be created successfully

    Examples:
      | group_order_name | host_name | order_details |
      | Group Order 1 | John Doe | Pizza, Burger, Fries |
      | Group Order 2 | Jane Smith | Salad, Pasta, Soup |


  Scenario: Failed Group Order Creation - System Hiccup
    Given the user has launched the app and logged in with valid credentials
    And the user is on the group order info screen
    When the user clicks the "Confirm" CTA and group order creation fails
    Then the user should see a full-screen error message with:
      | Attribute                     | Detail                                                                     |
      | Back icon                      | Navigates back to order details, preserving previous selections           |
      | Decorative image               | Displayed as per Figma design                                             |
      | "Unable to Create a Group Order" | Text, read-only                                                          |
      | Error sub-text               | "We’re experiencing a system hiccup. Please try creating your order again." |
      | "Try again" CTA               | Navigates to the group order naming screen                               |


  Scenario: Verify UI Elements on Group Order Info Screen
    Given the user has launched the app and logged in with valid credentials
    And the user is on the group order info screen
    Then the "Confirm" CTA should be visible and enabled
    And all input fields should be displayed correctly
    And the screen should match the Figma design


  Scenario Outline: Negative Testing - Invalid Input
    Given the user has launched the app and logged in with valid credentials
    And the user is on the group order info screen
    When the user enters invalid "<invalid_input>" in the "<field_name>" field
    And the user clicks the "Confirm" CTA
    Then an appropriate error message should be displayed for "<field_name>"

    Examples:
      | invalid_input | field_name |
      | ""            | Group Order Name |
      | 123           | Host Name       |
      | abc           | Order Details   |


  Scenario: Verify Personal Cart Clearing on Successful Order Creation
    Given the user has a non-empty personal cart and is logged in
    And the user completes the group order creation successfully
    Then the user's personal cart should be empty


  Scenario: Confirm CTA disabled until all required fields are filled
    Given the user is on the group order info screen
    When the user leaves required fields empty
    Then the "Confirm" CTA should be disabled


  Scenario: Back button functionality after failed order creation
    Given the user has launched the app and logged in with valid credentials
    And the user is on the group order info screen
    When the user clicks "Confirm" and the order fails
    And the user clicks the back button on the error screen
    Then the user should be returned to the group order info screen
    And previous order details should be preserved.




****************