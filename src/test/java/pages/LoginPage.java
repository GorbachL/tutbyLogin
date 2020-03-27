package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends BasePage {

    private static final By ENTER_LINK = By.className("enter");
    private static final By LOGIN_INPUT = By.xpath("//input[@name='login']");
    private static final By PASSWORD_INPUT = By.name("password");
    private static final By LOGIN_BUTTON = By.cssSelector(".button.auth__enter");
    private static final By LOGIN_USER_NAME = By.cssSelector(".enter.logedin .uname");
    private static final By REMEMBER_CHECKBOX = By.id("memory");
    private static final By REGISTRATION_LINK = By.linkText("Регистрация");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void openPage() {
        driver.get("https://www.tut.by/");
        isPageOpened();
    }


    public void isPageOpened() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(ENTER_LINK));
        } catch (TimeoutException ex) {
            throw new TimeoutException("Page is not open");
        }
    }

    public void loginUsingCorrectCredentials(String loginName, String password) {
        driver.findElement(ENTER_LINK).click();
        driver.findElement(REGISTRATION_LINK).click();
        driver.navigate().back();
        driver.findElement(ENTER_LINK).click();
        driver.findElement(LOGIN_INPUT).sendKeys(loginName);
        driver.findElement(PASSWORD_INPUT).sendKeys(password);
        driver.findElement((REMEMBER_CHECKBOX)).isSelected();
        driver.findElement(LOGIN_BUTTON).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(LOGIN_USER_NAME));
    }
}
