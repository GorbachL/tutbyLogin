package tests.herokuapp.upload;

import driver.DriverFactory;
import driver.DriverManager;
import driver.DriverType;
import io.qameta.allure.Feature;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.ScreenshotUtils;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Feature("Upload")
class UploadFileWithHelpOfRobotLib {

	private static final By FILE_INPUT = By.cssSelector("#file-upload");
	private static final By DRAG_AND_DROP = By.cssSelector("#drag-drop-upload");
	private static final By DRAG_AND_DROP_DETAILS = By.cssSelector(".dz-success-mark .dz-preview .dz-filename");
	private static final By UPLOAD_BUTTON = By.cssSelector("#file-submit");
	private static final By UPLOADED_FILES_PANEL = By.cssSelector("#uploaded-files");
	private static final By UPLOADED_FILES_TEXT_AND_FILE_NAME = By.cssSelector(".example");

	private DriverManager driverManager;
	protected WebDriver driver;
	private WebDriverWait wait;

	@BeforeEach
	void setUp() {
		System.setProperty("webdriver.chrome.driver", "src/test/resources/webdrivers/chromedriver.exe");
		driverManager = DriverFactory.getManager(DriverType.CHROME);
		driver = driverManager.getDriver();
		wait = new WebDriverWait(driver, 10);
		driver.manage().window().maximize();
		driver.get("https://the-internet.herokuapp.com/upload");
	}

	@AfterEach
	void afterTest() {
		driverManager.quiteDriver();
	}

	void clickJs(WebDriver driver, WebElement element) {
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
	}

	//File upload by Robot Class
	void uploadFileWithRobot(String imagePath) throws AWTException {
		StringSelection stringSelection = new StringSelection(imagePath);
		Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
		clipboard.setContents(stringSelection, null);

		Robot robot = new Robot();

		robot.delay(250);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		robot.delay(250);
	}

	/**
	 * Upload file using drag and drop does not work.
	 * We can only see the file name in the "drag and drop" area.
	 * The test can be updated after fixing the upload using drag and drop.
	 * TODO
	 * create a bug
	 */
	@Test
	void uploadFileViaDragAndDropTest() throws InterruptedException, AWTException, IOException {
		File file = new File("files/fileToUpload/Image-1.jpg");
		wait.until(ExpectedConditions.elementToBeClickable(DRAG_AND_DROP));

		//#1 Upload file ==> it is possible to select file using Drag and Drop field
		driver.findElement(DRAG_AND_DROP).click();
		uploadFileWithRobot(file.getAbsolutePath());
		Thread.sleep(2000); //sleep is needed here
		String addedFileInDrugAndDrop = driver.findElement(DRAG_AND_DROP_DETAILS).getText();
		assertEquals("Image-1.jpg", addedFileInDrugAndDrop, "File is not added");
		ScreenshotUtils.takeScreenshot("files/screenshots_uploadedFile/UploadFileWithHelpOfRobotLib.png");
	}

	/**
	 * "Drivers should throw "invalid argument" error on an attempt to click file input"
	 * https://github.com/SeleniumHQ/selenium/issues/4843
	 * <p>
	 * The JavascriptExecutor was used to complete the second task.
	 * ==>> "Test should upload some file with help of Robot library for Java"
	 * <p>
	 * Using JavascriptExecutor is undesirable,
	 * since the behavior of the java script cannot be considered equivalent to the behavior of the user.
	 */
	@Test
	void uploadFileViaChoseFileInputTest() throws InterruptedException, AWTException, IOException {
		File file = new File("files/fileToUpload/Image-1.jpg");
		wait.until(ExpectedConditions.elementToBeClickable(DRAG_AND_DROP));

		//#2 Upload file ==> using Choose File input
		WebElement input = driver.findElement(FILE_INPUT);
		clickJs(driver, input);
		uploadFileWithRobot(file.getAbsolutePath());
		Thread.sleep(1000); //sleep is needed here
		clickJs(driver, input);
		uploadFileWithRobot(file.getAbsolutePath());
		Thread.sleep(2000); //sleep is needed here

		driver.findElement(UPLOAD_BUTTON).click();
		String textAndFileName = driver.findElement(UPLOADED_FILES_TEXT_AND_FILE_NAME).getText();
		assertEquals("File Uploaded!\n" + "Image-1.jpg", textAndFileName, "File is not uploaded");
		ScreenshotUtils.takeScreenshot("files/screenshots_uploadedFile/FileUploaded_2.png");
	}
}
