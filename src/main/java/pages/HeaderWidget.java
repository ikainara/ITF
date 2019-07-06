package pages;

import controls.ITF_Button;
import controls.ITF_ButtonDropdown;
import controls.ITF_Textbox;
import core.BaseDriver;
import core.BasePage;

public class HeaderWidget extends BasePage {
    private final String BASE_XPATH = "//div[@class='header']";
    private final ITF_Textbox searchTextbox;
    private final ITF_Button searchButton;
    private final ITF_ButtonDropdown searchByDropdown;

    public HeaderWidget(BaseDriver driver) {
        super(driver);
        searchTextbox = new ITF_Textbox(driver, BASE_XPATH + "//input[@id='search']");
        searchButton = new ITF_Button(driver, BASE_XPATH + "//span[@class='input-group-btn pull-left']/a");
        searchByDropdown = new ITF_ButtonDropdown(driver, "/button", BASE_XPATH + "//div[contains(@class, 'search-dropdown')]");
    }

    public void searchBySMTHG(String searchFor, String searchBy) {
        searchByDropdown.selectElementByText(searchBy);
        searchTextbox.setText(searchFor);
        searchButton.click();
    }
}
