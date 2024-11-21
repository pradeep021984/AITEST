
Feature: User Registration

  Scenario Outline: Successful User Registration - Functional
    Given a user is on the registration page
    When the user enters a valid email address: <email>
    And the user enters a valid username: <username>
    And the user enters a valid password: <password>
    And the user confirms the password: <password>
    And the user clicks the "Register" button
    Then the user is redirected to the homepage or a confirmation page

    Examples:
      | email                  | username | password     |
      | testuser@example.com | testuser | TestPassword1! |
      | another@test.com     | another  | PasswOrd2     |


  Scenario Outline: Unsuccessful User Registration - Functional - Invalid Email
    Given a user is on the registration page
    When the user enters an invalid email address: <email>
    And the user enters a valid username: <username>
    And the user enters a valid password: <password>
    And the user confirms the password: <password>
    And the user clicks the "Register" button
    Then the user sees an error message indicating an invalid email

    Examples:
      | email            | username | password     |
      | invalid-email   | testuser | TestPassword1! |
      | test@.com       | another  | PasswOrd2     |
      | test@example     | user3    | Password3     |


  Scenario Outline: Unsuccessful User Registration - Functional - Invalid Password
    Given a user is on the registration page
    When the user enters a valid email address: <email>
    And the user enters a valid username: <username>
    And the user enters an invalid password: <password>
    And the user confirms the password: <password>
    And the user clicks the "Register" button
    Then the user sees an error message indicating an invalid password

    Examples:
      | email                  | username | password   |
      | testuser@example.com | testuser | short      |
      | another@test.com     | another  | NoSpecial! |
      | yetanother@test.com   | user3    | 123        |


  Scenario Outline: Unsuccessful User Registration - Functional - Password Mismatch
    Given a user is on the registration page
    When the user enters a valid email address: <email>
    And the user enters a valid username: <username>
    And the user enters a valid password: <password>
    And the user confirms the password: <confirmedPassword>
    And the user clicks the "Register" button
    Then the user sees an error message indicating a password mismatch

    Examples:
      | email                  | username | password     | confirmedPassword |
      | testuser@example.com | testuser | TestPassword1! | TestPassword2!   |


  Scenario: UI Test - Successful Registration - Check for Redirection
    Given a user is on the registration page
    When the user enters valid registration details
    And the user clicks the "Register" button
    Then the URL changes to the homepage URL

  Scenario: UI Test - Unsuccessful Registration - Error Message Visibility
    Given a user is on the registration page
    When the user enters an invalid email address
    And the user clicks the "Register" button
    Then an error message is visible on the page

  Scenario: UI Test - Check for Input Field Placeholders
    Given a user is on the registration page
    Then the email input field has a placeholder "Email Address"
    And the username input field has a placeholder "Username"
    And the password input field has a placeholder "Password"


  Scenario: UI Test - Check Button Functionality
    Given a user is on the registration page
    When the user clicks the "Register" button without entering any details
    Then the "Register" button remains enabled  

  Scenario: UI Test - Check Button Text
    Given a user is on the registration page
    Then the registration button displays the text "Register"

  Scenario Outline: Negative Test -  Username already exists
    Given a user is on the registration page
    When the user enters a valid email address: <email>
    And the user enters an existing username: <username>
    And the user enters a valid password: <password>
    And the user confirms the password: <password>
    And the user clicks the "Register" button
    Then the user receives an error message indicating the username already exists
    
    Examples:
      | email                  | username | password     |
      | testuser2@example.com | existinguser | TestPassword1! |


