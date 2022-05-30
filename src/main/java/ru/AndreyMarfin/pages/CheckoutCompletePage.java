package ru.AndreyMarfin.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

public class CheckoutCompletePage extends BaseAuthorizedPage{

    @FindBy(id = "back-to-products")
    private WebElement backToProductButton;

    @FindBy(className = "complete-header")
    private WebElement completeMessage;

    public CheckoutCompletePage(WebDriver driver) {
        super(driver);
    }

    @Step("Checking URL")
    public CheckoutCompletePage checkCheckoutCompletePageURL(){
        assertThat(driver.getCurrentUrl(), equalTo("https://www.saucedemo.com/checkout-complete.html"));
        return this;
    }

    @Step("Checking complete message")
    public CheckoutCompletePage checkCompleteMessage(){
        assertThat(completeMessage.getAccessibleName(), equalTo("THANK YOU FOR YOUR ORDER"));
        return this;
    }

    @Step("Click back to product button")
    public InventoryPage clickBackToProductButton(){
        backToProductButton.click();
        return new InventoryPage(driver);
    }

}
