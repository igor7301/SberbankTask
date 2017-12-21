

import com.PageObjects.YandexMarketPage;
import com.SearchRequest;
import com.Steps.CommonSteps;
import com.Steps.YandexSteps;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.Arrays;

public class Sberbank_Tests extends Abstract {


    private YandexSteps yandexSteps = new YandexSteps();
    private CommonSteps commonSteps = new CommonSteps();

    @Before
    public void beforeTest() {
       super.setup();
    }

    @After
    public  void  afterTest() {
        super.tearDown();
    }

    @Test
    @DisplayName("Yandex market test 1")
    @Story("Yandex market")
    @Feature("Yandex")
    public void test_1() {

        SearchRequest searchRequest = new SearchRequest();
        searchRequest.setEndPrice(BigDecimal.valueOf(30000));
        searchRequest.setManufacturer(Arrays.asList("Lenovo", "HP"));

        commonSteps.navigate("https://yandex.ru");
        yandexSteps.openMarket();
        yandexSteps.openMainDepartment("Компьютеры");
        yandexSteps.openSubDepartment("Ноутбуки");
        yandexSteps.applyFilter(searchRequest);
//        yandexSteps.verifyAmountOfResults(48);

        searchRequest = new SearchRequest();
        String productName = new YandexMarketPage().getResults().get(0).getProductName();
        searchRequest.setProductName(productName);

        yandexSteps.makeSearch(searchRequest.getProductName());
        yandexSteps.verifyResults(searchRequest);

    }

    @Test
    @DisplayName("Yandex market test 2")
    @Story("Yandex market")
    @Feature("Yandex")
    public void test_2() {

        SearchRequest searchRequest = new SearchRequest();
        searchRequest.setStartPrice(BigDecimal.valueOf(20000));
        searchRequest.setEndPrice(BigDecimal.valueOf(25000));
        searchRequest.setManufacturer(Arrays.asList("Acer", "Dell"));

        commonSteps.navigate("https://yandex.ru");
        yandexSteps.openMarket();
        yandexSteps.openMainDepartment("Компьютеры");
        yandexSteps.openSubDepartment("Планшеты");
        yandexSteps.applyFilter(searchRequest);
//        yandexSteps.verifyAmountOfResults(48);

        searchRequest = new SearchRequest();
        String productName = new YandexMarketPage().getResults().get(0).getProductName();
        searchRequest.setProductName(productName);

        yandexSteps.makeSearch(searchRequest.getProductName());
        yandexSteps.verifyResults(searchRequest);

    }


}
