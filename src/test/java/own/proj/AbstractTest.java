package own.proj;

import java.time.Duration;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class AbstractTest extends BrowserFactory{
	public static WebDriver driver;
	private WebDriverWait wait;

	@BeforeClass
	public void setup() throws Exception {
		String browser = System.getProperty("browser", "firefox");
		driver = BrowserFactory.getDriver(browser);
		wait = new WebDriverWait(driver, Duration.ofSeconds(2));
		driver.manage().window().setSize(new Dimension(1024, 768));
	}

	@AfterClass
	public void teardown() {
		if (driver != null) {
			driver.quit();
		}
	}
}