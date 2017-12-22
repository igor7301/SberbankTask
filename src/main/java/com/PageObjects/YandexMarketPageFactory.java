package com.PageObjects;

import com.Utils.Constants;
import com.codeborne.selenide.Condition;

import static com.Utils.Constants.*;
import static com.codeborne.selenide.Selenide.$;

/**
 * Created by Igor on 12/21/2017.
 */
public class YandexMarketPageFactory {

    private static final String MARKER_ALL_DEPARTMENTS_BTN = ".n-topmenu-new-vertical-wrapper .n-topmenu-new-vertical__left button";

    private YandexMarketPageFactory() {
    }

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
