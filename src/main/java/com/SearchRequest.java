package com;

import java.math.BigDecimal;
import java.util.List;

/**
 * Класс для хранения параметров поиска для яндекс фильтра
 */
public class SearchRequest {

    //Название продукта
    private String productName;

    //Начальная цена
    private BigDecimal startPrice;

    //Конечная цена
    private BigDecimal endPrice;

    //Фирмы прозводители
    private List<String> manufacturer;

    public void setStartPrice(BigDecimal startPrice) {
        this.startPrice = startPrice;
    }

    public void setEndPrice(BigDecimal endPrice) {
        this.endPrice = endPrice;
    }

    public void setManufacturer(List<String> manufacturer) {
        this.manufacturer = manufacturer;
    }

    public BigDecimal getStartPrice() {
        return startPrice;
    }

    public BigDecimal getEndPrice() {
        return endPrice;
    }

    public List<String> getManufacturer() {
        return manufacturer;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }
}
