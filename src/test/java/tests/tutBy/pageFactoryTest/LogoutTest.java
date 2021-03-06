package tests.tutBy.pageFactoryTest;

import io.qameta.allure.Feature;
import org.junit.jupiter.api.Test;
import pages.pageFactoryPattern.HomePage;
import pages.pageFactoryPattern.LoginPage;

@Feature("Factory")
class LogoutTest extends BaseTest {

	@Test
	void logoutFromHomePage() {
		LoginPage loginPage = new LoginPage(driver);
		loginPage.openPage();
		loginPage.loginUser(prop.get("username"), prop.get("password"));
		HomePage homePage = new HomePage(driver);
		homePage.isPageOpened();
		homePage.logoutFromPage();
	}
}
