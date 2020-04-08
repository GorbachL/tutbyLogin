package tests.alert;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ClickForJSPromptTest {

	private static final By JS_PROMPT = By.cssSelector("button[onclick='jsPrompt()']");
	private static final By PROMPT_RESULT = By.cssSelector("#result");

	@Test
	void validateJSPromptTest() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "src/test/resources/webdrivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://the-internet.herokuapp.com/javascript_alerts");

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

		driver.quit();
	}
}
