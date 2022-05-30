package ru.AndreyMarfin.pages;

import io.qameta.allure.Step;
import org.hamcrest.core.IsEqual;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class CheckoutStepTwoPage extends BaseAuthorizedPage{

    @FindBy(id = "cancel")
    private WebElement cancelButton;

    @FindBy(id = "finish")
    private WebElement finishButton;

    @FindBy(css = "#item_4_title_link")
    private WebElement backpackPic;

    @FindBy(css = ".error-message-container.error")
    private WebElement errorMessage;

    public CheckoutStepTwoPage(WebDriver driver) {
        super(driver);
    }

    @Step("Checking URL")
    public CheckoutStepTwoPage checkCheckOutStepTwoRageURL(){
        assertThat(driver.getCurrentUrl(), equalTo("https://www.saucedemo.com/checkout-step-two.html"));
        return this;
    }

    @Step("Checking backpack on order")
    public CheckoutStepTwoPage checkBackpackOnOrder(){
        assertThat(backpackPic.getAccessibleName(), equalTo("Sauce Labs Backpack"));
        return this;
    }

    @Step("Checking error message")
    public CheckoutStepTwoPage checkErrorMessage(){
        assertThat(errorMessage.getText(), IsEqual.equalTo("Error: Last Name is required"));
        return this;
    }

    @Step("Click finish button")
    public CheckoutCompletePage clickFinishButton(){
        finishButton.click();
        return new CheckoutCompletePage(driver);
    }

    @Step("Click cancel button")
    public CheckoutStepOnePage clickCancelButton(){
        cancelButton.click();
        return new CheckoutStepOnePage(driver);
    }
}
