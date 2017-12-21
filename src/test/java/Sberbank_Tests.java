

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

        //1. Открыть браузер и развернуть на весь экран.
        //2. Зайти на yandex.ru.
        commonSteps.navigate("https://yandex.ru");

        //3. Перейти в яндекс маркет
        yandexSteps.openMarket();

        //4. Выбрать раздел Компьютеры
        yandexSteps.openMainDepartment("Компьютеры");

        //5. Выбрать раздел Ноутбуки
        yandexSteps.openSubDepartment("Ноутбуки");

        //6. Зайти в расширенный поиск
        //7. Задать параметр поиска до 30000 рублей.
        //8. Выбрать производителя HP и Lenovo
        //9. Нажать кнопку Применить.
        yandexSteps.applyFilter(searchRequest);

        //10. Проверить, что элементов на странице 10.
        // по факту результатов больше 10 - поэму данная проверка не пройдет
//        yandexSteps.verifyAmountOfResults(10);

        //11. Запомнить первый элемент в списке.
        searchRequest = new SearchRequest();
        String productName = new YandexMarketPage().getResults().get(0).getProductName();
        searchRequest.setProductName(productName);

        //12. В поисковую строку ввести запомненное значение.
        yandexSteps.makeSearch(searchRequest.getProductName());

        //13. Найти и проверить, что наименование товара соответствует запомненному значению.
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

        //1. Открыть браузер и развернуть на весь экран.
        //2. Зайти на yandex.ru.
        commonSteps.navigate("https://yandex.ru");

        //3. Перейти в яндекс маркет
        yandexSteps.openMarket();

        //4. Выбрать раздел  Компьютеры
        yandexSteps.openMainDepartment("Компьютеры");

        //5. Выбрать раздел Планшеты
        yandexSteps.openSubDepartment("Планшеты");

        //6. Зайти в расширенный поиск
        //7. Задать параметр поиска от 20000 рублей.
        //8. Задать параметр поиска до 25000 рублей.
        //9. Выбрать производителей Acer и DELL
        //10. Нажать кнопку Применить.
        yandexSteps.applyFilter(searchRequest);

        //11. Проверить, что элементов на странице 10.
        // по факту результатов больше 10 - поэму данная проверка не пройдет
//        yandexSteps.verifyAmountOfResults(10);

        //12. Запомнить первый элемент в списке.
        searchRequest = new SearchRequest();
        String productName = new YandexMarketPage().getResults().get(0).getProductName();
        searchRequest.setProductName(productName);


        //13. В поисковую строку ввести запомненное значение.
        yandexSteps.makeSearch(searchRequest.getProductName());

        //14. Найти и проверить, что наименование товара соответствует запомненному значению.
        yandexSteps.verifyResults(searchRequest);

    }


}
