package ru.AndreyMarfin.tests;

import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.RegisterExtension;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import ru.AndreyMarfin.elements.SortingDropDownValues;
import ru.AndreyMarfin.pages.InventoryPage;
import ru.AndreyMarfin.pages.LoginPage;
import ru.AndreyMarfin.utils.ScreenshotWatcher5;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

@Feature("Checking static page elements")
public class StaticTests extends BaseTest {

    @RegisterExtension
    ScreenshotWatcher5 watcher = new ScreenshotWatcher5(driver);

    @DisplayName("(P)Checking the elements on the page standard user")
    @Description("Checking the elements on the page https://www.saucedemo.com/checkout-step-one.html via standard user")
    @Test
    void standardUserElementTest() {
        new LoginPage(driver)
                .enterLogin(username)
                .enterPassword(password)
                .clickLoginButton()
                .checkInventoryPageURL()
                .checkCartOnThePage()
                .clickCartButton()
                .clickCheckoutButton()
                .checkCheckoutStepOnePageURL()
                .checkHeaderTitle()
                .checkFirstnameTitle()
                .checkLastnameTitle()
                .checkPostalCodeTitle()
                .checkCancelButton()
                .checkContinueButton()
                .checkCartButton()
                .checkLogo()
                .checkFooterRobot()
                .checkFooterText()
                .clickOpenReactMenuButton()
                .checkAllItemsInReactMenu()
                .checkAboutInReactMenu()
                .checkResetInReactMenu()
                .checkLogoutInReactMenu()
                .clickCloseReactMenuButton()
                .goLogout();
    }

    @DisplayName("(P)Checking the elements on the page problem user")
    @Description("Checking the elements on the page https://www.saucedemo.com/checkout-step-one.html via problem user")
    @Test
    void problemUserElementTest() {
        new LoginPage(driver)
                .enterLogin(problemUser)
                .enterPassword(password)
                .clickLoginButton()
                .checkInventoryPageURL()
                .checkCartOnThePage()
                .clickCartButton()
                .clickCheckoutButton()
                .checkCheckoutStepOnePageURL()
                .checkHeaderTitle()
                .checkFirstnameTitle()
                .checkLastnameTitle()
                .checkPostalCodeTitle()
                .checkCancelButton()
                .checkContinueButton()
                .checkCartButton()
                .checkLogo()
                .checkFooterRobot()
                .checkFooterText()
                .clickOpenReactMenuButton()
                .checkAllItemsInReactMenu()
                .checkAboutInReactMenu()
                .checkResetInReactMenu()
                .checkLogoutInReactMenu()
                .clickCloseReactMenuButton()
                .goLogout();
    }

    @DisplayName("(P)Checking the elements on the page performance glitch user")
    @Description("Checking the elements on the page https://www.saucedemo.com/checkout-step-one.html via performance glitch user")
    @Test
    void performanceGlitchUserElementTest() {
        new LoginPage(driver)
                .enterLogin(performanceGlitchUser)
                .enterPassword(password)
                .clickLoginButton()
                .checkInventoryPageURL()
                .checkCartOnThePage()
                .clickCartButton()
                .clickCheckoutButton()
                .checkCheckoutStepOnePageURL()
                .checkHeaderTitle()
                .checkFirstnameTitle()
                .checkLastnameTitle()
                .checkPostalCodeTitle()
                .checkCancelButton()
                .checkContinueButton()
                .checkCartButton()
                .checkLogo()
                .checkFooterRobot()
                .checkFooterText()
                .clickOpenReactMenuButton()
                .checkAllItemsInReactMenu()
                .checkAboutInReactMenu()
                .checkResetInReactMenu()
                .checkLogoutInReactMenu()
                .clickCloseReactMenuButton()
                .goLogout();
    }

    @DisplayName("(P)Checking backpack picture on the page standard user")
    @Description("Checking backpack picture on the page https://www.saucedemo.com/inventory.html via standard user")
    @Test
    void standardUserCheckOnInventoryPageBackpackPicTest(){
        new LoginPage(driver)
                .enterLogin(username)
                .enterPassword(password)
                .clickLoginButton()
                .checkBackpackPic()
                .goLogout();
    }

    @DisplayName("(P)Checking bike light picture on the page standard user")
    @Description("Checking bike light picture on the page https://www.saucedemo.com/inventory.html via standard user")
    @Test
    void standardUserCheckOnInventoryPageBikeLightPicTest(){
        new LoginPage(driver)
                .enterLogin(username)
                .enterPassword(password)
                .clickLoginButton()
                .checkBikeLightPic()
                .goLogout();
    }

