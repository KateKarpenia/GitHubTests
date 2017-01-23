package by.karpenia.pages;

import by.karpenia.tools.Util;
import by.karpenia.components.NavigationMenu;
import org.openqa.selenium.WebDriver;

/**
 * Created by Kate on 21.01.17.
 */
public class HomePage {

    private final WebDriver driver;
    private final NavigationMenu navigationMenu;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        this.navigationMenu = new NavigationMenu(driver);
    }

    public HomePage open() {
        driver.get(Util.BASE_URL);
        return this;
    }

//    public HomePage explore() {
//        driver.
//    }

    public NavigationMenu navigationMenu() {
        return navigationMenu;
    }

}
