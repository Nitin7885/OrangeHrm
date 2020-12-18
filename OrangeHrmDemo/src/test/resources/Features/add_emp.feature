Feature: Add Employee

Scenario: Employee should be added with all required field
Given Admin is on Add Employee page
When Admin enter firstname and lastname
And click on save button
Then Admin should be added and navigate to personal details page
 
Scenario: Show required message when required fields are not filled
Given Admin is on Add Employee page
When Admin does not enter firstname and lastname
And click on save button
Then display appropriate message

Scenario: Employee image should be added with correct format and size
Given Admin is on Add Employee page 
And all required fileds are filled
When Admin click on choose_file button
And Admin add the selected file
And Admin click on save button
Then Employee should be added and navigate to personal details page

Scenario: Employee image should not be added with incorrect format or size
Given Admin is on Add Employee page 
And all required fileds are filled
When Admin click on choose_file button
And Admin add the selected file with incorrect format or size
And Admin click on save button
Then Error Message should be displayed.

Scenario Outline: In create login credential username should be accepted
Given Admin is on Add Employee page 
And check box is checked
When Admin enter a <username>
And move to the next textbox
Then username textbox doesnot display any error message.
Examples:
|username|
|"abcde"|
|"abcdef"|

Scenario Outline: In create login credential username of less than five character should not be accepted
Given Admin is on Add Employee page 
And check box is checked
When Admin enter a <username> of less than five character
And move to the next textbox
Then username textbox should display error message.
Examples:
|username|
|"abc"|

Scenario Outline: In create login credential password should be accepted
Given Admin is on Add Employee page 
And check box is checked
When Admin enter a <password> with correct format
Then password textbox doesnot display any error message
Examples:
|password|
|"abcde1234"|

Scenario Outline: In create login credential password of incorrect format should not be accepted
Given Admin is on Add Employee page 
And check box is checked
When Admin enter a <password> with incorrect format
Then password textbox does display any error message
Examples:
|password|
|"asd"|
|"asdfgbgtbtbtbr512316546r1vr5rv4t"|
|"4621165484"|
|"asdfgbgj"|
