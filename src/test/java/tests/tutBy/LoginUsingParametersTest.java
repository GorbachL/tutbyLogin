package tests.tutBy;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.LoginPage;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class LoginUsingParametersTest {

	private WebDriver driver;

	@BeforeEach
	void setUp() {
		System.setProperty("webdriver.chrome.driver", "src/test/resources/webdrivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}

	@AfterEach
	void afterTest() {
		driver.quit();
	}

	@ParameterizedTest
	@MethodSource("loginWithDifferentCredentials")
	void logInTest(String userName, String password) throws InterruptedException {
		LoginPage loginPage = new LoginPage(driver);
		loginPage.openPage();
		loginPage.loginUsingCorrectCredentials(userName, password);
		assertEquals("Selenium Test", driver.findElement(By.cssSelector(".uname")).getText());
	}

	static Stream<Arguments> loginWithDifferentCredentials() {
		return Stream.of(
				arguments("seleniumtests@tut.by", "123456789zxcvbn"),
				arguments("seleniumtests2@tut.by", "123456789zxcvbn")
		);
	}
}
