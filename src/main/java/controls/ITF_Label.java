package controls;

import controls.baseControls.BaseControl;
import core.BaseDriver;
import org.openqa.selenium.By;

public class ITF_Label extends BaseControl {
    public ITF_Label(BaseDriver driver, By locator) {
        super(driver, locator);
    }

    @Override
    public String getText(int  timeoutSec) {
        waitIsPresent(timeoutSec);
        return driver.getDriver().findElement(BASE_LOCATOR).getText();
    }

    @Override
    public String getText() {
        return getText(DEFAULT_TIMEOUT);
    }
}
