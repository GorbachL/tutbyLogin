package tests.tutBy.pageObjectTest;

import org.junit.jupiter.api.Test;
import pages.pageObjectPattern.HomePage;
import pages.pageObjectPattern.LoginPage;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;


class LoginTest extends BaseTest {

	@Test
	void logInTest() throws IOException {
		LoginPage loginPage = new LoginPage(driver);
		loginPage.openPage()
				.loginUsingCorrectCredentials(prop.get("username"), prop.get("password"));
		HomePage homePage = new HomePage(driver);
		String actualResult = homePage.getUserFullName();
		String expectedResult = "Selenium Test";
		assertEquals(expectedResult, actualResult);
	}
}
