package UITesting.Pages;

import UITesting.Utilities.Methods;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.List;

public class Elements extends Methods {

    public Elements(){
        PageFactory.initElements(getDriver(),this);
    }

    @FindBy(id = "userName")
    public WebElement userNameBox;
    @FindBy(id = "password")
    public WebElement passwordBox;
    @FindBy(id = "login")
    public WebElement loginButton;
    @FindBy(id = "name")
    public WebElement errorMessage;
    @FindBy(id = "userName-value")
    public WebElement logInVerify;
    @FindBy(xpath = "//button[text()='Log out']")
    public WebElement logOutButton;
    @FindBy(className = "main-header")
    public WebElement logOutVerify;
    @FindBy(id = "searchBox")
    public WebElement searchBox;
    @FindBy(css = "[id*=see-book]")
    public List<WebElement> searchResults;
    @FindBy(xpath = "//button[text()='Add To Your Collection']")
    public WebElement addToTheCollection;
    @FindBy(xpath = "//span[text()='Profile']")
    public WebElement profilePage;
    @FindBy(id = "delete-record-undefined")
    public WebElement trashIcon;
    @FindBy(id = "closeSmallModal-ok")
    public WebElement okConfirmButton;
    @FindBy(css = "[aria-label='rows per page']")
    public WebElement rowSelect;


    public WebElement getWebElement(String element) {
        switch (element) {
            case "userNameBox": return userNameBox;
            case "passwordBox": return passwordBox;
        }
        return null;
    }
}
