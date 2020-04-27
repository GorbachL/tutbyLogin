package pages.pageFactoryPattern;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LoginPage extends BasePage {

	@FindBy(className = "enter")
	private WebElement enterLink;

	@FindBy(name = "login")
	private WebElement loginInput;

	@FindBy(name = "password")
	private WebElement passwordInput;

	@FindBy(className = "auth__enter")
	private WebElement loginButton;

	private static final By ENTER_LINK = By.cssSelector(".enter");

	public LoginPage(WebDriver driver) {
		super(driver);
	}

	@Override
	public void openPage() {
		driver.get("https://www.tut.by/");
		isPageOpened();
		PageFactory.initElements(driver, LoginPage.this);
	}

	@Override
	public void isPageOpened() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(ENTER_LINK));
	}

	private void loginWithCorrectCredential(String loginName, String password) {
		enterLink.click();
		loginInput.sendKeys(loginName);
		passwordInput.sendKeys(password);
		loginButton.click();
		HomePage homePage = new HomePage(driver);
		homePage.isPageOpened();
	}

	public HomePage loginUser(String loginName, String password) {
		loginWithCorrectCredential(loginName, password);
		return new HomePage(driver);
	}
}

