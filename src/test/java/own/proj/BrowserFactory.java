package own.proj;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserFactory {
	public static WebDriver getDriver(String browser) throws Exception {
		switch (browser.toLowerCase()) {
			case "chrome":
				return new ChromeDriver();
			case "firefox":
				return new FirefoxDriver();
			case "edge":
				return new EdgeDriver();
			default:
				throw new Exception("Unsupported browser: " + browser);
		}
	}
}