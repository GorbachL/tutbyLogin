package tests.tutBy.pageFactoryTest;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import pages.pageFactoryPattern.HomePage;
import pages.pageFactoryPattern.LoginPage;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LogoutTest extends BaseTest {

	@Test
	void logoutFromHomePage() throws InterruptedException {
		LoginPage loginPage = new LoginPage(driver);
		loginPage.openPage();
		loginPage.loginUser(prop.get("username"), prop.get("password"));
		HomePage homePage = new HomePage(driver);
		homePage.isPageOpened();
		homePage.logoutFromPage();
		Thread.sleep(3000);
		assertEquals("Войти", driver.findElement(By.cssSelector(".enter")).getAttribute("text"));
	}
}
