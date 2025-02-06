
Feature: Group Order Cart Navigation

  Scenario Outline: Navigation to Group Ordering Cart Page after Emptying Orders
    Given the user is on the cart page
    And the "your order" section is <your_order_status>
    And the "member order" section is <member_order_status>
    When the host removes the member items
    Then the host should be able to view the group ordering cart page

    Examples:
      | your_order_status | member_order_status |
      | empty             | empty             |
      | empty             | not empty         |
      | not empty         | empty             |


  Scenario: Handling Error - No Group Order Exists
    Given the user is on the cart page
    And no group order exists
    When the host attempts to remove member items
    Then an appropriate error message should be displayed


  Scenario: Handling Error - User Not Logged In
    Given the user is not logged in
    When the user attempts to access the cart page
    Then the user should be redirected to the login page

  Scenario: UI Check - Cart Page Elements
      Given the user is on the cart page
      Then the "Your Order" section should be displayed
      And the "Member Order" section should be displayed
      And a "Proceed to Checkout" button should be displayed

  Scenario: Functional Check - Item Removal from Your Order
    Given the user is on the cart page
    And the "your order" section is not empty
    When the user removes an item from "your order"
    Then the item should be removed from the cart
    And the cart total should be updated

  Scenario: Functional Check - Item Removal from Member Order (Host)
    Given the user is on the cart page
    And the "member order" section is not empty
    When the host removes an item from "member order"
    Then the item should be removed from the member order section
    And the cart total should be updated

  Scenario: Negative Test - Attempt to Remove Non-Existent Item
    Given the user is on the cart page
    When the user attempts to remove a non-existent item
    Then an appropriate error message should be displayed


  Scenario: Negative Test - Attempt to remove item without permissions
    Given the user is a member and on the cart page
    And the "member order" section is not empty
    When the member attempts to remove an item from the "member order"
    Then the action should be blocked and an appropriate message should be displayed



***********