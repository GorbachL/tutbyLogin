package tests.herokuapp.upload;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;


class UploadFileViaInput {

	private static final By FILE_INPUT = By.cssSelector("#file-upload");
	private static final By UPLOAD_BUTTON = By.cssSelector("#file-submit");
	private static final By UPLOADED_FILES_PANEL = By.cssSelector("#uploaded-files");
	private static final By UPLOADED_FILES_TEXT_AND_FILE_NAME = By.cssSelector(".example");

	private WebDriver driver;

	@BeforeEach
	void setUp() {
		System.setProperty("webdriver.chrome.driver", "src/test/resources/webdrivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://the-internet.herokuapp.com/upload");
	}

	@AfterEach
	void afterTest() {
		driver.quit();
	}

	private void uploadFile(String pathFile) {
		WebElement input = driver.findElement(FILE_INPUT);
		input.sendKeys(pathFile);
		driver.findElement(UPLOAD_BUTTON).click();
	}

	@Test
	void uploadOneFile() {
		String filePath = "C:\\Users\\LenaGorbach\\IdeaProjects\\tutbyLogin\\src\\test\\resources\\fileToUpload\\Image-1.jpg";
		uploadFile(filePath);
		String textAndFileName = driver.findElement(UPLOADED_FILES_TEXT_AND_FILE_NAME).getText();
		assertEquals("File Uploaded!\n" + "Image-1.jpg", textAndFileName, "File is not uploaded");
	}
}