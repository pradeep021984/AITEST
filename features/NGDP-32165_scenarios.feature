**Feature File**:

```gherkin
Feature: Set Suggested Order Limit in Group Order

  Scenario: Toggle on Set Suggested Order Limit
    Given the user has launched the app
    And the user clicks on the Sign in CTA and logs in using valid credentials
    And the user is landed on the homepage
    And the user clicks on the hamburger icon
    And the user should be able to view the Group order CTA in the secondary navigation
    And on clicking Group order CTA, the user should be able to view the Group order naming screen
    And on clicking Next CTA, the user should be able to view the Enter your name screen
    And the user should be able to view the group order info screen
    When the user toggles on the Set suggested order limit
    Then the user should be able to view limit set field with field name as “No Limit Set”
    And the field should be highlighted in black
    And a subtext should be displayed below the field as “Group members can still add items to your group order if they exceed this limit.“

  Scenario: View Drawer on Clicking Chevron in Limit Set Field
    Given the user is in the group order info screen
    And the user toggles on the set suggested order limit
    When the user clicks on the chevron icon in the no limit set field
    Then the user should be able to view a drawer with the following attributes:
      | Attribute                     | Detail                                      |
      |---------------------------------|----------------------------------------------|
      | Dollar icon                    | Image                                       |
      | Close icon                     | Button; On clicking closes the drawer. On entering any value and then clicking on close icon the changes made should not be saved |
      | Enter Suggested Order Limit     | Text, Read only                             |
      | Suggested limit entry field     | Defaulted as $0; Allows only numeric        |
      | Set limit                      | Button                                       |
    And on clicking Set Limit CTA, the drawer should be closed and the respective value should be displayed in the limit set field


  Scenario: View "No Limit Set" when Order Limit is $0
    Given the user is in the group order info screen
    And the user toggles on the set suggested order limit
    And the user clicks on the chevron icon
    And the user sets the value as $0
    When the user clicks on Set limit CTA
    Then the user should be able to see “No limit set” as the order limit value
    And the limit value should not be displayed in the host cart and member cart/menu landing screen


  Scenario: Click Set Limit Field Without Entering Value
    Given the user is in the group order info screen
    And the user toggles on the set suggested order limit
    When the user clicks on the set limit field without entering a value
    Then the user should see "No Limit Set" as the order limit value

```

***********