package tests.alert;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ClickForJSConfirmTest {

	private static final By JS_CONFIRM = By.cssSelector("button[onclick='jsConfirm()']");
	private static final By CONFIRM_RESULT = By.cssSelector("#result");

	@Test
	void validateJSConfirmTest() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "src/test/resources/webdrivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://the-internet.herokuapp.com/javascript_alerts");

		//You clicked: Cancel
		driver.findElement(JS_CONFIRM).click();
		Alert alertClickCancel = driver.switchTo().alert();
		Thread.sleep(2000);
		String confirmText = alertClickCancel.getText();
		assertEquals("I am a JS Confirm", confirmText, "Confirm text is incorrect");
		alertClickCancel.dismiss();
		Thread.sleep(2000);
		String confirmResultCancel = driver.findElement(CONFIRM_RESULT).getText();
		assertEquals("You clicked: Cancel", confirmResultCancel, "Result is incorrect");

		//You clicked: Ok
		driver.findElement(JS_CONFIRM).click();
		Alert alertClickOk = driver.switchTo().alert();
		Thread.sleep(2000);
		alertClickOk.accept();
		Thread.sleep(2000);
		String confirmResultOk = driver.findElement(CONFIRM_RESULT).getText();
		assertEquals("You clicked: Ok", confirmResultOk, "Result is incorrect");

		driver.quit();
	}
}
