package tests.herokuapp.alert;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ClickForJSConfirmTest extends AlertBaseTest {

	private static final By JS_CONFIRM = By.cssSelector("button[onclick='jsConfirm()']");
	private static final By CONFIRM_RESULT = By.cssSelector("#result");

	@Test
	void validateJSConfirmTest() throws InterruptedException {

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
	}
}
