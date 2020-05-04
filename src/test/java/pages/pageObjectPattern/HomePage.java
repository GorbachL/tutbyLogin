package pages.pageObjectPattern;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utils.ScreenshotUtils;

import java.io.IOException;


public class HomePage extends BasePage {

	private static final By LOGIN_USER_NAME = By.cssSelector(".uname");
	private static final By LOGOUT_BUTTON = By.cssSelector(".auth__reg");

	@Override
	public HomePage openPage() {
		isPageOpened();
		return this;
	}

	@Override
	public void isPageOpened() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(LOGIN_USER_NAME));
	}

	public LoginPage logout() throws IOException {
		ScreenshotUtils.takeScreenshot("files/screenShots/homePageView.png");
		ScreenshotUtils.captureScreenshot();
		driver.findElement(LOGIN_USER_NAME).click();
		ScreenshotUtils.takeScreenshot("files/screenShots/click_Logout_fromHomePage.png");
		ScreenshotUtils.captureScreenshot();
		driver.findElement(LOGOUT_BUTTON).click();
		ScreenshotUtils.takeScreenshot("files/screenShots/loginPage_afterLogout.png");
		ScreenshotUtils.captureScreenshot();
		return new LoginPage();
	}

	public String getUserFullName() {
		return driver.findElement(LOGIN_USER_NAME).getText();
	}
}
