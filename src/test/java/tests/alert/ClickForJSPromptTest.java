package tests.alert;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ClickForJSPromptTest extends AlertBaseTest {

	private static final By JS_PROMPT = By.cssSelector("button[onclick='jsPrompt()']");
	private static final By PROMPT_RESULT = By.cssSelector("#result");

	@Test
	void validateJSPromptTest() throws InterruptedException {

		//You entered: null
		driver.findElement(JS_PROMPT).click();
		Alert alertClickCancel = driver.switchTo().alert();
		Thread.sleep(2000);
		String promptText = alertClickCancel.getText();
		assertEquals("I am a JS prompt", promptText, "Prompt text is incorrect");
		alertClickCancel.dismiss();
		Thread.sleep(2000);
		String promptResultCancel = driver.findElement(PROMPT_RESULT).getText();
		assertEquals("You entered: null", promptResultCancel, "Result is incorrect");

		//You entered: Send message
		driver.findElement(JS_PROMPT).click();
		Alert alertClickOk = driver.switchTo().alert();
		Thread.sleep(2000);
		alertClickOk.sendKeys("Send message");
		alertClickOk.accept();
		Thread.sleep(2000);
		String promptResultOk = driver.findElement(PROMPT_RESULT).getText();
		assertEquals("You entered: Send message", promptResultOk, "Result is incorrect");
	}
}
