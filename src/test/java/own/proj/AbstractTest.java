package own.proj;

import java.time.Duration;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class AbstractTest {
	public WebDriver driver;
	private WebDriverWait wait;

	@BeforeClass
	public void setup() {
		driver = new FirefoxDriver();
		wait = new WebDriverWait(driver, Duration.ofSeconds(2));
		driver.manage().window().setSize(new Dimension(1024, 768));
	}

	@AfterClass
	public void teardown() {
		driver.quit();
	}
}