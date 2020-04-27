package framework;

import core.BaseDriver;
import core.BaseObject;
import core.Verifier;
import helpers.LoginHelper;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import web.GloConfig;


public class BaseTest extends BaseObject {
    private BaseDriver driver;
    protected static GloConfig config;
    protected final Verifier verifier;
    protected final LoginHelper loginHelper;

    public BaseTest() {
        verifier = new Verifier();
        loginHelper = new LoginHelper();
    }

    @BeforeClass
    public void beforeClass() throws Exception {
        getLogger().info(String.format("***** Start executing test '%s' *****", getTestName()));
        config = new GloConfig();
        driver = new BaseDriver(config.getDriverType());
    }

    @AfterClass
    public void afterClass() {
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
