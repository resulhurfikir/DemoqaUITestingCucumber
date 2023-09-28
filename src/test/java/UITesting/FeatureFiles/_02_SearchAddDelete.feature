Feature: Search Functionality

  Background: Login Process
    Given Navigate to related URL
    When Click on the Login button
    And Fill up the Username & Password using *ConfigurationReader*
    And Click on the Login button
    Then Verify that the user logged in successfully

  Scenario: User should be able to add a book to the collection by searching
    Given Enter "No Starch Press" into the search box to search
    And Choose a book from search results
    And Add the book to the collection
    Then Verify that the book has been added to the collection successfully

  Scenario: The user should be able to delete the book from the collection
    Given Navigate to Profile Page
    And Click on the trash icon
    And Click on the OK button to confirm deleting
    Then Verify that the book has been deleted successfully




