Feature: Group Order - View Member Items

  Scenario Outline: View successfully submitted items
    Given the user is on the cart screen
    And other group members have successfully submitted items
    When the user views the cart
    Then the user should see items submitted by other group members
    Examples:
      | member1Items | member2Items |
      | ["Burger", "Fries"] | ["Salad", "Drink"] |
      | ["Pizza"] | [] |
      | [] | ["Chicken"] |


  Scenario: View "No Items" message after item removal
    Given the user is on the cart screen
    And other group members have successfully submitted items
    When the host removes a submitted item
    Then the user should see "No Items" message for the member with no items


  Scenario Outline: Verify UI elements after item removal
    Given the user is on the cart screen
    And other group members have successfully submitted items
    When the host removes a submitted item
    Then the "No Items" message should have correct styling and copy
    Examples:
      | memberName |
      | "Member A" |
      | "Member B" |


  Scenario: Guest User Access
    Given the user is a guest and on the cart screen
    And other group members have successfully submitted items
    When the user views the cart
    Then the user should see items submitted by other group members

  Scenario: Logged-in User Access
    Given the user is logged in and on the cart screen
    And other group members have successfully submitted items
    When the user views the cart
    Then the user should see items submitted by other group members


***********