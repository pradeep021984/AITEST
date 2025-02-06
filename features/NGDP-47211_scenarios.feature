Feature: Group Order Cart Navigation

  Scenario Outline: Empty Cart Navigation
    Given the user is on the group order cart page
    And the user's order section is <userOrderState>
    And the member order section is <memberOrderState>
    When the host removes the last member item
    Then the host should be navigated to the group ordering cart page

    Examples:
      | userOrderState | memberOrderState |
      | Empty          | Empty          |
      | Empty          | Non-Empty      |
      | Non-Empty      | Empty          |
      | Non-Empty      | Non-Empty      |


  Scenario: Verify Navigation from Empty Member Order Section
    Given the user is on the group order cart page
    And the user's order section is Non-Empty
    And the member order section is Empty
    When the user navigates away from the member order section
    Then the user should remain on the group order cart page

  Scenario: Verify Navigation from Empty User Order Section
    Given the user is on the group order cart page
    And the user's order section is Empty
    And the member order section is Non-Empty
    When the user navigates away from the user order section
    Then the user should remain on the group order cart page

  Scenario: UI Verification on Empty Cart
    Given the user is on the group ordering cart page
    And the user's order section is empty
    And the member order section is empty
    Then the "Group Order Cart is Empty" message should be displayed
    And the "Start Ordering" button should be visible

  Scenario: Negative Test - Attempt to Checkout with Empty Cart
    Given the user is on the group ordering cart page
    And the user's order section is empty
    And the member order section is empty
    When the user taps the "Checkout" button
    Then an error message should be displayed indicating that the cart is empty

  Scenario: Functional Test - Add Item to Cart from Empty State
    Given the user is on the group ordering cart page
    And the user's order section is empty
    And the member order section is empty
    When the user adds an item to their order
    Then the user should be on the group order cart page
    And the added item should be displayed in the user's order section


  Scenario: UI Test - Verify Cart Item Display
    Given the user is on the group order cart page
    And the user's order section contains items
    Then the items should be displayed correctly with name, quantity, and price.

  Scenario: Negative Test - Removing Non-Existent Item
    Given the user is on the group order cart page
    When the user attempts to remove an item that does not exist
    Then an appropriate error message or no change should be observed.