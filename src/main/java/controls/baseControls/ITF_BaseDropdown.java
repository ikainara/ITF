package controls.baseControls;

import core.BaseDriver;
import org.openqa.selenium.By;

public abstract class ITF_BaseDropdown extends BaseControl {
    protected final String BASE_XPATH;
    protected final String SELECTED_ITEM_XPATH;
    protected final String ITEMS_XPATH;

    protected String EXPAND_ATTRIBUTE_NAME;
    protected String DROPDOWN_ELEMENT_TEXT_XPATH;

    protected boolean isExpanded;

    public ITF_BaseDropdown(BaseDriver driver, String selectedItemXPath, String baseXPath) {
        super(driver, By.xpath(baseXPath));
        BASE_XPATH = baseXPath;
        ITEMS_XPATH = "/ul//li";
        SELECTED_ITEM_XPATH = selectedItemXPath;
        isExpanded = false;
    }

    public boolean isExpanded() {
        return isExpanded;
    }

    protected abstract void expand();

    protected abstract void claps();

    public void selectElementByText(String text) {
        expand();
        driver.getElement(By.xpath(BASE_XPATH + ITEMS_XPATH + String.format(DROPDOWN_ELEMENT_TEXT_XPATH, text))).click();
        waitForTextToBe(By.xpath(BASE_XPATH + SELECTED_ITEM_XPATH), text, 30);
        claps();
    }

}
