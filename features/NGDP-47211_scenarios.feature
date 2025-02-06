Feature: Group Order Cart Navigation

  Scenario Outline: Empty Cart Navigation
    Given the user is on the cart page
    And the your order section is <your_order_status>
    And the member order section is <member_order_status>
    When the host removes the last member item
    Then the host should be taken to the group ordering cart page

    Examples:
      | your_order_status | member_order_status |
      | empty             | empty                 |
      | empty             | not empty             |
      | not empty         | empty                 |
      | not empty         | not empty             |


  Scenario:  Error Handling - No Member Items to Remove
    Given the user is on the cart page
    And the your order section is empty
    And the member order section is empty
    When the host attempts to remove a member item
    Then an appropriate message should be displayed (e.g., "No member items to remove")


  Scenario:  Unexpected Behavior - Cart Page Not Displayed
      Given the user is on the cart page
      And the your order section is empty
      And the member order section is empty
      When the host removes the last member item
      Then the application should not crash


  Scenario: UI Validation - Group Order Cart Page Elements
    Given the user is on the group ordering cart page after removing all items
    Then the page should display the "Group Order" title
    And the page should display the "Create Order" button (or equivalent)


  Scenario:  Member Removes Item - Navigation Check
    Given a group order exists with members
    And the user is a member of the group order
    And the user is on the group order cart page
    And the member order section is not empty
    When the member removes an item from their order
    Then the member should still be on the group order cart page (unless it becomes empty)




***********