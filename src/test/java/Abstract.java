import com.Application.WebDriverFactory;
import com.codeborne.selenide.WebDriverRunner;

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
        WebDriverRunner.setWebDriver(WebDriverFactory.getInstance());
    }

    /**
     * Закрываем вебрайвер
     */
    public void tearDown() {

        makeScreenshot();
        closeWebDriver();

    }
}
