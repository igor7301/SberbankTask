package com.Utils;

import com.codeborne.selenide.Selenide;
import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class Utils {

    @Attachment("Screenshot")
    public static byte[] makeScreenshot() {

        return ((TakesScreenshot) getWebDriver()).getScreenshotAs(OutputType.BYTES);

    }

    @Attachment("Screenshot")
    public static byte[] makeScreenshotFullPage() {


        BufferedImage image = new AShot().shootingStrategy(ShootingStrategies
                .viewportPasting(100))
                .takeScreenshot(getWebDriver()).getImage();

        scrollToTop();

        return convertToByte(image);


    }

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


    public static synchronized void scrollToTop() {

        try {
            Selenide.executeJavaScript("document.body.scrollTop = 0");
            Selenide.executeJavaScript("document.documentElement.scrollTop = 0");
        }
        catch (Exception e) {
        }
        catch (Error e) {
        }

    }
}
