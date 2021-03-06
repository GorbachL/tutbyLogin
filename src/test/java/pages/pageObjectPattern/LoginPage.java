package pages.pageObjectPattern;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utils.ScreenshotUtils;

import java.io.IOException;

public class LoginPage extends BasePage {

	private static final String URL = "https://www.tut.by/";
	private static final By ENTER_LINK = By.cssSelector(".enter");
	private static final By LOGIN_INPUT = By.xpath("//input[@name='login']");
	private static final By PASSWORD_INPUT = By.name("password");
	private static final By LOGIN_BUTTON = By.cssSelector(".button.auth__enter");

	@Override
	public LoginPage openPage() {
		driver.get(URL);
		isPageOpened();
		return this;
	}

	@Override
	public void isPageOpened() {
		try {
			wait.until(ExpectedConditions.visibilityOfElementLocated(ENTER_LINK));
		} catch (TimeoutException ex) {
			throw new TimeoutException("Login Page is not opened");
		}
	}

	public HomePage loginUsingCorrectCredentials(String loginName, String password) throws IOException {
		driver.findElement(ENTER_LINK).click();
		driver.findElement(LOGIN_INPUT).sendKeys(loginName);
		driver.findElement(PASSWORD_INPUT).sendKeys(password);
		driver.findElement(LOGIN_BUTTON).click();
		ScreenshotUtils.takeScreenshot("files/screenShots/homePageView_afterLogin.png");
		ScreenshotUtils.captureScreenshot();
		return new HomePage();
	}

	public String loginPageIsOpened() {
		return driver.findElement(ENTER_LINK).getAttribute("text");
	}
}
