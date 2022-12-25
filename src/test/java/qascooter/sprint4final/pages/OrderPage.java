package qascooter.sprint4final.pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class OrderPage {
    private WebDriver driver;
    private By firstNInput = By.xpath("//input[@placeholder = '* Имя']");
    private By lastNameInput = By.xpath("//input[@placeholder = '* Фамилия']");
    private By addressInput = By.xpath("//input[@placeholder = '* Адрес: куда привезти заказ']");
    private By metroStationInput = By.xpath("//input[@placeholder = '* Станция метро']");
    //private By metroSearchInput = By.className("select-search__select");
    private By metroSearchItem = By.className("select-search__row");
    private By phoneNumberInput = By.xpath("//input[@placeholder = '* Телефон: на него позвонит курьер']");
    private By dateInput = By.xpath("//input[@placeholder = '* Когда привезти самокат']");
    private By orderingPeriodInput = By.className("Dropdown-arrow");
    private By commentInput = By.xpath("//input[@placeholder = 'Комментарий для курьера']");
    private By nextStepButton = By.xpath("//button[@class ='Button_Button__ra12g Button_Middle__1CSJM']");
    private By orderPopupInput = By.className("Order_Modal__YZ-d3");

    public OrderPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickNextStepOrder() {
        WebElement element = driver.findElement(nextStepButton);
        //scroll to next step button
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
        Assert.assertTrue(driver.findElement(nextStepButton).isEnabled());
        driver.findElement(nextStepButton).click();
    }

    public void orderPopupIsEnabled() {
        WebElement element = driver.findElement(orderPopupInput);
        //scroll to popup window
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
        Assert.assertTrue(driver.findElement(orderPopupInput).isEnabled());
    }

    public void setFieldsInOrderWindow(String firstName, String lastName, String address, String metroStation, String phoneNumber, String date, String orderingPeriod, String color, String comment) {
        driver.findElement(firstNInput).sendKeys(firstName);
        driver.findElement(lastNameInput).sendKeys(lastName);
        driver.findElement(addressInput).sendKeys(address);
        driver.findElement(metroStationInput).sendKeys(metroStation);
        driver.findElement(metroSearchItem).click();
        driver.findElement(phoneNumberInput).sendKeys(phoneNumber);
        driver.findElement(nextStepButton).click();
        driver.findElement(dateInput).sendKeys(date);
        driver.findElement(orderingPeriodInput).click();
        driver.findElement(By.xpath(".//div[@class = 'Dropdown-menu']/div[" + orderingPeriod + "]")).click();
        driver.findElement(By.id(color)).click();
        driver.findElement(commentInput).sendKeys(comment);
    }
}
