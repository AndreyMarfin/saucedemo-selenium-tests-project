package ru.AndreyMarfin.tests;

import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.RegisterExtension;
import ru.AndreyMarfin.pages.LoginPage;
import ru.AndreyMarfin.utils.ScreenshotWatcher5;


@Feature("Checking page movements")
public class TransitionTests extends BaseTest {

    @RegisterExtension
    ScreenshotWatcher5 watcher = new ScreenshotWatcher5(driver);

    @DisplayName("(P)Authorisation test of standard user")
    @Description("Checking authorisation process")
    @Test
    void authorisationPositiveTest() {
        new LoginPage(driver)
                .enterLogin(username)
                .enterPassword(password)
                .clickLoginButton()
                .checkInventoryPageURL()
                .checkCartOnThePage()
                .goLogout();
    }

    @DisplayName("(P)Standard user`s happy path test")
    @Description("Checking the standard user's path from authorisation to completion of the purchase")
    @Test
    void happyPathTest() {
        new LoginPage(driver)
                .enterLogin(username)
                .enterPassword(password)
                .clickLoginButton()
                .checkInventoryPageURL()
                .checkCartOnThePage()
                .clickButtonAddBackPack()
                .clickCartButton()
                .checkCartPageURL()
                .checkBackpackOnTheCart()
                .clickCheckoutButton()
                .checkCheckoutStepOnePageURL()
                .enterFirstname(firstname)
                .enterLastname(lastname)
                .enterPostalCode(postalcode)
                .clickContinueButton()
                .checkCheckOutStepTwoRageURL()
                .checkBackpackOnOrder()
                .clickFinishButton()
                .checkCheckoutCompletePageURL()
                .checkCompleteMessage()
                .clickBackToProductButton()
                .checkInventoryPageURL()
                .goLogout();
    }

    @DisplayName("(N)Authorisation test with wrong username")
    @Description("Checking authorisation process with wrong username")
    @Test
    void authorisationWrongUsernameNegativeTest() {
        new LoginPage(driver)
                .enterLogin(wrongLogin)
                .enterPassword(password)
                .clickLoginButton()
                .checkErrorMessage(errorTextWrongUser)
                .checkInventoryPageURL();
    }

    @DisplayName("(N)Authorisation test with locked username")
    @Description("Checking authorisation process with locked username")
    @Test
    void authorisationLockedUsernameNegativeTest() {
        new LoginPage(driver)
                .enterLogin(lockedUsername)
                .enterPassword(password)
                .clickLoginButton()
                .checkErrorMessage(errorTextLockedUser)
                .checkInventoryPageURL();
    }

    @DisplayName("(P)Performance glitch user`s happy path")
    @Description("Checking the performance glitch user's path from authorisation to completion of the purchase")
    @Test
    void performanceGlitchUserHappyPathTest(){
        new LoginPage(driver)
                .enterLogin(performanceGlitchUser)
                .enterPassword(password)
                .clickLoginButton()
                .checkInventoryPageURL()
                .checkCartOnThePage()
                .clickButtonAddBackPack()
                .clickCartButton()
                .checkCartPageURL()
                .checkBackpackOnTheCart()
                .clickCheckoutButton()
                .checkCheckoutStepOnePageURL()
                .enterFirstname(firstname)
                .enterLastname(lastname)
                .enterPostalCode(postalcode)
                .clickContinueButton()
                .checkCheckOutStepTwoRageURL()
                .checkBackpackOnOrder()
                .clickFinishButton()
                .checkCheckoutCompletePageURL()
                .checkCompleteMessage()
                .clickBackToProductButton()
                .checkInventoryPageURL()
                .goLogout();
    }

    @DisplayName("(N)Problem user`s path to checkout")
    @Description("Checking the problem user's path from authorisation to completion of the purchase")
    @Test
    void problemUserPathToCheckoutTest(){
        new LoginPage(driver)
                .enterLogin(problemUser)
                .enterPassword(password)
                .clickLoginButton()
                .checkInventoryPageURL()
                .clickCartButton()
                .checkCartPageURL()
                .clickCheckoutButton()
                .checkCheckoutStepOnePageURL()
                .enterFirstname(firstname)
                .enterLastname(lastname)
                .enterPostalCode(postalcode)
                .clickContinueButton()
                .checkErrorMessage()
                .checkCheckOutStepTwoRageURL();
    }
}