


Feature: Edit, Remove, and Duplicate Line Items in Member Order

  Scenario: Edit a line item in Member Order
    Given the user (host) is on the cart page
    And the user can view the member order section
    When the host clicks on the Edit CTA for a line item in the member order section
    Then the user should see the PDP drawer with modifiers
    And the user should see the error message "This item is no longer available and has been removed from your cart. To replace this item, please have this member start a new order." if the item is unavailable
    And the user should see the error message "Sorry, we’re out of <category>: <item>. Please edit the item for the group member or remove it and resend the invite for this member to start a new order." if a required modifier is unavailable
    And the user should see the error message "We removed these items. They’re no longer available." if a modifier is unavailable
    And other functionalities remain the same

  Scenario: Remove a line item in Member Order
    Given the user (host) is on the cart page
    And the user can view the member order section
    When the host clicks on the Remove CTA for a line item in the member order section
    Then the user should see a confirmation drawer
    And clicking "Yes, Remove" should display a success toast "Item removed from Cart"
    And clicking "Nevermind" should retain the user on the cart page
    And the user should be taken to the empty cart screen when the order and member sections are empty

  Scenario: Duplicate a line item in Member Order
    Given the user (host) is on the cart page
    And the user can view the member order section
    When the host clicks on the Duplicate CTA for a line item in the member order section
    Then the user should see the duplicated line item displayed below the parent line item


***********