package ru.AndreyMarfin.utils;

import io.qameta.allure.Allure;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestWatcher;
import org.openqa.selenium.WebDriver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.time.Duration;
import java.util.Optional;

import static ru.AndreyMarfin.utils.ScreenshotMaker.makeScreenshotOnFailure;

public class ScreenshotWatcher5 implements TestWatcher {

    WebDriver driver;

    public ScreenshotWatcher5(WebDriver driver) {
        this.driver = driver;
    }

    @Override
    public void testAborted(ExtensionContext context, Throwable throwable) {
        // do something
    }

    @Override
    public void testDisabled(ExtensionContext context, Optional<String> optional) {
        // do something
    }

    @Override
    public void testFailed(ExtensionContext context, Throwable throwable) {
        try {
            Allure.addAttachment("Page screenshot", new FileInputStream(makeScreenshotOnFailure(driver)));
            driver.navigate().refresh();
            driver.navigate().to("https://www.saucedemo.com/");
            driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(5));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            driver.navigate().refresh();
        }
    }

    @Override
    public void testSuccessful(ExtensionContext extensionContext) {
        // do something
    }
}