    @DisplayName("(P)Checking bolt t-shirt picture on the page standard user")
    @Description("Checking bolt t-shirt picture on the page https://www.saucedemo.com/inventory.html via standard user")
    @Test
    void standardUserCheckOnInventoryPageBoltTShirtPicTest(){
        new LoginPage(driver)
                .enterLogin(username)
                .enterPassword(password)
                .clickLoginButton()
                .checkBoltTShirtPic()
                .goLogout();
    }

    @DisplayName("(P)Checking fleece jacket picture on the page standard user")
    @Description("Checking fleece jacket picture on the page https://www.saucedemo.com/inventory.html via standard user")
    @Test
    void standardUserCheckOnInventoryPageFleeceJacketPicTest(){
        new LoginPage(driver)
                .enterLogin(username)
                .enterPassword(password)
                .clickLoginButton()
                .checkFleeceJacketPic()
                .goLogout();
    }

    @DisplayName("(P)Checking onesie picture on the page standard user")
    @Description("Checking onesie jacket picture on the page https://www.saucedemo.com/inventory.html via standard user")
    @Test
    void standardUserCheckOnInventoryPageOnesiePicTest(){
        new LoginPage(driver)
                .enterLogin(username)
                .enterPassword(password)
                .clickLoginButton()
                .checkOnesiePic()
                .goLogout();
    }

    @DisplayName("(P)Checking red t-shirt picture on the page standard user")
    @Description("Checking red t-shirt jacket picture on the page https://www.saucedemo.com/inventory.html via standard user")
    @Test
    void standardUserCheckOnInventoryPageRedTShirtPicTest(){
        new LoginPage(driver)
                .enterLogin(username)
                .enterPassword(password)
                .clickLoginButton()
                .checkRedTShirtPic()
                .goLogout();
    }

    @DisplayName("(P)Checking the addition of a backpack to cart standard user")
    @Description("Checking the addition of a backpack to cart via standard user")
    @Test
    void addedBackpackOnCartStandardUserTest(){
        new LoginPage(driver)
                .enterLogin(username)
                .enterPassword(password)
                .clickLoginButton()
                .clickButtonAddBackPack()
                .clickCartButton()
                .checkBackpackOnTheCart()
                .clickRemoveBackpackButton()
                .goLogout();
    }

    @DisplayName("(P)Checking the addition of a bike light to cart standard user")
    @Description("Checking the addition of a bike light to cart via standard user")
    @Test
    void addedBikeLightOnCartStandardUserTest(){
        new LoginPage(driver)
                .enterLogin(username)
                .enterPassword(password)
                .clickLoginButton()
                .clickButtonAddBikeLight()
                .clickCartButton()
                .checkBikeLightOnTheCart()
                .clickRemoveBikeLightButton()
                .goLogout();
    }

    @DisplayName("(P)Checking the addition of a bolt t-shirt to cart standard user")
    @Description("Checking the addition of a bolt t-shirt to cart via standard user")
    @Test
    void addedBoltTShirtOnCartStandardUserTest(){
        new LoginPage(driver)
                .enterLogin(username)
                .enterPassword(password)
                .clickLoginButton()
                .clickButtonAddBoltTShirt()
                .clickCartButton()
                .checkBoltTShirtOnTheCart()
                .clickRemoveBoltTShirtButton()
                .goLogout();
    }

    @DisplayName("(P)Checking the addition of a fleece jacket to cart standard user")
    @Description("Checking the addition of a fleece facket to cart via standard user")
    @Test
    void addedFleeceJacketOnCartStandardUserTest(){
        new LoginPage(driver)
                .enterLogin(username)
                .enterPassword(password)
                .clickLoginButton()
                .clickButtonAddFleeceJacket()
                .clickCartButton()
                .checkFleeceJacketOnTheCart()
                .clickRemoveFleeceJacketButton()
                .goLogout();
    }

    @DisplayName("(P)Checking the addition of an onesie to cart standard user")
    @Description("Checking the addition of an onesie to cart via standard user")
    @Test
    void addedOnesieOnCartStandardUserTest(){
        new LoginPage(driver)
                .enterLogin(username)
                .enterPassword(password)
                .clickLoginButton()
                .clickButtonAddOnesie()
                .clickCartButton()
                .checkOnesieOnTheCart()
                .clickRemoveOnesieButton()
                .goLogout();
    }

