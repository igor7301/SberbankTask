package com.PageObjects;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.math.BigDecimal;
import static com.Utils.Constants.TIMEOUT_IN_MILLISECONDS_10000;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;


/**
 * Яндекс фильтр
 */
public class YandexFilter {

    private final static Logger LOGGER = LogManager.getLogger(YandexFilter.class);

    private static final String START_PRICE = ".n-filter-panel-aside .input_price_from .input__control";
    private static final String END_PRICE = ".n-filter-panel-aside .input_price_to .input__control";
    private static final String MANUFACTURE_LIST = ".n-filter-panel-aside__content .n-filter-block:nth-child(4) .checkbox";
    private static final String MANUFACTURE_CHECK_BOX = ".checkbox__label";
    private static final String APPLY_FILTER_BTN = ".n-filter-panel-aside__apply button";
    private static final String SPINNER = ".preloadable__preloader";


    /**
     * Устанавливает начальную цену в параметры фильтра
     * @param startPrice
     */
    @Step("I set price from \"{startPrice}\"")
    public void setStartPrice(BigDecimal startPrice) {
        $(START_PRICE).setValue(startPrice.toString());
    }


    /**
     * Устанавливает конечную цену в парамерты фильтра
     * @param endPrice
     */
    @Step("I set price to \"{endPrice}\"")
    public void setEndPrice(BigDecimal endPrice) {
        $(END_PRICE).setValue(endPrice.toString());
    }


    /**
     * Устанавливает в параметры фильтра фирму производителя товара
     * @param manufacture фирма производитель
     */
    @Step("I check manufacture \"{manufacture}\"")
    public void setManufacture(String manufacture) {

        for (SelenideElement manufactureElement : $$(MANUFACTURE_LIST)) {
            if (manufactureElement.getText().equalsIgnoreCase(manufacture)) {
                manufactureElement.$(MANUFACTURE_CHECK_BOX).click();
            }
        }
    }

    /**
     * Применяет фильтр и ожидает завершения обновления результатов
     */
    @Step("I apply all filters")
    public void apply() {
        $(APPLY_FILTER_BTN).click();
        waitUntilResultsUpdated();
    }

    /**
     * Ожидает завершения обновления результатов
     */
    private void waitUntilResultsUpdated() {
        try {

            $(SPINNER).waitUntil(Condition.visible, TIMEOUT_IN_MILLISECONDS_10000);
            $(SPINNER).should(Condition.disappear);

        } catch (Error e) {

            LOGGER.warn("Can't find spinner ... ");
            e.printStackTrace();
        }
    }


}
