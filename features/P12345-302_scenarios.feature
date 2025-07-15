**Feature File:**


Feature: User Sign Up

  Scenario Outline: Successful User Sign Up
    Given I am on the signup page
    When I enter a valid email "<email>"
    And I enter a valid mobile number "<mobile>"
    And I enter a valid password "<password>"
    When I click on the signup button
    Then I should receive a verification link/OTP
    And I should be logged in successfully

    Examples:
      | email                | mobile       | password     |
      | testuser@example.com | 1234567890  | Password123! |


  Scenario Outline: Unsuccessful User Sign Up - Invalid Email
    Given I am on the signup page
    When I enter an invalid email "<email>"
    And I enter a valid mobile number "<mobile>"
    And I enter a valid password "<password>"
    When I click on the signup button
    Then I should see an error message for invalid email

    Examples:
      | email           | mobile       | password     |
      | invalidEmail   | 1234567890  | Password123! |


  Scenario Outline: Unsuccessful User Sign Up - Invalid Mobile
    Given I am on the signup page
    When I enter a valid email "<email>"
    And I enter an invalid mobile number "<mobile>"
    And I enter a valid password "<password>"
    When I click on the signup button
    Then I should see an error message for invalid mobile number

    Examples:
      | email                | mobile     | password     |
      | testuser@example.com | invalidMob | Password123! |


  Scenario Outline: Unsuccessful User Sign Up - Weak Password
    Given I am on the signup page
    When I enter a valid email "<email>"
    And I enter a valid mobile number "<mobile>"
    And I enter a weak password "<password>"
    When I click on the signup button
    Then I should see an error message for weak password

    Examples:
      | email                | mobile       | password |
      | testuser@example.com | 1234567890  | Pass123  |


  Scenario: UI Test - Check Signup Page Elements
    Given I am on the signup page
    Then I should see the email field
    And I should see the mobile number field
    And I should see the password field
    And I should see the signup button



***********