    @DisplayName("(P)Checking the addition of a red t-shirt to cart standard user")
    @Description("Checking the addition of a red t-shirt to cart via standard user")
    @Test
    void addedRedTShirtOnCartStandardUserTest(){
        new LoginPage(driver)
                .enterLogin(username)
                .enterPassword(password)
                .clickLoginButton()
                .clickButtonAddRedTShirt()
                .clickCartButton()
                .checkRedTShirtOnTheCart()
                .clickRemoveRedTShirtButton()
                .goLogout();
    }

    @DisplayName("(P)Checking backpack picture on the page performance glitch user")
    @Description("Checking backpack picture on the page https://www.saucedemo.com/inventory.html via performance glitch user")
    @Test
    void performanceGlitchUserCheckOnInventoryPageBackpackPicTest(){
        new LoginPage(driver)
                .enterLogin(performanceGlitchUser)
                .enterPassword(password)
                .clickLoginButton()
                .checkBackpackPic()
                .goLogout();
    }

    @DisplayName("(P)Checking bike light picture on the page performance glitch user")
    @Description("Checking bike light picture on the page https://www.saucedemo.com/inventory.html via performance glitch user")
    @Test
    void performanceGlitchUserCheckOnInventoryPageBikeLightPicTest(){
        new LoginPage(driver)
                .enterLogin(performanceGlitchUser)
                .enterPassword(password)
                .clickLoginButton()
                .checkBikeLightPic()
                .goLogout();
    }

    @DisplayName("(P)Checking bolt t-shirt picture on the page performance glitch user")
    @Description("Checking bolt t-shirt picture on the page https://www.saucedemo.com/inventory.html via performance glitch user")
    @Test
    void performanceGlitchUserCheckOnInventoryPageBoltTShirtPicTest(){
        new LoginPage(driver)
                .enterLogin(performanceGlitchUser)
                .enterPassword(password)
                .clickLoginButton()
                .checkBoltTShirtPic()
                .goLogout();
    }

    @DisplayName("(P)Checking fleece jacket picture on the page performance glitch user")
    @Description("Checking fleece jacket picture on the page https://www.saucedemo.com/inventory.html via performance glitch user")
    @Test
    void performanceGlitchUserCheckOnInventoryPageFleeceJacketPicTest(){
        new LoginPage(driver)
                .enterLogin(performanceGlitchUser)
                .enterPassword(password)
                .clickLoginButton()
                .checkFleeceJacketPic()
                .goLogout();
    }

    @DisplayName("(P)Checking onesie picture on the page performance glitch user")
    @Description("Checking onesie jacket picture on the page https://www.saucedemo.com/inventory.html via performance glitch user")
    @Test
    void performanceGlitchUserCheckOnInventoryPageOnesiePicTest(){
        new LoginPage(driver)
                .enterLogin(performanceGlitchUser)
                .enterPassword(password)
                .clickLoginButton()
                .checkOnesiePic()
                .goLogout();
    }

    @DisplayName("(P)Checking red t-shirt picture on the page performance glitch user")
    @Description("Checking red t-shirt jacket picture on the page https://www.saucedemo.com/inventory.html via performance glitch user")
    @Test
    void performanceGlitchUserCheckOnInventoryPageRedTShirtPicTest(){
        new LoginPage(driver)
                .enterLogin(performanceGlitchUser)
                .enterPassword(password)
                .clickLoginButton()
                .checkRedTShirtPic()
                .goLogout();
    }

    @DisplayName("(P)Checking the addition of a backpack to cart performance glitch user")
    @Description("Checking the addition of a backpack to cart via performance glitch user")
    @Test
    void addedBackpackOnCartPerformanceGlitchUserTest(){
        new LoginPage(driver)
                .enterLogin(performanceGlitchUser)
                .enterPassword(password)
                .clickLoginButton()
                .clickButtonAddBackPack()
                .clickCartButton()
                .checkBackpackOnTheCart()
                .clickRemoveBackpackButton()
                .goLogout();
    }

    @DisplayName("(P)Checking the addition of a bike light to cart performance glitch user")
    @Description("Checking the addition of a bike light to cart via performance glitch user")
    @Test
    void addedBikeLightOnCartPerformanceGlitchUserTest(){
        new LoginPage(driver)
                .enterLogin(performanceGlitchUser)
                .enterPassword(password)
                .clickLoginButton()
                .clickButtonAddBikeLight()
                .clickCartButton()
                .checkBikeLightOnTheCart()
                .clickRemoveBikeLightButton()
                .goLogout();
    }

