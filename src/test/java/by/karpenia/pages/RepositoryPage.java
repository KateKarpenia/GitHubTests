package by.karpenia.pages;

import by.karpenia.components.AlertBox;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by Kate on 23.01.17.
 */
public class RepositoryPage {

    private final WebDriver driver;
    private final AlertBox alertBox;

    By repositoryNameLocator = By.xpath(".//*[@id='repository_name']");
    By submitRepositoryLocator = By.xpath(".//*[@id='new_repository']/div[4]/button");
    By settingsRepositoryLocator = By.xpath(".//*[@id='js-repo-pjax-container']/div[1]/div[2]/nav/a[5]");
    By deleteRepositoryLocator = By.xpath(".//*[@id='options_bucket']/div[5]/div/button[3]");

    public RepositoryPage(WebDriver driver)  {
        this.driver = driver;
        this.alertBox = new AlertBox(driver);
    }

    public RepositoryPage typeRepositoryName(String repositoryName) {
        driver.findElement(repositoryNameLocator).sendKeys(repositoryName);
        return new RepositoryPage(driver);
    }

    public RepositoryPage submitNewRopository() {
        driver.findElement(submitRepositoryLocator).submit();
        return new RepositoryPage(driver);
    }

    public RepositoryPage settingsRepository() {
        driver.findElement(settingsRepositoryLocator).click();
        return new RepositoryPage(driver);
    }

    public RepositoryPage deleteRepository() {
        driver.findElement(deleteRepositoryLocator).click();
        return new RepositoryPage(driver);
    }

    public AlertBox alertBox() {
        return alertBox;
    }


}
