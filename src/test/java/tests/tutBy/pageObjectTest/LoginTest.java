package tests.tutBy.pageObjectTest;

import org.junit.jupiter.api.Test;
import pages.pageObjectPattern.LoginPage;

class LoginTest extends BaseTest {

	@Test
	void logInTest() {
		LoginPage loginPage = new LoginPage(driver);
		loginPage.openPage()
				.loginUsingCorrectCredentials(prop.get("username"), prop.get("password"));
	}
}
