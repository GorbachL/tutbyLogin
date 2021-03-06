package tests.tutBy.pageFactoryTest;

import io.qameta.allure.Feature;
import org.junit.jupiter.api.Test;
import pages.pageFactoryPattern.HomePage;
import pages.pageFactoryPattern.LoginPage;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Feature("Factory")
class LoginTest extends BaseTest {

	@Test
	void loginCCTest() {
		LoginPage loginPage = new LoginPage(driver);
		loginPage.openPage();
		loginPage.loginUser(prop.get("username"), prop.get("password"));
		HomePage homePage = new HomePage(driver);
		String actualResult = homePage.getUserName();
		String expectedResult = "Selenium Test";
		assertEquals(expectedResult, actualResult);
	}
}
