package tests;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

class Task120Test {

	public static final String USERNAME = "lenag";
	public static final String ACCESS_KEY = "4d66b29b-ebf5-4b2d-b76b-9e611f2d5da3";
	public static final String URL = "https://" + USERNAME + ":" + ACCESS_KEY + "@ondemand.saucelabs.com:443/wd/hub";

	@Test
	void simpleEdgeTest() throws MalformedURLException, InterruptedException {
		DesiredCapabilities caps = DesiredCapabilities.edge();
		caps.setCapability("platform", "Windows 10");
		caps.setCapability("version", "latest");

		WebDriver driver = new RemoteWebDriver(new URL(URL), caps);
		driver.get("https://www.tut.by/");
		Thread.sleep(2000);
		driver.close();
	}

	@Test
	void simpleFirefoxTest() throws MalformedURLException, InterruptedException {
		DesiredCapabilities caps = DesiredCapabilities.firefox();
		caps.setCapability("platform", "Windows 8.1");
		caps.setCapability("version", "39.0");

		WebDriver driver = new RemoteWebDriver(new URL(URL), caps);
		driver.get("https://www.tut.by/");
		Thread.sleep(2000);
		driver.close();
	}

	@Test
	void simpleChromeTest() throws MalformedURLException, InterruptedException {
		DesiredCapabilities caps = DesiredCapabilities.chrome();
		caps.setCapability("platform", "Linux");
		caps.setCapability("version", "40.0");

		WebDriver driver = new RemoteWebDriver(new URL(URL), caps);
		driver.get("https://www.tut.by/");
		Thread.sleep(2000);
		driver.close();
	}
}
