package by.karpenia.test;

import by.karpenia.pages.*;
import by.karpenia.tools.Util;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import static by.karpenia.tools.Util.*;
import static by.karpenia.components.AlertBox.*;
import static by.karpenia.pages.SettingsPage.*;

/**
 * Created by Kate on 23.01.17.
 */
public class GitHubTests {

    private WebDriver driver;
    private HomePage homePage;
    private LoginPage loginPage;
    private SettingsPage settingsPage;
    private RepositoryPage repositoryPage;
    private RepliesPage repliesPage;
    private String textOnAlert;

    @BeforeClass
    public void setUpAndLogin () throws InterruptedException {
        System.setProperty("webdriver.gecko.driver", DRIVER_PATH);
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        homePage = new HomePage(driver).open();
        homePage.navigationMenu().navigateLoginPage();
        Thread.sleep(2000);
        loginPage = new LoginPage(driver);
        loginPage.typeUsername(USERNAME);
        loginPage.typePassword(PASS);
        loginPage.submitLogin();

        Thread.sleep(2000);

    }

    @Test
    public void changePublicEmailInProfileTest() throws InterruptedException {
        loginPage.navigationMenu().navigateProfilePage();
        loginPage.navigationMenu().navigateSettingsPage();
        settingsPage = new SettingsPage(driver);
        settingsPage.profileSettings();
        settingsPage.changePublicEmail();
        Thread.sleep(2000);
        settingsPage.updateProfileButton();

        Thread.sleep(2000);
        textOnAlert = driver.findElement(alertBoxLocator).getText();
        Assert.assertEquals(PROFILE_UPDATED, textOnAlert);

    }

    @Test
    public void changeEmailPreferencesInSettingsTest() throws InterruptedException {
//        Thread.sleep(2000);
        loginPage.navigationMenu().navigateProfilePage();
        loginPage.navigationMenu().navigateSettingsPage();
        settingsPage = new SettingsPage(driver);
        settingsPage.emailsSettings();

        WebDriverWait wait = new WebDriverWait(driver, 50);
        wait.until(ExpectedConditions.visibilityOfElementLocated(emailsPrefRadioButtonMarketingLocator));
        settingsPage.emailsPreferencesChangeRadioButton();
        settingsPage.saveEmailPreferences();
        settingsPage.alertBox().alertBoxIsDisplayed();

        Thread.sleep(2000);
        textOnAlert = driver.findElement(alertBoxLocator).getText();
        Assert.assertEquals(SUCCESS_MESSAGE, textOnAlert);

    }

    @Test
    public void newRepositoryCreateAndDeleteTest () throws InterruptedException {
        homePage.navigationMenu().navigateCreateNew();
        homePage.navigationMenu().navigateNewRepository();
        repositoryPage = new RepositoryPage(driver);
        repositoryPage.typeRepositoryName(REPOSITORY_NAME);
        Thread.sleep(2000);

        repositoryPage.submitNewRopository();
        repositoryPage.settingsRepository();
        repositoryPage.deleteRepository();
        Thread.sleep(2000);

        String parentWindowHandler = driver.getWindowHandle(); // Store parent window
        String subWindowHandler = null;

        Set<String> handles = driver.getWindowHandles(); // get all window handles
        Iterator<String> iterator = handles.iterator();
        while (iterator.hasNext()){
            subWindowHandler = iterator.next();
        }
        driver.switchTo().window(subWindowHandler);
        driver.findElement(alertBoxInputLocator).sendKeys(Util.REPOSITORY_NAME);
        driver.findElement(alertSubmitDeleteLocator).click();
        driver.switchTo().window(parentWindowHandler);
        Thread.sleep(2000);

        repositoryPage.alertBox().alertBoxIsDisplayed();
        textOnAlert = driver.findElement(alertBoxLocator).getText();
        Assert.assertEquals(SUCCESS_DELETE, textOnAlert);

    }

    @Test
    public void saveRepliesTest() throws InterruptedException {
        loginPage.navigationMenu().navigateProfilePage();
        loginPage.navigationMenu().navigateSettingsPage();
        repliesPage = new RepliesPage(driver);
        repliesPage.navigationMenu().navigateSavedRepliesPage();
        repliesPage.typeReplyTitle(REPLY_TITLE);
        repliesPage.typeReplyBody(REPLY_BODY);
        Thread.sleep(2000);
        repliesPage.saveReply();
        Thread.sleep(2000);

        repliesPage.alertBox().alertBoxIsDisplayed();
        textOnAlert = driver.findElement(alertBoxLocator).getText();
        Assert.assertEquals(REPLY_SAVED, textOnAlert);

    }

}
