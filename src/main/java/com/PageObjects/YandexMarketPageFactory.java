package com.PageObjects;

import com.codeborne.selenide.Condition;

import static com.Utils.Constants.TIMEOUT_IN_MILLISECONDS_1000;
import static com.codeborne.selenide.Selenide.$;

/**
 * Created by Igor on 12/21/2017.
 * Фабрика для раздачи различных версий страницы яндекс маркета
 */
public class YandexMarketPageFactory {

    //маркер (кнопка Все Категории) которая присутствует только на одной из версии  яндекс маркет страницы
    private static final String MARKER_ALL_DEPARTMENTS_BTN = ".n-topmenu-new-vertical-wrapper .n-topmenu-new-vertical__left button";

    private YandexMarketPageFactory() {
    }

    /**
     *
     * @return активную версию страницы яндекс маркета
     */
    public static YandexMarketAbstractPage getPage() {

        try {
            $(MARKER_ALL_DEPARTMENTS_BTN).waitUntil(Condition.visible, TIMEOUT_IN_MILLISECONDS_1000);
            return new YandexMarketPage();
        }
        catch (Error e) {
            return new YandexMarketPage2();
        }

    }


}
