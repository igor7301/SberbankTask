package com.PageObjects;

import io.qameta.allure.Step;
import org.openqa.selenium.Keys;

import static com.codeborne.selenide.Selenide.$;

/**
 * Created by Igor on 12/21/2017.
 */
public class YandexHeader {

    private static final String SEARCH_FIELD = "#header-search";

    public void makeSearch(String searchText) {
        $(SEARCH_FIELD).clear();
        $(SEARCH_FIELD).sendKeys(searchText);
        $(SEARCH_FIELD).sendKeys(Keys.ENTER);
    }


}
