package com.PageObjects;

import com.codeborne.selenide.Condition;

import static com.codeborne.selenide.Selenide.$;

public class YandexHomePage {

    private static final String SEARCH_BOX = ".home-arrow .input__box";
    private static final String MARKET_LINK = "a[data-statlog='sites.market.title']";

    public YandexHomePage() {
        $(SEARCH_BOX).shouldBe(Condition.visible);
    }


    public void openMarket() {
        $(MARKET_LINK).click();
    }
}
