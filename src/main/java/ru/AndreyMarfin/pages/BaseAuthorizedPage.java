package ru.AndreyMarfin.pages;

import io.qameta.allure.Step;
import org.hamcrest.core.IsEqual;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;

import java.time.Duration;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.equalTo;
import static ru.AndreyMarfin.pages.LoginPage.*;
import static ru.AndreyMarfin.utils.TabUtils.switchToTheNextTab;

public class BaseAuthorizedPage extends BasePage {

    @FindBy(css = ".social_twitter a")
    WebElement twitterButton;

    @FindBy(css = ".social_facebook a")
    WebElement facebookButton;

    @FindBy(css = ".social_linkedin a")
    WebElement linkedInButton;

    @FindBy(id = "react-burger-menu-btn")
    WebElement reactMenuOpenButton;

    @FindBy(id = "react-burger-cross-btn")
    WebElement reactMenuCloseButton;

    @FindBy(id = "logout_sidebar_link")
    WebElement logout;

    @FindBy(css = "#inventory_sidebar_link")
    WebElement allItemTitle;

    @FindBy(css = "#about_sidebar_link")
    WebElement aboutTitle;

    @FindBy(css = "#logout_sidebar_link")
    WebElement logoutTitle;

    @FindBy(css = "#reset_sidebar_link")
    WebElement resetTitle;

    public BaseAuthorizedPage(WebDriver driver) {

        super(driver);
    }


    @Step("Click on the button that opens the react menu")
    public BaseAuthorizedPage clickOpenReactMenuButton(){
        reactMenuOpenButton.click();
        return this;
    }

    @Step("Checking 'all items' category in react menu")
    public BaseAuthorizedPage checkAllItemsInReactMenu(){
        assertThat(allItemTitle.getAccessibleName(), IsEqual.equalTo("ALL ITEMS"));
        return this;
    }

    @Step("Checking 'about' category in react menu")
    public BaseAuthorizedPage checkAboutInReactMenu(){
        assertThat(aboutTitle.getAccessibleName(), IsEqual.equalTo("ABOUT"));
        return this;
    }

    @Step("Checking 'logout' category in react menu")
    public BaseAuthorizedPage checkLogoutInReactMenu(){
        assertThat(logoutTitle.getAccessibleName(), IsEqual.equalTo("LOGOUT"));
        return this;
    }

    @Step("Checking 'reset' category in react menu")
    public BaseAuthorizedPage checkResetInReactMenu(){
        assertThat(resetTitle.getAccessibleName(), IsEqual.equalTo("RESET APP STATE"));
        return this;
    }

    @Step("Click on the button that closes the react menu")
    public BaseAuthorizedPage clickCloseReactMenuButton(){
        reactMenuCloseButton.click();
        return this;
    }

    @Step("Logout")
    public LoginPage goLogout(){
        reactMenuOpenButton.click();
        driver.manage().timeouts().getPageLoadTimeout();
        logout.click();
        assertThat(driver.getCurrentUrl(), equalTo("https://www.saucedemo.com/"));
        return new LoginPage(driver);
    }

    @Step("Go to twitter")
    public void goToTwitter(){
        twitterButton.click();
        switchToTheNextTab(driver);
        assertThat(driver.getCurrentUrl(), containsString("twitter.com"));
}
    @Step("Go to facebook")
    public void goToFacebook(){
        facebookButton.click();
        switchToTheNextTab(driver);
        assertThat(driver.getCurrentUrl(), containsString("facebook.com"));
    }

    @Step("Go to LinkedIn")
    public void goToLinkedIn(){
        linkedInButton.click();
        switchToTheNextTab(driver);
        assertThat(driver.getCurrentUrl(), containsString("linkedin.com"));
    }
}
