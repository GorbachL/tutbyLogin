package tests;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import pages.LoginPage;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LoginTest extends BaseTest {

	@Test
	void logInTest() throws InterruptedException {
		LoginPage loginPage = new LoginPage(driver);
		loginPage.openPage();
		loginPage.loginUsingCorrectCredentials(prop.get("username"), prop.get("password"));
		assertEquals("Selenium Test", driver.findElement(By.cssSelector(".uname")).getText());
	}

	@Test
	void registrationLinkTest() {
		LoginPage loginPage = new LoginPage(driver);
		loginPage.openPage();
		loginPage.verifyRegistration();
	}

	@Test
	void personalAreaLinkTest() throws InterruptedException {
		LoginPage loginPage = new LoginPage(driver);
		loginPage.openPage();
		loginPage.loginUsingCorrectCredentials(prop.get("username"), prop.get("password"));
		loginPage.verifyPersonalArea();
		assertEquals("Профили TUT.BY", driver.getTitle());
	}
}
