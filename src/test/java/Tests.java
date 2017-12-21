import com.Departments;
import com.PageObjects.YandexMarketPage;
import com.ProductItem;
import com.SearchRequest;
import com.Steps.CommonSteps;
import com.Steps.YandexSteps;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.Arrays;

public class Tests extends AbstractTest {


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
    public void test_1() {


        SearchRequest searchRequest = new SearchRequest();
        searchRequest.setEndPrice(BigDecimal.valueOf(30000));
        searchRequest.setManufacturer(Arrays.asList("Lenovo", "HP"));

        commonSteps.navigate("https://yandex.ru");
        yandexSteps.openMarket();
       // yandexSteps.openDepartment(Departments.NOTEBOOKS);
        yandexSteps.openMainDepartment("Компьютеры");
        yandexSteps.openSubDepartment("Ноутбуки");
       // yandexSteps.chooseExpandSearch();
        yandexSteps.applyFilter(searchRequest);
       // yandexSteps.verifyAmountOfResults(48);

        searchRequest = new SearchRequest();
        String productName = new YandexMarketPage().getResults().get(0).getProductName();
        searchRequest.setProductName(productName);

        yandexSteps.makeSearch(searchRequest.getProductName());
        yandexSteps.verifyResults(searchRequest);


//        ProductItem expectedItem = new ProductItem();
//        expectedItem.setProductName(productName);
//        yandexSteps.verifyProductItem(1, expectedItem);




    }

}
