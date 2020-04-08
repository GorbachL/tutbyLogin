package tests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import utils.PropertyManager;

import java.util.concurrent.TimeUnit;

public class BaseTest {

    WebDriver driver;
    static PropertyManager prop;

    @BeforeEach
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/webdrivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @BeforeAll
    static void loadProperties() {
        prop = new PropertyManager();
    }

    @AfterEach
    public void afterTest() {
        driver.quit();
    }
}
