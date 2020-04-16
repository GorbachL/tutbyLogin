package tests.tutBy.pageFactoryTest;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import pages.pageFactoryPattern.LoginPage;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LoginTest extends BaseTest {

	@Test
	void loginCCTest() {
		LoginPage loginPage = new LoginPage(driver);
		loginPage.openPage();
		loginPage.loginUser(prop.get("username"), prop.get("password"));
		assertEquals("Selenium Test", driver.findElement(By.cssSelector(".uname")).getText());
	}
}
