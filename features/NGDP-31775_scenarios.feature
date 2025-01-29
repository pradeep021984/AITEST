```gherkin
**Feature File**: Group Order Landing Page for Guest User

Feature: Group Order Landing Page Access and Functionality

  Scenario: Guest User Accesses Group Order Landing Page via Link

    Given the user is a guest user
    And the host has sent a link to the group order
    When the user clicks the link
    Then the application should open
    And the user should be on the Group Member Landing Page

  Scenario: Group Member Landing Page Attributes

    Given the user is on the Group Member Landing Page
    Then the page should display the Moe's logo
    And the page should display a "Back" button
    And the page should display the title "Welcome to Marketing Meeting's Group Order"
    And the page should display the sub-copy "Please add your items to the group order by xx:xxpm today."  # Note: This should be conditional on suggested order time being set.
    And the page should display a "Your Name" text field
    And the "Your Name" text field should accept only alphabets
    And the "Your Name" text field should have a maximum character limit of 20
    And the "Your Name" text field should be a mandatory field
    And the "Your Name" text field should not allow special characters
    And the page should display the sub-copy "We recommend using your first name and last initial to avoid duplicates. If you are a returning member to this group order, please use a different unique name." with an information icon
    And the page should display a "Join Group Order" button
    And the page should display the text "Have an Account?"
    And the page should display a "Sign In" button
    And the page should display "or"
    And the page should display a "Create an Account" link with a chevron icon
    And the page should visually match the Figma design [link to Figma design]


  Scenario: "Your Name" Field Behavior

    Given the user is on the Group Member Landing Page
    And the "Your Name" text field is empty
    When the user taps the "Your Name" text field
    Then the "Your Name" label should move up
    When the user taps outside the "Your Name" text field
    Then the "Your Name" label should return to its original position


  Scenario: Back Button Functionality

    Given the user is on the Group Member Landing Page
    When the user clicks the "Back" button
    Then the user should be redirected to the welcome screen


  Scenario: Back Button Functionality from Different Screens (Outline - Requires multiple scenarios to fully cover)

    #This scenario needs to be broken down into more specific scenarios for each screen.
    Given the user is on [Specific Screen within the app]
    When the user clicks the "Back" button
    Then the user should be redirected to the [Previous Screen]


  Scenario: Visual Consistency

    Given the user is on the Group Member Landing Page
    Then all elements should match the styling, sizing, and copy specified in the Figma design [link to Figma design]

```

**Note:**  This Gherkin outlines the scenarios.  To truly implement BDD, you'll need to:

* **Replace bracketed placeholders:**  Update placeholders like "[link to Figma design]" with the actual links.  Also specify the previous screen in the last scenario outline.
* **Expand Scenario Outlines:** The last scenario is an outline; it needs to be broken down into multiple scenarios, one for each screen you want to test the back button functionality from.
* **Implement Step Definitions:** You need to write code (in your chosen language) that defines what happens for each `Given`, `When`, and `Then` step.  This code will interact with your application to perform the actions and verify the outcomes.
* **Automated Testing:** Ideally, these scenarios should be run as automated tests as part of your continuous integration process.


This improved Gherkin provides a more robust and comprehensive basis for your BDD testing. Remember to consider edge cases and error handling as you implement your step definitions.