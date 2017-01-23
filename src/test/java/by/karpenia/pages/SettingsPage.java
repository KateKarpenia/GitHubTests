package by.karpenia.pages;

import by.karpenia.components.NavigationMenu;
import by.karpenia.tools.Util;
import by.karpenia.components.AlertBox;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by Kate on 21.01.17.
 */
public class SettingsPage {

    private final WebDriver driver;
    private final NavigationMenu navigationMenu;
    private final AlertBox alertBox;

    public final static By emailsSettingLocator = By.xpath(".//*[@id='js-pjax-container']/div/div[1]/nav[1]/a[3]");
    public final static By emailsPrefRadioButtonMarketingLocator = By.cssSelector("input[id='type_marketing']");
    public final static By emailsPrefRadioButtonTransLocator = By.cssSelector("input[id='type_transactional']");
    public final static By saveEmailPreferencesLocator = By.name("commit");

    public SettingsPage(WebDriver driver) {

        this.driver = driver;
        this.navigationMenu = new NavigationMenu(driver);
        this.alertBox = new AlertBox(driver);
    }

    public SettingsPage open() {
        driver.get(Util.SETTINGS_URL);
        return this;
    }

    public SettingsPage emailsSettings() {
        driver.findElement(emailsSettingLocator).click();
        return new SettingsPage(driver);
    }

    public SettingsPage emailsPreferencesChangeRadioButton() {
        if (driver.findElement(emailsPrefRadioButtonMarketingLocator).isSelected()) {
            System.out.println("marketing selected");
            driver.findElement(emailsPrefRadioButtonTransLocator).click();
        } else {
            System.out.println("transactional selected");
            driver.findElement(emailsPrefRadioButtonMarketingLocator).click();
        }
        return new SettingsPage(driver);
    }

    public SettingsPage saveEmailPreferences() {
        driver.findElement(saveEmailPreferencesLocator).submit();
        return new SettingsPage(driver);
    }

    public NavigationMenu navigationMenu() {
        return navigationMenu;
    }

    public AlertBox alertBox() {
        return alertBox;
    }



}
