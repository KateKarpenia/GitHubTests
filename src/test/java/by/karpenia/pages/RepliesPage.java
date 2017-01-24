package by.karpenia.pages;

import by.karpenia.components.AlertBox;
import by.karpenia.components.NavigationMenu;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by Kate on 23.01.17.
 */
public class RepliesPage {

    private WebDriver driver;
    private NavigationMenu navigationMenu;
    private AlertBox alertBox;

    By replyTitleLocator = By.xpath(".//*[@id='saved-reply-title-field']");
    By replyBodyLocator = By.xpath(".//*[@id='comment_body_1']");
    By saveReplyButtonLocator = By.xpath(".//*[@id='new_saved_reply']/div[2]/div[2]/button");

    public RepliesPage (WebDriver driver) {

        this.driver = driver;
        this.navigationMenu = new NavigationMenu(driver);
        this.alertBox = new AlertBox(driver);
    }

    public RepliesPage typeReplyTitle(String replyTitle) {
        driver.findElement(replyTitleLocator).clear();
        driver.findElement(replyTitleLocator).sendKeys(replyTitle);
        return this;
    }

    public RepliesPage typeReplyBody(String replyBody) {
        driver.findElement(replyBodyLocator).clear();
        driver.findElement(replyBodyLocator).sendKeys(replyBody);
        return this;
    }

    public RepliesPage saveReply() {
        driver.findElement(saveReplyButtonLocator).submit();
        return new RepliesPage(driver);
    }

    public NavigationMenu navigationMenu() {
        return navigationMenu;
    }

    public AlertBox alertBox() {
        return alertBox;
    }

}
