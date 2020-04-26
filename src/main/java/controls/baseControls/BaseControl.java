package controls.baseControls;

import controls.interfaces.base.IBaseControlActions;
import controls.interfaces.base.IBaseControlWaiters;
import core.BaseDriver;
import org.openqa.selenium.By;

public abstract class BaseControl extends BaseControlWaiters implements IBaseControlWaiters, IBaseControlActions {


    public BaseControl(BaseDriver driver, By locator) {
        super(driver, locator);
    }

    public void click() {
        click(DEFAULT_TIMEOUT);
    }

    public void click(int timeoutSec) {
        waitIsPresent(timeoutSec);
        driver.getDriver().findElement(BASE_LOCATOR).click();
    }

    public String getAttribute(String attributeName) {
        return getAttribute(attributeName, DEFAULT_TIMEOUT);
    }

    public String getAttribute(String attributeName, int timeout) {
        waitIsPresent(timeout);
        return driver.getDriver().findElement(BASE_LOCATOR).getAttribute(attributeName);
    }

    public String getText() {
        return getAttribute("value");
    }

    public String getText(int timeoutSec) {
        return getAttribute("value", timeoutSec);
    }

    public boolean isDisplayed(int timeoutSec) {
        return driver.getDriver().findElement(BASE_LOCATOR).isDisplayed();
    }

    public boolean isDisplayed() {
        return isDisplayed(DEFAULT_TIMEOUT);
    }
}
