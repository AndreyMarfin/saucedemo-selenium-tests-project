package ru.AndreyMarfin.tests;

import org.junit.jupiter.api.Test;
import ru.AndreyMarfin.pages.LoginPage;

public class StaticTests extends BaseTest {

    @Test
    void ElementTest() {
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
}