    @DisplayName("(P)Checking the addition of a bolt t-shirt to cart performance glitch user")
    @Description("Checking the addition of a bolt t-shirt to cart via performance glitch user")
    @Test
    void addedBoltTShirtOnCartPerformanceGlitchUserTest(){
        new LoginPage(driver)
                .enterLogin(performanceGlitchUser)
                .enterPassword(password)
                .clickLoginButton()
                .clickButtonAddBoltTShirt()
                .clickCartButton()
                .checkBoltTShirtOnTheCart()
                .clickRemoveBoltTShirtButton()
                .goLogout();
    }

    @DisplayName("(P)Checking the addition of a fleece jacket to cart performance glitch user")
    @Description("Checking the addition of a fleece facket to cart via performance glitch user")
    @Test
    void addedFleeceJacketOnCartPerformanceGlitchUserTest(){
        new LoginPage(driver)
                .enterLogin(performanceGlitchUser)
                .enterPassword(password)
                .clickLoginButton()
                .clickButtonAddFleeceJacket()
                .clickCartButton()
                .checkFleeceJacketOnTheCart()
                .clickRemoveFleeceJacketButton()
                .goLogout();
    }

    @DisplayName("(P)Checking the addition of an onesie to cart performance glitch user")
    @Description("Checking the addition of an onesie to cart via performance glitch user")
    @Test
    void addedOnesieOnCartPerformanceGlitchUserTest(){
        new LoginPage(driver)
                .enterLogin(performanceGlitchUser)
                .enterPassword(password)
                .clickLoginButton()
                .clickButtonAddOnesie()
                .clickCartButton()
                .checkOnesieOnTheCart()
                .clickRemoveOnesieButton()
                .goLogout();
    }

    @DisplayName("(P)Checking the addition of a red t-shirt to cart performance glitch user")
    @Description("Checking the addition of a red t-shirt to cart via performance glitch user")
    @Test
    void addedRedTShirtOnCartPerformanceGlitchUserTest(){
        new LoginPage(driver)
                .enterLogin(performanceGlitchUser)
                .enterPassword(password)
                .clickLoginButton()
                .clickButtonAddRedTShirt()
                .clickCartButton()
                .checkRedTShirtOnTheCart()
                .clickRemoveRedTShirtButton()
                .goLogout();
    }

    @DisplayName("(N)Checking backpack picture on the page problem user")
    @Description("Checking backpack picture on the page https://www.saucedemo.com/inventory.html via problem user")
    @Test
    void problemUserCheckOnInventoryPageBackpackPicTest(){
        new LoginPage(driver)
                .enterLogin(problemUser)
                .enterPassword(password)
                .clickLoginButton()
                .checkBackpackPic()
                .goLogout();
    }

    @DisplayName("(N)Checking bike light picture on the page problem user")
    @Description("Checking bike light picture on the page https://www.saucedemo.com/inventory.html via problem user")
    @Test
    void problemUserCheckOnInventoryPageBikeLightPicTest(){
        new LoginPage(driver)
                .enterLogin(problemUser)
                .enterPassword(password)
                .clickLoginButton()
                .checkBikeLightPic()
                .goLogout();
    }

    @DisplayName("(N)Checking bolt t-shirt picture on the page problem user")
    @Description("Checking bolt t-shirt picture on the page https://www.saucedemo.com/inventory.html via problem user")
    @Test
    void problemUserCheckOnInventoryPageBoltTShirtPicTest(){
        new LoginPage(driver)
                .enterLogin(problemUser)
                .enterPassword(password)
                .clickLoginButton()
                .checkBoltTShirtPic()
                .goLogout();
    }

    @DisplayName("(N)Checking fleece jacket picture on the page problem user")
    @Description("Checking fleece jacket picture on the page https://www.saucedemo.com/inventory.html via problem user")
    @Test
    void problemUserCheckOnInventoryPageFleeceJacketPicTest(){
        new LoginPage(driver)
                .enterLogin(problemUser)
                .enterPassword(password)
                .clickLoginButton()
                .checkFleeceJacketPic()
                .goLogout();
    }

    @DisplayName("(N)Checking onesie picture on the page problem user")
    @Description("Checking onesie jacket picture on the page https://www.saucedemo.com/inventory.html via problem user")
    @Test
    void problemUserCheckOnInventoryPageOnesiePicTest(){
        new LoginPage(driver)
                .enterLogin(problemUser)
                .enterPassword(password)
                .clickLoginButton()
                .checkOnesiePic()
                .goLogout();
    }

    @DisplayName("(N)Checking red t-shirt picture on the page problem user")
    @Description("Checking red t-shirt jacket picture on the page https://www.saucedemo.com/inventory.html via problem user")
    @Test
    void problemUserCheckOnInventoryPageRedTShirtPicTest(){
        new LoginPage(driver)
                .enterLogin(problemUser)
                .enterPassword(password)
                .clickLoginButton()
                .checkRedTShirtPic()
                .goLogout();
    }

