Feature: Edit, Remove, and Duplicate Line Items in Member Order Section

  Scenario Outline: Edit Line Item in Member Order Section
    Given the user (host) is on the cart page
    And the user can view the member order section
    When the host clicks on the "Edit" CTA for line item "<line_item>" in the member order section
    Then the user should see the PDP drawer for "<line_item>"
    And the user should see the error message "<error_message>" if the item is unavailable
    And the other functionalities remain the same

    Examples:
      | line_item           | error_message                                                                        |
      | Burger              | This item is no longer available and has been removed from your cart. To replace this item, please have this member start a new order. |
      | Fries               | This item is no longer available and has been removed from your cart. To replace this item, please have this member start a new order. |
      | Soda                | This item is no longer available and has been removed from your cart. To replace this item, please have this member start a new order. |
      | Burger with extra cheese | Sorry, we’re out of cheese: extra cheese. Please edit the item for the group member or remove it and resend the invite for this member to start a new order. |


  Scenario Outline: Remove Line Item in Member Order Section
    Given the user (host) is on the cart page
    And the user can view the member order section
    When the host clicks on the "Remove" CTA for line item "<line_item>" in the member order section
    Then the user should see a confirmation drawer
    And clicking "Yes, Remove" shows the success toast "Item removed from Cart"
    And clicking "Nevermind" retains the user on the cart page
    And the other functionalities remain the same

    Examples:
      | line_item |
      | Burger     |
      | Fries      |
      | Soda       |


  Scenario: Duplicate Line Item in Member Order Section
    Given the user (host) is on the cart page
    And the user can view the member order section
    When the host clicks on the "Duplicate" CTA for line item "Burger" in the member order section
    Then the user should see the duplicated line item "Burger duplicate" below the original "Burger" item
    And the other functionalities remain the same


  Scenario Outline: UI Test Cases - Edit Line Item
    Given the user (host) is on the cart page
    And the user can view the member order section
    When the host clicks on Edit CTA for a line item
    Then Verify the Edit button is displayed correctly(UI)
    And Verify the Edit button is enabled(UI)

  Scenario Outline: UI Test Cases - Remove Line Item
    Given the user (host) is on the cart page
    And the user can view the member order section
    When the host clicks on Remove CTA for a line item
    Then Verify the Remove button is displayed correctly(UI)
    And Verify the Remove button is enabled(UI)


  Scenario Outline: UI Test Cases - Duplicate Line Item
    Given the user (host) is on the cart page
    And the user can view the member order section
    When the host clicks on Duplicate CTA for a line item
    Then Verify the Duplicate button is displayed correctly(UI)
    And Verify the Duplicate button is enabled(UI)


  Scenario Outline: Negative Test Cases - Edit Line Item
    Given the user (host) is on the cart page
    And the user can view the member order section
    When the host tries to edit a non-existent line item
    Then Verify an appropriate error message is displayed

  Scenario Outline: Negative Test Cases - Remove Line Item
    Given the user (host) is on the cart page
    And the user can view the member order section
    When the host tries to remove a non-existent line item
    Then Verify an appropriate error message is displayed

  Scenario Outline: Negative Test Cases - Duplicate Line Item
    Given the user (host) is on the cart page
    And the user can view the member order section
    When the host tries to duplicate a non-existent line item
    Then Verify an appropriate error message is displayed


  Scenario: Functional Test Cases - Empty Cart Handling
    Given the user (host) is on the cart page
    And the member order section is empty
    When the host tries to edit, remove, or duplicate a line item
    Then Verify an appropriate message indicating an empty cart is displayed


***********