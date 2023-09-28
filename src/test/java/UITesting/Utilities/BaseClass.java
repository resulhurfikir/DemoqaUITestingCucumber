package UITesting.Utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeDriverService;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxDriverService;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BaseClass {


    private static ThreadLocal<WebDriver> threadDriver = new ThreadLocal<>();
    private static ThreadLocal<String> threadBrowserName = new ThreadLocal<>();

    public static WebDriver getDriver() {
        Locale.setDefault(new Locale("EN"));
        System.setProperty("user.language", "EN");

        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY, "true");

        Logger logger = Logger.getLogger("");
        logger.setLevel(Level.SEVERE);

       if (threadBrowserName.get() == null)
           threadBrowserName.set("chrome");

        if (threadDriver.get() == null) {

            switch (threadBrowserName.get()) {
                case "firefox":
                    System.setProperty(FirefoxDriverService.LOG_NULL, "/dev/null");
                    threadDriver.set(new FirefoxDriver());
                    threadDriver.get().manage().window().maximize();
                    break;

                case "edge":
                    System.setProperty(EdgeDriverService.LOG_NULL,"/dev/null");
                    threadDriver.set(new EdgeDriver());
                    threadDriver.get().manage().window().maximize();
                    break;

                default:
                    threadDriver.set(new ChromeDriver(options));
                    break;
            }
        }

        return threadDriver.get();
    }

    public static void quitDriver() {

        if (threadDriver.get() != null) {
            threadDriver.get().quit();
            threadDriver.set(null);
        }
    }

    public static void threadBrowserSet(String browser) {
        threadBrowserName.set(browser);
    }
    public static String threadBrowserGet() {
        return threadBrowserName.get();
    }
}