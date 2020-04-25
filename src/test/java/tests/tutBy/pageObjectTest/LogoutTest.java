package tests.tutBy.pageObjectTest;

import org.junit.jupiter.api.Test;
import pages.pageObjectPattern.HomePage;
import pages.pageObjectPattern.LoginPage;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LogoutTest extends BaseTest {

	@Test
	void logOutTest() throws IOException {
		LoginPage loginPage = new LoginPage(driver);
		loginPage.openPage()
				.loginUsingCorrectCredentials(prop.get("username"), prop.get("password"));
		HomePage homePage = new HomePage(driver);
		homePage.logout();
		String actualResult = loginPage.loginPageIsOpened();
		String expectedResult = "Войти";
		assertEquals(expectedResult, actualResult);
	}
}

