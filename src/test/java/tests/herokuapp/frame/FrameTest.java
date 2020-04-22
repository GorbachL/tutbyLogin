package tests.herokuapp.frame;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FrameTest {

	private static final By CONTENT_INPUT = By.cssSelector(".mce-content-body");
	private static final By BOLD_BUTTON = By.cssSelector("#mceu_3");

	private WebDriver driver;

	@BeforeEach
	void setUp() {
		System.setProperty("webdriver.chrome.driver", "src/test/resources/webdrivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://the-internet.herokuapp.com/iframe");
	}

	@AfterEach
	void afterTest() {
		driver.quit();
	}

	@Test
	void addNewTextInFrameTest() throws InterruptedException {
		driver.switchTo().frame(driver.findElement(By.tagName("iframe")));
		driver.findElement(CONTENT_INPUT).clear();
		driver.findElement(CONTENT_INPUT).sendKeys("Hello");

		String text = (driver.findElement(CONTENT_INPUT).getText());
		assertEquals("Hello", text, "text is incorrect");

		driver.switchTo().defaultContent();
		driver.findElement(BOLD_BUTTON).click();

		Thread.sleep(2000);

		Actions actions = new Actions(driver);
		actions
				.sendKeys(" world!")
				.perform();

		driver.switchTo().frame(driver.findElement(By.tagName("iframe")));
		String bold = driver.findElement(By.tagName("strong")).getCssValue("font-weight");
		assertEquals("700", bold);
	}
}



