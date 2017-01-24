package by.karpenia.pages;

import by.karpenia.components.NavigationMenu;
import by.karpenia.tools.Util;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


/**
 * Created by Kate on 20.01.17.
 */
public class LoginPage {

    private final WebDriver driver;
    private final NavigationMenu navigationMenu;

    By usernameLocator = By.id("login_field");
    By passwordLocator = By.id("password");
    By loginButtonLocator = By.xpath(".//*[@id='login']/form/div[4]/input[3]");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        this.navigationMenu = new NavigationMenu(driver);

    }

    public LoginPage open() {
        driver.get(Util.LOGIN_URL);
        return this;
    }

    public LoginPage typeUsername(String username) {
        driver.findElement(usernameLocator).clear();
        driver.findElement(usernameLocator).sendKeys(username);
        return this;
    }

    public LoginPage typePassword(String password) {
        driver.findElement(passwordLocator).clear();
        driver.findElement(passwordLocator).sendKeys(password);
        return this;
    }

    public HomePage submitLogin() {
        driver.findElement(loginButtonLocator).submit();
        return new HomePage(driver);
    }


    public NavigationMenu navigationMenu() {
        return navigationMenu;
    }

}
