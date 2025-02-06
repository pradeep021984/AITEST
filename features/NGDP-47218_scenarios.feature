


Feature: View Group Order Items

  Scenario: View successfully submitted items
    Given the user is on the cart screen
    And other group members have successfully submitted items
    When the user views the cart
    Then the user should see all submitted items from other group members

  Scenario: View "No Items" message after item removal
    Given the user is on the cart screen
    And other group members have successfully submitted items
    When the host removes an item submitted by another member
    Then the user should see "No Items" message for that member

  Scenario: Verify UI elements after item removal (Negative)
    Given the user is on the cart screen
    And other group members have successfully submitted items
    When the host removes an item submitted by another member
    Then the "No Items" message should match the Figma design in terms of text, size, and styling

  Scenario: Handle empty group order (Negative)
    Given the user is on the cart screen
    And no other group members have submitted items
    When the user views the cart
    Then the user should see a message indicating no items are available  or appropriate empty state

  Scenario: User is not on the cart screen (Negative)
    Given the user is on the home screen
    When the user attempts to view group order items
    Then the user should be redirected to the cart screen or receive an appropriate error message


  Scenario: Invalid group order ID (Negative)
    Given the user is on the cart screen with an invalid group order ID
    When the user views the cart
    Then an appropriate error message should be displayed.


  Scenario: Network error during group order retrieval (Negative)
    Given the user is on the cart screen
    When the network is disconnected while trying to view group order items
    Then the user should see a network error message.

  Scenario: Verify UI elements for submitted items (Positive)
    Given the user is on the cart screen
    And other group members have successfully submitted items
    When the user views the cart
    Then the UI elements for each submitted item (e.g., item name, quantity, price) should match the Figma design.




***********