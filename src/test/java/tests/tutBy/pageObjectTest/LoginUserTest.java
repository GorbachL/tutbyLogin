package tests.tutBy.pageObjectTest;

import io.qameta.allure.Feature;
import org.junit.jupiter.api.Test;
import pages.pageObjectPattern.HomePage;
import pages.pageObjectPattern.LoginPage;
import utils.ReadUserNameFromTestData;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Feature("Page Object")
class LoginUserTest extends BaseTest {

	@Test
	void loginUserTest() throws IOException {
		LoginPage loginPage = new LoginPage();
		loginPage.openPage()
				.loginUsingCorrectCredentials(prop.get("username"), prop.get("password"));
		HomePage homePage = new HomePage();
		String actualResult = homePage.getUserFullName();
		ReadUserNameFromTestData userNameFromTestData = new ReadUserNameFromTestData();
		String expectedResult = userNameFromTestData.verifyUserName();
		assertEquals(expectedResult, ("{\t\"userName\": \"" + actualResult + "\"}"));
	}
}
