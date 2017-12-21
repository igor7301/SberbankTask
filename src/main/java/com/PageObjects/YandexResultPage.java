package com.PageObjects;

import com.ProductItem;
import com.codeborne.selenide.SelenideElement;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class YandexResultPage {

    private static final String  TITLE_OF_PRODUCT = ".n-title__text";


    public String getTitleOfProduct () {
        return $(TITLE_OF_PRODUCT).getText();
    }


}
