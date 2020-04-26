package tests.tutBy.pageObjectTest;

import org.junit.jupiter.api.Test;
import pages.pageObjectPattern.HomePage;
import pages.pageObjectPattern.LoginPage;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;


class LoginTest extends BaseTest {

	/**
	 * The test has been updated according to this comment.
	 * I'll remove these lines after review
	 */
	/*
	Now you have assertions in page objects :) Move them back to tests, but do not forget to encapsulate work with WebElement/WebDriver.
	Example.
	Incorrect variant:
	assertEquals("Selenium Test", driver.findElement(By.cssSelector(".uname")).getText());
	Correct variant (after login you're on the Home page):
	assertEquals(EXPECTED_USER_NAME, homePage.getUserFullName()); //Names can be changed
	 */
	@Test
	void logInTest() throws IOException {
		LoginPage loginPage = new LoginPage();
		loginPage.openPage()
				.loginUsingCorrectCredentials(prop.get("username"), prop.get("password"));
		HomePage homePage = new HomePage();
		String actualResult = homePage.getUserFullName();
		String expectedResult = "Selenium Test";
		assertEquals(expectedResult, actualResult);
	}
}
