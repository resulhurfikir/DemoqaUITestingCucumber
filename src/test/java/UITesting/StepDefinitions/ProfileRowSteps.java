package UITesting.StepDefinitions;

import UITesting.Pages.Elements;
import io.cucumber.java.en.*;
import org.testng.Assert;

public class ProfileRowSteps extends Elements {
    @And("Fill up the Username & Password")
    public void fillUpTheUsernamePassword() {
        sendKeysFunction(userNameBox,"resulhurfikir");
        sendKeysFunction(passwordBox,"ResulHurfikir123#.");
    }


    @When("Click on the profile page")
    public void clickOnTheProfilePage() {
        jsClickFunction(profilePage);
    }


    @And("Click on the row count and change it different option")
    public void clickOnTheRowCountAndChangeItDifferentOption() {
        waitUntilClickable(rowSelect);
        select(rowSelect).selectByValue("10");
    }


    @Then("Verify that the row count has been changed successfully")
    public void verifyThatTheRowCountHasBeenChangedSuccessfully() {
        Assert.assertEquals("10",rowSelect.getDomProperty("value"));
    }
}
