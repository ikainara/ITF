package controls;

import controls.baseControls.BaseControl;
import core.BaseDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ITF_Textbox extends BaseControl {
    WebElement textbox;
    public ITF_Textbox(BaseDriver driver, By locator) {
        super(driver, locator);
        textbox = driver.getElement(locator);
    }

    public ITF_Textbox(BaseDriver driver, String xPath) {
        super(driver, By.xpath(xPath));
        textbox = driver.getElement(By.xpath(xPath));
    }

    public void setText(String text) {
        textbox.sendKeys(text);
    }
}
