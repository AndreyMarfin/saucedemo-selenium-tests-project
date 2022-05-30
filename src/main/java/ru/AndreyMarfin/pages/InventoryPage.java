package ru.AndreyMarfin.pages;

import io.qameta.allure.Step;
import org.hamcrest.core.IsEqual;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.AndreyMarfin.elements.SortingDropDownValues;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.core.IsNot.not;

public class InventoryPage extends BaseAuthorizedPage {
    @FindBy(id = "add-to-cart-sauce-labs-backpack")
    private WebElement buttonAddBackpack;
    @FindBy(id = "add-to-cart-sauce-labs-bolt-t-shirt")
    private WebElement buttonAddBoltTShirt;
    @FindBy(id = "add-to-cart-sauce-labs-bike-light")
    private WebElement buttonAddBikeLight;
    @FindBy(id = "add-to-cart-sauce-labs-fleece-jacket")
    private WebElement buttonAddFleeceJacket;
    @FindBy(id = "add-to-cart-sauce-labs-onesie")
    private WebElement buttonAddOnesie;
    @FindBy(id = "add-to-cart-test.allthethings()-t-shirt-(red)")
    private WebElement buttonAddRedTShirt;
    @FindBy(id = "shopping_cart_container")
    static WebElement cartButton;
    @FindBy(css = ".shopping_cart_badge")
    WebElement cartBadge;
    @FindBy(css = "[data-test=product_sort_container]")
    WebElement sortingDropDown;
    @FindBy(css = "[data-test= 'error']")
    WebElement closeErrorMessage;
    @FindBy(css = "#item_4_img_link > img")
    WebElement backpackPic;
    @FindBy(css = "#item_0_img_link > img")
    WebElement bikeLightPic;
    @FindBy(css = "#item_1_img_link > img")
    WebElement boltTShirtPic;
    @FindBy(css = "#item_5_img_link > img")
    WebElement fleeceJacketPic;
    @FindBy(css = "#item_2_img_link > img")
    WebElement onesiePic;
    @FindBy(css = "#item_3_img_link > img")
    WebElement redTShirtPic;

    static String originalSrcBackpack = "https://www.saucedemo.com/static/media/sauce-backpack-1200x1500.34e7aa42.jpg";
    static String originalSrcBikeLight = "https://www.saucedemo.com/static/media/bike-light-1200x1500.a0c9caae.jpg";
    static String originalSrcBoltTShirt = "https://www.saucedemo.com/static/media/bolt-shirt-1200x1500.c0dae290.jpg";
    static String originalSrcFleeceJacket = "https://www.saucedemo.com/static/media/sauce-pullover-1200x1500.439fc934.jpg";
    static String originalSrcOnesie = "https://www.saucedemo.com/static/media/red-onesie-1200x1500.1b15e1fa.jpg";
    static String originalSrcRedTShirt = "https://www.saucedemo.com/static/media/red-tatt-1200x1500.e32b4ef9.jpg";
    String productListByName = ".inventory_item_name";
    String productListByPrice = ".inventory_item_price";

    public InventoryPage(WebDriver driver) {

        super(driver);
    }

    @Step("Checking URL")
    public InventoryPage checkInventoryPageURL() {
        assertThat(driver.getCurrentUrl(), equalTo("https://www.saucedemo.com/inventory.html"));
        return this;
    }

    @Step("Checking cart icon on the page")
    public InventoryPage checkCartOnThePage() {
        assertThat(cartButton.getSize(), not(IsEqual.equalTo("0")));
        return this;
    }

    @Step("Checking badge on cart icon")
    public InventoryPage checkCartBadgeOnThePage() {
        assertThat(cartBadge.getText(), equalTo("1"));
        return this;
    }

    @Step("Click on backpack add button")
    public InventoryPage clickButtonAddBackPack() {
        buttonAddBackpack.click();
        return this;
    }

    @Step("Click on bolt T-Shirt add button")
    public InventoryPage clickButtonAddBoltTShirt() {
        buttonAddBoltTShirt.click();
        return this;
    }

    @Step("Checking bolt t-shirt add button")
    public InventoryPage checkButtonAddBoltTShirt() {
        assertThat(buttonAddBoltTShirt.getText(), equalTo("Remote"));
        return this;
    }

    @Step("Click on bike light add button")
    public InventoryPage clickButtonAddBikeLight() {
        buttonAddBikeLight.click();
        return this;
    }

    @Step("Click on fleece jacket add button")
    public InventoryPage clickButtonAddFleeceJacket() {
        buttonAddFleeceJacket.click();
        return this;
    }

    @Step("Checking fleece jacket add button")
    public InventoryPage checkButtonAddFleeceJacket() {
        assertThat(buttonAddFleeceJacket.getText(), equalTo("Remote"));
        return this;
    }

    @Step("Click on onesie add button")
    public InventoryPage clickButtonAddOnesie() {
        buttonAddOnesie.click();
        return this;
    }

    @Step("Click on red T-Shirt add button")
    public InventoryPage clickButtonAddRedTShirt() {
        buttonAddRedTShirt.click();
        return this;
    }

    @Step("Checking red T-Shirt add button")
    public InventoryPage checkButtonAddRedTShirt() {
        assertThat(buttonAddRedTShirt.getText(), equalTo("Remote"));
        return this;
    }

