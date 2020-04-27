package helpers;

import core.BaseDriver;
import pages.LoginPage;

public class LoginHelper {
    public void login(BaseDriver driver, String url, String login, String password) {
        driver.navigateToURL(url);
        new LoginPage(driver).login(login, password);
    }
}
