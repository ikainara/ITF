package pages;

import controls.ITF_Button;
import controls.ITF_Textbox;
import core.BaseDriver;
import core.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {
    private ITF_Textbox loginTextbox;
    private ITF_Textbox passwordTextBox;
    private ITF_Button loginButton;
    public LoginPage(BaseDriver driver) {
        super(driver);
        loginTextbox = new ITF_Textbox(driver, By.id("login"));
        passwordTextBox = new ITF_Textbox(driver, By.id("password"));
        loginButton = new ITF_Button(driver, By.xpath("//input[@type='submit']"));
    }

    public void login(String username, String password) {
        fillLoginForm(username, password);
        loginButton.click();
        driver.getElement(By.id("slideSkip")).click();
    }

    public void fillLoginForm(String username, String password) {
        loginTextbox.setText(username);
        passwordTextBox.setText(password);
    }


}
