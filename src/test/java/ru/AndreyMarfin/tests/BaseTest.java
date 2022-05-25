package ru.AndreyMarfin.tests;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public abstract class BaseTest {
    static Properties properties = new Properties();
    static String homepage;
    static WebDriver driver;
    static String username;
    static String password;
    static String firstname;
    static String lastname;
    static String postalcode;

    @BeforeAll
    static void beforeAllTests() throws IOException {
        properties.load(new FileInputStream("src/test/resources/application.properties"));
        username = properties.getProperty("standard.username");
        password = properties.getProperty("password");
        homepage = properties.getProperty("homepage");
        firstname = properties.getProperty("firstname");
        lastname = properties.getProperty("lastname");
        postalcode = properties.getProperty("postalcode");

        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        options.addArguments("--disable-popup-blocking");
        driver = new ChromeDriver(options);
        driver.get(homepage);
    }

    @AfterAll
    static void afterAllTests() {
        if (driver != null){
            driver.quit();
        }
    }
}
