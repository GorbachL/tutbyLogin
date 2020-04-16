package tests.tutBy.pageObjectTest;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import pages.pageObjectPattern.HomePage;
import pages.pageObjectPattern.LoginPage;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LogoutTest extends BaseTest {

	@Test
	void logOutTest() throws InterruptedException {
		LoginPage loginPage = new LoginPage(driver);
		loginPage.openPage()
				.loginUsingCorrectCredentials(prop.get("username"), prop.get("password"));
		HomePage homePage = new HomePage(driver);
		homePage.logout();
		Thread.sleep(3000);
		assertEquals("Войти", driver.findElement(By.cssSelector(".enter")).getAttribute("text"));
	}
}

