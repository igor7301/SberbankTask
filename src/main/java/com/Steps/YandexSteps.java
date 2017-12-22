package com.Steps;

import com.PageObjects.*;
import com.SearchRequest;
import io.qameta.allure.Step;
import org.hamcrest.Matchers;

import static com.Utils.AllureAsserts.allureAssertThat;
import static com.Utils.Utils.makeScreenshot;
import static com.Utils.Utils.makeScreenshotFullPage;


/**
 * Класс шагов для Yandex страниц
 */
public class YandexSteps {


    /**
     * Открывает стратовую страницу яндекса
     */
    @Step("I open yandex market")
    public void openMarket() {
        new YandexHomePage().openMarket();
        makeScreenshot();
    }


    /**
     * Применет яндекс фильтр исходя из параметров searchRequest
     * @param searchRequest параметры поиска для яндекс фильтра
     */
    @Step("I apply filter with params ... ")
    public void applyFilter(SearchRequest searchRequest) {

        YandexFilter yandexFilter = new YandexFilter();
        if (searchRequest.getStartPrice() != null) {
            yandexFilter.setStartPrice(searchRequest.getStartPrice());
        }

        if (searchRequest.getEndPrice() != null) {
            yandexFilter.setEndPrice(searchRequest.getEndPrice());

        }

        if (searchRequest.getManufacturer() != null) {
            for (String manufacture : searchRequest.getManufacturer()) {

                yandexFilter.setManufacture(manufacture);
            }
        }


        yandexFilter.apply();
        makeScreenshotFullPage();


    }

    /**
     * Проверяет количество товаров на странице
     * @param resultsNumber ожидаемое количество товаров на странице
     */
    @Step("I verify amount of product items on page ...")
    public void verifyAmountOfResults(int resultsNumber) {

        YandexMarketPage yandexMarketPage = new YandexMarketPage();
        yandexMarketPage.getResults();
        allureAssertThat("Amount of product items should be : \"" + resultsNumber + "\"",
                yandexMarketPage.getResults().size(), Matchers.is(resultsNumber), false);

    }


    /**
     * Производит яндекс поиск по тексту
     * @param searchText текст для поиска в строке яндекса
     */
    @Step("I make search with \"{searchText}\" text")
    public void makeSearch(String searchText) {
        new YandexHeader().makeSearch(searchText);
    }

    /**
     * Проверяет что товар на странице результатов соответсвует ожидаемому
     * @param searchRequest ожидаемый результат поиска
     */
    @Step("I verify product item on result page ...")
    public void verifyResults(SearchRequest searchRequest) {

        YandexResultPage yandexResultPage = new YandexResultPage();

        if (searchRequest.getStartPrice() != null) {
            //добавьте проверку startPrice здесь
        }

        if (searchRequest.getEndPrice() != null) {
            //добавьте проверку endPrice здесь

        }

        if (searchRequest.getManufacturer() != null) {
            for (String manufacture : searchRequest.getManufacturer()) {
                //добавьте проверку всех фирм производителей здесь
            }
        }

        //проверка наименования товара
        if (searchRequest.getProductName() != null) {
            allureAssertThat("Product title on results page should be : " + searchRequest.getProductName(),
                    yandexResultPage.getTitleOfProduct(), Matchers.equalToIgnoringCase(searchRequest.getProductName()),
                    false);
        }

        makeScreenshot();


    }

    /**
     * Открывает категорию из главного списка
     * @param depName назавание категории
     */
    @Step("I open main department with name \"{depName}\" ")
    public void openMainDepartment(String depName) {

        YandexMarketAbstractPage yandexMarketPage = YandexMarketPageFactory.getPage();
        yandexMarketPage.openNavPanel();
        yandexMarketPage.openMainDepartment(depName);
        makeScreenshot();

    }


    /**
     * Открывает под-категорию
     * @param depName название под-категории
     */
    @Step("I open sub-department with name \"{depName}\" ")
    public void openSubDepartment(String depName) {

        YandexMarketPageFactory.getPage().openSubDepartment(depName);
        makeScreenshot();
    }
}
