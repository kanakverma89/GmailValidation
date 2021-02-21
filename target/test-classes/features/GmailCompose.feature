Feature: Validating the compose functionality of Gmail.

Scenario: Validating the Login of Gmail.
Given I have navigate to the below url in the browser.
|https://mail.google.com|
Then I click on the Compose button.
And I enter the recepient name and subject mail.
Then I attach the required document.
And I click on send button to send the email.