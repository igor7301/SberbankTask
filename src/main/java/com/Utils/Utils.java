package com.Utils;

import com.codeborne.selenide.Selenide;
import io.qameta.allure.Attachment;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

import static com.Utils.Constants.TIMEOUT_IN_MILLISECONDS_100;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

/**
 * Вспомогательный класс
 */
public class Utils {

    private final static Logger LOGGER = LogManager.getLogger(Utils.class);

    /**
     * Делает скриншот видимой части страницы
     * @return скриншот видимой части страницы в виде byte[]
     */
    @Attachment("Screenshot")
    public static byte[] makeScreenshot() {
        return ((TakesScreenshot) getWebDriver()).getScreenshotAs(OutputType.BYTES);
    }

    /**
     * Делает скриншот всей страницы, постепенно проскроливая страницу вниз
     * При достижении конца страницы, скроллим страницу обратно в начало
     * @return скриншот всей страницы в виде byte[]
     */
    @Attachment("Screenshot")
    public static byte[] makeScreenshotFullPage() {

        BufferedImage image = new AShot().shootingStrategy(ShootingStrategies
                .viewportPasting(TIMEOUT_IN_MILLISECONDS_100))
                .takeScreenshot(getWebDriver()).getImage();

        scrollToTop();

        return convertToByte(image);

    }

    /**
     * Конвертирует BufferedImage в byte[]
     * @param image
     * @return byte[]
     */
    private static byte[] convertToByte(BufferedImage image) {

        try {

            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            byte[] imageInByte;

            ImageIO.write(image, "png", baos);
            baos.flush();
            imageInByte = baos.toByteArray();
            baos.close();
            return imageInByte;

        } catch (IOException e) {

            e.printStackTrace();
        }

        return null;
    }

    /**
     * Скроллим страницу наверх
     * В случае возникновения ошибки метод выводит stackTrace но не прерывает свою работу
     */
    public static void scrollToTop() {

        try {
            Selenide.executeJavaScript("document.body.scrollTop = 0");
            Selenide.executeJavaScript("document.documentElement.scrollTop = 0");
        } catch (Exception e) {
            LOGGER.warn("Can't scroll page to top");
            e.printStackTrace();
        } catch (Error e) {
            LOGGER.warn("Can't scroll page to top");
            e.printStackTrace();
        }

    }
}
