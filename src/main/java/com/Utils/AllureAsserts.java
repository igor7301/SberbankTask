package com.Utils;

import io.qameta.allure.Step;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hamcrest.Matcher;
import org.junit.Assert;

import static com.Utils.Utils.makeScreenshot;

/**
 * Класс обертка для assert
 */
public class AllureAsserts {

    private final static Logger LOGGER = LogManager.getLogger(AllureAsserts.class);


    /**
     * Метод проверяет заданные условия и представляет собой шаг для allure отчета
     * @param message для allure отчета
     * @param valueToBeChecked значение для проверки
     * @param condition условие проверки
     * @param makeScreenshot нужно ли делать скриншот или нет
     * @param <T>
     */
    @Step("{message}")
    public static <T> void allureAssertThat(String message, T valueToBeChecked, Matcher<? super T> condition, boolean makeScreenshot) {

        LOGGER.info(message);
        Assert.assertThat(message, valueToBeChecked, condition);
        if (makeScreenshot) {
            makeScreenshot();
        }

    }
}
