
Feature: Group Order Creation

  Scenario Outline: Successful Group Order Creation
    Given the user has launched the app and logged in with valid credentials
    And the user is on the homepage
    And the user navigates to the group order creation screen
    When the user enters the following details:
      | Order Name        | 
