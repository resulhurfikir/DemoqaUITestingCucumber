Feature: Login and Logout Functionality

  Background: Works for all scenarios as first
    Given Navigate to related URL
    When Click on the Login button

  Scenario Outline: User should not be able to login with invalid username & password
    And Fill up the username as "<username>" password as "<password>"
    And Click on the Login button
    Then Verify that the user gets an error message

    Examples: Valid username/Invalid password & Invalid username/Valid password
      | username      | password          |
      | resulhurfikir | resul123.         |
      | resulh        | ResulHurfikir123# |


  Scenario: User should be able to login successfully
    And Fill up the Username & Password using *DataTable*
      | userNameBox | resulhurfikir      |
      | passwordBox | ResulHurfikir123#. |
    And Click on the Login button
    Then Verify that the user logged in successfully


  Scenario: User should be able to log out successfully
    And Fill up the Username & Password using *ExcelFile*
    And Click on the Login button
    Then Verify that the user logged in successfully
    And Click on the Logout button
    Then Verify that the user logged out successfully