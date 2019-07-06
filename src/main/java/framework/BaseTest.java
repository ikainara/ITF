package framework;

import core.BaseDriver;
import core.BaseObject;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import web.GloConfig;


public class BaseTest extends BaseObject {
    private BaseDriver driver;
    protected static GloConfig config;
    protected Object clazz;

    public BaseTest(Object clazz) {
        this.clazz = clazz;
    }

    @BeforeSuite
    public void beforeSuite() throws Exception {
        getLogger().info(String.format("***** Start executing test '%s' *****", getTestName()));
        config = new GloConfig();
        driver = new BaseDriver(config.getDriverType());
    }

    @AfterSuite
    public void afterSuite() {
        if(null != driver) {
            driver.close();
            driver.quit();
        }
    }

    public BaseDriver getDriver() {
        return driver;
    }

    private String getTestName() {
        String[] test = ((Class) clazz).getName().toString().split("\\.");
        return test[test.length-1];
    }

}
