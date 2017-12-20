import com.Application.WebDriverFactory;
import com.codeborne.selenide.WebDriverRunner;

import java.net.MalformedURLException;

import static com.codeborne.selenide.WebDriverRunner.closeWebDriver;

public class AbstractTest {


    public void setup() {

        try {
            WebDriverRunner.setWebDriver(WebDriverFactory.getChromeDriver());
        } catch (MalformedURLException e) {

            e.printStackTrace();
        }

    }

    public void tearDown() {
        closeWebDriver();
    }
}
