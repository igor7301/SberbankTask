import com.Application.WebDriverFactory;
import com.codeborne.selenide.WebDriverRunner;

import java.net.MalformedURLException;

import static com.Utils.Utils.makeScreenshot;
import static com.codeborne.selenide.WebDriverRunner.closeWebDriver;

/**
 * Абстрактный класс в котором инициализируется и закрывается вебрайвер
 */
public class Abstract {


    /**
     * Инициализируем вебрайвер
     */
    public void setup() {

        try {
            WebDriverRunner.setWebDriver(WebDriverFactory.getInstance());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

    }


    /**
     * Закрываем вебрайвер
     */
    public void tearDown() {

        makeScreenshot();
        closeWebDriver();

    }
}
