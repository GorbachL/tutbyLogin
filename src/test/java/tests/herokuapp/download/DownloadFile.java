package tests.herokuapp.download;

import io.qameta.allure.Feature;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@Feature("Download")
class DownloadFile {

	private static final By FILE_LIST = By.cssSelector("div.example>a");

	private WebDriver driver;

	@BeforeEach
	void setUp() {
		System.setProperty("webdriver.chrome.driver", "src/test/resources/webdrivers/chromedriver.exe");

		// Setting new download directory path
		Map<String, Object> chromePrefs = new HashMap<>();

		// Use File.separator as it will work on any OS
		chromePrefs.put("download.default_directory", System.getProperty("user.dir")
				+ File.separator + "files"
				+ File.separator + "downloadedFiles");

		// Adding capabilities to ChromeOptions
		ChromeOptions options = new ChromeOptions();
		options.setExperimentalOption("prefs", chromePrefs);

		// Launching browser with desired capabilities
		driver = new ChromeDriver(options);

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://the-internet.herokuapp.com/download");
	}

	@AfterEach
	void afterTest() {
		driver.quit();
	}

	@Test
	void downloadFileTest() throws InterruptedException {
		Thread.sleep(2000);

		//#1 - download last file in the list
		List<WebElement> list = driver.findElements(FILE_LIST);
		WebElement lastFileInTheList = list.get(list.size() - 1);
		lastFileInTheList.click();

		//#2 - download a specific file if you know that it exists
		WebElement specificFile = driver.findElement(By.xpath(".//a[text()='car.jpg']"));
		specificFile.click();

		Thread.sleep(7000);
	}
}
