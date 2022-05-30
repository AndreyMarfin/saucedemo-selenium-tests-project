package ru.AndreyMarfin.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.logging.LogType;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public abstract class BaseTest {
    private static final String PATH_TO_PROPERTIES = "src/test/resources/application.properties";
    static Properties properties = new Properties();
    public static WebDriver driver;
    static String homepage;
    static String username;
    static String password;
    static String firstname;
    static String lastname;
    static String postalcode;
    static String wrongLogin;
    static String lockedUsername;
    static String performanceGlitchUser;
    static String problemUser;
    static String errorTextWrongUser;
    static String errorTextLockedUser;
    static String productList;


    @BeforeAll
    static void beforeAllTests() throws IOException {


        properties.load(new FileInputStream(PATH_TO_PROPERTIES));
        username = properties.getProperty("standard.username");
        password = properties.getProperty("password");
        homepage = properties.getProperty("homepage");
        firstname = properties.getProperty("firstname");
        lastname = properties.getProperty("lastname");
        postalcode = properties.getProperty("postalcode");
        wrongLogin = properties.getProperty("wrongLogin");
        lockedUsername = properties.getProperty("locked.username");
        problemUser = properties.getProperty("problem.user");
        performanceGlitchUser = properties.getProperty("performance.glitch.user");
        errorTextWrongUser = properties.getProperty("error.text.wrong.login");
        errorTextLockedUser = properties.getProperty("error.text.locked.user");

        driver = WebDriverManager.chromedriver().create();

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        options.addArguments("--disable-popup-blocking");

        driver = new ChromeDriver(options);
        driver.get(homepage);
    }

    @AfterEach
    void afterEach() {
        driver.manage()
                .logs()
                .get(LogType.BROWSER)
                .getAll()
                .forEach(System.out::println);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @AfterAll
    static void afterAllTests() {
        if (driver != null){
            driver.quit();
        }
    }
}
