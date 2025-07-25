Feature: Testing Flipkart Functionality

@smoke
@NavigateMobilesPage
Scenario: Validating able to navigate mobiles page 
Then Validate user should able to navigates to mobiles page
 

@ValidateSortOptions
Scenario Outline: Validating sort options
When User Search for a product
Then Validate Search result lable should display
Examples:
|sheet|dsID|
|Flipkart|ds001|