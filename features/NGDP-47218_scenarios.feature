Feature: Group Order - View Member Items

  Scenario Outline: View other members' items
    Given the user is on the cart screen
    And the group order has been successfully submitted by at least one member
    When the user views the cart
    Then the user should see items from other group members
    Examples:
      | memberCount |
      | 1           |
      | 2           |
      | 3           |


  Scenario Outline: Host removes items - No Items message
    Given the user is on the cart screen
    And the group order has at least one successfully submitted item from another member
    When the host removes a successfully submitted item from another member
    Then the user should see "No Items" message for that member
    Examples:
      | member | itemName |
      | Member A | Item 1 |
      | Member B | Item 2 |


  Scenario: UI verification of "No Items" message
    Given the user is on the cart screen and a member has no items
    Then the "No Items" message should match the Figma design in terms of copy, size, and styling


  Scenario: View other members' items - Guest User
    Given the user is a guest and on the cart screen
    And the group order has been successfully submitted by at least one member
    When the user views the cart
    Then the user should see items from other group members


  Scenario: Error handling - No Group Order
    Given the user is on the cart screen
    And there is no active group order
    When the user tries to view other members' items
    Then an appropriate error message should be displayed


  Scenario: Error handling - Network issue
    Given the user is on the cart screen
    And there is a network issue
    When the user tries to view other members' items
    Then an appropriate error message should be displayed



***********