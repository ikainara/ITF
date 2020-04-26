package testcases;

import controls.ITF_Label;
import framework.BaseTest;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import pages.HeaderWidget;
import pages.LoginPage;

public class SuccessfulLogin extends BaseTest {

    @Test(groups = "default")
    public void test() {
        getDriver().navigateToURL(config.getServerURL().replaceAll("<URL>", "https://my.web.site.com"));
        new LoginPage(getDriver()).login("user.name", "UserPassword");
        HeaderWidget headerWidget = new HeaderWidget(getDriver());
        String str = new ITF_Label(getDriver(), By.xpath("//div[@class='profile-widget']//h2")).getText();
        verifier.verify(str, "Ihor Kainara", "Verify username is correct");
    }
}
