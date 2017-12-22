package com.PageObjects;

import com.ProductItem;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import java.util.ArrayList;
import java.util.List;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

/**
 * Одна из версий страницы яндекс маркета
 */
public class YandexMarketPage extends YandexMarketAbstractPage {

    private static final String HEADER_MAIN = ".header2__main";
    private static final String ALL_DEPARTMENTS_BTN = ".n-topmenu-new-vertical-wrapper .n-topmenu-new-vertical__left button";
    private static final String DEPARTMENTS_PANEL = ".n-navigation-vertical.i-bem.n-navigation-vertical_js_inited";
    private static final String MAIN_DEPARTMENTS_LIST = ".n-navigation-vertical span[class='link__title']";
    private static final String SUB_DEPARTMENTS_LIST =
            ".n-navigation-vertical-category.active .link.n-navigation-vertical-menu__item.i-bem.b-zone.b-spy-events";
    private static final String PRODUCT_ITEMS = ".n-snippet-card2";
    private static final String PRODUCT_ITEM_TITLE = ".n-snippet-card2__title";


    public YandexMarketPage() {

        $(HEADER_MAIN).shouldBe(Condition.visible);
    }


    public void openSubDepartment(String subDepartmentName) {

        for (SelenideElement departmentElement : $$(SUB_DEPARTMENTS_LIST)) {
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
                $(SUB_DEPARTMENTS_LIST).shouldBe(Condition.visible);
                return;
            }
        }

        throw new RuntimeException("Can't find item with name " + departmentName);


    }


    public void openNavPanel() {

        $(ALL_DEPARTMENTS_BTN).click();
        $(DEPARTMENTS_PANEL).should(Condition.appear);

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
