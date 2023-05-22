Feature: To validate the login page of Adactin
Scenario: To validate the login page using invalid details
Given User has to be in Adactin login page
When User has to enter the invalid Username and password
          |Username|ramki1994|
          |password|98526456|
 And User has to click the login button
Then Error message will be displayed    


Scenario: To validate the login page using invalid details
Given User has to be in Adactin login page
When User has to enter the invalid Username and password
          |Username|ramki19941612|
          |password|98526456465|
 And User has to click the login button
Then Error message will be displayed 


