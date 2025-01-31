**Feature File:**

```gherkin
Feature: Group Order - Group Member Landing Page Access

  Scenario: Guest User Access and Account Creation via Link

    Given the user is a guest user
    And the host has provided a link to the group order

    When the user clicks the link

    Then the app should open
    And the user should be on the Group Member Landing page
    And the page should contain:
      | Attribute                | Details     |
      | Join Group Order Button  | Button       |
      | Have an Account? Text    | Copy Text    |
      | Sign In Button           | Button       |
      | "or" Text                | Copy         |
      | Create Account Link      | Link (with Chevron Icon) |

    When the user clicks the "Create Account Link"

    Then the user should be navigated to the Sign-up page

    When the user provides valid sign-up information and clicks the "Sign Up" button

    Then the user should be navigated back to the Group Member Landing page
    And the user's name should be pre-filled in the "Your Name" field
    And the user should be able to edit the "Your Name" field


  Scenario Outline: Social Sign-Up (Apple & Facebook)

    Given the user is a guest user
    And the host has provided a link to the group order

    When the user clicks the link

    Then the app should open
    And the user should be on the Group Member Landing page

    When the user signs up using <socialProvider>

    Then the user should be navigated back to the Group Member Landing page
    And the user's name should be pre-filled in the "Your Name" field
    And the user should be able to edit the "Your Name" field

    Examples:
      | socialProvider |
      | Apple          |
      | Facebook       |
```


This Gherkin feature file covers both the guest user flow and the social sign-up scenarios.  The `Scenario Outline` efficiently handles the similar behavior for both Apple and Facebook sign-ups, avoiding repetition.  The data table within the first scenario clearly outlines the expected UI elements on the landing page.  Remember to replace placeholders like "{{ }}" with actual app identifiers or details as needed.  The provided Figma link is not directly incorporated into the Gherkin, as Gherkin focuses on behavior, not visual design specifics. The visual aspects should be verified through separate UI testing.