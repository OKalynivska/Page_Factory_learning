package own.proj;

import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;

import java.time.Duration;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AbstractPage {
	private static final Logger logger = LoggerFactory.getLogger(AbstractPage.class);
	private WebDriverWait wait;
	public WebDriver driver;

	public AbstractPage(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, Duration.ofSeconds(20));
	}

	public void click(WebElement element) {
		wait.until(elementToBeClickable(element));
		element.click();

		logger.info("\u001B[32m" + element + " is clicked\u001B[0m");
	}

	public void writeText(WebElement element, String text) {
		wait.until(ExpectedConditions.visibilityOf(element));
		element.sendKeys(text);

		logger.info("\u001B[32m'{}' is typed in the {}\u001B[0m", text, element.getAttribute("id"));
	}

	public String getText(WebElement element) {
		wait.until(ExpectedConditions.visibilityOf(element));
		return element.getText();
	}

	public void hoverMouseOver(WebElement element) {
		Actions action = new Actions(driver);
		wait.until(ExpectedConditions.visibilityOf(element));
		action.moveToElement(element).build().perform();

		logger.info("mouse pointer is moved to the " + element.getAccessibleName());
	}

	public boolean isElementVisible(WebElement element) {
		wait.until(ExpectedConditions.visibilityOf(element));
		return element.isDisplayed();
	}

	public void scrollDownThePage() {
		Actions action = new Actions(driver);
		action.sendKeys(Keys.PAGE_DOWN).build().perform();
	}

	public <T extends AbstractPage> T initPage(String url, Class<T> pageClass) {
		driver.get(PropertiesUtil.get(url));
		return PageFactory.initElements(driver, pageClass);
	}
}