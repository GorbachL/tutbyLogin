package pages.pageFactoryPattern;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomePage extends BasePage {

	@FindBy(className = "uname")
	private WebElement loginName;

	@FindBy(className = "auth__reg")
	private WebElement logout;

	private static final By LOGIN_USER_NAME = By.cssSelector(".uname");

	public HomePage(WebDriver driver) {
		super(driver);
	}

	@Override
	public void openPage() {
		isPageOpened();
		PageFactory.initElements(driver, HomePage.this);
	}

	@Override
	public void isPageOpened() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(LOGIN_USER_NAME));
		PageFactory.initElements(driver, HomePage.this);
	}

	private void logOutFromHomePage() {
		loginName.click();
		logout.click();
	}

	public LoginPage logoutFromPage() {
		logOutFromHomePage();
		LoginPage loginPage = new LoginPage(driver);
		loginPage.isPageOpened();
		return loginPage;
	}
}
