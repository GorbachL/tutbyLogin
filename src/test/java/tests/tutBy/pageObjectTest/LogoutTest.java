package tests.tutBy.pageObjectTest;

import org.junit.jupiter.api.Test;
import pages.pageObjectPattern.HomePage;
import pages.pageObjectPattern.LoginPage;

class LogoutTest extends BaseTest {

	@Test
	void logOutTest() {
		LoginPage loginPage = new LoginPage(driver);
		loginPage.openPage()
				.loginUsingCorrectCredentials(prop.get("username"), prop.get("password"));
		HomePage homePage = new HomePage(driver);
		homePage.logout();
	}
}