    @DisplayName("(P)Сhecking the addition of a backpack to cart problem user")
    @Description("Checking the addition of a backpack to cart via problem user")
    @Test
    void addedBackpackOnCartProblemUserTest(){
        new LoginPage(driver)
                .enterLogin(problemUser)
                .enterPassword(password)
                .clickLoginButton()
                .clickButtonAddBackPack()
                .clickCartButton()
                .checkBackpackOnTheCart()
                .clickRemoveBackpackButton()
                .goLogout();
    }

    @DisplayName("(P)Сhecking the addition of a bike light to cart problem user")
    @Description("Checking the addition of a bike light to cart via problem user")
    @Test
    void addedBikeLightOnCartProblemUserTest(){
        new LoginPage(driver)
                .enterLogin(problemUser)
                .enterPassword(password)
                .clickLoginButton()
                .clickButtonAddBikeLight()
                .clickCartButton()
                .checkBikeLightOnTheCart()
                .clickRemoveBikeLightButton()
                .goLogout();
    }

    @DisplayName("(N)Сhecking the addition of a bolt t-shirt to cart problem user")
    @Description("Checking the addition of a bolt t-shirt to cart via problem user")
    @Test
    void addedBoltTShirtOnCartProblemUserTest(){
        new LoginPage(driver)
                .enterLogin(problemUser)
                .enterPassword(password)
                .clickLoginButton()
                .clickButtonAddBoltTShirt()
                .checkButtonAddBoltTShirt()
                .goLogout();
    }

    @DisplayName("(N)Сhecking the addition of a fleece jacket to cart problem user")
    @Description("Checking the addition of a fleece facket to cart via problem user")
    @Test
    void addedFleeceJacketOnCartProblemUserTest(){
        new LoginPage(driver)
                .enterLogin(problemUser)
                .enterPassword(password)
                .clickLoginButton()
                .clickButtonAddFleeceJacket()
                .checkButtonAddFleeceJacket()
                .goLogout();
    }

    @DisplayName("(P)Checking the addition of an onesie to cart problem user")
    @Description("Checking the addition of an onesie to cart via problem user")
    @Test
    void addedOnesieOnCartProblemUserTest(){
        new LoginPage(driver)
                .enterLogin(problemUser)
                .enterPassword(password)
                .clickLoginButton()
                .clickButtonAddOnesie()
                .clickCartButton()
                .checkOnesieOnTheCart()
                .clickRemoveOnesieButton()
                .goLogout();
    }

    @DisplayName("(N)Checking the addition of a red t-shirt to cart problem user")
    @Description("Checking the addition of a red t-shirt to cart via problem user")
    @Test
    void addedRedTShirtOnCartProblemUserTest(){
        new LoginPage(driver)
                .enterLogin(problemUser)
                .enterPassword(password)
                .clickLoginButton()
                .clickButtonAddRedTShirt()
                .checkButtonAddRedTShirt()
                .goLogout();
    }

    @DisplayName("(P)Checking sorting by name (A to Z)")
    @Description("Checking sorting by name (A to Z)")
    @Test
    void checkSortingNameAZTest(){
        new LoginPage(driver)
                .enterLogin(username)
                .enterPassword(password)
                .clickLoginButton()
                .checkInventoryPageURL()
                .checkSortingNameAZ()
                .goLogout();
    }

    @DisplayName("(P)Checking sorting by name (Z to A)")
    @Description("Checking sorting by name (Z to A)")
    @Test
    void checkSortingNameZATest(){
        new LoginPage(driver)
                .enterLogin(username)
                .enterPassword(password)
                .clickLoginButton()
                .checkInventoryPageURL()
                .checkSortingNameZA()
                .goLogout();
    }

    @DisplayName("(P)Checking sorting by price (low to high)")
    @Description("Checking sorting by price (low to high)")
    @Test
    void checkSortingPriceLHTest(){
        new LoginPage(driver)
                .enterLogin(username)
                .enterPassword(password)
                .clickLoginButton()
                .checkInventoryPageURL()
                .checkSortingPriceLH()
                .goLogout();
    }

    @DisplayName("(P)Checking sorting by price (high to low)")
    @Description("Checking sorting by price (high to low)")
    @Test
    void checkSortingPriceHLTest(){
        new LoginPage(driver)
                .enterLogin(username)
                .enterPassword(password)
                .clickLoginButton()
                .checkInventoryPageURL()
                .checkSortingPriceHL()
                .goLogout();
    }
}



