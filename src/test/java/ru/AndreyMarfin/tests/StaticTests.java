package ru.AndreyMarfin.tests;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.hamcrest.core.IsNot.not;

public class StaticTests {
    static WebDriver driver;
    @BeforeAll
    static void beforeAll() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        options.addArguments("--disable-popup-blocking");
        driver = new ChromeDriver(options);
        driver.get("https://www.saucedemo.com/");
        driver.findElement(By.id("user-name")).click();
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.name("password")).click();
        driver.findElement(By.name("password")).sendKeys("secret_sauce");
        driver.findElement(By.name("login-button")).click();
        driver.findElement(By.id("shopping_cart_container")).click();
        driver.findElement(By.id("checkout")).click();
        assertThat(driver.getCurrentUrl(), equalTo("https://www.saucedemo.com/checkout-step-one.html"));

    }

    @AfterAll
    static void afterAll() {
        driver.quit();
    }

    @Test
    void headersTest() {
        assertThat(driver.findElements(By.cssSelector("#shopping_cart_container")).size(), not(equalTo("0")));
        assertThat(driver.findElements(By.cssSelector(".app_logo")).size(), not(equalTo("0")));
        assertThat(driver.findElements(By.id("react-burger-menu-btn")).size(), not(equalTo("0")));
    }

    @Test
    void reactMenuTest() {
        driver.findElement(By.id("react-burger-menu-btn")).click();
        assertThat(driver.findElements(By.cssSelector("#inventory_sidebar_link")).size(), not(equalTo("0")));
        assertThat(driver.findElement(By.cssSelector("#inventory_sidebar_link")).getAccessibleName(), equalTo("ALL ITEMS"));
        assertThat(driver.findElements(By.cssSelector("#about_sidebar_link")).size(), not(equalTo("0")));
        assertThat(driver.findElement(By.cssSelector("#about_sidebar_link")).getAccessibleName(), equalTo("ABOUT"));
        assertThat(driver.findElements(By.cssSelector("#logout_sidebar_link")).size(), not(equalTo("0")));
        assertThat(driver.findElement(By.cssSelector("#logout_sidebar_link")).getAccessibleName(), equalTo("LOGOUT"));
        assertThat(driver.findElements(By.cssSelector("#reset_sidebar_link")).size(), not(equalTo("0")));
        assertThat(driver.findElement(By.cssSelector("#reset_sidebar_link")).getAccessibleName(), equalTo("RESET APP STATE"));
        driver.findElement(By.id("react-burger-cross-btn")).click();
    }

    @Test
    void centralFormTest() {
        assertThat(driver.findElement(By.className("header_secondary_container")).getText(), equalTo("CHECKOUT: YOUR INFORMATION"));
        assertThat(driver.findElement(By.id("first-name")).getAccessibleName(), equalTo("First Name"));
        assertThat(driver.findElement(By.id("last-name")).getAccessibleName(), equalTo("Last Name"));
        assertThat(driver.findElement(By.id("postal-code")).getAccessibleName(), equalTo("Zip/Postal Code"));
    }

    @Test
    void floorButtonTest() {
        assertThat(driver.findElements(By.id("cancel")).size(), not(equalTo("0")));
        assertThat(driver.findElement(By.id("cancel")).getAccessibleName(), equalTo("Go back CANCEL"));
        assertThat(driver.findElements(By.id("continue")).size(), not(equalTo("0")));
        assertThat(driver.findElement(By.id("continue")).getAccessibleName(), equalTo("Continue"));
    }

    @Test
    void footerTest() {
        assertThat(driver.findElement(By.className("footer_copy")).getText(), equalTo("© 2022 Sauce Labs. All Rights Reserved. Terms of Service | Privacy Policy"));
        assertThat(driver.findElements(By.className("footer_robot")).size(), not(equalTo("0")));
        assertThat(driver.findElement(By.partialLinkText("Twitter")).getAttribute("href"), equalTo("https://twitter.com/saucelabs"));
        assertThat(driver.findElement(By.partialLinkText("Facebook")).getAttribute("href"), equalTo("https://www.facebook.com/saucelabs"));
        assertThat(driver.findElement(By.partialLinkText("LinkedIn")).getAttribute("href"), equalTo("https://www.linkedin.com/company/sauce-labs/"));
        assertThat(driver.findElement(By.className("social_facebook")).getText(), equalTo("Facebook"));
        assertThat(driver.findElement(By.className("social_linkedin")).getText(), equalTo("LinkedIn"));
    }
}
