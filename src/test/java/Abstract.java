import com.Application.WebDriverFactory;
import com.codeborne.selenide.WebDriverRunner;
import org.junit.After;
import org.junit.Before;

import java.net.MalformedURLException;

import static com.codeborne.selenide.WebDriverRunner.closeWebDriver;

public class Abstract {


    @Before
    public void setup() {

        try {
            WebDriverRunner.setWebDriver(WebDriverFactory.getChromeDriver());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

    }

    @After
    public void tearDown() {

        closeWebDriver();

    }
}
