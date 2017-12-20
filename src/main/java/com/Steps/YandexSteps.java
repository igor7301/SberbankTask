package com.Steps;

import com.Departments;
import com.PageObjects.YandexFilter;
import com.PageObjects.YandexHomePage;
import com.PageObjects.YandexMarketPage;
import com.PageObjects.YandexResultPage;
import com.ProductItem;
import com.SearchRequest;
import io.qameta.allure.Step;
import org.hamcrest.Matchers;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;


public class YandexSteps {


    @Step("I open yandex market")
    public void openMarket() {

        new YandexHomePage().openMarket();
    }

    @Step("I open \"{department}\" department form main navigation panel")
    public void openDepartment(Departments department) {

        YandexMarketPage yandexMarketPage = new YandexMarketPage();

        switch (department) {
            case NOTEBOOKS:
                yandexMarketPage.openNotebooks();
                break;


        }

    }

    @Step("I make search")
    public void makeSearch(SearchRequest searchRequest) {

        YandexFilter yandexFilter = new YandexFilter();
        if (searchRequest.getStartPrice() != null) {
           yandexFilter.setStartPrice();
        }

        if (searchRequest.getEndPrice() != null) {
            yandexFilter.setEndPrice();

        }

        if (searchRequest.getManufacturer().size() > 0) {
            for (String manufacture : searchRequest.getManufacturer()) {

                yandexFilter.setManufacture(manufacture);
            }
        }


    }

    public void verifyAmountOfResults(int resultsNumber) {

        YandexResultPage yandexResultPage =  new YandexResultPage();

        yandexResultPage.getResults();

        assertThat("", yandexResultPage.getResults(), Matchers.is(resultsNumber));

    }

    public List<ProductItem> getResults() {

        YandexResultPage yandexResultPage =  new YandexResultPage();

        return yandexResultPage.getResults();
    }

    public void verifyProductItem(int productNumber, ProductItem expectedItem) {

    }
}
