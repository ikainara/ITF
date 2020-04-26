package framework;

import core.BaseDriver;
import core.BaseObject;
import core.Verifier;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import web.GloConfig;


public class BaseTest extends BaseObject {
    private BaseDriver driver;
    protected static GloConfig config;
    protected final Verifier verifier;

    public BaseTest() {
        verifier = new Verifier();
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
        String[] test = ((Class) String.class).getName().toString().split("\\.");
        return test[test.length-1];
    }

}
