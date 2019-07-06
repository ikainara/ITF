package core;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseDriver extends BaseObject {
    private WebDriver driver;

    public BaseDriver(String driverType) throws Exception {
        if(driverType.equals("chromedriver")) {
            configurateChromeDriver();
            runChromeDriver();
        }
        else {
            throw new Exception(String.format("Unknown driver type '%s'", driverType));
        }

    }

    public void close() {
       driver.close();
    }

    public void quit() {
        driver.quit();
    }

    public WebDriver getDriver() {
        return driver;
    }

    public WebElement getElement(By locator) {
        return getElement(locator, DEFAULT_TIMEOUT);
    }

    public WebElement getElement(By locator, int timeoutSec) {
        new WebDriverWait(driver, timeoutSec, SLEEP).until(ExpectedConditions.presenceOfElementLocated(locator));
        return driver.findElement(locator);
    }

    public void navigateToURL(String url) {
        driver.navigate().to(url);
    }

    public void back() {
        driver.navigate().back();
    }

    public void forward() {
        driver.navigate().forward();
    }

    private void configurateChromeDriver() {
        System.setProperty("webdriver.chrome.driver", "/Users/igor.kainara/Documents/WebDrivers/chromedriver");
        System.setProperty("headless", "false");                // true - to not display chrome browser while running the tests
    }

    private void runChromeDriver() {
        String headless = System.getProperty("headless");
        if("true".equals(headless)) {
            ChromeOptions chromeOptions = new ChromeOptions();
            chromeOptions.addArguments("--headless");
            driver = new ChromeDriver(chromeOptions);

        } else {
            driver = new ChromeDriver();
        }
    }

}
