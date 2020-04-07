Feature: Google HomePage Search


Scenario Outline: User can search with Google Search
Given I am on the homepage
When I type "<infoSearched>" into the search field
And I click google search buttom
Then I go to search results page
And I verify the first result
When I click the first result link
Then I go to the "<namePage>" page

Examples:
|infoSearched|namePage|
|The name of the Wind|Patrick Rothfuss - The Books|


Scenario Outline: User can search by using the suggestions
Given I am on the homepage
When I type "<infoSearched>" into the search field
And The suggestion list is displayed
And I click on the first suggestion in the list
Then I go to search results page
And I verify the first result
When I click the first result link
Then I go to the "<namePage>" page

Examples:
|infoSearched|namePage|
|The name of the W|Patrick Rothfuss - The Books|
