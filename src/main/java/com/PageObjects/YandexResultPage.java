package com.PageObjects;

import static com.codeborne.selenide.Selenide.$;

/**
 * Страница яндекс результатов
 */
public class YandexResultPage {

    private static final String TITLE_OF_PRODUCT = ".n-title__text";

    /**
     * Возвращает название первого и единственного товара со страницы результатов
     * @return название товара
     */
    public String getTitleOfProduct() {
        return $(TITLE_OF_PRODUCT).getText();
    }


}
