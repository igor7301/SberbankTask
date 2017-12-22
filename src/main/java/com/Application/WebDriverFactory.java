package com.Application;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import java.net.MalformedURLException;


/**
 * Фабрика для вебрайвера
 */
public class WebDriverFactory {

    /**
     * @return инстанс вебрайвера
     * @throws MalformedURLException
     */
    public static WebDriver getInstance() throws MalformedURLException {
        return getChromeDriver();
    }

    /**
     * Создает инстанс chrome вебрайвера
     * @return chrome вебрайвер
     * @throws MalformedURLException
     */
    private static WebDriver getChromeDriver() throws MalformedURLException {

        DesiredCapabilities capabilities = DesiredCapabilities.chrome();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        capabilities.setCapability(ChromeOptions.CAPABILITY, options);

        return new EventFiringWebDriver(new ChromeWebDriverProvider().createDriver(capabilities))
                .register(new CustomWebDriverEventListener());
    }
}
