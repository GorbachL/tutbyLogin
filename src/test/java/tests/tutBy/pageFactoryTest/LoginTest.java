package tests.tutBy.pageFactoryTest;

import org.junit.jupiter.api.Test;
import pages.pageFactoryPattern.LoginPage;

class LoginTest extends BaseTest {

	@Test
	void loginCCTest() {
		LoginPage loginPage = new LoginPage(driver);
		loginPage.openPage();
		loginPage.loginUser(prop.get("username"), prop.get("password"));
	}
}
