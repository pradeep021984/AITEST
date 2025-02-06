Feature: Group Order Management in QSR Mobile App

  Scenario Outline: Edit Line Item in Member Order
    Given the user (host) is on the cart page
    And the user can view the member order section
    When the host clicks on the Edit CTA for a line item "<line_item>" in the member order section
    Then the user should be able to view the PDP drawer
    And the user should see the correct modifiers for "<line_item>"
    Examples:
      | line_item |
      | Burger      |
      | Fries       |
      | Drink       |

  Scenario Outline: Edit Line Item - Item Unavailable
    Given the user (host) is on the cart page
    And the user can view the member order section
    When the host clicks on the Edit CTA for an unavailable line item "<line_item>"
    Then the user should see the error message "This item is no longer available and has been removed from your cart. To replace this item, please have this member start a new order."
    Examples:
      | line_item |
      | UnavailableBurger |


  Scenario Outline: Edit Line Item - Modifier Unavailable
    Given the user (host) is on the cart page
    And the user can view the member order section
    When the host clicks on the Edit CTA for a line item "<line_item>" with unavailable modifier "<modifier>"
    Then the user should see the error message "Sorry, we’re out of <modifier>: <item>. Please edit the item for the group member or remove it and resend the invite for this member to start a new order."
    Examples:
      | line_item | modifier          |
      | Burger     | Cheese            |
      | Fries      | SpecialSauce     |


  Scenario: Edit Line Item - Multiple Modifiers Unavailable
    Given the user (host) is on the cart page
    And the user can view the member order section
    When the host clicks on the Edit CTA for a line item with multiple unavailable modifiers
    Then the user should see the error message "We removed these items. They’re no longer available."


  Scenario Outline: Remove Line Item from Member Order
    Given the user (host) is on the cart page
    And the user can view the member order section
    When the host clicks on the Remove CTA for a line item "<line_item>" in the member order section
    Then the user should see a confirmation drawer
    When the user clicks "Yes, Remove"
    Then the user should see the success toast "Item removed from Cart"
    When the user clicks "Nevermind"
    Then the user should remain on the cart page
    Examples:
      | line_item |
      | Burger      |
      | Fries       |


  Scenario: Remove Last Item - Empty Cart
    Given the user (host) is on the cart page
    And the user can view the member order section with only one item
    When the host clicks on the Remove CTA for the only line item
    Then the user should be taken to the empty cart screen


  Scenario Outline: Duplicate Line Item in Member Order
    Given the user (host) is on the cart page
    And the user can view the member order section
    When the host clicks on the Duplicate CTA for a line item "<line_item>" in the member order section
    Then the user should see the duplicated line item below the original "<line_item>"
    Examples:
      | line_item |
      | Burger      |
      | Fries       |


  Scenario: Duplicate Line Item - UI Verification
    Given the user (host) is on the cart page
    And the user can view the member order section with items "A", "B", "C"
    When the host clicks on the Duplicate CTA for item "A"
    Then the member order section should display items "A", "A duplicate", "B", "C" in that order.


  Scenario: UI Test - Check for Edit/Remove/Duplicate Buttons
    Given the user (host) is on the cart page
    And the user can view the member order section with at least one item
    Then the Edit, Remove, and Duplicate CTAs should be visible for each item in the member order section.

  Scenario: Negative Test - Attempt to edit/remove/duplicate without login
    Given the user is not logged in
    When the user navigates to the cart page
    Then the user should be redirected to the login page or be unable to interact with member order items.