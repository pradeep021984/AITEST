Feature: View Group Member Items

Scenario Outline: Successful View of Group Member Items
Given the user is on the cart screen
And other group members have successfully submitted items
When the user views the cart
Then the user should see items submitted by other group members
Examples:
| member1Items | member2Items |
|---|---|
| Apple, Banana | Orange, Grape |
| Bread, Milk | Cheese, Eggs |
|  | Coffee, Tea |


Scenario Outline: View "No Items" Message After Item Removal
Given the user is on the cart screen
And other group members have successfully submitted items
When the host removes "<item>" submitted by "<member>"
Then the user should see "No Items" for <member>
Examples:
| item | member |
|---|---|
| Apple | Member1 |
| Orange | Member2 |
| Coffee | Member3 |


Scenario: UI Check for Item Details
Given the user is on the cart screen
And other group members have successfully submitted items
When the user views the cart
Then the item details (copy, size, styling) should match the Figma design


Scenario: Guest User Access
Given the user is a guest user
And other group members have successfully submitted items
When the user navigates to the group order cart
Then the user should see items submitted by other group members


Scenario:  No Group Members Submitted Items
Given the user is on the cart screen
And no other group members have submitted items
When the user views the cart
Then the user should see a message indicating no items submitted by other members


Scenario: Error Handling -  Network Issue
Given the user is on the cart screen
And there is a network issue
When the user views the cart
Then the user should see an appropriate error message


Scenario: Error Handling -  Server Error
Given the user is on the cart screen
And there is a server error
When the user views the cart
Then the user should see an appropriate error message



***********