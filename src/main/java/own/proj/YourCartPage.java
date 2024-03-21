package own.proj;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class YourCartPage extends Pages{
	@FindBy(className =  "cart_item")
	private List<WebElement> listCartItems;
	public YourCartPage(WebDriver driver) {
		super(driver);
	}

	public int checkNumberOfItems() {
		return listCartItems.size();
	}
}
