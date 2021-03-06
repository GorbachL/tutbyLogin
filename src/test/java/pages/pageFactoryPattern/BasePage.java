package pages.pageFactoryPattern;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class BasePage {

	WebDriver driver;
	WebDriverWait wait;

	BasePage(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, 20);
	}

	public abstract void openPage();

	public abstract void isPageOpened();
}
