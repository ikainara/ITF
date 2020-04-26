package core;

public class BasePage {
    private static final int DEFAULT_TIMEOUT = 30;

    protected BaseDriver driver;

    public BasePage(BaseDriver driver) {
        this.driver = driver;
    }

    protected boolean isDisplayed() {
        return true;
    }
}
