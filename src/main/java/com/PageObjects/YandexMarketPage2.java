package com.PageObjects;

import com.ProductItem;
import com.Utils.Constants;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import java.util.ArrayList;
import java.util.List;

import static com.Utils.Constants.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

/**
 * Created by Igor on 12/21/2017.
 */
public class YandexMarketPage2 extends   YandexMarketAbstractPage{


    private static final String HEADER_MAIN = ".header2__main";
    private static final String DEPARTMENTS_PANEL = ".n-navigation-vertical.i-bem.n-navigation-vertical_js_inited";
    private static final String MAIN_DEPARTMENTS_LIST = ".topmenu__list .topmenu__item.i-bem.topmenu__item_js_inited";
    private static final String SUB_DEPARTMENTS_LIST =".topmenu__subwrap .topmenu__sublist";
    private static final String PRODUCT_ITEMS = ".n-snippet-card2";
    private static final String PRODUCT_ITEM_TITLE = ".n-snippet-card2__title";



    public YandexMarketPage2() {

        $(HEADER_MAIN).shouldBe(Condition.visible);
    }



    public void openSubDepartment(String subDepartmentName) {

        for (SelenideElement departmentElement : $$(".link.topmenu__subitem")) {
            if (departmentElement.getText().equalsIgnoreCase(subDepartmentName)) {
                departmentElement.click();
                return;
            }
        }
        throw new RuntimeException("Can't find item with name " + subDepartmentName);
    }

    public void openMainDepartment(String departmentName) {


        ElementsCollection collection = $$(MAIN_DEPARTMENTS_LIST);
        for (SelenideElement departmentElement : collection) {

            if (departmentElement.getText().equalsIgnoreCase(departmentName)) {

                departmentElement.hover();
                Selenide.sleep(TIMEOUT_IN_MILLISECONDS_1000);
                departmentElement.$(SUB_DEPARTMENTS_LIST).shouldBe(Condition.visible);
                return;
            }
        }

        throw new RuntimeException("Can't find item with name " + departmentName);

    }


    public void openNavPanel() {

    }


    public List<ProductItem> getResults() {

        List<ProductItem> productItems = new ArrayList<>();
        for (SelenideElement productItemElement : $$(PRODUCT_ITEMS)) {

            ProductItem productItem1 = new ProductItem();
            productItem1.setProductName(productItemElement.$(PRODUCT_ITEM_TITLE).getText());
            productItems.add(productItem1);
        }
        return productItems;

    }

}
