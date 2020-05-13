package utils;

import driver.DriverFactory;
import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import static driver.DriverType.CHROME;


public class TestListener implements ITestListener {

	@Override
	public void onTestStart(ITestResult iTestResult) {

	}

	@Override
	public void onTestSuccess(ITestResult result) {
		createScreenshot();
	}

	@Override
	public void onTestFailure(ITestResult result) {
		createScreenshot();
	}

	@Override
	public void onTestSkipped(ITestResult iTestResult) {

	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {

	}

	@Override
	public void onStart(ITestContext iTestContext) {

	}

	@Override
	public void onFinish(ITestContext iTestContext) {

	}

	@Attachment(value = "Last screen state TESTListener", type = "image/png")
	private byte[] createScreenshot() {
		WebDriver driver = DriverFactory.getManager(CHROME).getDriver();
		return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
	}
}
