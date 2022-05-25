package ru.AndreyMarfin.tests;

import org.junit.jupiter.api.Test;
import ru.AndreyMarfin.pages.LoginPage;

public class TransitionTests extends BaseTest {

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
}