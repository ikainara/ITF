package testcases.HeaderWidget;

import controls.ITF_Label;
import framework.BaseTest;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import pages.HeaderWidget;

public class SearchWithEmptyResult extends BaseTest {

    @Test(groups = "gr2")
    public void test() {
        loginHelper.login(getDriver(), "https://asdasdas.asdasd.com", "user.name", "pwd!");
        HeaderWidget headerWidget = new HeaderWidget(getDriver());
        headerWidget.searchBySMTHG("emptyResult", "People");
        String str = new ITF_Label(getDriver(), By.xpath("//div[@class='search-header']/following-sibling::div[@class='content-box']//div[@id]")).getText();
        verifier.verify(str, "No Results Found", "Verify Message is No result found");
    }
}
