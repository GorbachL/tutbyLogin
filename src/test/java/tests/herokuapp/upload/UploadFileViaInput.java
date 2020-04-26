package tests.herokuapp.upload;

import driver.DriverFactory;
import driver.DriverManager;
import driver.DriverType;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.ScreenshotUtils;

import java.io.File;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;


class UploadFileViaInput {

	private static final By FILE_INPUT = By.cssSelector("#file-upload");
	private static final By UPLOAD_BUTTON = By.cssSelector("#file-submit");
	private static final By UPLOADED_FILES_PANEL = By.cssSelector("#uploaded-files");
	private static final By UPLOADED_FILES_TEXT_AND_FILE_NAME = By.cssSelector(".example");

	private DriverManager driverManager;
	protected WebDriver driver;

	@BeforeEach
	void setUp() {
		System.setProperty("webdriver.chrome.driver", "src/test/resources/webdrivers/chromedriver.exe");
		driverManager = DriverFactory.getManager(DriverType.CHROME);
		driver = driverManager.getDriver();
		driver.manage().window().maximize();
		driver.get("https://the-internet.herokuapp.com/upload");
	}

	@AfterEach
	void afterTest() {
		driverManager.quiteDriver();
	}

	private void uploadFile(String pathFile) {
		WebElement input = driver.findElement(FILE_INPUT);
		input.sendKeys(pathFile);
		driver.findElement(UPLOAD_BUTTON).click();
	}

	@Test
	void uploadOneFileTest() throws IOException {
		File file = new File("files/fileToUpload/Image-1.jpg");
		uploadFile(file.getAbsolutePath());
		String textAndFileName = driver.findElement(UPLOADED_FILES_TEXT_AND_FILE_NAME).getText();
		assertEquals("File Uploaded!\n" + "Image-1.jpg", textAndFileName, "File is not uploaded");
		ScreenshotUtils.takeScreenshot("files/screenshots_uploadedFile/FileUploaded_1.png");
	}
}
