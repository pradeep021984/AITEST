**Feature File:**

```gherkin
Feature: Group Order Cancellation When Joining a New Order

  Scenario: Guest User Joins New Group Order, Cancels Current Order
    Given the user is a Guest user in the app
    And the guest user is a member of an active group order with an unplaced order
    When the user taps on a new group ordering invite URL
    Then a confirmation drawer should appear with the title "Join <Group Order Name>'s Group Order?"
    And the drawer should display the sub-copy "Joining a new group order will cancel your current order"
    And the drawer should contain "X" and "No, Go Back" CTAs
    And tapping "X" or "No, Go Back" or outside the drawer should keep the user on the current group order page
    And the drawer should contain a "JOIN NEW GROUP ORDER" CTA
    When the user taps "JOIN NEW GROUP ORDER"
    Then the user should be redirected to the guest view of the new group order's member landing page
    When the user navigates back from the new group order's member landing page
    Then the user should be redirected to the Welcome landing page
    And the user should not be part of either the old or new group order


  Scenario: Logged-in User Joins New Group Order, Cancels Current Order
    Given the user is a logged-in user in the app
    And the logged-in user is a member of an active group order with an unplaced order
    When the user taps on a new group ordering invite URL
    Then a confirmation drawer should appear with the title "Join <Group Order Name>'s Group Order?"
    And the drawer should display the sub-copy "Joining a new group order will cancel your current order"
    And the drawer should contain "X" and "No, Go Back" CTAs
    And tapping "X" or "No, Go Back" or outside the drawer should keep the user on the current group order page
    And the drawer should contain a "JOIN NEW GROUP ORDER" CTA
    When the user taps "JOIN NEW GROUP ORDER"
    Then the user should be redirected to the logged-in view of the new group order's member landing page
    When the user navigates back from the new group order's member landing page
    Then the user should be redirected to the Homepage
    And the user's last selected order method (pickup or delivery), location, and ASAP timing should be selected by default
    And the user should not be part of either the old or new group order


  Scenario: Host Joins New Group Order, Cancels Current Order
    Given the user is a logged-in user in the app
    And the logged-in user is the host of an active group order with an unplaced order
    When the user taps on a new group ordering invite URL
    Then a confirmation drawer should appear with the title "Join <Group Order Name>'s Group Order?"
    And the drawer should display the sub-copy "Joining a new group order will cancel your current order"
    And the drawer should contain "X" and "No, Go Back" CTAs
    And tapping "X" or "No, Go Back" or outside the drawer should keep the user on the current group order page
    And the drawer should contain a "JOIN NEW GROUP ORDER" CTA
    When the user taps "JOIN NEW GROUP ORDER"
    Then the previous group order should be automatically cancelled
    And other members of the previous group order should see a group order cancellation drawer  #(This is covered in a separate story NGDP-31660)
    Then the user should be redirected to the logged-in view of the new group order's member landing page

```