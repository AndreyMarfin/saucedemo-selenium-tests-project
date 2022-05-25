package ru.AndreyMarfin.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{

    @FindBy(id = "user-name")
    private WebElement loginInput;
    @FindBy(name = "password")
    private WebElement passwordInput;
    @FindBy(name = "login-button")
    private WebElement loginButton;

    public LoginPage(WebDriver driver){

        super(driver);
    }

    public LoginPage enterLogin(String loginName){
        loginInput.click();
        loginInput.sendKeys(loginName);
        return this;
    }

    public LoginPage enterPassword(String password){
        passwordInput.click();
        passwordInput.sendKeys(password);
        return this;
    }

    public InventoryPage clickLoginButton(){
        loginButton.click();
        return new InventoryPage(driver);
    }


}
