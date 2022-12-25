package qascooter.sprint4final;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import qascooter.sprint4final.pages.MainPage;
import qascooter.sprint4final.pages.OrderPage;

@RunWith(Parameterized.class)
public class OrderPageTests extends TestBase {
    private final String firstName;
    private final String lastName;
    private final String address;
    private final String metroStation;
    private final String phoneNumber;
    private final String date;
    private final String orderingPeriod;
    private final String colorSet;
    private final String commentSet;

    public OrderPageTests(String firstName, String lastName, String address, String metroStation, String phoneNumber, String date, String orderingPeriod, String colorSet, String commentSet) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.metroStation = metroStation;
        this.phoneNumber = phoneNumber;
        this.date = date;
        this.orderingPeriod = orderingPeriod;
        this.colorSet = colorSet;
        this.commentSet = commentSet;
    }

    @Parameterized.Parameters
    public static Object[][] getDataOrder() {
        return new Object[][]{
                {"Иван", "Иванов", "Мира 17-46", "ВДНХ", "89991567880", "31.12.2022\n", "1", "grey", "Позвонить"},
                {"Петр", "Петров", "Ленина 22-1", "Лубянка", "89991567881", "12.06.2023\n", "2", "grey", "привет"},
                {"Стас", "Стасов", "Маркса 7-17", "Петровско-Разумовская", "89991567882", "23.02.2023\n", "3", "black", "-2"},
                {"Елена", "Ленина", "Фрунзе 22-3", "Академическая", "89991567883", "01.01.2023\n", "4", "black", "Привезти пиццу"},
                {"Ольга", "Ольгина", "Чкалова 97-15", "Алексеевская", "89991567884", "29.12.2022\n", "5", "grey", "Жду подарок"}
        };
    }

    @Test
    /*
    Test-case:
     1. Open main page 'qa-scooter'
     2. Close 'Confirm cookies' block
     3. Click on the top button 'Order'
     4. Set all order fields
     5.
     */
    public void orderTestUsingTopButton() {
        MainPage mainPage = new MainPage(driver);
        OrderPage orderPage = new OrderPage(driver);
        mainPage.closeConfirmCookiesBlock();
        mainPage.orderTopButtonClick();
        orderPage.setFieldsInOrderWindow(firstName, lastName, address, metroStation, phoneNumber, date, orderingPeriod, colorSet, commentSet);
        orderPage.clickNextStepOrder();
        orderPage.orderPopupIsEnabled();
    }

    @Test
    public void orderTestUsingBottomButton() {
        MainPage mainPage = new MainPage(driver);
        OrderPage orderPage = new OrderPage(driver);
        mainPage.closeConfirmCookiesBlock();
        mainPage.orderBottomButtonClick();
        orderPage.setFieldsInOrderWindow(firstName, lastName, address, metroStation, phoneNumber, date, orderingPeriod, colorSet, commentSet);
        orderPage.clickNextStepOrder();
        orderPage.orderPopupIsEnabled();
    }
}
