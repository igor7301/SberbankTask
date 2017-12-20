package com.Application;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import java.net.MalformedURLException;
import java.util.HashMap;
import java.util.Map;

public class WebDriverFactory {

    public static WebDriver getChromeDriver() throws MalformedURLException {
        Map<String, Object> prefs = new HashMap<String, Object>();
        DesiredCapabilities capabilities = DesiredCapabilities.chrome();
        ChromeOptions options = new ChromeOptions();


        options.addArguments("--start-maximized");
        options.addArguments("--disable-extensions");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-logging");


        prefs.put("credentials_enable_service", false);
        prefs.put("profile.password_manager_enabled", false);

        options.setExperimentalOption("prefs", prefs);
        capabilities.setCapability(ChromeOptions.CAPABILITY, options);

        return new EventFiringWebDriver(new ChromeWebDriverProvider().createDriver(capabilities))
                .register(new CustomWebDriverEventListener());
    }
}
