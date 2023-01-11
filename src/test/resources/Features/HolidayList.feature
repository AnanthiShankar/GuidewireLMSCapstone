Feature: Holidays in LMS
@Regression
Scenario: Displaying Holiday List as per Holiday type
Given User is on the EY LMS Page
When User Navigates to the Holiday List Page
Then Validate the public holiday count is  equal to or greater than “9”
And User is able to split the holiday details as per Holiday Type and print it as a report






