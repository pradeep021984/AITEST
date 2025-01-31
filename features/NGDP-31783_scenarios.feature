**Feature File:**

```gherkin
Feature: Group Order Leave Confirmation for Guest User

  Scenario: Guest user leaves group order without moving items to cart

    Given the user is on the Group Member Landing page
    When the user provides their name and clicks on the "Join Group Order" button
    Then the user should be redirected to the Category Landing Page
    And the user should be able to add items to the cart

    When the user clicks on the "Leave Group Order" link
    Then the user should see a confirmation drawer with the following attributes:
      | Attribute             | Details                                         |
      |----------------------|-------------------------------------------------|
      | Alert Icon           | Logo                                             |
      | Want to Go Solo?     | Title                                            |
      | We can move the items from your group order to your cart. | Copy text                                      |
      | Move Items to My cart | Button                                           |
      | Leave Order          | Button                                           |

    When the user clicks the close button on the confirmation drawer
    Then the user should be redirected to the previous page

    When the user drags down the confirmation drawer
    Then the user should be redirected to the previous page

    When the user clicks the "Leave Order" button in the confirmation drawer
    Then the user should be navigated to the welcome page
    When the user clicks "Continue as Guest"
    Then the user should be landed on the store search screen
    And the user should see a success toast message: "You’ve left Marketing Meeting’s group order."
    And the user should be able to select a location
    And the user should be redirected to the homepage
    And the user should see the success toast message: "You’ve left Marketing Meeting’s group order."
    And the toast message should disappear automatically in 6 seconds or be closable manually

    And the displayed elements should match the Figma design: [https://www.figma.com/design/tJzJy7WVGqRyrm85talrk0/MOE-APP-SP3-UI?node-id=6-32025&t=fxxZPUFtN1uffrPH-4](https://www.figma.com/design/tJzJy7WVGqRyrm85talrk0/MOE-APP-SP3-UI?node-id=6-32025&t=fxxZPUFtN1uffrPH-4)


  Scenario Outline: Guest user interacts with confirmation drawer elements

    Given the user is on the Group Member Landing page
    When the user provides their name and clicks on the "Join Group Order" button
    And the user adds items to the cart
    When the user clicks on the "Leave Group Order" link
    When the user <action> on the confirmation drawer
    Then the user <outcome>

    Examples:
      | action                         | outcome                                           |
      |---------------------------------|---------------------------------------------------|
      | clicks the close button        | should be redirected to the previous page         |
      | drags down the drawer           | should be redirected to the previous page         |
      | clicks the "Move Items to My cart" button | should have items moved to their cart (This scenario needs further definition and likely a separate feature) |
      | clicks the "Leave Order" button | should be navigated to the welcome page             |

```

This Gherkin feature file covers the main user story and provides outlines for additional scenarios related to interacting with the confirmation drawer elements.  Remember that the "Move Items to My Cart" scenario will require further definition and potentially its own feature file as it's a distinct action with different outcomes.  The Figma link is included for visual reference in the test steps for easier understanding by the test automation engineers.  The `Scenario Outline` allows for parameterization and testing various interactions.