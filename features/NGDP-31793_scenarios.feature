**Feature File**:

```gherkin
Feature: Group Order Limit Exceeded

  Scenario: Exceeding Group Order Limit
    Given the group member is on the cart page
    And the user adds items to the cart
    And the user can view the CART Title
    And the user can view the group order's name
    And the user can view the order by date and time
    And the user can view the order limit of $15
    And the user can view their order with added items
    When the user exceeds the order limit
    Then the user sees the message "Your order is over the suggested order limit of $15 set by your group order host." with an Info icon
    And the user can still proceed with the "DONE ADDING ITEMS" CTA
```

***********