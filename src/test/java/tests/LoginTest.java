package tests;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import pages.LoginPage;

import static org.junit.jupiter.api.Assertions.assertEquals;


class LoginTest extends BaseTest {

    @Test
    void logInTest() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.openPage();
        loginPage.loginUsingCorrectCredentials(prop.get("username"), prop.get("password"));
        assertEquals("Selenium Test", driver.findElement(By.cssSelector(".uname")).getText());
    }
}
