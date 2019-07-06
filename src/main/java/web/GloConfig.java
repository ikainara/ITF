package web;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class GloConfig {
    Properties properties = new Properties();
    private String fileName = "TestEnvironment.properties";

    public GloConfig() throws IOException {
        InputStream inputStream = getClass().getClassLoader().getResourceAsStream(fileName);
        if (inputStream != null) {
            properties.load(inputStream);
        }
    }

    public String getServerURL() {
        return properties.getProperty("web.base.url");
    }

    public String getDriverType() {
        return properties.getProperty("webdriver.type");
    }

}
