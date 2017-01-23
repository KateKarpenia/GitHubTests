package by.karpenia.components;

import by.karpenia.pages.RepositoryPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by Kate on 23.01.17.
 */
public class AlertBox {

    private WebDriver driver;

    public final static By alertBoxLocator = By.id("js-flash-container");
    public final static By alertBoxInputLocator = By.xpath(".//*[@id='facebox']/div/div/form/p/input");
    public final static By alertSubmitDeleteLocator = By.xpath(".//*[@id='facebox']/div/div/form/button");

    public AlertBox (WebDriver driver){
        this.driver = driver;
    }

    public void alertBoxIsDisplayed() {
        driver.findElement(alertBoxLocator).isDisplayed();
    }

    public RepositoryPage alertBoxMessage() {
        driver.findElement(alertBoxLocator).getText();
        return new RepositoryPage(driver);
    }

}
