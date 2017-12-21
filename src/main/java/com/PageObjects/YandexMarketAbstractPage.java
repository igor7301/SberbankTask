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
 * Created by Igor on 12/21/2017.
 */
public abstract class YandexMarketAbstractPage {

    public abstract void openSubDepartment(String subDepartmentName);

    public abstract void openMainDepartment(String departmentName);

    public abstract void openNavPanel();

    public abstract List<ProductItem> getResults();
}
