package testcases.Login;

import controls.ITF_Label;
import framework.BaseTest;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class SuccessfulLogin extends BaseTest {

    @Test(groups = "gr1")
    public void test() {
        loginHelper.login(getDriver(), "https://asdasdas.asdasd.com", "user.name", "pwd!");
        String str = new ITF_Label(getDriver(), By.xpath("//div[@class='profile-widget']//h2")).getText();
        verifier.verify(str, "Ihor Kainara", "Verify username is correct");
    }
}
