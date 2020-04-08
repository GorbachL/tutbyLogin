package tests.alert;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ClickForJSAlertTest {

	private static final By JS_ALERT = By.cssSelector("button[onclick='jsAlert()']");
	private static final By ALERT_RESULT = By.cssSelector("#result");

	@Test
	void validateJSAlertTest() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "src/test/resources/webdrivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://the-internet.herokuapp.com/javascript_alerts");

		driver.findElement(JS_ALERT).click();

		Alert alert = driver.switchTo().alert();

		Thread.sleep(2000);

		String alertText = alert.getText();
		assertEquals("I am a JS Alert", alertText, "Alert text is incorrect");

		alert.accept();

		Thread.sleep(2000);

		String alertResult = driver.findElement(ALERT_RESULT).getText();
		assertEquals("You successfuly clicked an alert", alertResult, "Result is incorrect");

		driver.quit();
	}
}
