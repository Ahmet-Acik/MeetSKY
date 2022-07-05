@MTSK-410
Feature:  Test login functionality

  US As a user, I should be able to login.

  Background:
    Given User goes to login page

  @MTSK-404
  Scenario Outline: user should be able to login with valid credentials
    When user enters "<username>" username
    And user enters "<password>" password
    And user clicks to Log in button
    Then user can login
    Examples:
      | username   | password    |
      | Employee71 | Employee123 |
      | Employee21 | Employee123 |


  @MTSK-405
  Scenario Outline: user can not login as blank
    When user enters "<username>" username
    And user enters "<password>" password
    And user clicks to Log in button
    Then user can not login as "<username>" and or "<password>" blank and see Please fill in this field.
    Examples:
      | username   | password   |
      |            | Employee71 |
      |            |            |
      | Employee71 |            |

  @MTSK-406
  Scenario Outline: user can not login with invalid credentials
    When user enters "<username>" username
    And user enters "<password>" password
    And user clicks to Log in button
    Then user can not login and see Wrong username or password.
    Examples:
      | username         | password         |
      | Employee71       | Emp23.           |
      | Employee21       | empLoyee123      |
      | 71Emp            | Employee123      |
      | 7                | Employee123      |
      | 21Emp01          | Employee123      |
      | 213Employ        | Employee123      |
      | Ahmet123         | E                |
      | AhmetAkk32145123 | Employeee321456. |

  @MTSK-407
  Scenario: can see dots and then password explicitly
    When user enters "<password>" password
    And user can see dots in the password input
    And user Clicks to the eye symbol
    Then user can see the password

  @MTSK-408
  Scenario: Reset Password Link can be seen
    When user click to Forgot password link
    Then user can see Reset Password button

  @MTSK-409
  Scenario:Username or email and Password placeholder is visible
    Then User can see "Username or email" and "Password" placeholder is visible


  #Scenario Outline: user can not login as blank and or with invalid credentials
  #  Given User goes to login page
  #  When user enters "<username>" username
  #  And user enters "<password>" password
  #  And user clicks to Log in button
  #  Then user can not login as "<username>" and or "<password>" blank and or with invalid credentials see error message.
  #  Examples:
  #    | username      | password        |
  #    |               | Employee71      |
  #    |               |                 |
  #    | Employee71    |                 |
  #    | Employee71    | Emp23.          |
  #    | Employee21    | empLoyee123     |
  #    | 71Emp         | Employee123     |
  #    | 71E           | Employee123     |
  #    | 21Emp01       | Employee123     |
  #    | 213Employ     | Employee123     |
  #    | Ahmet123      | Emp1.           |
  #    | AhmetAkk32145 | Employee321456. |