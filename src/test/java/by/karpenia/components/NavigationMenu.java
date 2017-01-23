package by.karpenia.components;

import by.karpenia.pages.*;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

/**
 * Created by Kate on 21.01.17.
 */
public class NavigationMenu {

    private WebDriver driver;
    private WebElement element;
    By navigateLoginLocator = By.cssSelector(".btn.site-header-actions-btn.mr-1");
    By navigateSettingsLocator = By.xpath(".//*[@id='user-links']/li[3]/div/div/a[6]");
    By navigateProfileLocator = By.xpath(".//*[@id='user-links']/li[3]/a");
    By navigateCreateNewLocator = By.xpath(".//*[@id='user-links']/li[2]/a");
    By navigateNewRepositoryLocator = By.xpath(".//*[@id='user-links']/li[2]/div/ul/a[1]");
    By navigateSavedRepliesPage = By.xpath(".//*[@id='js-pjax-container']/div/div[1]/nav[1]/a[11]");

    public NavigationMenu(WebDriver driver) {
        this.driver = driver;
    }

    public LoginPage navigateLoginPage () {
        driver.findElement(navigateLoginLocator).click();
        return new LoginPage(driver);
    }

    public HomePage navigateProfilePage() {
        driver.findElement(navigateProfileLocator).click();
        return new HomePage(driver);
    }

    public SettingsPage navigateSettingsPage() {
        driver.findElement(navigateSettingsLocator).click();
        return new SettingsPage(driver);
    }

    public SettingsPage navigateCreateNew() {
        driver.findElement(navigateCreateNewLocator).click();
        return new SettingsPage(driver);
    }

    public RepositoryPage navigateNewRepository() {
        driver.findElement(navigateNewRepositoryLocator).click();
        return new RepositoryPage(driver);
    }

    public RepliesPage navigateSavedRepliesPage() {
        driver.findElement(navigateSavedRepliesPage).click();
        return new RepliesPage(driver);
    }

}
