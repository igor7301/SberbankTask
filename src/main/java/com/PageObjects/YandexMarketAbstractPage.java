package com.PageObjects;

import com.ProductItem;

import java.util.List;

/**
 * Created by Igor on 12/21/2017.
 * Абстрактная страница яндекс маркета
 */
public abstract class YandexMarketAbstractPage {

    /**
     * Открывает под-категорию из списка
     * @param subDepartmentName имя под-категории
     */
    public abstract void openSubDepartment(String subDepartmentName);

    /**
     * Открывает категорию из списка
     * @param departmentName имя категории
     */
    public abstract void openMainDepartment(String departmentName);

    /**
     * Открывает список всех категорий
     * Доступно только для версии YandexMarketPage
     * Версия YandexMarketPage2 не требует открытия списка категорий, так как они уже открыты по умолчанию
     */
    public abstract void openNavPanel();

    /**
     * Возвращает список товаров на странице
     * @return список товаров
     */
    public abstract List<ProductItem> getResults();
}
