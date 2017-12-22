import com.Application.WebDriverFactory;
import com.codeborne.selenide.WebDriverRunner;

import java.net.MalformedURLException;

import static com.Utils.Utils.makeScreenshot;
import static com.codeborne.selenide.WebDriverRunner.closeWebDriver;

public class Abstract {


    public void setup() {

        try {
            WebDriverRunner.setWebDriver(WebDriverFactory.getInstance());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

    }


    public void tearDown() {

        makeScreenshot();
        closeWebDriver();

    }
}
