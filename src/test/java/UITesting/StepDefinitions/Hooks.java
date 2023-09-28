package UITesting.StepDefinitions;

import UITesting.Utilities.BaseClass;
import UITesting.Utilities.ExcelConnection;
import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class Hooks {

   @After
   public void after(Scenario scenario){

       ExcelConnection.writeDataExcel("src/test/resources/ExcelFiles/ScenarioStatus.xlsx",
               scenario, BaseClass.threadBrowserGet());

       if (scenario.isFailed()){
           TakesScreenshot ts=(TakesScreenshot) BaseClass.getDriver();
           final byte[] ssInMemory=ts.getScreenshotAs(OutputType.BYTES);
           scenario.attach(ssInMemory, "image/png","screenshot name");
       }
       BaseClass.quitDriver();
   }
}