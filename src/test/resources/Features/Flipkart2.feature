Feature: Testing Flipkart2 Functionality

@NavigateMobilesPage1
Scenario Outline: Validating able to navigate mobiles page1
Then Validate user should able to navigates to mobiles page
 


Examples:
|sheet|dsID|
|Flipkart|ds001|

@smoke
@ValidateSortOptions1
Scenario Outline: Validating sort options1
When User Search for a product
Then Validate Search result lable should display
 


Examples:
|sheet|dsID|
|Flipkart|ds001|