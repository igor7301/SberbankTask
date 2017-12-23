import com.Application.WebDriverFactory;
import com.codeborne.selenide.WebDriverRunner;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.awt.*;

import static com.Utils.Utils.makeScreenshot;
import static com.codeborne.selenide.WebDriverRunner.closeWebDriver;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

/**
 * Абстрактный класс в котором инициализируется и закрывается вебрайвер
 */
public class Abstract {

    private final static Logger LOGGER = LogManager.getLogger(Abstract.class);

    /**
     * Инициализируем вебрайвер
     */
    public void setup() {

        WebDriverRunner.setWebDriver(WebDriverFactory.getInstance());
        maximizeBrowser();

        //перемещаем курсор в левый верхний угол чтобы не машать выполнению тестов
        moveMousePointer(0,0);
    }


    /**
     * Закрываем вебрайвер
     */
    public void tearDown() {

        makeScreenshot();
        closeWebDriver();

    }


    /**
     * Максимизирует окно браузера и не прерывает работу в случае неудачи
     */
    private void maximizeBrowser() {

        try {
            getWebDriver().manage().window().maximize();
        }
        catch (Error e) {
            LOGGER.error("Can't maximize browser");
            e.printStackTrace();
        }
        catch (Exception e) {
            LOGGER.error("Can't maximize browser");
            e.printStackTrace();
        }
    }

    /**
     * Передвигает курсор мыши в точку с координатами  (x,y)
     *
     */
    private void moveMousePointer(int x, int y) {

        try {
            new Robot().mouseMove(x, y);
        }
        catch (AWTException e) {
            LOGGER.warn("Can't move mouse to top-left corner");
            e.printStackTrace();
        }
    }
}
