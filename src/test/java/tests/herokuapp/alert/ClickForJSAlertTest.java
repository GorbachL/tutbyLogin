package tests.herokuapp.alert;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ClickForJSAlertTest extends AlertBaseTest {

	private static final By JS_ALERT = By.cssSelector("button[onclick='jsAlert()']");
	private static final By ALERT_RESULT = By.cssSelector("#result");

	@Test
	void validateJSAlertTest() throws InterruptedException {
		driver.findElement(JS_ALERT).click();

		Alert alert = driver.switchTo().alert();

		Thread.sleep(2000);

		String alertText = alert.getText();
		assertEquals("I am a JS Alert", alertText, "Alert text is incorrect");

		alert.accept();

		Thread.sleep(2000);

		String alertResult = driver.findElement(ALERT_RESULT).getText();
		assertEquals("You successfuly clicked an alert", alertResult, "Result is incorrect");
	}
}