    @Step("Click on cart icon")
    public CartPage clickCartButton() {
        cartButton.click();
        return new CartPage(driver);
    }

    public InventoryPage chooseSortingOption(SortingDropDownValues value) {
        sortingDropDown.click();
        driver.findElement(value.getElementlocator()).click();
        return this;
    }

    @Step("Checking error message")
    public InventoryPage checkErrorMessage(String error) {
        assertThat(closeErrorMessage.getText(), equalTo(error));
        return this;
    }

    @Step("Checking backpackPic")
    public InventoryPage checkBackpackPic() {
        assertThat(backpackPic.getAttribute("src"), equalTo(originalSrcBackpack));
        return this;
    }

    @Step("Checking bike light pic")
    public InventoryPage checkBikeLightPic() {
        assertThat(bikeLightPic.getAttribute("src"), equalTo(originalSrcBikeLight));
        return this;
    }

    @Step("Checking bolt t-shirt pic")
    public InventoryPage checkBoltTShirtPic() {
        assertThat(boltTShirtPic.getAttribute("src"), equalTo(originalSrcBoltTShirt));
        return this;
    }

    @Step("Checking fleece jacket pic")
    public InventoryPage checkFleeceJacketPic() {
        assertThat(fleeceJacketPic.getAttribute("src"), equalTo(originalSrcFleeceJacket));
        return this;
    }

    @Step("Checking onesie pic")
    public InventoryPage checkOnesiePic() {
        assertThat(onesiePic.getAttribute("src"), equalTo(originalSrcOnesie));
        return this;
    }

    @Step("Checking red t-shert pic")
    public InventoryPage checkRedTShirtPic() {
        assertThat(redTShirtPic.getAttribute("src"), equalTo(originalSrcRedTShirt));
        return this;
    }

    @Step("Checking sorting name (Z to A)")
    public InventoryPage checkSortingNameZA(){
        List<String> listOfProductNames = driver.findElements(By.cssSelector(productListByName))
                .stream().map(WebElement::getText)
                .collect(Collectors.toList());
        listOfProductNames.sort(Comparator.reverseOrder());
        chooseSortingOption(SortingDropDownValues.NAME_ZA);
        List<String> listOfProductNamesAfterSorting = driver.findElements(By.cssSelector(productListByName))
                .stream().map(WebElement::getText)
                .collect(Collectors.toList());
        assertThat(listOfProductNames, IsEqual.equalTo(listOfProductNamesAfterSorting));
        return this;
    }

    @Step("Checking sorting name (A to Z)")
    public InventoryPage checkSortingNameAZ(){
        List<String> listOfProductNames = driver.findElements(By.cssSelector(productListByName))
                .stream().map(WebElement::getText)
                .collect(Collectors.toList());
        listOfProductNames.sort(Comparator.naturalOrder());
        chooseSortingOption(SortingDropDownValues.NAME_AZ);
        List<String> listOfProductNamesAfterSorting = driver.findElements(By.cssSelector(productListByName))
                .stream().map(WebElement::getText)
                .collect(Collectors.toList());
        assertThat(listOfProductNames, IsEqual.equalTo(listOfProductNamesAfterSorting));
        return this;
    }

    @Step("Checking sorting price (low to high)")
    public InventoryPage checkSortingPriceLH(){
        List<String> listOfProductNames = driver.findElements(By.cssSelector(productListByPrice))
                .stream().map(e->e.getText().substring(1))
                .collect(Collectors.toList());
        List<Double> listOfProductPrice = new ArrayList<>();
        listOfProductNames.forEach(e->listOfProductPrice.add(Double.valueOf(e)));
            listOfProductPrice.sort(Comparator.naturalOrder());
            chooseSortingOption(SortingDropDownValues.PRICE_LH);
            List<String> listOfProductNamesAfterSorting = driver.findElements(By.cssSelector(productListByPrice))
                    .stream().map(e -> e.getText().substring(1))
                    .collect(Collectors.toList());
            List<Double>listOfProductPriceAfterSorting = new ArrayList<>();
            listOfProductNamesAfterSorting.forEach(e->listOfProductPriceAfterSorting.add(Double.valueOf(e)));
            assertThat(listOfProductPrice, equalTo(listOfProductPriceAfterSorting));
        return this;
    }

    @Step("Checking sorting price (high to low)")
    public InventoryPage checkSortingPriceHL(){
        List<String> listOfProductNames = driver.findElements(By.cssSelector(productListByPrice))
                .stream().map(e->e.getText().substring(1))
                .collect(Collectors.toList());
        List<Double> listOfProductPrice = new ArrayList<>();
        listOfProductNames.forEach(e->listOfProductPrice.add(Double.valueOf(e)));
        listOfProductPrice.sort(Comparator.reverseOrder());
        chooseSortingOption(SortingDropDownValues.PRICE_HL);
        List<String> listOfProductNamesAfterSorting = driver.findElements(By.cssSelector(productListByPrice))
                .stream().map(e -> e.getText().substring(1))
                .collect(Collectors.toList());
        List<Double>listOfProductPriceAfterSorting = new ArrayList<>();
        listOfProductNamesAfterSorting.forEach(e->listOfProductPriceAfterSorting.add(Double.valueOf(e)));
        assertThat(listOfProductPrice, equalTo(listOfProductPriceAfterSorting));
        return this;
    }
}
