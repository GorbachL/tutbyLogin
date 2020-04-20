package tests.tutBy.pageObjectTest;

import driver.DriverFactory;
import driver.DriverManager;
import driver.DriverType;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import utils.PropertyManager;

import java.util.concurrent.TimeUnit;

public class BaseTest {

	private DriverManager driverManager;
	static WebDriver driver;
	static PropertyManager prop;

	@BeforeEach
	public void setUp() {
		driverManager = DriverFactory.getManager(DriverType.CHROME);
		driver = driverManager.getDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

	@BeforeAll
	static void loadProperties() {
		prop = new PropertyManager();
	}

	@AfterEach
	public void afterTest() {
		driverManager.quiteDriver();
	}
}
