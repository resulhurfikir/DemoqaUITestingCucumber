package UITesting.StepDefinitions;

import UITesting.Pages.Elements;
import UITesting.Utilities.ConfigurationReader;
import UITesting.Utilities.ExcelConnection;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import java.util.List;

public class LogInAndLogOutSteps extends Elements {
    @Given("Navigate to related URL")
    public void navigateToRelatedURL() {
        getDriver().get(ConfigurationReader.getProperty("url"));
    }


    @When("Click on the Login button")
    public void clickOnTheLoginButton() {
        jsClickFunction(loginButton);
    }


    @And("Fill up the username as {string} password as {string}")
    public void fillUpTheUsernameAsPasswordAs(String userName, String password) {
        sendKeysFunction(userNameBox, userName);
        sendKeysFunction(passwordBox, password);
    }


    @Then("Verify that the user gets an error message")
    public void verifyThatTheUserGetsAnErrorMessage() {
        waitUntilVisible(errorMessage);
        Assert.assertEquals("Invalid username or password!", errorMessage.getText());
    }


    @And("Fill up the Username & Password using *ExcelFile*")
    public void fillUpTheUsernamePasswordUsingExcelFile() {
        sendKeysFunction(userNameBox, ExcelConnection
                .getDataExcel("src/test/resources/ExcelFiles/LoginInfo.xlsx", "Login", 2).get(1).get(0));
        sendKeysFunction(passwordBox, ExcelConnection
                .getDataExcel("src/test/resources/ExcelFiles/LoginInfo.xlsx", "Login", 2).get(1).get(1));
    }


    @Then("Verify that the user logged in successfully")
    public void verifyThatTheUserLoggedInSuccessfully() {
        waitUntilVisible(logInVerify);
        Assert.assertEquals("resulhurfikir", logInVerify.getText(), "Login Failed");
    }


    @And("Click on the Logout button")
    public void clickOnTheLogoutButton() {
        clickFunction(logOutButton);
    }


    @Then("Verify that the user logged out successfully")
    public void verifyThatTheUserLoggedOutSuccessfully() {
        waitUntilVisible(logOutVerify);
        Assert.assertEquals("Login", logOutVerify.getText(), "Logout Failed");
    }


    @And("Fill up the Username & Password using *DataTable*")
    public void fillUpTheUsernamePasswordUsingDataTable(DataTable dt) {
        List<List<String>> items = dt.asLists(String.class);
        for (int i = 0; i < items.size(); i++) {
            WebElement w = getWebElement(items.get(i).get(0));
            sendKeysFunction(w, items.get(i).get(1));
        }
    }


}
