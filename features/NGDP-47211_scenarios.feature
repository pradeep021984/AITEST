


Feature: Navigate back to Group Ordering Cart

  Scenario: Navigate back to Group Ordering Cart when both sections are empty
    Given the user is on the cart page
    And the your order section is empty
    And the member order section is empty
    When the host removes the last member item
    Then the host should be taken to the group ordering cart page


***********