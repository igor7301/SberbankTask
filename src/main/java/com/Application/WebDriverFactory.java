package com.Application;

import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import java.net.MalformedURLException;
import java.util.HashMap;
import java.util.Map;

public class WebDriverFactory {

    public  static  WebDriver getInstance() throws MalformedURLException {

        return getChromeDriver();

    }

    private static WebDriver getChromeDriver() throws MalformedURLException {

        DesiredCapabilities capabilities = DesiredCapabilities.chrome();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        capabilities.setCapability(ChromeOptions.CAPABILITY, options);

        return new EventFiringWebDriver(new ChromeWebDriverProvider().createDriver(capabilities))
                .register(new CustomWebDriverEventListener());
    }
}
