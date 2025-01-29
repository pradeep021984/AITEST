**Feature File:**

```gherkin
Feature: Group Order Menu Access for Guest Users

  Scenario: Guest User Accesses Group Order Menu
    Given the user is on the Group Member Landing page
    When the user provides their name and clicks the "Join Group Order" button
    Then the user should be redirected to the Category Landing Page
    And the page title should be "Marketing Meeting’s Group Order"
    And the page should contain a "Hamburger" button
    And the page should contain a "Cart" icon
    And the page should display "Pickup at “Location”" with an icon
    And the page should display "ASAP" or a scheduled time with an icon (as proposed by the host)
    And the page should display the order deadline as "Order By MM/DD/YY X:XXpm" (if applicable, highlighted in red if the deadline is exceeded)
    And the page should display the order limit as "Order Limit $xx" (if applicable)
    And the page should contain a brand-specific Search Menu field
    And the page should display brand-specific Allergens & Sensitivities options
    And the page should display "Menu", "Recents", and "Favourites" tabs
    And the page should display a list of categories
    And the page elements should match the Figma design [https://www.figma.com/design/tJzJy7WVGqRyrm85talrk0/MOE-APP-SP3-UI?node-id=105-57269&t=fxxZPUFtN1uffrPH-4] in terms of copy, size, and styling

```

**Notes:**

* The Gherkin scenario directly reflects the acceptance criteria.  We've broken down the "And the user should be able to view the above attribute(s)..." into more specific, testable steps.
* The Figma link is included for reference in the scenario.  Automated testing would require a visual comparison tool to verify against the Figma design.  This is usually a more advanced testing technique.
* Error handling (e.g., what happens if the user enters an invalid name) is not explicitly covered in the user story and therefore not included in the scenario.  This could be added as separate scenarios.
*  The images provided were not directly used in the Gherkin, as they are visual aids and not directly part of the acceptance criteria definition. The Figma link serves as the visual reference for styling and layout.


This Gherkin scenario provides a solid foundation for writing automated tests using a BDD framework like Cucumber, SpecFlow, or Behave.  Remember to pair these scenarios with appropriate step definitions in your chosen testing language to automate the test execution.