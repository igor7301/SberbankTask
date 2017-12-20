package com.PageObjects;

import com.codeborne.selenide.Condition;

import static com.codeborne.selenide.Selenide.$;

public class YandexMarketPage {

    public static final String HEADER_MAIN = ".header2__main";
    public static final String DEP_COMPUTERS = "li[data-department=\"Компьютеры\"]";
    public static final String SUB_DEP_NOTEBOOKS = "li[data-department=\"Компьютеры\"]";


    public YandexMarketPage() {
        $(HEADER_MAIN).shouldBe(Condition.visible);
    }


    public void openNotebooks() {
        $(DEP_COMPUTERS).hover();
        $(SUB_DEP_NOTEBOOKS).shouldBe(Condition.visible).click();

    }
}
