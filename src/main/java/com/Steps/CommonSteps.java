package com.Steps;

import io.qameta.allure.Step;

import static com.Utils.Utils.makeScreenshot;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class CommonSteps {

    @Step("I navigate to \"{url}\"")
    public void navigate(String url) {
        getWebDriver().navigate().to(url);
        makeScreenshot();
    }
}
