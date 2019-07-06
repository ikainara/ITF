package controls;

import controls.baseControls.ITF_BaseDropdown;
import core.BaseDriver;
import org.openqa.selenium.By;

public class ITF_ButtonDropdown extends ITF_BaseDropdown {

    public ITF_ButtonDropdown(BaseDriver driver, String selectedItemXPath, String baseXPath) {
        super(driver, selectedItemXPath, baseXPath);
        super.EXPAND_ATTRIBUTE_NAME = "aria-expanded";
        super.DROPDOWN_ELEMENT_TEXT_XPATH = "/a[text()='%s']";
    }

    protected void expand() {
        if (!isExpanded) {
            driver.getElement(By.xpath(super.BASE_XPATH + super.SELECTED_ITEM_XPATH)).click();
            waitForAttributeBecome(By.xpath(super.BASE_XPATH + super.SELECTED_ITEM_XPATH), EXPAND_ATTRIBUTE_NAME, "true");
            isExpanded = true;
        }
    }

    protected void claps() {
        if (isExpanded) {
            if(!driver.getElement(By.xpath(super.BASE_XPATH + super.SELECTED_ITEM_XPATH)).getAttribute(EXPAND_ATTRIBUTE_NAME).equals("false")) {
                driver.getElement(By.xpath(super.BASE_XPATH + super.SELECTED_ITEM_XPATH)).click();
                waitForAttributeBecome(By.xpath(super.BASE_XPATH + super.SELECTED_ITEM_XPATH), EXPAND_ATTRIBUTE_NAME, "false");
                isExpanded = false;
            }
        }
    }
}
