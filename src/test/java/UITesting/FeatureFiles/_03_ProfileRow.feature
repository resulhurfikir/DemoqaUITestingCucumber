Feature: Profile Page Functionality

  Scenario: User should be able to change row count in the profile page
    Given Navigate to related URL
    When Click on the Login button
    And Fill up the Username & Password
    And Click on the Login button
    Then Verify that the user logged in successfully
    When Click on the profile page
    And Click on the row count and change it different option
    Then Verify that the row count has been changed successfully