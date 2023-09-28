package UITesting.Utilities;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;


public class Methods extends BaseClass {

    public Methods() {
        PageFactory.initElements(getDriver(), this);
    }

    WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(20));
    JavascriptExecutor js = (JavascriptExecutor) getDriver();


    public void clickFunction(WebElement element) {
        waitUntilClickable(element);
        scrollToElement(element);
        element.click();
    }


    public void sendKeysFunction(WebElement element, String text) {
        waitUntilVisible(element);
        waitUntilClickable(element);
        scrollToElement(element);
        element.clear();
        element.sendKeys(text);
    }


    public void scrollToElement(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        js.executeScript("arguments[0].scrollIntoView(false);", element);
    }


    public void waitUntilVisible(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
    }


    public void waitUntilClickable(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }


    public void jsClickFunction(WebElement element) {
        waitUntilClickable(element);
        js.executeScript("arguments[0].click();", element);
    }


    public Select select(WebElement element) {
        waitUntilClickable(element);
        return new Select(element);
    }


    public String getAlertMessage(){
       return getDriver().switchTo().alert().getText();
    }


    public void waitAlertPresent(){
        wait.until(ExpectedConditions.alertIsPresent());
    }


    public void closeAlert(){
        getDriver().switchTo().alert().accept();
    }


}