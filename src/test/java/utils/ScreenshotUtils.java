package utils;

import driver.DriverFactory;
import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;

import static driver.DriverType.CHROME;

public class ScreenshotUtils {

	public static void takeScreenshot(String fileWithPath) throws IOException {
		WebDriver driver = DriverFactory.getManager(CHROME).getDriver();
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		File destFile = new File(fileWithPath);
		FileUtils.copyFile(scrFile, destFile);
	}

	@Attachment(value = "screenshot", type = "image/png")
	public static byte[] captureScreenshot() {
		WebDriver driver = DriverFactory.getManager(CHROME).getDriver();
		return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
	}
}
