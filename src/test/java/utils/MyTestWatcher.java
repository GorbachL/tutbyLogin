package utils;

import driver.DriverFactory;
import io.qameta.allure.Attachment;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestWatcher;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.util.Optional;

import static driver.DriverType.CHROME;

public class MyTestWatcher implements TestWatcher {

	@Override
	public void testDisabled(ExtensionContext context, Optional<String> reason) {
	}

	@Override
	public void testSuccessful(ExtensionContext context) {
		makeScreenshot();
	}

	@Override
	public void testAborted(ExtensionContext context, Throwable cause) {
	}

	@Override
	public void testFailed(ExtensionContext context, Throwable cause) {
		makeScreenshot();
	}


	@Attachment(value = "Last screen state from MyTestWatcher", type = "image/png")
	private static byte[] makeScreenshot() {
		WebDriver driver = DriverFactory.getManager(CHROME).getDriver();
		return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
	}
}
