package com.PageObjects;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import java.math.BigDecimal;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class YandexFilter {


    private static final String START_PRICE = ".n-filter-panel-aside .input_price_from .input__control";
    private static final String END_PRICE = ".n-filter-panel-aside .input_price_to .input__control";
    private static final String MANUFACTURE_LIST = ".n-filter-panel-aside__content .n-filter-block:nth-child(4) .checkbox";
    //  private static final String MANUFACTURE_NAME = ".checkbox__control";
    private static final String MANUFACTURE_CHECK_BOX = ".checkbox__label";
    public static final String APPLY_FILTER_BTN = ".n-filter-panel-aside__apply button";
    public static final String SPINNER = ".preloadable__preloader";


    @Step("I set price from {startPrice}")
    public void setStartPrice(BigDecimal startPrice) {
        $(START_PRICE).setValue(startPrice.toString());
    }


    @Step("I set price to {endPrice}")
    public void setEndPrice(BigDecimal endPrice) {
        $(END_PRICE).setValue(endPrice.toString());
    }


    @Step("I check manufacture \"{manufacture}\"")
    public void setManufacture(String manufacture) {

        for (SelenideElement manufactureElement : $$(MANUFACTURE_LIST)) {
            if (manufactureElement.getText().equalsIgnoreCase(manufacture)) {
                manufactureElement.$(MANUFACTURE_CHECK_BOX).click();
            }
        }
    }

    @Step("I apply all filters")
    public void apply() {
        $(APPLY_FILTER_BTN).click();
        waitUntilResultsUpdated();
    }

    private void waitUntilResultsUpdated() {
        try {
            $(SPINNER).waitUntil(Condition.visible, 10000);
            $(SPINNER).should(Condition.disappear);
        } catch (Error e) {

        }
    }

    @Step("I set product name {productName}")
    public void setProductName(String productName) {

        $("");
    }
}
