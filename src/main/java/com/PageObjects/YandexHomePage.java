package com.PageObjects;

import com.codeborne.selenide.Condition;
import static com.codeborne.selenide.Selenide.$;


/**
 * Стартовая страница яндекса
 */
public class YandexHomePage {

    private static final String SEARCH_BOX = ".home-arrow .input__box";
    private static final String MARKET_LINK = "a[data-statlog='sites.market.title']";

    public YandexHomePage() {
        $(SEARCH_BOX).shouldBe(Condition.visible);
    }


    /**
     * Открывает яндекс маркет
     */
    public void openMarket() {
        $(MARKET_LINK).click();
    }
}
