package controls.baseControls;

import core.BaseDriver;
import core.BaseObject;
import core.utils.Sleeper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.function.Function;

public class BaseControlWaiters extends BaseObject {
    protected BaseDriver driver;
    protected final By BASE_LOCATOR;

    public BaseControlWaiters(BaseDriver driver, By controlLocator) {
        this.driver = driver;
        BASE_LOCATOR = controlLocator;
    }

    public void waitIsPresent() {
        waitIsPresent(DEFAULT_TIMEOUT);
    }

    public void waitIsPresent(int timeoutSec) {
        new WebDriverWait(driver.getDriver(), timeoutSec, SLEEP).until(ExpectedConditions.presenceOfElementLocated(BASE_LOCATOR));
    }

    public void waitIsVisible() {
        waitIsVisible(DEFAULT_TIMEOUT);
    }

    public void waitIsVisible(int timeoutSec) {
        new WebDriverWait(driver.getDriver(), timeoutSec, SLEEP).until(ExpectedConditions.visibilityOfElementLocated(BASE_LOCATOR));
    }

    public void waitIsClickable() {
        waitIsClickable(DEFAULT_TIMEOUT);
    }

    public void waitIsClickable(int timeoutSec)
    {
        new WebDriverWait(driver.getDriver(), timeoutSec, SLEEP).until(ExpectedConditions.elementToBeClickable(BASE_LOCATOR));
    }

    public void waitIsNotPresent() throws InterruptedException {
        waitIsNotPresent(DEFAULT_TIMEOUT);
    }

    public void waitIsNotPresent(int timeout) throws InterruptedException {
        int i = timeout;
        while (i > 0 && null != driver.getDriver().findElement(BASE_LOCATOR)) {
            Sleeper.sleepInSeconds(SLEEP);
            i--;
        }
    }

    public void waitIsNotVisible() {
        waitIsNotVisible(DEFAULT_TIMEOUT);
    }

    public void waitIsNotVisible(int timeoutSec) {
        new WebDriverWait(driver.getDriver(), timeoutSec, SLEEP).until(ExpectedConditions.invisibilityOfElementLocated(BASE_LOCATOR));
    }

    public void waitIsNotClickable() {
        waitIsNotClickable(DEFAULT_TIMEOUT);
    }

    public void waitIsNotClickable(int timeoutSec) {
        new WebDriverWait(driver.getDriver(), timeoutSec, SLEEP).until(ExpectedConditions.not(ExpectedConditions.elementToBeClickable(BASE_LOCATOR)));
    }

    public void waitForAttributeBecome(By locator, String attribute, String value) {
        new WebDriverWait(driver.getDriver(), DEFAULT_TIMEOUT, SLEEP).until(ExpectedConditions.attributeContains(locator, attribute, value));
    }

    public void waitForAttributeBecome(By locator, String attribute, String value, int timeoutSec) {
        new WebDriverWait(driver.getDriver(), timeoutSec, SLEEP).until(ExpectedConditions.attributeContains(locator, attribute, value));
    }

    public void waitForTextToBe(By locator, String text, int timeoutSec) {
        new WebDriverWait(driver.getDriver(), timeoutSec, SLEEP).until(ExpectedConditions.textToBe(locator, text));
    }

}
