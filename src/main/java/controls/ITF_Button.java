package controls;

import controls.baseControls.BaseControl;
import core.BaseDriver;
import org.openqa.selenium.By;

public class ITF_Button extends BaseControl {
    public ITF_Button(BaseDriver driver, By locator) {
        super(driver, locator);
    }

    public ITF_Button(BaseDriver driver, String xPath) {
        super(driver, By.xpath(xPath));
    }
}
