package qascooter.sprint4final.pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MainPage {
    private WebDriver driver;
    private By orderTopButton = By.className("Button_Button__ra12g");
    private By orderBottomButton = By.xpath(".//button[@class ='Button_Button__ra12g Button_Middle__1CSJM']");
    private By confirmCookiesButton = By.id("rcc-confirm-button");

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    public void closeConfirmCookiesBlock() {
        driver.findElement(confirmCookiesButton).click();
    }

    public void orderTopButtonClick() {
        WebElement element = driver.findElement(orderTopButton);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
        Assert.assertTrue(driver.findElement(orderTopButton).isEnabled());
        driver.findElement(orderTopButton).click();
    }

    public void orderBottomButtonClick() {
        WebElement element = driver.findElement(orderBottomButton);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
        Assert.assertTrue(driver.findElement(orderBottomButton).isEnabled());
        driver.findElement(orderBottomButton).click();
    }

    public void accordionButtonClick(int num) {
        WebElement element = driver.findElement(By.id("accordion__heading-" + num));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
        Assert.assertTrue(driver.findElement(By.id("accordion__heading-" + num)).isEnabled());
        driver.findElement(By.id("accordion__heading-" + num)).click();
    }

    public String getAccordionPanelText(int num) {
        WebElement element = driver.findElement(By.id("accordion__panel-" + num));
        return element.getAttribute("innerText");
    }
}
