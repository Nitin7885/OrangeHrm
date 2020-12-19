@Login
#Author : Tuhin 



Feature: Login



Scenario Outline: Successful login with valid data
Description:  to login, user needs to enter valid user name and password 
Given user is on login page
When user enters valid <uname> and <pwd>
Then navigate to the orangeHRM dashboard
Examples:
|uname|pwd|
|"Admin"|"admin123"| 



Scenario Outline: Unsuccessful login due to incorrect user name or password  
Given user is on login page
When user enters invalid <uname> or <pwd>
Then display login failed message
Examples:
|uname|pwd|
|"user"|"user123"|
|"Admin"|"admin"|
|"admin"|"admin123"|
|"ADMIN"|"admin123"|
|"Admin"|"ADMIN123"|
|"ADMIN"|"ADMIN123"|



Scenario: Prompt user to enter user name or password when he leaves it empty 
Given user is on login page
When user does not enter username or password 
And clicks the login button
Then display appropiate error message 
