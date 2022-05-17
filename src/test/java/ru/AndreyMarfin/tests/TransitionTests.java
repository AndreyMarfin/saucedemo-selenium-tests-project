package ru.AndreyMarfin.tests;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.hamcrest.core.IsNot.not;

public class TransitionTests {
    static WebDriver driver;
    @BeforeAll
    static void beforeAll() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        options.addArguments("--disable-popup-blocking");
        driver = new ChromeDriver(options);
        driver.get("https://www.saucedemo.com/");
    }


    @Test
    void authorisationPositiveTest() {
        driver.findElement(By.id("user-name")).click();
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.name("password")).click();
        driver.findElement(By.name("password")).sendKeys("secret_sauce");
        driver.findElement(By.name("login-button")).click();
        assertThat(driver.getCurrentUrl(), equalTo("https://www.saucedemo.com/inventory.html"));
        assertThat(driver.findElements(By.cssSelector("#shopping_cart_container")).size(), not(equalTo("0")));
    }

    @Test
    void happyPathTest() {
        driver.findElement(By.id("user-name")).click();
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.name("password")).click();
        driver.findElement(By.name("password")).sendKeys("secret_sauce");
        driver.findElement(By.name("login-button")).click();
        assertThat(driver.getCurrentUrl(), equalTo("https://www.saucedemo.com/inventory.html"));
        assertThat(driver.findElements(By.cssSelector("#item_4_img_link")).size(), not(equalTo("0")));

        driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();
        driver.findElement(By.id("shopping_cart_container")).click();
        assertThat(driver.getCurrentUrl(), equalTo("https://www.saucedemo.com/cart.html"));
        assertThat(driver.findElement(By.cssSelector("#item_4_title_link")).getAccessibleName(), equalTo("Sauce Labs Backpack"));

        driver.findElement(By.id("checkout")).click();
        assertThat(driver.getCurrentUrl(), equalTo("https://www.saucedemo.com/checkout-step-one.html"));

        driver.findElement(By.id("first-name")).sendKeys("Mark");
        driver.findElement(By.id("last-name")).sendKeys("Polo");
        driver.findElement(By.id("postal-code")).sendKeys("000000");
        driver.findElement(By.id("continue")).click();
        assertThat(driver.getCurrentUrl(), equalTo("https://www.saucedemo.com/checkout-step-two.html"));
        assertThat(driver.findElement(By.cssSelector("#item_4_title_link")).getAccessibleName(), equalTo("Sauce Labs Backpack"));

        driver.findElement(By.id("finish")).click();
        assertThat(driver.getCurrentUrl(), equalTo("https://www.saucedemo.com/checkout-complete.html"));
        assertThat(driver.findElements(By.cssSelector("#back-to-products")).size(), not(equalTo("0")));
        assertThat(driver.findElement(By.className("complete-header")).getAccessibleName(), equalTo("THANK YOU FOR YOUR ORDER"));

    }


    @AfterEach
    void tearDown() {
        driver.findElement(By.id("react-burger-menu-btn")).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));
        driver.findElement(By.id("logout_sidebar_link")).click();
    }

    @AfterAll
    static void afterAll() {
        driver.quit();
    }

}