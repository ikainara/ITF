package core;

import org.testng.Assert;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class Verifier {
    private final Logger logger;

    public Verifier() {
        logger =  LogManager.getRootLogger();
    }

    public void verify(String actual, String expected,  String verificationMessage) {
        logger.info(verificationMessage);
        Assert.assertEquals(actual, expected);
    }
}
