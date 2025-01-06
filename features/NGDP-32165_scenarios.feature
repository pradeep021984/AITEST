**Feature File**:

```gherkin
Feature: Set Suggested Order Limit in Group Order

  Scenario Outline: Toggle Set Suggested Order Limit
    Given the user has launched the app and logged in successfully
    And the user is on the group order info screen
    When the user toggles the "Set suggested order limit" switch <toggleState>
    Then the "Set suggested order limit" field should display "<limitStatus>"
    And the field should be highlighted <highlight>
    And the subtext should be "<subtext>"

    Examples:
      | toggleState | limitStatus      | highlight | subtext                                                                        |
      | on          | "No Limit Set"   | black      | "Group members can still add items to your group order if they exceed this limit." |
      | off         | ""               | null       | ""                                                                             |


  Scenario: View Drawer on Clicking Chevron
    Given the user is on the group order info screen
    And the "Set suggested order limit" switch is on
    When the user clicks the chevron icon in the "No Limit Set" field
    Then the user should see a drawer with the following attributes:
      | Attribute                  | Detail                                     |
      | Dollar icon                | Image                                       |
      | Close icon                 | Button; closes the drawer; unsaved changes discarded on close |
      | Enter Suggested Order Limit | Text, Read only                            |
      | Suggested limit entry field | Defaults to $0; allows only numeric input |
      | Set limit                  | Button                                      |


  Scenario: Set Order Limit to $0
    Given the user is on the group order info screen
    And the "Set suggested order limit" switch is on
    When the user sets the suggested order limit to $0 and clicks "Set limit"
    Then the "Set suggested order limit" field should display "No limit set"
    And the limit value should not be displayed in the host cart and member cart/menu landing screen


  Scenario: Set Limit Field without Value
    Given the user is on the group order info screen
    And the "Set suggested order limit" switch is on
    When the user clicks the "Set limit" button without entering a value
    Then the "Set suggested order limit" field should display "No Limit Set"

```

***********