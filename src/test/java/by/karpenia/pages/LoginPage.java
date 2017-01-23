package by.karpenia.pages;

import by.karpenia.components.NavigationMenu;
import by.karpenia.tools.Util;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

/**
 * Created by Kate on 20.01.17.
 */
public class LoginPage {

    private final WebDriver driver;
    private final NavigationMenu navigationMenu;

    @FindBy(how = How.ID, using = "login_field")
    WebElement usernameField;

    By usernameLocator = By.id("login_field");
    By passwordLocator = By.id("password");
    By loginButtonLocator = By.xpath(".//*[@id='login']/form/div[4]/input[3]");
    By navigateProfileLocator = By.xpath(".//*[@id='user-links']/li[3]/a");


    public LoginPage(WebDriver driver) {
        this.driver = driver;
        this.navigationMenu = new NavigationMenu(driver);

//        if (!TITLE.equals(driver.getTitle())) {
//            throw new IllegalStateException("This is not the login page");
//        }
    }

    public LoginPage open() {
        driver.get(Util.LOGIN_URL);
        return this;
    }

    public LoginPage typeUsername(String username) {
        driver.findElement(usernameLocator).sendKeys(username);
        return this;
    }

//    public void EnterUserName(String username)
//    {
//        usernameField.sendKeys(username);
//    }


    public LoginPage typePassword(String password) {
        driver.findElement(passwordLocator).sendKeys(password);
        return this;
    }

    public HomePage submitLogin() {
        driver.findElement(loginButtonLocator).submit();
        return new HomePage(driver);
    }

//    public HomePage navigateProfile() {
//        driver.findElement(navigateProfileLocator).submit();
//        return new HomePage(driver);
//    }

    public LoginPage submitLoginExpectingFailure() {
        driver.findElement(loginButtonLocator).submit();
        return new LoginPage(driver);
    }

//    public HomePage loginAs(String username, String password) {
//        typeUsername(username);
//        typePassword(password);
//        return submitLogin();
//    }

    public NavigationMenu navigationMenu() {
        return navigationMenu;
    }

}
