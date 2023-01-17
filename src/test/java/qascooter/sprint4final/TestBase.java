package qascooter.sprint4final;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class TestBase {
    public static WebDriver driver;
    public final String STAND_URL = "https://qa-scooter.praktikum-services.ru/";

    @Before
    public void setup() {
        ChromeOptions options = new ChromeOptions();
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get(STAND_URL);
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
