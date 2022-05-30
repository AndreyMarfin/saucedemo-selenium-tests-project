package ru.AndreyMarfin.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

public class CartPage extends BaseAuthorizedPage{

    @FindBy(id = "checkout")
    private WebElement buttonCheckout;

    @FindBy(id = "remove-sauce-labs-backpack")
    private WebElement buttonRemoveBackpack;

    @FindBy(id = "remove-sauce-labs-bike-light")
    private WebElement buttonRemoveBikeLight;

    @FindBy(id = "remove-sauce-labs-bolt-t-shirt")
    private WebElement buttonRemoveBoltTShirt;

    @FindBy(id = "remove-sauce-labs-fleece-jacket")
    private WebElement buttonRemoveFleeceJacket;

    @FindBy(id = "remove-sauce-labs-onesie")
    private WebElement buttonRemoveOnesie;

    @FindBy(id = "remove-test.allthethings()-t-shirt-(red)")
    private WebElement buttonRemoveRedTShirt;

    @FindBy(id = "continue-shopping")
    private WebElement buttonContinueShopping;

    @FindBy(css = "#item_4_title_link")
    private WebElement backPackOnTheCart;

    @FindBy(css = "#item_0_title_link")
    private WebElement bikeLightOnTheCart;

    @FindBy(css = "#item_1_title_link")
    private WebElement boltTShirtOnTheCart;

    @FindBy(css = "#item_5_title_link")
    WebElement fleeceJacketOnTheCart;

    @FindBy(css = "#item_2_title_link")
    WebElement onesieOnTheCart;

    @FindBy(css = "#item_3_title_link")
    WebElement redTShirtOnTheCart;

    @FindBy(css = ".removed_cart_item")
    WebElement emptyCart;

    public CartPage(WebDriver driver) {
        super(driver);
    }

    @Step("Checking URL")
    public CartPage checkCartPageURL(){
        assertThat(driver.getCurrentUrl(), equalTo("https://www.saucedemo.com/cart.html"));
        return this;
    }

    @Step("Checking backpack on the cart")
    public CartPage checkBackpackOnTheCart(){
        assertThat(backPackOnTheCart.getAccessibleName(), equalTo("Sauce Labs Backpack"));
        return this;
    }

    @Step("Checking bike light on the cart")
    public CartPage checkBikeLightOnTheCart(){
        assertThat(bikeLightOnTheCart.getAccessibleName(), equalTo("Sauce Labs Bike Light"));
        return this;
    }

    @Step("Checking bolt t-shirt on the cart")
    public CartPage checkBoltTShirtOnTheCart(){
        assertThat(boltTShirtOnTheCart.getAccessibleName(), equalTo("Sauce Labs Bolt T-Shirt"));
        return this;
    }

    @Step("Checking fleece jacket on the cart")
    public CartPage checkFleeceJacketOnTheCart(){
        assertThat(fleeceJacketOnTheCart.getAccessibleName(), equalTo("Sauce Labs Fleece Jacket"));
        return this;
    }

    @Step("Checking onesie on the cart")
    public CartPage checkOnesieOnTheCart(){
        assertThat(onesieOnTheCart.getAccessibleName(), equalTo("Sauce Labs Onesie"));
        return this;
    }

    @Step("Checking red t-shirt on the cart")
    public CartPage checkRedTShirtOnTheCart(){
        assertThat(redTShirtOnTheCart.getAccessibleName(), equalTo("Test.allTheThings() T-Shirt (Red)"));
        return this;
    }

    @Step("Click remove backpack button")
    public CartPage clickRemoveBackpackButton(){
        buttonRemoveBackpack.click();
        return this;
    }

    @Step("Click remove bike light button")
    public CartPage clickRemoveBikeLightButton(){
        buttonRemoveBikeLight.click();
        return this;
    }

    @Step("Click remove bolt T-Shirt button")
    public CartPage clickRemoveBoltTShirtButton(){
        buttonRemoveBoltTShirt.click();
        return this;
    }

    @Step("Click remove fleece jacket button")
    public CartPage clickRemoveFleeceJacketButton(){
        buttonRemoveFleeceJacket.click();
        return this;
    }

    @Step("Click remove onesie button")
    public CartPage clickRemoveOnesieButton(){
        buttonRemoveOnesie.click();
        return this;
    }

    @Step("Click remove red T-Shirt button")
    public CartPage clickRemoveRedTShirtButton(){
        buttonRemoveRedTShirt.click();
        return this;
    }

    @Step("Click checkout button")
    public CheckoutStepOnePage clickCheckoutButton(){
        buttonCheckout.click();
        return new CheckoutStepOnePage(driver);
    }

    @Step("Click continue shopping button")
    public InventoryPage clickContinueShoppingButton(){
        buttonContinueShopping.click();
        return new InventoryPage(driver);
    }
}
