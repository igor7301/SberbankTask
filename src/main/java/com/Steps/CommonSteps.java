package com.Steps;

import io.qameta.allure.Step;

import static com.Utils.Utils.makeScreenshot;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;


/**
 * Класс общих шагов
 */
public class CommonSteps {

    /**
     * Переходит на заданный url
     * @param url
     */
    @Step("I navigate to \"{url}\"")
    public void navigate(String url) {
        getWebDriver().navigate().to(url);
        makeScreenshot();
    }
}
