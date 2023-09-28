package UITesting.StepDefinitions;

import UITesting.Pages.Elements;
import UITesting.Utilities.ConfigurationReader;
import io.cucumber.java.en.*;
import org.testng.Assert;

public class SearchAddDeleteSteps extends Elements {
    @And("Fill up the Username & Password using *ConfigurationReader*")
    public void fillUpTheUsernamePasswordUsingConfigurationReader() {
        sendKeysFunction(userNameBox, ConfigurationReader.getProperty("userName"));
        sendKeysFunction(passwordBox, ConfigurationReader.getProperty("password"));
    }


    @Given("Enter {string} into the search box to search")
    public void enterIntoTheSearchBoxToSearch(String word) {
        sendKeysFunction(searchBox,word);
    }


    @And("Choose a book from search results")
    public void chooseABookFromSearchResults() {
        clickFunction(searchResults.get(0));
    }


    @And("Add the book to the collection")
    public void addTheBookToTheCollection() {
        jsClickFunction(addToTheCollection);
    }


    @Then("Verify that the book has been added to the collection successfully")
    public void verifyThatTheBookHasBeenAddedToTheCollectionSuccessfully() {
        waitAlertPresent();
        Assert.assertTrue(getAlertMessage().contains("Book added"));
        closeAlert();
    }


    @Given("Navigate to Profile Page")
    public void navigateToProfilePage() {
        jsClickFunction(profilePage);
    }


    @And("Click on the trash icon")
    public void clickOnTheTrashIcon() {
        clickFunction(trashIcon);
    }


    @And("Click on the OK button to confirm deleting")
    public void clickOnTheOKButtonToConfirmDeleting() {
    clickFunction(okConfirmButton);
    }


    @Then("Verify that the book has been deleted successfully")
    public void verifyThatTheBookHasBeenDeletedSuccessfully() {
        waitAlertPresent();
        Assert.assertTrue(getAlertMessage().contains("Book deleted"));
        closeAlert();
    }
}
