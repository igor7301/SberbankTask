package com.Application;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.WebDriverEventListener;

import java.util.Arrays;

public class CustomWebDriverEventListener implements WebDriverEventListener {

    private final static Logger LOGGER = LogManager.getLogger(CustomWebDriverEventListener.class);

    @Override
    public void beforeAlertAccept(WebDriver webDriver) {

    }

    @Override
    public void afterAlertAccept(WebDriver webDriver) {

    }

    @Override
    public void afterAlertDismiss(WebDriver webDriver) {

    }

    @Override
    public void beforeAlertDismiss(WebDriver webDriver) {

    }

    @Override
    public void beforeNavigateTo(String s, WebDriver webDriver) {
        LOGGER.info("Navigate to "  + s);
    }

    @Override
    public void afterNavigateTo(String s, WebDriver webDriver) {

    }

    @Override
    public void beforeNavigateBack(WebDriver webDriver) {

        LOGGER.info("Navigate back");
    }

    @Override
    public void afterNavigateBack(WebDriver webDriver) {

    }

    @Override
    public void beforeNavigateForward(WebDriver webDriver) {

        LOGGER.info("Navigate forward");
    }

    @Override
    public void afterNavigateForward(WebDriver webDriver) {

    }

    @Override
    public void beforeNavigateRefresh(WebDriver webDriver) {

        LOGGER.info("Refresh the page");
    }

    @Override
    public void afterNavigateRefresh(WebDriver webDriver) {

    }

    @Override
    public void beforeFindBy(By by, WebElement webElement, WebDriver webDriver) {

        logWebElement("Find element", webElement);
    }

    @Override
    public void afterFindBy(By by, WebElement webElement, WebDriver webDriver) {

    }

    @Override
    public void beforeClickOn(WebElement webElement, WebDriver webDriver) {

        logWebElement("Click on element", webElement);
    }

    @Override
    public void afterClickOn(WebElement webElement, WebDriver webDriver) {

    }

    @Override
    public void beforeChangeValueOf(WebElement webElement, WebDriver webDriver, CharSequence[] charSequences) {

        String sendKeys = "";
        try {

            if(charSequences != null) {

                sendKeys = Arrays.asList(charSequences).toString();
            }

        } catch (Exception e) {

            e.printStackTrace();

            LOGGER.error("Can't convert to list...");
        }

        logWebElement("Send keys \"" + sendKeys + "\" to element", webElement);
    }

    @Override
    public void afterChangeValueOf(WebElement webElement, WebDriver webDriver, CharSequence[] charSequences) {

    }

    @Override
    public void beforeScript(String s, WebDriver webDriver) {

        LOGGER.debug("executing java script : " + s);
    }

    @Override
    public void afterScript(String s, WebDriver webDriver) {

    }

    @Override
    public void onException(Throwable throwable, WebDriver webDriver) {

    }

    private void logWebElement(String message, WebElement webElement) {

        try {

            if(webElement != null) {

                LOGGER.info(message + " : {text=\"" + webElement.getText().replaceAll("\\n", " ").trim() + "\";  element=\"" + webElement.toString().split("css selector:")[1].split("]")[0] + "\"}");
            }

        } catch (Exception e) {

            LOGGER.warn("Can't log web element...");
            e.printStackTrace();
        }
    }

}
