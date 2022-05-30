package ru.AndreyMarfin.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class LoginPage extends BasePage{

    @FindBy(id = "user-name")
    protected static WebElement loginInput;

    @FindBy(name = "password")
    protected static WebElement passwordInput;

    @FindBy(name = "login-button")
    private WebElement loginButton;

    public LoginPage(WebDriver driver){

        super(driver);
    }

    @Step("Enter login {loginName}")
    public LoginPage enterLogin(String loginName){
        loginInput.click();
        loginInput.sendKeys(loginName);
        return this;
    }

    @Step("Enter password {password}")
    public LoginPage enterPassword(String password){
        passwordInput.click();
        passwordInput.sendKeys(password);
        return this;
    }

    @Step("Click on the login button")
    public InventoryPage clickLoginButton(){
        loginButton.click();
        return new InventoryPage(driver);
    }

    @Step("Checking URL")
    public LoginPage checkLoginPageURL(){
        assertThat(driver.getCurrentUrl(), equalTo("https://www.saucedemo.com/"));
        return this;
    }
}
