package pages.pageObjectPattern;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class HomePage extends BasePage {

	private static final By LOGIN_USER_NAME = By.cssSelector(".uname");
	private static final By LOGOUT_BUTTON = By.cssSelector(".auth__reg");

	public HomePage(WebDriver driver) {
		super(driver);
		isPageOpened();
	}

	@Override
	public HomePage openPage() {
		isPageOpened();
		return this;
	}

	@Override
	public void isPageOpened() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(LOGIN_USER_NAME));
	}

	public LoginPage logout() {
		driver.findElement(LOGIN_USER_NAME).click();
		driver.findElement(LOGOUT_BUTTON).click();
		return new LoginPage(driver);
	}

	public String getUserFullName() {
		return driver.findElement(LOGIN_USER_NAME).getText();
	}
}
