package com.Application;

import com.Utils.Browsers;
import static com.Utils.Browsers.*;

/**
 * Класс для чтения конфигурации
 */
public class Configuration {


    /**
     * @return системное проперти "webdriver.driver" в виде Browsers (enum)
     */
    public static Browsers getBrowser() {

        String propertyName = "expected.browser";
        String browser = System.getProperty(propertyName);

        if(browser != null) {
            if (browser.equalsIgnoreCase("firefox")) {
                return FIREFOX;
            } else if (browser.equalsIgnoreCase("chrome")) {
                return CHROME;
            }
        }
        throw new RuntimeException("Property \"" + propertyName + "\"" + " is undefined");

    }
}
