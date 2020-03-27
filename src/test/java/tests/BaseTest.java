package tests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.PropertyManager;

public class BaseTest {

    WebDriver driver;
    WebDriverWait wait;
    static PropertyManager prop;

    @BeforeEach
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/webdrivers/chromedriver.exe");
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 20);
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
