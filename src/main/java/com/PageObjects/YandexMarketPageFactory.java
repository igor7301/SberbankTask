package com.PageObjects;

import com.codeborne.selenide.Condition;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

/**
 * Created by Igor on 12/21/2017.
 */
public class YandexMarketPageFactory {

    private static final String ALL_DEPARTMENTS_BTN = ".n-topmenu-new-vertical-wrapper .n-topmenu-new-vertical__left button";



    private YandexMarketPageFactory() {
    }


    public static YandexMarketAbstractPage getPage() {



        try  {
            $(ALL_DEPARTMENTS_BTN).waitUntil(Condition.visible, 1000);
            return new YandexMarketPage();
        }
        catch (Error e) {

            return new YandexMarketPage2();
        }


    }


}
