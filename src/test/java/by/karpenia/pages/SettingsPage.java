package by.karpenia.pages;

import by.karpenia.components.NavigationMenu;
import by.karpenia.tools.Util;
import by.karpenia.components.AlertBox;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

/**
 * Created by Kate on 21.01.17.
 */
public class SettingsPage {

    private final WebDriver driver;
    private final NavigationMenu navigationMenu;
    private final AlertBox alertBox;

    By emailsSettingLocator = By.xpath(".//*[@id='js-pjax-container']/div/div[1]/nav[1]/a[3]");
    public final static By emailsPrefRadioButtonMarketingLocator = By.cssSelector("input[id='type_marketing']");
    By emailsPrefRadioButtonTransLocator = By.cssSelector("input[id='type_transactional']");
    By saveEmailPreferencesLocator = By.name("commit");
    By profileSettingsLocator = By.xpath(".//*[@id='js-pjax-container']/div/div[1]/nav[1]/a[1]");
    By changePublicEmailLocator = By.id("user_profile_email");
    By updateProfileButtonLocator = By.xpath(".//*[@id='profile_25301399']/div[2]/p/button");

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
            driver.findElement(emailsPrefRadioButtonTransLocator).click();
        } else {
            driver.findElement(emailsPrefRadioButtonMarketingLocator).click();
        }
        return new SettingsPage(driver);
    }

    public SettingsPage saveEmailPreferences() {
        driver.findElement(saveEmailPreferencesLocator).submit();
        return new SettingsPage(driver);
    }

    public SettingsPage profileSettings() {
        driver.findElement(profileSettingsLocator).click();
        return new SettingsPage(driver);
    }

    public SettingsPage changePublicEmail() {
        driver.findElement(changePublicEmailLocator).click();

        Select dropdownMenu = new Select(driver.findElement(changePublicEmailLocator));
        WebElement selectedValue = dropdownMenu.getFirstSelectedOption();
        String value = selectedValue.getText();
        if(value.contains("Don’t show my email address")) {
            dropdownMenu.selectByIndex(1);
        } else {
            dropdownMenu.selectByIndex(0);
        }

        return new SettingsPage(driver);
    }

    public SettingsPage updateProfileButton() {
        driver.findElement(updateProfileButtonLocator).click();
        return new SettingsPage(driver);
    }


    public NavigationMenu navigationMenu() {
        return navigationMenu;
    }

    public AlertBox alertBox() {
        return alertBox;
    }



}
