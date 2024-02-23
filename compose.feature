Feature: To test the compose function of G-mail

Background:
Given user is on G-mail login page
When user enters valid User-Id
And user enter valid password
And click on sign in button
Then user logged in successfully


Scenario: validate Compose button is available 
Given user is on the G-mail account page
Then compose button should be displayed or available  in G-mail box


Scenario: validate Compose button is clickable
Given user is on the G-mail account page
When click on compose button
Then Compose button should be clickable 
And User closes the browser


Scenario: Ensure users can create and send a new email successfully
Given user is on the G-mail account page
And click on compose button
Then user should create and send a new email successfully 
And User closes the browser
 
Scenario Outline: Confirm that users can add multiple recipients to an email
Given user is on the G-mail account page
When logged in user click on compose button
And redirected to new email box screen
Then user should be able to add "<multipleRecipients>" separated by comma to an email
And User closes the browser
Examples:
|multipleRecipients|
|user1@example.com, user_name@email-provider.net, john.doe@company.org, user123@email.co.uk|

Scenario: Verify that G-mail supports CC and BCC functionality
Given user is on the G-mail account page
When user clicks on compose button
And navigate to new email box
Then G-mail supports CC and BCC function
And User closes the browser



