package com.PageObjects;

import org.openqa.selenium.Keys;
import static com.codeborne.selenide.Selenide.$;

/**
 * Created by Igor on 12/21/2017.
 * Заголовок яндекса
 */
public class YandexHeader {

    private static final String SEARCH_FIELD = "#header-search";

    /**
     * Делает поиск через заголовок яндекса
     * @param searchText строка для поиска
     */
    public void makeSearch(String searchText) {

        $(SEARCH_FIELD).clear();
        $(SEARCH_FIELD).sendKeys(searchText);
        $(SEARCH_FIELD).sendKeys(Keys.ENTER);
    }


}
