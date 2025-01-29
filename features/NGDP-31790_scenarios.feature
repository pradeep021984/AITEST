**Feature File**: Write Gherkin scenarios under the Feature: section.

```gherkin
Feature: Group Order Confirmation

  Scenario: Verify Group Order Confirmation Page after clicking the link
    Given the user is on the Group Member Landing page
    When the user provides his name and clicks on the Join Group Order Button
    And the user adds items to the cart and clicks on the Done Adding Items Button
    And the user clicks on the Confirm Order Button
    And the user is redirected to the confirmation page
    And the user clicks on the close icon on the confirmation page
    When the user clicks on the group order link
    Then the user should see the confirmation screen with the following attributes:
      | Attribute             | Details                                                                          |
      |-----------------------|--------------------------------------------------------------------------------------|
      | Moes Logo             | Logo present                                                                       |
      | Decorative Image      | Image present                                                                      |
      | Title                 | "Your Original Order Was Submitted"                                                |
      | Copy Text             | "If you want to modify your existing items or add new items to the group order, please update your order. You can make changes to your order until the host places the group order." |
      | Update My Group Order | Button present and functional (links to NGDP-31791)                             |
      | Close Icon            | Present and closes the confirmation screen                                          |

```

***********