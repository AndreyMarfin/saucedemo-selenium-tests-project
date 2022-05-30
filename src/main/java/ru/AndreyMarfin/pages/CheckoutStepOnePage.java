package ru.AndreyMarfin.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.hamcrest.core.IsNot.not;
import static ru.AndreyMarfin.pages.InventoryPage.cartButton;

public class CheckoutStepOnePage extends BaseAuthorizedPage{

    @FindBy(id = "cancel")
    private WebElement cancelButton;

    @FindBy(id = "continue")
    private WebElement continueButton;

    @FindBy(id = "first-name")
    private WebElement firstnameInput;

    @FindBy(id = "last-name")
    private WebElement lastnameInput;

    @FindBy(id = "postal-code")
    private WebElement postalCodeInput;

    @FindBy(className = "header_secondary_container")
    private WebElement headerTitle;

    @FindBy(css = ".app_logo")
    private WebElement logoPic;

    @FindBy(className = "footer_copy")
    private WebElement footerText;

    @FindBy(className = "footer_robot")
    private WebElement footerRobot;


    public CheckoutStepOnePage(WebDriver driver) {
        super(driver);
    }

    @Step("Checking URL")
    public CheckoutStepOnePage checkCheckoutStepOnePageURL(){
        assertThat(driver.getCurrentUrl(), equalTo("https://www.saucedemo.com/checkout-step-one.html"));
        return this;
    }

    @Step("Checking header title")
    public CheckoutStepOnePage checkHeaderTitle(){
        assertThat(headerTitle.getText(), equalTo("CHECKOUT: YOUR INFORMATION"));
        return this;
    }

    @Step("Checking Firstname placeholder")
    public CheckoutStepOnePage checkFirstnameTitle(){
        assertThat(firstnameInput.getAccessibleName(), equalTo("First Name"));
        return this;
    }

    @Step("Checking Lastname placeholder")
    public CheckoutStepOnePage checkLastnameTitle(){
        assertThat(lastnameInput.getAccessibleName(), equalTo("Last Name"));
        return this;
    }

    @Step("Checking Zip/Postal placeholder")
    public CheckoutStepOnePage checkPostalCodeTitle(){
        assertThat(postalCodeInput.getAccessibleName(), equalTo("Zip/Postal Code"));
        return this;
    }

    @Step("Checking cancel button")
    public CheckoutStepOnePage checkCancelButton(){
        String id = cancelButton.getAttribute("id");
        assertThat(existElementById(id) , equalTo(true));
        return this;
    }

    @Step("Checking continue button")
    public CheckoutStepOnePage checkContinueButton(){
        String id = continueButton.getAttribute("id");
        assertThat(existElementById(id) , equalTo(true));
        return this;
    }

    @Step("Checking cart button")
    public CheckoutStepOnePage checkCartButton(){
        String id = cartButton.getAttribute("id");
        assertThat(existElementById(id) , equalTo(true));
        return this;
    }

    @Step("Checking logo")
    public CheckoutStepOnePage checkLogo(){
        assertThat(logout.getSize(), not(equalTo("0")));
        return this;
    }

    @Step("Checking footer text")
    public CheckoutStepOnePage checkFooterText(){
        assertThat(footerText.getText(), equalTo("© 2022 Sauce Labs. All Rights Reserved. Terms of Service | Privacy Policy"));
        return this;
    }

    @Step("Checking robot pic")
    public CheckoutStepOnePage checkFooterRobot(){
        assertThat(footerRobot.getSize(), not(equalTo("0")));
        return this;
    }

    @Step("Enter firstname {firstname}")
    public CheckoutStepOnePage enterFirstname(String firstname){
        firstnameInput.click();
        firstnameInput.sendKeys(firstname);
        return this;
    }

    @Step("Enter lastname {lastname}")
    public CheckoutStepOnePage enterLastname(String lastname){
        lastnameInput.click();
        lastnameInput.sendKeys(lastname);
        return this;
    }

    @Step("Enter zip/postal code {postalCode}")
    public CheckoutStepOnePage enterPostalCode(String postalCode){
        postalCodeInput.click();
        postalCodeInput.sendKeys(postalCode);
        return this;
    }

    @Step("Click cancel button")
    public CartPage clickCancelButton(){
        cancelButton.click();
        return new CartPage(driver);
    }

    @Step("Click continue button")
    public CheckoutStepTwoPage clickContinueButton(){
        continueButton.click();
        return new CheckoutStepTwoPage(driver);
    }
}
