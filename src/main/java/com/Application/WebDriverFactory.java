package com.Application;

import com.Utils.Browsers;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import static com.Utils.Browsers.CHROME;
import static com.Utils.Browsers.FIREFOX;


/**
 * Фабрика для вебрайвера
 */
public class WebDriverFactory {

    /**
     * @return инстанс вебрайвера
     */
    public static WebDriver getInstance() {

        Browsers expectedBrowser = Configuration.getBrowser();

        if (expectedBrowser == CHROME) {
            return getChromeDriver();
        }
        else if (expectedBrowser == FIREFOX) {
            return getFirefoxDriver();
        }

        throw new RuntimeException("Can't find browser :  " + expectedBrowser);
    }

    /**
     * Создает инстанс chrome вебрайвера
     * @return chrome вебрайвер
     */
    private static WebDriver getChromeDriver()  {

        DesiredCapabilities capabilities = DesiredCapabilities.chrome();
        ChromeOptions options = new ChromeOptions();
        //options.addArguments("start-fullscreen");
        capabilities.setCapability(ChromeOptions.CAPABILITY, options);
        return new ChromeDriver(capabilities);

    }

    /**
     * Создает инстанс firefox вебрайвера
     * @return firefox вебрайвер
     */
    private static WebDriver getFirefoxDriver() {

        DesiredCapabilities capabilities = DesiredCapabilities.firefox();
        FirefoxOptions options = new FirefoxOptions();
        //options.addArguments("start-fullscreen");
        capabilities.setCapability(FirefoxOptions.FIREFOX_OPTIONS, options);
        return  new FirefoxDriver(capabilities);

    }
}
