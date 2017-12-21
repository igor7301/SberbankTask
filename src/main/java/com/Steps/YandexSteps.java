package com.Steps;

import com.Departments;
import com.PageObjects.*;
import com.ProductItem;
import com.SearchRequest;
import io.qameta.allure.Step;
import org.hamcrest.Matchers;

import java.util.List;

import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static org.hamcrest.MatcherAssert.assertThat;


public class YandexSteps {


    @Step("I open yandex market")
    public void openMarket() {
        new YandexHomePage().openMarket();
    }



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


    }

    @Step("I verify amount of product items on page ...")
    public void verifyAmountOfResults(int resultsNumber) {

        YandexMarketPage yandexMarketPage = new YandexMarketPage();
        yandexMarketPage.getResults();
        assertThat("Amount of product items should be : \"" + resultsNumber + "\"",
                yandexMarketPage.getResults().size(), Matchers.is(resultsNumber));

    }

    public List<ProductItem> getResults() {

        return new YandexMarketPage().getResults();
    }

    public void verifyProductItem(int productNumber, ProductItem expectedItem) {

        throw new RuntimeException("Implement me!");
    }

    public void makeSearch(String searchText) {
        new YandexHeader().makeSearch(searchText);
    }

    public void verifyResults(SearchRequest searchRequest) {

        YandexResultPage yandexResultPage = new YandexResultPage();

        if (searchRequest.getStartPrice() != null) {
            //make checks here
        }

        if (searchRequest.getEndPrice() != null) {
            //make checks here

        }

        if (searchRequest.getManufacturer() != null) {
            for (String manufacture : searchRequest.getManufacturer()) {
                //make checks here
            }
        }

        if (searchRequest.getProductName() != null) {
            assertThat("Product title on results page should be : " + searchRequest.getProductName(),
                    yandexResultPage.getTitleOfProduct(), Matchers.equalToIgnoringCase(searchRequest.getProductName()));
        }


    }

    @Step("I open main department with name \"{depName}\" ")
    public void openMainDepartment(String depName) {

        YandexMarketAbstractPage yandexMarketPage = YandexMarketPageFactory.getPage();
        yandexMarketPage.openNavPanel();
        yandexMarketPage.openMainDepartment(depName);

    }

    @Step("I open sub-department with name \"{depName}\" ")
    public void openSubDepartment(String depName) {

        YandexMarketPageFactory.getPage().openSubDepartment(depName);
    }
}
