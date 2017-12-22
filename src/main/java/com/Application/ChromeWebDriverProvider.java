package com.Application;

import com.codeborne.selenide.WebDriverProvider;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

/**
 * ChromeWebDriverProvider
 */
public class ChromeWebDriverProvider implements WebDriverProvider {

    /**
     *
     * @param desiredCapabilities
     * @return ChromeDriver с заданными  desiredCapabilities
     */
    @Override
    public WebDriver createDriver(DesiredCapabilities desiredCapabilities) {
        return  new ChromeDriver(desiredCapabilities);
    }
}