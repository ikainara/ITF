package core;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class BaseObject {
    protected final static int DEFAULT_TIMEOUT = 30;              //default timeout in sec
    protected final static int SLEEP = 1000;

    protected static Logger logger;

    public BaseObject() {
        logger = LogManager.getRootLogger();
    }

    protected static Logger getLogger() {
        return logger;
    }
}
